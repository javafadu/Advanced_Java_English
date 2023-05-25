package Generics.Method;

// generic methods make easier
public class GenericMethodDemo {

    public static void main(String[] args) {
        GenericMethodDemo obj1 = new GenericMethodDemo();
        Integer[] intArr = {2,3,5,3,75,34};
        Double[] doubleArr = {1.1, 23.0,44.2,34.3};

        obj1.print(intArr);
        obj1.print(doubleArr);

    }

    // *********** WORST CASE-->
    /*
    public void print(Integer[] arr) {

        // ****
    }

    public void print(Double[] arr2) {
        // ****
    }
     */


    // *********** BEST CASE -->
    public <T> void print(T[] array) {
        for (T t:array
             ) {
            System.out.println(t);
        }
    }


}
