package Generics.Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCard {

    public static void main(String[] args) {

        // ***** add element method *****
        List<Object> ol = new ArrayList<>();
        addElements(ol);

        List<Number> nl = new ArrayList<>();
        addElements(nl);

        List<Double> dl = new ArrayList<>();
        // addElements(dl); // CTE , before Generic RTE


        // ***** print element method
        /*
        List<String> sl = new ArrayList<>();
        printElement(sl);
        */
        printElement(new ArrayList<String>());

        // ***** print object method
        // List<String> sl2 = new ArrayList<>();
        // printObjectElement(sl2); // CTE
        List<Object> ol2 = new ArrayList<>();
        printObjectElement(ol2);

    }

    // super Integer : parent of Integer (Object, Number)
    public static void addElements(List<? super Integer> list) {
        // ? : WildCard (unknown type)
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

    }

    // WildCard disadvantage, restrictions
    public static void printElement(List<?> listOfUnknown) {
        // listOfUnknown.add("Java");  // List<?> -->CTE data ype is not defined so we can not manipulate
        // listOfUnknown.add(null); --> works

        for (Object object : listOfUnknown
        ) {
            System.out.println(object);
        }

    }

    // Object data type
    public static void printObjectElement(List<Object> listOfObject) {
        listOfObject.add("Java");

        for (Object object : listOfObject
        ) {
            System.out.println(object);
        }

    }

}
