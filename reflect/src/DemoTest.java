import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Classname DemoTest
 * @Description TODO
 * @Date 2019/10/13 9:26
 * @Created by zjl
 */
public class DemoTest {
    @Test
    public void test(){
        Class <?> person = null;
        try {
            person = Class.forName("Person");
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace( );
        }
        Constructor <?>[] constructors = person.getConstructors( );
        for ( Constructor constructor : constructors ){
            System.out.println(constructor) ;
        }
        System.out.println("##############") ;
        Field[] declaredFields = person.getDeclaredFields( );
        for ( Field field:declaredFields ){
            System.out.println(field) ;
        }

    }
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties( );
        properties.load(new FileReader("a.txt"));
        String aClass = properties.getProperty("class", "10");
        System.out.println(aClass) ;

    }
}
