package resume;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class ProductManager extends JobRole {
    public ProductManager(String level, int minExp, int maxExp, double minSalary, double maxSalary) {
        super("Product Manager", "Product", level, minExp, maxExp, minSalary, maxSalary);
    }
    @Override
    public String[] getRequiredSkills() {
        switch (level.toLowerCase()) {
            case "junior":
                return new String[] { "Product Strategy", "Market Research", "Analytics",
                        "Agile", "Roadmapping", "Stakeholder Management" };
            case "mid":
                return new String[] { "Product Strategy", "Market Research", "Analytics",
                        "Agile", "Roadmapping", "A/B Testing", "User Research",
                        "Cross-functional Leadership", "Data-driven Decision Making" };
            case "senior":
                return new String[] { "Product Strategy", "Market Research", "Analytics",
                        "Strategic Planning", "Team Leadership", "P&L Management",
                        "Go-to-Market", "Product Portfolio Management" };
            default:
                return new String[] { "Product Management", "Analytics", "Agile" };
        }
    }
    @Override
    public String[] getPreferredSkills() {
        return new String[] { "SQL", "Python", "Tableau", "Figma", "JIRA", "Confluence",
                "Customer Development", "UX/UI Understanding", "Technical Background",
                "Growth Hacking", "Marketing", "Finance" };
    }
    @Override
    public String[] getRequiredEducation() {
        return new String[] { "Bachelor in Business", "Bachelor in Engineering",
                "Master in Business Administration", "Bachelor in Computer Science",
                "Any Bachelor with Product Management experience" };
    }
    @Override
    public String[] getWorkEnvironments() {
        return new String[] { "hybrid", "onsite", "remote" };
    }
    @Override
    public String[] getInterviewRounds() {
        return new String[] { "Screening Interview", "Product Case Study", "Analytics Challenge",
                "Stakeholder Scenario", "Executive Interview" };
    }
    @Override
    public int calculateMatchScore(String[] candidateSkills, int experience, String education) {
        int score = 0;
        if (experience >= minExperience && experience <= maxExperience) {
            score += 35;
        } else if (experience >= minExperience - 1) {
            score += 25;
        }
        String[] required = getRequiredSkills();
        Set<String> candidateSkillSet = new HashSet<>(Arrays.asList(candidateSkills));
        int matchingSkills = 0;
        for (String skill : required) {
            if (candidateSkillSet.contains(skill)) {
                matchingSkills++;
            }
        }
        score += (matchingSkills * 35) / required.length;
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