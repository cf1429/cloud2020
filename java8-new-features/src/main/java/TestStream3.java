import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author:chenf
 * @Date:2021/5/27 16:07
 * @describe
 */
public class TestStream3 {



    /**
     * 中间操作
     */

    Employee [] employees = {
            new Employee(1,"张三",20),
            new Employee(2,"李四",10),
            new Employee(3,"王三",50),
            new Employee(3,"王八",50),
            new Employee(3,"王三",50)} ;
    List<Employee> employees1 = Arrays.asList(employees);

    /**
     * 内部迭代
     */
    @Test
    public void test1(){


        List<Employee> employees2 = new ArrayList<>();

        Stream<Employee> employeeStream = employees1.stream().filter((e) -> e.getAge() >=20);
        employeeStream.forEach((e)-> employees2.add(e));

        System.out.println("遍历筛选之后的数据");

        employees2.forEach(System.out::println);

    }

    /**
     * 外部迭代
     */
    @Test
    public void test2(){
        System.out.println("外部迭代");
        Iterator<Employee> iterator = employees1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    /**
     * limit 截断流，找到对应数据之后就不会执行后续的操作了，会有短路的含义，即发现符合条件的数据之后就不会执行后续的操作了
     */
    @Test
    public void test3(){
        employees1.stream().filter(e->e.getAge()>10).limit(1).forEach(System.out::println);

    }

    /**
     * skip 跳过前一个，取除了前一个后面的数据
     */
    @Test
    public void test4(){
        employees1.stream().filter(e->e.getAge()>10).skip(1).forEach(System.out::println);
    }

    /**
     * distinct  去重，必须要借助equals（）和hashcode（）才生效
     */
    @Test
    public void test5(){
        employees1.stream().filter(e->e.getAge()>10).skip(1).distinct().forEach(System.out::println);

    }
}
