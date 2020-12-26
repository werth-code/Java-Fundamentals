package generics;

public class GenericsExample<T> {
    T obj;

    public GenericsExample(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
