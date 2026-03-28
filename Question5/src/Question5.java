//chatgpt
import java.util.*;

// Base class
class Book {
    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year) {
        if (author.length() >= 50) {
            throw new IllegalArgumentException("Author name too long");
        }
        if (year <= 1800 || year >= 2026) {
            throw new IllegalArgumentException("Invalid year");
        }

        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + year);
    }
}

// GeneralBook subclass
class GeneralBook extends Book {
    private String genre;

    public GeneralBook(String title, String author, int year, String genre) {
        super(title, author, year);

        if (genre.length() > 30) {
            throw new IllegalArgumentException("Genre too long");
        }

        this.genre = genre;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

// ChildrenBook subclass
class ChildrenBook extends Book {
    private int minAge;
    private boolean hasVisualisation;

    public ChildrenBook(String title, String author, int year, int minAge, boolean hasVisualisation) {
        super(title, author, year);

        if (minAge <= 3 || minAge >= 12) {
            throw new IllegalArgumentException("Invalid age");
        }

        this.minAge = minAge;
        this.hasVisualisation = hasVisualisation;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: " + (hasVisualisation ? "Yes" : "No"));
    }
}

// Main class (CLI)
public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // STACK (WAJIB)
        Stack<Book> library = new Stack<>();

        // ===== PRELOAD 5 BOOKS =====
        library.push(new Book("Why Black Moves First", "Wesley So", 2025));
        library.push(new GeneralBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"));
        library.push(new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true));
        library.push(new GeneralBook("Cooking Mastery", "Gordon Ramsay", 2010, "Cooking"));
        library.push(new ChildrenBook("Fun with Math", "Albert Junior", 2018, 7, true));

        int choice;

        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: // VIEW
                    if (library.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (int i = 0; i < library.size(); i++) {
                            System.out.println("\nBook " + (i + 1));
                            library.get(i).getInfo();
                        }
                    }
                    break;

                case 2: // ADD
                    System.out.println("Choose type:");
                    System.out.println("1. Book");
                    System.out.println("2. General Book");
                    System.out.println("3. Children Book");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    try {
                        if (type == 1) {
                            library.push(new Book(title, author, year));
                        } else if (type == 2) {
                            sc.nextLine();
                            System.out.print("Genre: ");
                            String genre = sc.nextLine();
                            library.push(new GeneralBook(title, author, year, genre));
                        } else if (type == 3) {
                            System.out.print("Min Age: ");
                            int age = sc.nextInt();
                            System.out.print("Has Visualisation (true/false): ");
                            boolean vis = sc.nextBoolean();
                            library.push(new ChildrenBook(title, author, year, age, vis));
                        }
                        System.out.println("Book added!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 3: // DELETE
                    if (library.isEmpty()) {
                        System.out.println("No books to delete.");
                        break;
                    }

                    System.out.print("Enter book index to delete: ");
                    int index = sc.nextInt();

                    if (index < 1 || index > library.size()) {
                        System.out.println("Invalid index.");
                    } else {
                        library.remove(index - 1);
                        System.out.println("Book deleted.");
                    }
                    break;

            }

        } while (choice != 0);

        System.out.println("Exiting...");
    }
}