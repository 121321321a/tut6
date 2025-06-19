class LibraryMedia {
    protected String title;
    protected int publicationYear;
    protected boolean available;

    public LibraryMedia(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnMedia() {
        if (!available) {
            available = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    public void displayInformation() {
        System.out.println(title + " (" + publicationYear + ") - " + (available ? "Available" : "Borrowed"));
    }
}

class Book extends LibraryMedia {
    private String author;
    private int numberOfPages;

    public Book(String title, int publicationYear, String author, int numberOfPages) {
        super(title, publicationYear);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Author: " + author + ", Pages: " + numberOfPages);
    }

    public void checkNumberOfPages() {
        if (numberOfPages > 500) {
            System.out.println(title + " is a long book.");
        } else {
            System.out.println(title + " is a standard book.");
        }
    }
}

class Movie extends LibraryMedia {
    private String director;
    private int duration;

    public Movie(String title, int publicationYear, String director, int duration) {
        super(title, publicationYear);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Director: " + director + ", Duration: " + duration + " minutes");
    }

    public void checkDuration() {
        if (duration > 120) {
            System.out.println(title + " is a long movie.");
        } else {
            System.out.println(title + " is a standard-length movie.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Witcher", 1996, "Andrzej Sapkowski", 320);
        Book book2 = new Book("War and Peace", 1869, "Leo Tolstoy", 1225);
        Movie movie1 = new Movie("The Green Mile", 1999, "Frank Darabont", 189);
        Movie movie2 = new Movie("Inception", 2010, "Christopher Nolan", 148);

        LibraryMedia[] mediaArray = new LibraryMedia[4];
        mediaArray[0] = book1;
        mediaArray[1] = book2;
        mediaArray[2] = movie1;
        mediaArray[3] = movie2;

        System.out.println("======= INFORMATION ABOUT ALL MEDIA =======");
        for (LibraryMedia media : mediaArray) {
            media.displayInformation();
            System.out.println();
        }

        System.out.println("======= BORROWING AND RETURNING =======");
        book1.borrow();
        book1.borrow(); // already borrowed
        book1.returnMedia();
        book1.returnMedia(); // already returned

        System.out.println("======= TYPE-SPECIFIC METHODS =======");
        book1.checkNumberOfPages();
        movie1.checkDuration();

        System.out.println("======= TYPE CASTING =======");
        for (LibraryMedia media : mediaArray) {
            if (media instanceof Book) {
                ((Book) media).checkNumberOfPages();
            } else if (media instanceof Movie) {
                ((Movie) media).checkDuration();
            }
        }
    }
}
