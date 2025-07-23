package university;
public abstract class CourseType {
    protected String typeName;
    protected String description;
    protected int maxStudents;
    protected double creditHours;
    public CourseType(String typeName, String description, int maxStudents, double creditHours) {
        this.typeName = typeName;
        this.description = description;
        this.maxStudents = maxStudents;
        this.creditHours = creditHours;
    }
    public abstract String getEvaluationMethod();
    public abstract double calculateWorkload(); 
    public abstract String[] getRequiredResources();
    public abstract boolean isOnlineCompatible();
    public String getTypeName() {
        return typeName;
    }
    public String getDescription() {
        return description;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public double getCreditHours() {
        return creditHours;
    }
    @Override
    public String toString() {
        return String.format("%s[Type: %s, Credits: %.1f, Max Students: %d, Workload: %.1f hrs/week, Online: %s]",
                getClass().getSimpleName(), typeName, creditHours, maxStudents,
                calculateWorkload(), isOnlineCompatible());
    }
}