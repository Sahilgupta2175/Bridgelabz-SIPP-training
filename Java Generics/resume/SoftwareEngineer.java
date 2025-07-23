package resume;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String level, int minExp, int maxExp, double minSalary, double maxSalary) {
        super("Software Engineer", "Engineering", level, minExp, maxExp, minSalary, maxSalary);
    }
    @Override
    public String[] getRequiredSkills() {
        switch (level.toLowerCase()) {
            case "junior":
                return new String[] { "Java", "Python", "Git", "SQL", "OOP", "Data Structures" };
            case "mid":
                return new String[] { "Java", "Python", "Git", "SQL", "Spring", "REST API",
                        "Microservices", "Testing", "Design Patterns" };
            case "senior":
                return new String[] { "Java", "Python", "Git", "SQL", "Spring", "REST API",
                        "Microservices", "System Design", "Architecture", "Leadership" };
            default:
                return new String[] { "Programming", "Git", "SQL" };
        }
    }
    @Override
    public String[] getPreferredSkills() {
        return new String[] { "Docker", "Kubernetes", "AWS", "React", "Angular", "Node.js",
                "MongoDB", "Redis", "CI/CD", "Agile" };
    }
    @Override
    public String[] getRequiredEducation() {
        return new String[] { "Bachelor in Computer Science", "Bachelor in Engineering",
                "Master in Computer Science", "Equivalent Experience" };
    }
    @Override
    public String[] getWorkEnvironments() {
        return new String[] { "remote", "hybrid", "onsite" };
    }
    @Override
    public String[] getInterviewRounds() {
        return new String[] { "Technical Screening", "Coding Challenge", "System Design",
                "Behavioral Interview", "Final Interview" };
    }
    @Override
    public int calculateMatchScore(String[] candidateSkills, int experience, String education) {
        int score = 0;
        if (experience >= minExperience && experience <= maxExperience) {
            score += 30;
        } else if (experience >= minExperience - 1) {
            score += 20; 
        }
        String[] required = getRequiredSkills();
        Set<String> candidateSkillSet = new HashSet<>(Arrays.asList(candidateSkills));
        int matchingSkills = 0;
        for (String skill : required) {
            if (candidateSkillSet.contains(skill)) {
                matchingSkills++;
            }
        }
        score += (matchingSkills * 40) / required.length;
        String[] preferred = getPreferredSkills();
        int preferredMatches = 0;
        for (String skill : preferred) {
            if (candidateSkillSet.contains(skill)) {
                preferredMatches++;
            }
        }
        score += Math.min(20, (preferredMatches * 20) / preferred.length);
        String[] requiredEducation = getRequiredEducation();
        for (String edu : requiredEducation) {
            if (education.toLowerCase().contains(edu.toLowerCase()) ||
                    edu.toLowerCase().contains(education.toLowerCase())) {
                score += 10;
                break;
            }
        }
        return Math.min(100, score);
    }
}