package resume;
public abstract class JobRole {
    protected String roleName;
    protected String department;
    protected String level; 
    protected int minExperience; 
    protected int maxExperience;
    protected double minSalary;
    protected double maxSalary;
    public JobRole(String roleName, String department, String level,
            int minExperience, int maxExperience, double minSalary, double maxSalary) {
        this.roleName = roleName;
        this.department = department;
        this.level = level;
        this.minExperience = minExperience;
        this.maxExperience = maxExperience;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
    public abstract String[] getRequiredSkills();
    public abstract String[] getPreferredSkills();
    public abstract String[] getRequiredEducation();
    public abstract String[] getWorkEnvironments(); 
    public abstract int calculateMatchScore(String[] candidateSkills, int experience, String education);
    public abstract String[] getInterviewRounds();
    public String getRoleName() {
        return roleName;
    }
    public String getDepartment() {
        return department;
    }
    public String getLevel() {
        return level;
    }
    public int getMinExperience() {
        return minExperience;
    }
    public int getMaxExperience() {
        return maxExperience;
    }
    public double getMinSalary() {
        return minSalary;
    }
    public double getMaxSalary() {
        return maxSalary;
    }
    @Override
    public String toString() {
        return String.format("%s[Role: %s, Dept: %s, Level: %s, Experience: %d-%d years, Salary: $%.0f-%.0f]",
                getClass().getSimpleName(), roleName, department, level,
                minExperience, maxExperience, minSalary, maxSalary);
    }
}