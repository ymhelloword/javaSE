import org.junit.Test;

import java.util.*;

/**
 * @Author zjl
 * @Date 2019/10/10 8:49
 */
public class ArrayListTest {
    @Test
    public void test(){
        ArrayList <Integer> objects = new ArrayList <>();
        int i;
        for ( i=0;i<100;i++ ){
            objects.add(i);
        }
        Iterator <Integer> iterator = objects.iterator( );
        long l = System.currentTimeMillis( );
        while ( iterator.hasNext() ){
            System.out.println(iterator.next()) ;
        }
        long l1 = System.currentTimeMillis( );
       System.out.println(l1-l) ;
//        long l = System.currentTimeMillis( );
//        for ( i=0;i<objects.size();i++ ){
//            System.out.println(objects.get(i)) ;
//        }
//        long l1 = System.currentTimeMillis( );
//        System.out.println(l1-l) ;

    }
    @Test
    public void test2(){
        LinkedList <Integer> objects = new LinkedList <>( );
        objects.add(12);
        objects.add(13);
        objects.push(24);


    }
    @Test
    public void test3(){
        Map <String, Integer> hashMap = new Hashtable <>();
        hashMap.put("sd",null);
        System.out.println(hashMap.get(null)) ;

    }
}
