import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReaderHandle implements Service<Reader> {
    @Override
    public Reader createObject(Scanner scanner) {
        int id;
        while (true) {
            try {
                System.out.print("Mời bạn nhập id đọc giả: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ!");
            }
        }
        System.out.print("Mời bạn nhập tên đọc giả: ");
        String name = scanner.nextLine();
        LocalDate birthDay;
        while (true) {
            try {
                System.out.print("Mời nhập ngày sinh của đọc giả: ");
                birthDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu không phù hợp!");
            }
        }
        return new Reader(id, name, birthDay);
    }

    @Override
    public void insertObject(Reader object, List<Reader> objects) {
        objects.add(object);
    }

    @Override
    public void updateObject(Reader object, List<Reader> objects) {
        for (Reader reader : objects) {
            if (reader.getId() == object.getId()) {
                reader.setName(object.getName());
                reader.setBirthDay(object.getBirthDay());
                break;
            }
        }
    }

    @Override
    public void deleteObject(Reader object, List<Reader> objects) {
        Iterator<Reader> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Reader reader = iterator.next();
            if (reader.getId() == object.getId()) {
                iterator.remove();
                break;
            }
        }
    }
}
