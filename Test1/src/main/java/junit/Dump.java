package junit;

import java.util.stream.Stream;

public class Dump {

    public int getSum(Integer... number){
        return Stream.of(number)
                .mapToInt(i ->i)
                .sum();
    }

    public int[] getNumbers(){
        return new int[]{0,1,2,3,4};
    }
}
