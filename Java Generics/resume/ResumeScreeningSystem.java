package resume;
import java.util.*;
import java.util.stream.Collectors;
public class ResumeScreeningSystem {
    private Map<String, List<Resume<? extends JobRole>>> resumeDatabase;
    private Map<String, JobRole> availablePositions;
    private String companyName;
    private int processedResumes;
    public ResumeScreeningSystem(String companyName) {
        this.companyName = companyName;
        this.resumeDatabase = new HashMap<>();
        this.availablePositions = new HashMap<>();
        this.processedResumes = 0;
        initializeDatabase();
    }
    private void initializeDatabase() {
        resumeDatabase.put("Software Engineer", new ArrayList<>());
        resumeDatabase.put("Data Scientist", new ArrayList<>());
        resumeDatabase.put("Product Manager", new ArrayList<>());
    }
    public <T extends JobRole> boolean addResume(Resume<T> resume) {
        String roleName = resume.getTargetJobRole().getRoleName();
        if (!resumeDatabase.containsKey(roleName)) {
            resumeDatabase.put(roleName, new ArrayList<>());
        }
        resume.calculateAIMatchScore();
        resumeDatabase.get(roleName).add(resume);
        processedResumes++;
        System.out.println(String.format("Added resume for %s (Score: %d%%) targeting %s position",
                resume.getCandidateName(), resume.getAiMatchScore(), roleName));
        return true;
    }
    public <T extends JobRole> void addJobPosition(String positionId, T jobRole) {
        availablePositions.put(positionId, jobRole);
        System.out.println("Added position: " + positionId + " - " + jobRole.getRoleName());
    }
    public List<Resume<? extends JobRole>> screenResumesByScore(int minScore) {
        System.out.println(String.format("\n=== SCREENING RESUMES WITH MIN SCORE: %d%% ===", minScore));
        List<Resume<? extends JobRole>> qualifiedResumes = new ArrayList<>();
        for (List<Resume<? extends JobRole>> resumeList : resumeDatabase.values()) {
            for (Resume<? extends JobRole> resume : resumeList) {
                if (resume.getAiMatchScore() >= minScore && resume.meetsMinimumRequirements()) {
                    qualifiedResumes.add(resume);
                    resume.updateScreeningStatus("screened");
                }
            }
        }
        qualifiedResumes.sort((r1, r2) -> Integer.compare(r2.getAiMatchScore(), r1.getAiMatchScore()));
        System.out.println("Found " + qualifiedResumes.size() + " qualified candidates");
        return qualifiedResumes;
    }
    public List<Resume<? extends JobRole>> findResumesByJobRole(String roleName) {
        List<Resume<? extends JobRole>> resumes = resumeDatabase.get(roleName);
        return resumes != null ? new ArrayList<>(resumes) : new ArrayList<>();
    }
    public <T extends JobRole> List<Resume<T>> findTopCandidates(Class<T> jobRoleClass, int limit) {
        List<Resume<T>> topCandidates = new ArrayList<>();
        for (List<Resume<? extends JobRole>> resumeList : resumeDatabase.values()) {
            for (Resume<? extends JobRole> resume : resumeList) {
                if (jobRoleClass.isInstance(resume.getTargetJobRole())) {
                    @SuppressWarnings("unchecked")
                    Resume<T> typedResume = (Resume<T>) resume;
                    topCandidates.add(typedResume);
                }
            }
        }
        return topCandidates.stream()
                .sorted((r1, r2) -> Integer.compare(r2.getAiMatchScore(), r1.getAiMatchScore()))
                .limit(limit)
                .collect(Collectors.toList());
    }
    public Map<String, List<Resume<? extends JobRole>>> batchScreening(int minScore) {
        System.out.println(String.format("\n=== BATCH SCREENING (MIN SCORE: %d%%) ===", minScore));
        Map<String, List<Resume<? extends JobRole>>> screeningResults = new HashMap<>();
        for (Map.Entry<String, List<Resume<? extends JobRole>>> entry : resumeDatabase.entrySet()) {
            String roleName = entry.getKey();
            List<Resume<? extends JobRole>> candidates = entry.getValue().stream()
                    .filter(resume -> resume.getAiMatchScore() >= minScore)
                    .filter(Resume::meetsMinimumRequirements)
                    .sorted((r1, r2) -> Integer.compare(r2.getAiMatchScore(), r1.getAiMatchScore()))
                    .collect(Collectors.toList());
            screeningResults.put(roleName, candidates);
            System.out.println(roleName + ": " + candidates.size() + " qualified candidates");
            candidates.forEach(resume -> resume.updateScreeningStatus("screened"));
        }
        return screeningResults;
    }
    public List<Resume<? extends JobRole>> findCandidatesByExperience(int minYears, int maxYears) {
        List<Resume<? extends JobRole>> experiencedCandidates = new ArrayList<>();
        for (List<Resume<? extends JobRole>> resumeList : resumeDatabase.values()) {
            for (Resume<? extends JobRole> resume : resumeList) {
                int experience = resume.getYearsOfExperience();
                if (experience >= minYears && experience <= maxYears) {
                    experiencedCandidates.add(resume);
                }
            }
        }
        return experiencedCandidates.stream()
                .sorted((r1, r2) -> Integer.compare(r2.getAiMatchScore(), r1.getAiMatchScore()))
                .collect(Collectors.toList());
    }
    public List<Resume<? extends JobRole>> findCandidatesBySkill(String skill) {
        List<Resume<? extends JobRole>> skilledCandidates = new ArrayList<>();
        for (List<Resume<? extends JobRole>> resumeList : resumeDatabase.values()) {
            for (Resume<? extends JobRole> resume : resumeList) {
                if (resume.getSkills().contains(skill)) {
                    skilledCandidates.add(resume);
                }
            }
        }
        return skilledCandidates;
    }
    public void generateDiversityReport() {
        System.out.println("\n=== DIVERSITY REPORT ===");
        Map<String, Integer> roleCount = new HashMap<>();
        Map<String, Integer> experienceDistribution = new HashMap<>();
        for (Map.Entry<String, List<Resume<? extends JobRole>>> entry : resumeDatabase.entrySet()) {
            String roleName = entry.getKey();
            roleCount.put(roleName, entry.getValue().size());
            for (Resume<? extends JobRole> resume : entry.getValue()) {
                String expLevel = resume.getExperienceLevel();
                experienceDistribution.merge(expLevel, 1, Integer::sum);
            }
        }
        System.out.println("Applications by Role:");
        roleCount.forEach((role, count) -> System.out.println("  " + role + ": " + count + " applications"));
        System.out.println("\nExperience Distribution:");
        experienceDistribution
                .forEach((level, count) -> System.out.println("  " + level + ": " + count + " candidates"));
    }
    public void displaySystemMetrics() {
        System.out.println("\n=== SYSTEM PERFORMANCE METRICS ===");
        System.out.println("Company: " + companyName);
        System.out.println("Total Resumes Processed: " + processedResumes);
        System.out.println("Available Positions: " + availablePositions.size());
        int screenedResumes = 0;
        int totalResumes = 0;
        double avgScore = 0.0;
        for (List<Resume<? extends JobRole>> resumeList : resumeDatabase.values()) {
            totalResumes += resumeList.size();
            for (Resume<? extends JobRole> resume : resumeList) {
                if ("screened".equals(resume.getScreeningStatus()) ||
                        "interviewed".equals(resume.getScreeningStatus())) {
                    screenedResumes++;
                }
                avgScore += resume.getAiMatchScore();
            }
        }
        if (totalResumes > 0) {
            avgScore /= totalResumes;
            double screeningRate = (double) screenedResumes / totalResumes * 100;
            System.out.println("Screening Rate: " + String.format("%.1f%%", screeningRate));
            System.out.println("Average AI Match Score: " + String.format("%.1f%%", avgScore));
        }
    }
    public void displayAllResumes() {
        System.out.println("\n=== ALL RESUME APPLICATIONS ===");
        if (resumeDatabase.isEmpty() || processedResumes == 0) {
            System.out.println("No resumes in the system.");
            return;
        }
        for (Map.Entry<String, List<Resume<? extends JobRole>>> entry : resumeDatabase.entrySet()) {
            String roleName = entry.getKey();
            List<Resume<? extends JobRole>> resumes = entry.getValue();
            if (!resumes.isEmpty()) {
                System.out.println("\n--- " + roleName.toUpperCase() + " APPLICATIONS ---");
                resumes.stream()
                        .sorted((r1, r2) -> Integer.compare(r2.getAiMatchScore(), r1.getAiMatchScore()))
                        .forEach(resume -> System.out.println("  " + resume.toString()));
            }
        }
    }
    public <T extends JobRole> void scheduleInterviews(Class<T> jobRoleClass, int candidateCount) {
        System.out.println(String.format("\n=== SCHEDULING INTERVIEWS FOR TOP %d %s CANDIDATES ===",
                candidateCount, jobRoleClass.getSimpleName()));
        List<Resume<T>> topCandidates = findTopCandidates(jobRoleClass, candidateCount);
        for (Resume<T> resume : topCandidates) {
            resume.updateScreeningStatus("interviewed");
            System.out.println("Scheduled interview for: " + resume.getCandidateName() +
                    " (Score: " + resume.getAiMatchScore() + "%)");
            String[] rounds = resume.getTargetJobRole().getInterviewRounds();
            System.out.println("  Interview Rounds: " + Arrays.toString(rounds));
        }
    }
    public static void main(String[] args) {
        ResumeScreeningSystem system = new ResumeScreeningSystem("Tech Innovations Inc.");
        SoftwareEngineer seniorSWE = new SoftwareEngineer("senior", 5, 10, 120000, 180000);
        SoftwareEngineer midSWE = new SoftwareEngineer("mid", 2, 5, 80000, 120000);
        DataScientist seniorDS = new DataScientist("senior", 4, 8, 130000, 200000);
        ProductManager seniorPM = new ProductManager("senior", 3, 7, 110000, 160000);
        system.addJobPosition("SWE-001", seniorSWE);
        system.addJobPosition("SWE-002", midSWE);
        system.addJobPosition("DS-001", seniorDS);
        system.addJobPosition("PM-001", seniorPM);
        System.out.println("\n=== AI-DRIVEN RESUME SCREENING SYSTEM DEMO ===");
        Resume<SoftwareEngineer> resume1 = new Resume<>("R001", "John Smith", "john@email.com",
                "123-456-7890", seniorSWE, 6, "Master in Computer Science");
        resume1.addSkills(new String[] { "Java", "Python", "Spring", "Microservices", "Docker", "AWS" });
        resume1.addWorkExperience("Tech Corp", "Senior Developer", 36, "Led microservices architecture");
        resume1.addWorkExperience("StartupXYZ", "Full Stack Developer", 24, "Built scalable web applications");
        resume1.addCertification("AWS Certified Solutions Architect");
        resume1.addProject("E-commerce Platform with 1M+ users");
        Resume<SoftwareEngineer> resume2 = new Resume<>("R002", "Alice Johnson", "alice@email.com",
                "234-567-8901", midSWE, 3, "Bachelor in Computer Science");
        resume2.addSkills(new String[] { "Java", "React", "SQL", "Git", "Testing" });
        resume2.addWorkExperience("WebDev Co", "Software Developer", 36, "Developed web applications");
        resume2.addCertification("Oracle Java Certification");
        Resume<DataScientist> resume3 = new Resume<>("R003", "Dr. Sarah Chen", "sarah@email.com",
                "345-678-9012", seniorDS, 5, "PhD in Statistics");
        resume3.addSkills(new String[] { "Python", "R", "Machine Learning", "TensorFlow", "SQL", "Statistics" });
        resume3.addWorkExperience("Data Analytics Inc", "Senior Data Scientist", 30, "ML model development");
        resume3.addWorkExperience("Research Lab", "Data Analyst", 24, "Statistical analysis and research");
        resume3.addCertification("Google Cloud Professional ML Engineer");
        resume3.addProject("Predictive Analytics Platform");
        Resume<DataScientist> resume4 = new Resume<>("R004", "Mike Rodriguez", "mike@email.com",
                "456-789-0123", seniorDS, 3, "Master in Data Science");
        resume4.addSkills(new String[] { "Python", "Pandas", "SQL", "Machine Learning", "Tableau" });
        resume4.addWorkExperience("Analytics Corp", "Data Scientist", 36, "Business intelligence solutions");
        Resume<ProductManager> resume5 = new Resume<>("R005", "Emma Wilson", "emma@email.com",
                "567-890-1234", seniorPM, 4, "Master in Business Administration");
        resume5.addSkills(new String[] { "Product Strategy", "Analytics", "Agile", "A/B Testing", "SQL" });
        resume5.addWorkExperience("Product Co", "Senior Product Manager", 30, "Led product roadmap for SaaS platform");
        resume5.addWorkExperience("StartupABC", "Product Manager", 18, "0-1 product development");
        resume5.addCertification("Certified Scrum Product Owner");
        system.addResume(resume1);
        system.addResume(resume2);
        system.addResume(resume3);
        system.addResume(resume4);
        system.addResume(resume5);
        system.displayAllResumes();
        List<Resume<? extends JobRole>> qualifiedCandidates = system.screenResumesByScore(70);
        System.out.println("\nQualified Candidates (70%+ score):");
        qualifiedCandidates.forEach(resume -> System.out
                .println("  " + resume.getCandidateName() + " - " + resume.getAiMatchScore() + "%"));
        Map<String, List<Resume<? extends JobRole>>> batchResults = system.batchScreening(60);
        System.out.println("\n=== TOP SOFTWARE ENGINEER CANDIDATES ===");
        List<Resume<SoftwareEngineer>> topSWE = system.findTopCandidates(SoftwareEngineer.class, 3);
        topSWE.forEach(resume -> {
            System.out.println("  " + resume.getCandidateName() + " - Score: " + resume.getAiMatchScore() + "%");
            System.out.println("    " + resume.generateScreeningSummary());
        });
        System.out.println("\n=== CANDIDATES WITH 3-6 YEARS EXPERIENCE ===");
        List<Resume<? extends JobRole>> experiencedCandidates = system.findCandidatesByExperience(3, 6);
        experiencedCandidates.forEach(
                resume -> System.out.println("  " + resume.getCandidateName() + " (" + resume.getYearsOfExperience() +
                        " years) - " + resume.getTargetJobRole().getRoleName()));
        System.out.println("\n=== CANDIDATES WITH PYTHON SKILLS ===");
        List<Resume<? extends JobRole>> pythonDevelopers = system.findCandidatesBySkill("Python");
        pythonDevelopers.forEach(resume -> System.out
                .println("  " + resume.getCandidateName() + " - " + resume.getTargetJobRole().getRoleName()));
        system.scheduleInterviews(SoftwareEngineer.class, 2);
        system.scheduleInterviews(DataScientist.class, 1);
        system.generateDiversityReport();
        system.displaySystemMetrics();
        System.out.println("\n=== DETAILED SCREENING EXAMPLE ===");
        System.out.println(resume1.generateScreeningSummary());
        System.out.println("Missing Skills: " + resume1.getMissingSkills());
        System.out.println("Skill Match: " + String.format("%.1f%%", resume1.getSkillMatchPercentage()));
    }
}