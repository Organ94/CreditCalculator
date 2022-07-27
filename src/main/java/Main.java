import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        int sum, numberOfMonths;
        double interestRatePerYear;

        CreditCalculator creditCalculator = new CreditCalculatorImpl();

        System.out.print("Введите сумму кредита:\n>> ");
        sum = SCANNER.nextInt();
        System.out.print("Введите срок кредита в месяцах:\n>> ");
        numberOfMonths = SCANNER.nextInt();
        System.out.print("Введите процентную ставку годовых по кредиту:\n>> ");
        interestRatePerYear = SCANNER.nextDouble() / 100;

        double monthlyPayment = creditCalculator.monthlyPayment(numberOfMonths, interestRatePerYear, sum);
        double totalAmount = creditCalculator.totalAmount(numberOfMonths, monthlyPayment);
        double theAmountOfOverpayment = creditCalculator.theAmountOfOverpayment(sum, totalAmount);
        System.out.printf("""
                        Ваш ежемесячный платеж составит: %s
                        Сумма выплат по кредиту с учетом процентов составит: %s
                        Размер переплат по кредиту составит: %s""",
                monthlyPayment, totalAmount, theAmountOfOverpayment);
    }
}
