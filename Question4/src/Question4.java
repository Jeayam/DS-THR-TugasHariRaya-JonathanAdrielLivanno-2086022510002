//claude and chatgpt

// Base class
class Item {
    protected String title;
    protected int releaseYear;
    protected double price;

    public Item(String title, int releaseYear, double price) {
        if (title.length() >= 255) {
            throw new IllegalArgumentException("Title too long");
        }
        if (releaseYear <= 1800 || releaseYear >= 2026) {
            throw new IllegalArgumentException("Invalid release year");
        }

        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    public void getDescription() {
        System.out.println("Title: " + title);
        System.out.println("releaseYear: " + releaseYear);
        System.out.println("Price: " + (int)price);
    }
}

// DVD subclass
class Dvd extends Item {
    private double runtime;

    public Dvd(String title, int releaseYear, double price, double runtime) {
        super(title, releaseYear, price);

        if (runtime >= 720) {
            throw new IllegalArgumentException("Runtime too long");
        }

        this.runtime = runtime;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Runtime: " + (int)runtime + " minutes");
    }
}

// Magazine subclass
class Magazine extends Item {
    private String author;
    private int numPages;

    public Magazine(String title, int releaseYear, double price, String author, int numPages) {
        super(title, releaseYear, price);

        if (author.length() >= 50) {
            throw new IllegalArgumentException("Author name too long");
        }

        this.author = author;
        this.numPages = numPages;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + numPages);
    }
}

// Vinyl subclass
class Vinyl extends Item {
    private int size;

    public Vinyl(String title, int releaseYear, double price, int size) {
        super(title, releaseYear, price);

        if (size > 12) {
            throw new IllegalArgumentException("Invalid vinyl size");
        }

        this.size = size;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Size in inches: " + size);
    }
}

// Main class
public class Question4 {
    public static void main(String[] args) {

        Item item1 = new Dvd("Baby be Mine", 1982, 50000, 4);
        Item item2 = new Magazine("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
        Item item3 = new Vinyl("Song of The Wind", 1967, 350000, 12);

        item1.getDescription();
        item2.getDescription();
        item3.getDescription();
    }
}