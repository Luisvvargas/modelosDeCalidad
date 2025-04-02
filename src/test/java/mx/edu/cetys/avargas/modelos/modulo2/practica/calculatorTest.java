package mx.edu.cetys.avargas.modelos.modulo2.practica;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    @Test
    void testAdd() {
        //given
        calculator calculator = new calculator();
        //when (not yet)

        //then
        assertEquals(2, calculator.add(1,1));
    }

    @Test
    void testSub() {
        calculator calculator = new calculator();
        assertEquals(1, calculator.sub(2,1));
    }

    @Test
    void testMul() {
        calculator calculator = new calculator();
        assertEquals(2, calculator.mul(2,1));
    }

    @Test
    void testDiv() {
        calculator calculator = new calculator();
        assertEquals(2, calculator.div(2,1));
    }

    @Test
    void TestDivByZero() {
        calculator Calculator = new calculator();
        assertThrows(ArithmeticException.class, () ->{
            Calculator.div(1,0);
        });
    }

}