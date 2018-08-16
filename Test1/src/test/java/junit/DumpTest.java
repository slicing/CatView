package junit;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@RunWith(JUnitPlatform.class)
public class DumpTest {
    private static Dump dump;

    @BeforeAll
    static void init(){
        dump = new Dump();
    }

    @Test
    public void shouldGetSumForNumbers(){
        assertTrue(dump.getSum(1,2,3) == 6,()->"sgsgss");
    }

    @Test
    void shouldGetNumber(){
        final int[] numbers = dump.getNumbers();
        assertAll("numbers",
                ()->assertEquals(0,numbers[0]),
                ()->assertEquals(1,numbers[1]),
                ()->assertEquals(2,numbers[2]),
                ()->assertEquals(3,numbers[3])
        );
    }

    @Test
    void shouldTrueAssumtion(){
        assumeTrue(true);
        assertEquals(5+2,7);
    }
    @DisplayName("newNameOn")
    @Test
    void shouldAssumtionThatOne(){
        String someString = "Just a String".concat("!");
        assumingThat(someString.equals("Just a String"),()->assertEquals(2+2,2));
    }
}
