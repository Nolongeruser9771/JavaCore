package Exercise01;

import java.util.Scanner;

public class Book {
    private int bookID;
    private String bookName;
    private String author;
    private String bookTopic;
    private int releaseYear;

    private static int AUTO_BOOKID =0;

    public Book() {
        if (AUTO_BOOKID==0) {
            AUTO_BOOKID = 9999;
        }
        AUTO_BOOKID++;
        this.bookID = AUTO_BOOKID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookTopic() {
        return bookTopic;
    }

    public void setBookTopic(String bookTopic) {
        this.bookTopic = bookTopic;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public static int getAutoBookid() {
        return AUTO_BOOKID;
    }

    public static void setAutoBookid(int autoBookid) {
        AUTO_BOOKID = autoBookid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookTopic='" + bookTopic + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    public void InputBookInfo() {
        System.out.println("Input book name: ");
        this.bookName = new Scanner(System.in).nextLine();
        System.out.println("Input book author: ");
        this.author = new Scanner(System.in).nextLine();
        System.out.println("Input book topic: ");
        System.out.println("1. Natural science");
        System.out.println("2. literature and art");
        System.out.println("3. electronics and telecommunication");
        System.out.println("4. IT");
            selectedBookTopic();
        System.out.println("Input book released year: ");
        this.releaseYear = new Scanner(System.in).nextInt();
    }

    private void selectedBookTopic() {
        int bookTopic;
        do {
            bookTopic = new Scanner(System.in).nextInt();
            if(bookTopic>=1 && bookTopic <=4) {
                break;
            }
            System.out.println("Wrong type. Please input type again: ");
        } while (true);

        switch (bookTopic) {
            case 1:
                this.bookTopic = BookConstantType.SCIENCE;
                break;
            case 2:
                this.bookTopic = BookConstantType.LITER_ART;
                break;
            case 3:
                this.bookTopic = BookConstantType.ELEC_TEL;
                break;
            case 4:
                this.bookTopic = BookConstantType.IT;
                break;
        }
    }


}
