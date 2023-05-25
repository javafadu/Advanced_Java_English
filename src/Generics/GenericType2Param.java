package Generics;

public class GenericType2Param<S,U> {


    private S s;
    private U u;

    // all arg constructor
    public GenericType2Param(S s, U u) {
        this.s = s;
        this.u = u;
    }

    // getter & setter
    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }


    // main method
    public static void main(String[] args) {

        GenericType2Param<String,Integer> obj1 = new GenericType2Param<>("Java",1);
        GenericType2Param<Integer,String> obj2 = new GenericType2Param<>(1,"Spring Boot");

        System.out.println(obj1.getS());
        System.out.println(obj1.getU());
        System.out.println(obj2.getS());
        System.out.println(obj2.getU());


    }


}
