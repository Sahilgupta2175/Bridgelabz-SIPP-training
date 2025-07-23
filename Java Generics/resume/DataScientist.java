package resume;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class DataScientist extends JobRole {
    public DataScientist(String level, int minExp, int maxExp, double minSalary, double maxSalary) {
        super("Data Scientist", "Data Science", level, minExp, maxExp, minSalary, maxSalary);
    }
    @Override
    public String[] getRequiredSkills() {
        switch (level.toLowerCase()) {
            case "junior":
                return new String[] { "Python", "R", "SQL", "Statistics", "Machine Learning",
                        "Data Visualization", "Pandas", "NumPy" };
            case "mid":
                return new String[] { "Python", "R", "SQL", "Statistics", "Machine Learning",
                        "Deep Learning", "TensorFlow", "Scikit-learn", "Data Mining", "A/B Testing" };
            case "senior":
                return new String[] { "Python", "R", "SQL", "Statistics", "Machine Learning",
                        "Deep Learning", "MLOps", "Big Data", "Research", "Team Leadership" };
            default:
                return new String[] { "Python", "Statistics", "Machine Learning" };
        }
    }
    @Override
    public String[] getPreferredSkills() {
        return new String[] { "Spark", "Hadoop", "Tableau", "PowerBI", "Docker", "Kubernetes",
                "AWS", "GCP", "Azure", "Jupyter", "Git", "NLP", "Computer Vision" };
    }
    @Override
    public String[] getRequiredEducation() {
        return new String[] { "Master in Data Science", "Master in Statistics",
                "Master in Computer Science", "PhD in relevant field",
                "Bachelor with strong analytics background" };
    }
    @Override
    public String[] getWorkEnvironments() {
        return new String[] { "remote", "hybrid", "onsite" };
    }
    @Override
    public String[] getInterviewRounds() {
        return new String[] { "Technical Screening", "Data Challenge", "Case Study",
                "Statistical Concepts", "Behavioral Interview" };
    }
    @Override
    public int calculateMatchScore(String[] candidateSkills, int experience, String education) {
        int score = 0;
        if (experience >= minExperience && experience <= maxExperience) {
            score += 25;
        } else if (experience >= minExperience - 1) {
            score += 15;
        }
        String[] required = getRequiredSkills();
        Set<String> candidateSkillSet = new HashSet<>(Arrays.asList(candidateSkills));
        int matchingSkills = 0;
        for (String skill : required) {
            if (candidateSkillSet.contains(skill)) {
                matchingSkills++;
            }
        }
        score += (matchingSkills * 45) / required.length;
        String[] preferred = getPreferredSkills();
        int preferredMatches = 0;
        for (String skill : preferred) {
            if (candidateSkillSet.contains(skill)) {
                preferredMatches++;
            }
        }
        score += Math.min(15, (preferredMatches * 15) / preferred.length);
        String[] requiredEducation = getRequiredEducation();
        for (String edu : requiredEducation) {
            if (education.toLowerCase().contains(edu.toLowerCase()) ||
                    edu.toLowerCase().contains(education.toLowerCase())) {
                score += 15;
                break;
            }
        }
        return Math.min(100, score);
    }
}