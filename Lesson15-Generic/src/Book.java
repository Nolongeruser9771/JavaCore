import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String author;
    private LocalDate publicDate;

    public Book(int id, String name, String author, LocalDate publicDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publicDate = publicDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(LocalDate publicDate) {
        this.publicDate = publicDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publicDate=" + publicDate +
                '}';
    }
}
