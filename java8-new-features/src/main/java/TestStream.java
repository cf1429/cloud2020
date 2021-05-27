import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author:chenf
 * @Date:2021/5/27 15:17
 * @describe
 */

/**
 * Stream 的三个操作
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        // 通过collection系列集合提供的stream（）或者parallelStream()获取流
        Stream<String> listStream = list.stream();

        //通过Arrays创建流
        Employee [] employees = new Employee[10] ;
        Stream<Employee> arrayStream = Arrays.stream(employees);

       // 通过Stream的of方法获取流
        Stream<String> aa = Stream.of("aa", "vv", "c");
        String [] str = {"aa","g","yt"};
        Stream<String> str1 = Stream.of(str);


        //创建无限流 迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        //产生无限个
        //iterate.forEach(System.out::println);
        //产生10个
        //iterate.limit(10).forEach(System.out::println);


        //生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
        // 产生无限个
        //generate.forEach(System.out::println);

        //产生10个
        generate.limit(10).forEach(System.out::println);
    }


}
