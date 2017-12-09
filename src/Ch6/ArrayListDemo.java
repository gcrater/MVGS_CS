package Ch6;

import java.util.ArrayList;
//taken from ArrayList DropBox - Ria Galanos (?) TJHSST
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        // System.out.println(list.size());
        list.add("M&Ms");
        list.add("M&Ms");
        list.add("M&Ms");
        list.add("kale chips");
        list.add(1, "cupcake");
        // list.set(3, "oreos");
        // list.remove(0);

        // let's remove M&Ms
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("M&Ms")) {
                list.remove(i);
                i--;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("M&Ms")) {
                list.remove(i);
            }
        }

        // similar logic to printing arrays
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        // shortcut for ArrayLists
        System.out.println(list);

    }
}
