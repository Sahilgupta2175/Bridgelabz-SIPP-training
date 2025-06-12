public class ProfitCalculator {
    public static void main(String[] args) {
        double costPrice = 129;
        double sellingPrice = 191;
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;
        System.out.printf("The Cost Price is INR %.0f and the Selling Price is INR %.0f%n" +
                         "The Profit is INR %.0f and the Profit Percentage is %.2f%%%n",
                         costPrice, sellingPrice, profit, profitPercentage);
    }
}