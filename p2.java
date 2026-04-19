package lab1b;

import java.util.List;
import java.util.ArrayList;

public class p2 {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("Orange");
        ls.add("geen");
        ls.add("pink");
        ls.add("red");
        ls.add("Blue");

        System.out.println(ls);

        ls.remove(2);          // removes "pink"
        System.out.println(ls);

        ls.remove("Blue");     // removes "Blue"
        System.out.println(ls);
    }
}