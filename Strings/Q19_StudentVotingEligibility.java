public class Q19_StudentVotingEligibility {

    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int) (Math.random() * 50); // 0-49
        }
        return ages;
    }

    public static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] >= 18)
                result[i][1] = "true";
            else
                result[i][1] = "false";
        }
        return result;
    }

    public static void display(String[][] data) {
        System.out.println("Age\tCan Vote?");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] data = canVote(ages);
        display(data);
    }
}
