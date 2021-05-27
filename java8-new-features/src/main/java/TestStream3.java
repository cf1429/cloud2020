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

    /**
     * map 映射, 将元素转换成其他形式，或者提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素，
     * flatmap 接收一个函数作为参数，将流中的每一个值都换成另外一个流，然后把所有的流连成一个流
     */
    @Test
    public void test6(){
        List<String> list = Arrays.asList("aa","bb");
        list.stream().map(str-> str.toUpperCase()).forEach(System.out::println);

        System.out.println("获取对象的某个属性------");

        employees1.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("双层流遍历---------map");
        // 双层流遍历
        Stream<Stream<Character>> streamStream = list.stream().map(str -> filterCharacter(str));
        streamStream.forEach(stream ->{
            stream.forEach(str-> System.out.println(str));  // 前面等价于后面  stream.forEach(System.out::println);
        });


        System.out.println("-------flatmap");

        Stream<Character> characterStream = list.stream().flatMap(s -> this.filterCharacter(s));
        characterStream.forEach(System.out::println);

    }

    /**
     * 测试list的add() 和 addAll（）的区别
     */
    @Test
    public void test7(){
        List<String> list = Arrays.asList("aa","bb");

        List list2 = new ArrayList();
        System.out.println("------------add()");
        list2.add(11);
        list2.add(22);
        list2.add(list);
        System.out.println(list2);   //输出结果：[11, 22, [aa, bb]]   add 是将list集合整体添加到list2中
        System.out.println("-------------addAll()");
        list2.addAll(list);
        System.out.println(list2);  //输出结果：[11, 22, aa, bb]      addAll是将list集合中的元素添加到list2中
    }

    /**
     * 将字符串转换成字符流，并返回
     * @param str
     * @return
     */
    public Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }

}
