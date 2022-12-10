import java.util.List;
import java.util.Map;

public interface StudentService <T> {
    void updateStudent(int id, T object, Map<Integer, T> map);
}
