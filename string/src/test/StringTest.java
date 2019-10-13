package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author zjl
 * @Date 2019/9/21 9:39
 */
public class StringTest {
    public static void main(String[] args) throws Exception {
        Class <?> aClass = Class.forName("test.Student");
        Constructor <?> constructor = aClass.getConstructor(String.class, Integer.class);
        Object ym = constructor.newInstance("ym", 12);
        Method toString = aClass.getMethod("toString");
        Method getInt = aClass.getMethod("getInt");
        String invoke = ( String ) toString.invoke(ym);
        int invoke1 = ( int ) getInt.invoke(ym);
        System.out.println(invoke1) ;
    }

}
class Student{
    private String name;
    private Integer age;
    public Student(String name,Integer age){
        this.name= name;
        this.age = age;
        System.out.println("student的无参构造方法") ;
    }

    @Override
    public String toString( ) {
        return "student的tostring()"+this.name+":"+this.age;
    }
    public int getInt(){
        return 1;
    }
}
