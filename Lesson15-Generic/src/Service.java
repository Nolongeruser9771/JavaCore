import java.util.List;
import java.util.Scanner;

public interface Service <T> {
    T createObject(Scanner scanner);
    void insertObject(T object, List<T> objects);
    void updateObject(T object, List<T> objects);
    void deleteObject(T object, List<T> objects);


}
