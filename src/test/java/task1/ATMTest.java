package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @Test
    void testSuccessfulWithdrawal() {
        atm.giveMeYourMoney(870);
    }

    @Test
    void testWithdrawalNotDivisibleByDenominations() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> atm.giveMeYourMoney(45));
        assertEquals("Not enough currency in the ATM!", exception.getMessage());
    }
}
