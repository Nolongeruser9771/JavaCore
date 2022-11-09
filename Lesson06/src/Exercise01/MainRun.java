package Exercise01;

import java.util.Scanner;

public class MainRun {
    public static Reader readers[] = new Reader[100];
    public static Book books[] = new Book[100];

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int selectedOption = getSelectedOption();
            logicHandle(selectedOption);
        }
    }

   private static void showMenu(){
       System.out.println("------BOOK BORROW MANAGEMENT PROGRAM------");
       System.out.println("Please select option: ");
       System.out.println("1. Input new books");
       System.out.println("2. Print All book list");
       System.out.println("3. Input new readers");
       System.out.println("4. Print All reader list");
       System.out.println("5. Book borrow function");
       System.out.println("6. Book borrowed list sorting");
       System.out.println("7. Search and show Book borrowed list");
       System.out.println("8. Exit");
   }

   private static int getSelectedOption() {
       int functionChoice;
       do {
           functionChoice = new Scanner(System.in).nextInt();
           if (functionChoice <= 8 && functionChoice >= 1) {
               break;
           }
           System.out.println("Wrong input. Please input option again: ");
       } while (true);
       return functionChoice;
   }
   private static void logicHandle(int selectedOption) {
        switch (selectedOption) {
            case 1:
                addNewBooks();
                break;
            case 2:
                showAllBook();
                break;
            case 3:
                addNewReaders();
                break;
            case 4:
                showAllReader();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                System.exit(0);
        }
   }
    private static void addNewBooks() {
        System.out.println("Input number of books to add: ");
        int bookNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < bookNumber; i++) {
            Book book = new Book();
            book.InputBookInfo();
            saveBook(book);
        }
    }
    private static void saveBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if(books[i]==null) {
                books[i] = book;
                break;
            }
        }
    }

    private static void showAllBook() {
        for (int i = 0; i < books.length; i++) {
            if(books[i]!= null) {
                System.out.println(books[i]);
            }
        }
    }
    private static void addNewReaders() {
        System.out.println("Input number of readers to add: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            Reader reader = new Reader();
            reader.InputInfo();
            saveReader(reader);
        }
    }
    private static void saveReader(Reader reader) {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]==null) {
                readers[i] = reader;
                break;
            }
        }
    }

    private static void showAllReader() {
        for (int i = 0; i < readers.length; i++) {
            if(readers[i]!= null) {
                System.out.println(readers[i]);
            }
        }
    }
}
