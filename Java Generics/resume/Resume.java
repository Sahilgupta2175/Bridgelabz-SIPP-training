package resume;
import java.util.*;
import java.time.LocalDate;
public class Resume<T extends JobRole> {
    private String resumeId;
    private String candidateName;
    private String email;
    private String phone;
    private T targetJobRole;
    private int yearsOfExperience;
    private String education;
    private List<String> skills;
    private List<WorkExperience> workHistory;
    private List<String> certifications;
    private List<String> projects;
    private Map<String, String> additionalInfo;
    private LocalDate submissionDate;
    private int aiMatchScore;
    private String screeningStatus; 
    public Resume(String resumeId, String candidateName, String email, String phone,
            T targetJobRole, int yearsOfExperience, String education) {
        this.resumeId = resumeId;
        this.candidateName = candidateName;
        this.email = email;
        this.phone = phone;
        this.targetJobRole = targetJobRole;
        this.yearsOfExperience = yearsOfExperience;
        this.education = education;
        this.skills = new ArrayList<>();
        this.workHistory = new ArrayList<>();
        this.certifications = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.additionalInfo = new HashMap<>();
        this.submissionDate = LocalDate.now();
        this.screeningStatus = "pending";
        this.aiMatchScore = 0;
    }
    public void addSkill(String skill) {
        if (!skills.contains(skill)) {
            skills.add(skill);
        }
    }
    public void addSkills(String[] skillArray) {
        for (String skill : skillArray) {
            addSkill(skill);
        }
    }
    public void addWorkExperience(String company, String position, int durationMonths, String description) {
        workHistory.add(new WorkExperience(company, position, durationMonths, description));
    }
    public void addCertification(String certification) {
        certifications.add(certification);
    }
    public void addProject(String project) {
        projects.add(project);
    }
    public void addAdditionalInfo(String key, String value) {
        additionalInfo.put(key, value);
    }
    public void calculateAIMatchScore() {
        String[] skillsArray = skills.toArray(new String[0]);
        aiMatchScore = targetJobRole.calculateMatchScore(skillsArray, yearsOfExperience, education);
    }
    public void updateScreeningStatus(String status) {
        this.screeningStatus = status;
        System.out.println("Updated screening status for " + candidateName + " to: " + status);
    }
    public boolean meetsMinimumRequirements() {
        if (yearsOfExperience < targetJobRole.getMinExperience()) {
            return false;
        }
        String[] requiredSkills = targetJobRole.getRequiredSkills();
        int matchingSkills = 0;
        for (String required : requiredSkills) {
            if (skills.contains(required)) {
                matchingSkills++;
            }
        }
        return (double) matchingSkills / requiredSkills.length >= 0.3;
    }
    public String getExperienceLevel() {
        if (yearsOfExperience <= 2)
            return "Junior";
        else if (yearsOfExperience <= 5)
            return "Mid-level";
        else if (yearsOfExperience <= 10)
            return "Senior";
        else
            return "Expert";
    }
    public double getSkillMatchPercentage() {
        String[] requiredSkills = targetJobRole.getRequiredSkills();
        int matchingSkills = 0;
        for (String required : requiredSkills) {
            if (skills.contains(required)) {
                matchingSkills++;
            }
        }
        return requiredSkills.length > 0 ? (double) matchingSkills / requiredSkills.length * 100 : 0;
    }
    public List<String> getMissingSkills() {
        List<String> missing = new ArrayList<>();
        String[] requiredSkills = targetJobRole.getRequiredSkills();
        for (String required : requiredSkills) {
            if (!skills.contains(required)) {
                missing.add(required);
            }
        }
        return missing;
    }
    public String generateScreeningSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== SCREENING SUMMARY ===\n");
        summary.append("Candidate: ").append(candidateName).append("\n");
        summary.append("Target Role: ").append(targetJobRole.getRoleName()).append("\n");
        summary.append("AI Match Score: ").append(aiMatchScore).append("%\n");
        summary.append("Experience Level: ").append(getExperienceLevel()).append(" (")
                .append(yearsOfExperience).append(" years)\n");
        summary.append("Skill Match: ").append(String.format("%.1f%%", getSkillMatchPercentage())).append("\n");
        summary.append("Meets Minimum Requirements: ").append(meetsMinimumRequirements() ? "YES" : "NO").append("\n");
        summary.append("Status: ").append(screeningStatus.toUpperCase()).append("\n");
        if (!getMissingSkills().isEmpty()) {
            summary.append("Missing Skills: ").append(getMissingSkills()).append("\n");
        }
        return summary.toString();
    }
    public String getResumeId() {
        return resumeId;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public T getTargetJobRole() {
        return targetJobRole;
    }
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public String getEducation() {
        return education;
    }
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }
    public List<WorkExperience> getWorkHistory() {
        return new ArrayList<>(workHistory);
    }
    public List<String> getCertifications() {
        return new ArrayList<>(certifications);
    }
    public List<String> getProjects() {
        return new ArrayList<>(projects);
    }
    public Map<String, String> getAdditionalInfo() {
        return new HashMap<>(additionalInfo);
    }
    public LocalDate getSubmissionDate() {
        return submissionDate;
    }
    public int getAiMatchScore() {
        return aiMatchScore;
    }
    public String getScreeningStatus() {
        return screeningStatus;
    }
    @Override
    public String toString() {
        return String.format("Resume[ID: %s, Candidate: %s, Role: %s, Experience: %d years, " +
                "Score: %d%%, Status: %s, Skills: %d]",
                resumeId, candidateName, targetJobRole.getRoleName(), yearsOfExperience,
                aiMatchScore, screeningStatus, skills.size());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Resume<?> resume = (Resume<?>) obj;
        return Objects.equals(resumeId, resume.resumeId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(resumeId);
    }
    public static class WorkExperience {
        private String company;
        private String position;
        private int durationMonths;
        private String description;
        public WorkExperience(String company, String position, int durationMonths, String description) {
            this.company = company;
            this.position = position;
            this.durationMonths = durationMonths;
            this.description = description;
        }
        public String getCompany() {
            return company;
        }
        public String getPosition() {
            return position;
        }
        public int getDurationMonths() {
            return durationMonths;
        }
        public String getDescription() {
            return description;
        }
        @Override
        public String toString() {
            return String.format("%s at %s (%d months) - %s", position, company, durationMonths, description);
        }
    }
}