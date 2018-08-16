package stream.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStream {
    private static List<Student> register(){
        Student s1 = new Student(1L,"xiaoxiao", Student.Gender.FEMALE,200, LocalDate.of(2016, Month.SEPTEMBER,1), Student.Department.CL);
        Student s2 = new Student(2L,"xiaoxiao1", Student.Gender.MALE,400, LocalDate.of(2016, Month.SEPTEMBER,1), Student.Department.CN);
        Student s3 = new Student(3L,"xiaoxiao2", Student.Gender.FEMALE,100, LocalDate.of(2016, Month.SEPTEMBER,1), Student.Department.CS);
        Student s4 = new Student(4L,"xiaoxiao3", Student.Gender.MALE,800, LocalDate.of(2016, Month.SEPTEMBER,1), Student.Department.EE);
        Student s5 = new Student(5L,"xiaoxiao4", Student.Gender.FEMALE,800, LocalDate.of(2016, Month.SEPTEMBER,1), Student.Department.CS);

        return Arrays.asList(s1,s2,s3,s4,s5);
    }
    public static void _(Object o){
        System.out.println(o);
    }

    public static void __(String prefix,Object o){
        System.out.println(prefix + o);
    }

    public static void main(String[] args) {

        List<Student> students = register();
        Stream<Student> studentStream = students.stream();
        _(students);

        int  studentCount = students.stream().mapToInt((s) -> 1).sum();
        __("student num " , studentCount);



        int totalCredits = studentStream.mapToInt(Student::getCredit).sum();
        _(totalCredits);

        Map<Student.Gender,Long> groupCountByGender =
                students.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
        _(groupCountByGender);

        Optional<Student> max = students.stream()
                .max(Comparator.comparingInt(Student::getCredit));
        Optional<Student> max1 = students.stream()
                .max((s1,s2)->s2.getCredit() - s1.getCredit());
        _(max1.get().getName());
        _(max.get().getName());

        Integer sumCredit = students.stream()
                //.mapToInt(Student::getCredit)
                .reduce(0,(Integer parSum,Student s) -> {
                    Integer midsum = parSum + s.getCredit();
                    return midsum;
                },(a,b) ->{
                    return null;
                });
        _(sumCredit);


        boolean allMale = students.stream().allMatch(Student::isFaMale);
        boolean anyMale = students.stream().anyMatch(Student::isMale);
        _(allMale);
        _(anyMale);

        LongSummaryStatistics creditStates = students.stream()
                .map(Student::getCredit)
                .collect(LongSummaryStatistics::new,
                        LongSummaryStatistics::accept,
                        LongSummaryStatistics::combine);
        _(creditStates);

        LongSummaryStatistics creditStates1 = students.stream()
                .collect(Collectors.summarizingLong(Student::getCredit));
        _(creditStates1);

        Double creditAvg = students.stream()
                .collect(Collectors.averagingDouble(Student::getCredit));
        _(creditAvg);

        Map<Long,String> idNameMap = students.stream()
                .collect(Collectors.toMap(Student::getId,Student::getName));
        _(idNameMap);

        String names = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",","XUPT-","-Network"));
        _(names);

        Optional<Student> hasFemale = students.stream()
                .filter(Student::isFaMale)
                .findAny();
        if(hasFemale.isPresent()){
            __("hahahaha      ",hasFemale.get().getName());
        }

    }
}
