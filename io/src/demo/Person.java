package demo;

import java.io.Serializable;

/**
 * @Author zjl
 * @Date 2019/10/9 20:27
 */
public class Person implements Serializable {
    private String name;

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
