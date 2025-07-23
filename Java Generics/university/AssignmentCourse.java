package university;
public class AssignmentCourse extends CourseType {
    private int numberOfAssignments;
    private boolean hasGroupProjects;
    private String submissionFormat; 
    public AssignmentCourse(int maxStudents, double creditHours, int numberOfAssignments,
            boolean hasGroupProjects, String submissionFormat) {
        super("Assignment-Based", "Continuous assessment through assignments", maxStudents, creditHours);
        this.numberOfAssignments = numberOfAssignments;
        this.hasGroupProjects = hasGroupProjects;
        this.submissionFormat = submissionFormat;
    }
    @Override
    public String getEvaluationMethod() {
        return String.format("Assignments (%d total) %s, Submission: %s",
                numberOfAssignments,
                hasGroupProjects ? "+ Group Projects" : "",
                submissionFormat);
    }
    @Override
    public double calculateWorkload() {
        double baseWorkload = creditHours * 2.0; 
        double assignmentWork = numberOfAssignments * 4; 
        if (hasGroupProjects) {
            assignmentWork += 2; 
        }
        return baseWorkload + assignmentWork;
    }
    @Override
    public String[] getRequiredResources() {
        if ("digital".equals(submissionFormat)) {
            return new String[] { "LMS Platform", "File Storage", "Plagiarism Checker", "Grading Tools" };
        } else if ("physical".equals(submissionFormat)) {
            return new String[] { "Classroom", "Storage Space", "Binding Facilities", "Physical Grading" };
        } else {
            return new String[] { "LMS Platform", "Classroom", "File Storage", "Plagiarism Checker",
                    "Storage Space", "Grading Tools" };
        }
    }
    @Override
    public boolean isOnlineCompatible() {
        return "digital".equals(submissionFormat) || "both".equals(submissionFormat);
    }
    public int getNumberOfAssignments() {
        return numberOfAssignments;
    }
    public boolean hasGroupProjects() {
        return hasGroupProjects;
    }
    public String getSubmissionFormat() {
        return submissionFormat;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" [Assignments: %d, Group Projects: %s, Format: %s]",
                numberOfAssignments, hasGroupProjects, submissionFormat);
    }
}