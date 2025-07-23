package university;
public class ExamCourse extends CourseType {
    private int numberOfExams;
    private boolean hasCompreReviewable;
    private double examWeightage; 
    public ExamCourse(int maxStudents, double creditHours, int numberOfExams,
            boolean hasComprehensive, double examWeightage) {
        super("Exam-Based", "Traditional examination-based evaluation", maxStudents, creditHours);
        this.numberOfExams = numberOfExams;
        this.hasCompreReviewable = hasComprehensive;
        this.examWeightage = examWeightage;
    }
    @Override
    public String getEvaluationMethod() {
        return String.format("Exams (%d total, %.1f%% weight) %s",
                numberOfExams, examWeightage,
                hasCompreReviewable ? "+ Comprehensive Final" : "");
    }
    @Override
    public double calculateWorkload() {
        double baseWorkload = creditHours * 2.5; 
        double examPrep = numberOfExams * 3; 
        return baseWorkload + examPrep;
    }
    @Override
    public String[] getRequiredResources() {
        return new String[] { "Classroom", "Exam Halls", "Invigilation Staff", "Answer Sheets", "Grading System" };
    }
    @Override
    public boolean isOnlineCompatible() {
        return false; 
    }
    public int getNumberOfExams() {
        return numberOfExams;
    }
    public boolean hasComprehensive() {
        return hasCompreReviewable;
    }
    public double getExamWeightage() {
        return examWeightage;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" [Exams: %d, Comprehensive: %s, Weight: %.1f%%]",
                numberOfExams, hasCompreReviewable, examWeightage);
    }
}