package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(JUnitPlatform.class)
public class TranslateServiceTest {
    private TranslateService translateService;
    @BeforeEach
    void setup(){
        translateService = new TranslateService();
    }


    @Test
    void test1(){
        assertEquals("Bonjour",translateService.translate("hello"));
    }

    @Test
    void test2(){
        assertEquals("Merci",translateService.translate("THAnk yOu"));
    }

    @Test
    void test3(){
        assertEquals("No fount",translateService.translate("shajhsajshaks"));
    }

    @Test
    void test4(){
        assertThrows(IllegalArgumentException.class,()->{translateService.translate("");});
    }



    @Test
    void test5(){
        Throwable ex = assertThrows(IllegalArgumentException.class,()->translateService.translate(""));
        assertEquals("Translating .....  ",ex.getMessage());
    }

    @AfterEach
    void treadown(){
        translateService = null;
    }
}
