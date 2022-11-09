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
            getBookTopic();
        System.out.println("Input book released year: ");
        this.releaseYear = new Scanner(System.in).nextInt();
    }

    public void getBookTopic() {
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
                this.bookTopic = "Natural science";
                break;
            case 2:
                this.bookTopic = "literature and art";
                break;
            case 3:
                this.bookTopic = "electronics and telecommunication";
                break;
            case 4:
                this.bookTopic = "IT";
                break;
        }
    }


}
