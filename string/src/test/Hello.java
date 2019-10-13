package test;

/**
 * @Author zjl
 * @Date 2019/10/6 15:09
 */
public class Hello {
    private static int a = 23;
    static {
        System.out.println("dfdf"+a) ;
    }
    public Hello(){
        System.out.println("dd") ;
    }
    public static void main(String[] args) {

        System.out.println("hello world") ;
    }
}
