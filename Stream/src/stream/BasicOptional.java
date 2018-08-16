package stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class BasicOptional {
    private static void _(Object o){
        System.out.println(o);
    }

    private static void optionalStrem(){
        OptionalInt maxOdd = IntStream.of(10,20,30,40)
                .filter(n -> n%2 ==1)
                .max();
        if(maxOdd.isPresent()){
            _(maxOdd.getAsInt());
        }else {
            _("saad ddd");
        }
    }

    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        _(empty);

        Optional<String> str = Optional.of("slicing");
        _(str);

        String nullString = "";
        Optional<String> nullstr = Optional.of(nullString);
        _(nullstr);

        OptionalInt num = OptionalInt.of(2018);
        if(num.isPresent()){
            _(num.getAsInt());
        }else {
            _("number empty");
        }
    }
}
