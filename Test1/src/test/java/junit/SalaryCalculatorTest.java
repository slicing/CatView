package junit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
public class SalaryCalculatorTest {
    private SalaryCalculator salaryCalculator;


    @BeforeEach
    void init(){
        salaryCalculator = new SalaryCalculator();
    }

    @Test
    void shouldCalculaSalary(){
        double basicSalary = 10000;
        salaryCalculator.setBasicSalary(basicSalary);

        assertEquals(2000,salaryCalculator.getSocialInsurance());
        assertEquals(1000,salaryCalculator.getAdditionalBonus());
        assertEquals(13000,salaryCalculator.getGrossSalary());
    }

    @Test
    void shouldThrowException(){
        double basicSalary = -100;
        Throwable ex = assertThrows(IllegalArgumentException.class,()->{salaryCalculator.setBasicSalary(basicSalary);});
        assertEquals("hahha",ex.getMessage());
    }
    @AfterEach
    void tearddown(){
        salaryCalculator = null;
    }


}
