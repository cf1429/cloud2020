import java.util.Objects;

/**
 * @Author:chenf
 * @Date:2021/5/27 15:22
 * @describe
 */
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Status status;


    public Employee(Integer id, String name, Integer age, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) &&
                name.equals(employee.name) &&
                age.equals(employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
