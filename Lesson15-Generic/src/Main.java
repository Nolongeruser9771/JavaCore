import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        ArrayList<Book> bookLists = library.bookList();
        ArrayList<Reader> readerLists = library.readerList();

        ReaderHandle readerHandle = new ReaderHandle();
        System.out.println("Reader List ban đầu=========");
        readerLists.forEach(System.out::println);
        System.out.println("-----NHẬP THÔNG TIN ĐỌC GIẢ MUỐN THÊM-----");
        Reader reader1 = readerHandle.createObject(scanner);
        System.out.println("Reader list sau khi thêm đọc giả vào=========");
        readerHandle.insertObject(reader1,readerLists);
        readerLists.forEach(System.out::println);
        System.out.println("-----NHẬP THÔNG TIN ĐỌC GIẢ MUỐN CẬP NHẬT-----");
        Reader reader2 = readerHandle.createObject(scanner);
        System.out.println("Reader List sau khi update đọc giả=========");
        readerHandle.updateObject(reader2,readerLists);
        readerLists.forEach(System.out::println);
        System.out.println("-----NHẬP THÔNG TIN ĐỌC GIẢ MUỐN XÓA-----");
        Reader reader3 = readerHandle.createObject(scanner);
        System.out.println("Reader List sau khi xóa đọc giả=========");
        readerHandle.deleteObject(reader3,readerLists);
        readerLists.forEach(System.out::println);

        BookHandle bookHandle = new BookHandle();
        System.out.println("Book List ban đầu=========");
        bookLists.forEach(System.out::println);

        System.out.println("-----NHẬP THÔNG TIN SÁCH MUỐN THÊM-----");
        Book book1 = bookHandle.createObject(scanner);
        System.out.println("Book List sau khi thêm đầu sách=========");
        bookHandle.insertObject(book1, bookLists);
        bookLists.forEach(System.out::println);
        System.out.println("-----NHẬP THÔNG TIN SÁCH MUỐN UPDATE-----");
        Book book2 = bookHandle.createObject(scanner);
        System.out.println("Book List sau khi update=========");
        bookHandle.updateObject(book2,bookLists);
        bookLists.forEach(System.out::println);
        System.out.println("-----NHẬP THÔNG TIN SÁCH MUỐN XÓA-----");
        Book book3 = bookHandle.createObject(scanner);
        System.out.println("Book List sau khi xóa sách=========");
        bookHandle.deleteObject(book3,bookLists);
        bookLists.forEach(System.out::println);
    }
}