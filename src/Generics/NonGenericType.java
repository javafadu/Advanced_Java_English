package Generics;

public class NonGenericType {

    private Object o;

    // getter & setter
    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }


    // main method
    public static void main(String[] args) {
        NonGenericType obj1 = new NonGenericType();
        NonGenericType obj2 = new NonGenericType();

        obj1.setO("Test"); // used String
        obj2.setO(44); // uses Integer

        String str = (String) obj1.getO(); // Casting problem
        System.out.println(str);

        String str2 = (String) obj2.getO(); // RTE (RunTimeException --> ClassCastException
        System.out.println(str2);
        // String.valueOf(obj2.getO());
        // Integer.parseInt()

    }

}
