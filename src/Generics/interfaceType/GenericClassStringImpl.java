package Generics.interfaceType;

// if we implement a generic interface with a specific type, the child class should not be generic (GenericClassStringImpl)
public class GenericClassStringImpl implements  GenericInterface<String>{
    @Override
    public void setValue(String s) {

    }

    @Override
    public String getValue() {
        return null;
    }
}
