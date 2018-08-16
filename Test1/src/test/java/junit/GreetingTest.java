package junit;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
public class GreetingTest {
    @org.junit.jupiter.api.Test
    void TestSayHello(){
        Greeting greeting = new Greeting();
        assertEquals("g'day",greeting.sayHello());
    }
}
