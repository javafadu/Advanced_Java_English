package Generics.interfaceType;

// if we implement a generic interface, the child class should be generic (GenericClassImlp<T>)
public class GenericClassImlp<T> implements GenericInterface<T>{

    @Override
    public void setValue(T t) {

    }

    @Override
    public T getValue() {
        return null;
    }
}
