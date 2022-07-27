import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCalculatorTest {

    private static final int SUM = 10_000;
    private static final int NUMBER_OF_MONTHS = 12;
    private static final double INTEREST_RATE_PER_YEAR = 0.1;
    private static final double THE_FORMULA_FOR_CALCULATING_THE_MONTHLY_PAYMENT =
            (SUM * INTEREST_RATE_PER_YEAR / 12) / (1 - Math.pow((1 + INTEREST_RATE_PER_YEAR / 12), -NUMBER_OF_MONTHS));

    @Test
    @DisplayName("Тест на расчет ежемесячного платежа")
    void successMonthlyPayment() {
        CreditCalculator creditCalculator = new CreditCalculatorImpl();

        var monthlyPayment = creditCalculator.monthlyPayment(NUMBER_OF_MONTHS, INTEREST_RATE_PER_YEAR, SUM);
        Assertions.assertTrue(
                THE_FORMULA_FOR_CALCULATING_THE_MONTHLY_PAYMENT == monthlyPayment,
                "Вычисление ежемесячного платежа " + monthlyPayment);
    }

    @Test
    @DisplayName("Тест на расчет суммы выплат по кредиту с учетом процентов")
    void successTotalAmount() {
        CreditCalculator creditCalculator = new CreditCalculatorImpl();

        var totalAmount =
                creditCalculator.totalAmount(NUMBER_OF_MONTHS, THE_FORMULA_FOR_CALCULATING_THE_MONTHLY_PAYMENT);
        Assertions.assertTrue(
                THE_FORMULA_FOR_CALCULATING_THE_MONTHLY_PAYMENT * NUMBER_OF_MONTHS == totalAmount,
                "Вычисление суммы выплат по кредиту с учетом процентов" + totalAmount);
    }

    @Test
    @DisplayName("Тест на вычисление суммы переплат по кредиту")
    void successTheAmountOfOverpayment() {
        CreditCalculator creditCalculator = new CreditCalculatorImpl();

        var theAmountOfOverpayment = creditCalculator.theAmountOfOverpayment(
                SUM, THE_FORMULA_FOR_CALCULATING_THE_MONTHLY_PAYMENT * NUMBER_OF_MONTHS);
        Assertions.assertTrue(
                THE_FORMULA_FOR_CALCULATING_THE_MONTHLY_PAYMENT * NUMBER_OF_MONTHS - SUM == theAmountOfOverpayment,
                "Вычисление размера переплат " + theAmountOfOverpayment);
    }
}