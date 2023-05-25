package AdvancePractice.generics.interfaces;

public interface Repository<T> {

    void save(T t);
    void get(T t);
    void update(T t);
    void delete(T t);

}
