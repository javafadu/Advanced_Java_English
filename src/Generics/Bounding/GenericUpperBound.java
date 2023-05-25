package Generics.Bounding;

public class GenericUpperBound<T extends Number> {
    // Limit upper, generic can be integer, double,..

    private T[] numberArray;

    // constructor

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    // METHOD: calculate the average of array elements
    public double getAvg() {
        double sum = 0;
        for (T t:numberArray
             ) {
            sum+=t.doubleValue(); // convert all elements to double

        }
        double avg = sum/numberArray.length;
        return avg;

    }

    // main method
    public static void main(String[] args) {
        Integer[] intArr = {3,6,9,1,8,9};
        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAvg());

        Double[] doubleArr = {3.2,6.8,9.0,1.7,8.3,9.5};
        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.getAvg());

        // Generic prevents ClassCastException
        /*
        String[] stringArray = {"Java", "Is", "Easy", "To", "Learn"};
        GenericUpperBound<String> obj3 = new GenericUpperBound<String>(stringArray);
        */
    }


}
