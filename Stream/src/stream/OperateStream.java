package stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class OperateStream {


    private static void runMap(){
        DoubleStream.of(1.5,1.8,3.2,20)
                .map(Math::cos)
                .forEach(System.out::println);
    }

    private static void runFlatMap(){
        IntStream.range(1,10)
                .flatMap(n -> IntStream.of(n,n*n))
                .forEach(System.out::println);
    }
    private static void runPeek(){
        Double sum = IntStream.rangeClosed(1,5)
                .peek(System.out::println)
                .filter( n -> n % 2 ==1)
                .peek(System.out::println)
                .mapToDouble(Math::sqrt)
                .peek(System.out::println)
                .sum();
        _(sum);
    }

    private static  void runReduce(){
        int sum = IntStream.rangeClosed(1,5)
                .reduce(0,(left,right) -> left+right);
        _(sum);
    }

    private static void runStart(){
        DoubleSummaryStatistics state = new DoubleSummaryStatistics();
        state.accept(100);
        state.accept(300);
        state.accept(12323.3);
        state.accept(434.0);
        state.accept(1.00);
        long count = state.getCount();
        double sum = state.getSum();
        double average = state.getAverage();
        double max = state.getMax();
        double min = state.getMin();


        System.out.printf("counde=%d, sum=%.2f,min=%.2f,max=%.2f,average=%.2f%n",count,sum,min,max,average);

    }

    private  static  void _(Object o){
        System.out.println(o);
    }
    public static void main(String[] args) {
        //runMap();
        //runFlatMap();
        //runPeek();
        runReduce();
        runStart();
    }
}
