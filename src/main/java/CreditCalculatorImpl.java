public class CreditCalculatorImpl implements CreditCalculator {

    double monthlyPayment, totalAmount;
    @Override
    public double monthlyPayment(int numberOfMonths, double interestRatePerYear, int sum) {
        monthlyPayment =
                (sum * interestRatePerYear / 12) / (1 - Math.pow((1 + interestRatePerYear / 12), -numberOfMonths));
        return monthlyPayment;
    }

    @Override
    public double totalAmount(int numberOfMonths, double monthlyPayment) {
        totalAmount = monthlyPayment * numberOfMonths;
        return totalAmount;
    }

    @Override
    public double theAmountOfOverpayment(int sum, double totalAmount) {
        return totalAmount - sum;
    }
}
