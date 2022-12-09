import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Library {
public ArrayList<Book> bookList() {
    Book book1 = new Book(1, "Tiếng gọi nơi hoang dã", "Author Lawence",LocalDate.parse("01/01/1997", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    Book book2 = new Book(2,"Cuốn theo chiều gió", "Carmen Silver", LocalDate.parse("24/12/1991",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    Book book3 = new Book(3, "Your Name", "Nishimuta", LocalDate.parse("12/03/2010", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    Book book4 = new Book(4, "Hãy ngẩng mặt mà bước, đừng cuốn đầu mà đi", "Lư Tư Hạo", LocalDate.parse("12/12/2012",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    Book book5 = new Book(5, "Đúng việc", "Doãn Chính", LocalDate.parse("20/01/2011",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    return new ArrayList<>(Arrays.asList(book1,book2,book3,book4,book5));
}
public ArrayList<Reader> readerList() {
    Reader reader1 = new Reader(1, "Nguyên Nguyễn", LocalDate.parse("25/01/1997",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    Reader reader2 = new Reader(2,"Sương Trần", LocalDate.parse("26/09/1993",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    Reader reader3 = new Reader(3,"Tuyết Tô", LocalDate.parse("02/10/1964",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    return new ArrayList<>(Arrays.asList(reader1,reader2,reader3));
}
}
