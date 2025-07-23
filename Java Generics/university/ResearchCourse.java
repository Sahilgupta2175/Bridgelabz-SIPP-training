package university;
public class ResearchCourse extends CourseType {
    private String researchArea;
    private boolean requiresThesis;
    private int minPublications;
    private String supervisorLevel; 
    public ResearchCourse(int maxStudents, double creditHours, String researchArea,
            boolean requiresThesis, int minPublications, String supervisorLevel) {
        super("Research-Based", "Research-oriented course with thesis/project", maxStudents, creditHours);
        this.researchArea = researchArea;
        this.requiresThesis = requiresThesis;
        this.minPublications = minPublications;
        this.supervisorLevel = supervisorLevel;
    }
    @Override
    public String getEvaluationMethod() {
        return String.format("Research Project in %s %s %s",
                researchArea,
                requiresThesis ? "+ Thesis Defense" : "",
                minPublications > 0 ? String.format("+ %d Publications", minPublications) : "");
    }
    @Override
    public double calculateWorkload() {
        double baseWorkload = creditHours * 4.0; 
        if (requiresThesis) {
            baseWorkload += 8; 
        }
        if (minPublications > 0) {
            baseWorkload += minPublications * 5; 
        }
        return baseWorkload;
    }
    @Override
    public String[] getRequiredResources() {
        return new String[] { "Research Lab", "Library Access", "Research Databases",
                "Supervisor Meetings", "Research Equipment", "Publication Support",
                "Conference Funding", "Statistical Software" };
    }
    @Override
    public boolean isOnlineCompatible() {
        return true; 
    }
    public String getResearchArea() {
        return researchArea;
    }
    public boolean requiresThesis() {
        return requiresThesis;
    }
    public int getMinPublications() {
        return minPublications;
    }
    public String getSupervisorLevel() {
        return supervisorLevel;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" [Area: %s, Thesis: %s, Publications: %d, Supervisor: %s]",
                researchArea, requiresThesis, minPublications, supervisorLevel);
    }
}