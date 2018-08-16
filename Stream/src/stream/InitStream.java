package stream;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class InitStream {


    public static Stream<String> initByBuilder(){
        return  Stream.<String>builder()
                .add("web")
                .add("java")
                .add("c++")
                .add("os")
                .build();
    }

    public static Stream<String> initByCollection(){
        Set<String> names = new HashSet<String>();
        names.add("web");
        names.add("java");
        names.add("os");
        names.add("c");
        return names.stream();
    }

    private static void initByOf(){
        Stream<String> stream = Stream.of("we are dharma");
    }

    public static void main(String[] args) {
        Stream<String> stream = initByBuilder();
        stream.forEach(System.out::println);

        Stream<String> stream1 = initByCollection();
        stream1.forEach(System.out::println);

        Stream<String> stream2 = Stream.empty();
        stream2.forEach(System.out::println);

        Stream stream3 = Stream.generate(new Random()::nextInt);
        stream3.limit(5).forEach(System.out::println);
    }
}
