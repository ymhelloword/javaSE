/**
 * @Classname Person
 * @Description TODO
 * @Date 2019/10/13 9:23
 * @Created by zjl
 */
public class Person implements a {
    private String name;
    private Integer age;
    public Person(){}
    public Person(String name,int age){

    }
    public String say(){
        System.out.println("person") ;
        return "df";
    }

    @Override
    public String hello( ) {
        System.out.println("a interface hello") ;
        return null;
    }
}
