public class ProfitCalculator {
    public static void main(String[] args) {
        // Given values
        int costPrice = 129;
        int sellingPrice = 191;

        // Calculate profit and profit percentage
        int profit = sellingPrice - costPrice;
        double profitPercent = (profit * 100.0) / costPrice;

        // Print result using a single print statement with multiline text
        System.out.println(
                "The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + "\n" +
                        "The Profit is INR " + profit + " and the Profit Percentage is "
                        + String.format("%.2f", profitPercent) + "%");
    }
}
