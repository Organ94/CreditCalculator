public interface CreditCalculator {
    /**
     * Расчет ежемесячного платежа
     */
    double monthlyPayment(int numberOfMonths, double interestRatePerYear, int sum);

    /**
     * Расчет общей суммы кредита
     */
    double totalAmount(int numberOfMonths, double monthlyPayment);

    /**
     * Расчет размера переплат
     */
    double theAmountOfOverpayment(int sum, double totalAmount);
}