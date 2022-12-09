import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookHandle implements Service<Book>{

    @Override
    public Book createObject(Scanner scanner) {
        int id;
        while (true) {
            try {
                System.out.print("Mời bạn nhập id sách: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Nhập liệu không hợp lệ!");
            }
        }
        System.out.print("Mời bạn nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập tên tác giả: ");
        String author = scanner.nextLine();
        LocalDate publicDate;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày public: ");
                publicDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("Định dạng không phù hợp!");
            }
        }
        return new Book(id,name,author,publicDate);
    }

    @Override
    public void insertObject(Book object, List<Book> objects) {
        objects.add(object);
    }

    @Override
    public void updateObject(Book object, List<Book> objects) {
        for (Book book:objects) {
            if (book.getId()==object.getId()) {
                book.setName(object.getName());
                book.setAuthor(object.getAuthor());
                book.setPublicDate(object.getPublicDate());
                break;
            }
        }
    }

    @Override
    public void deleteObject(Book object, List<Book> objects) {
        Iterator<Book> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == object.getId()) {
                iterator.remove();
                break;
            }
        }
    }
}
