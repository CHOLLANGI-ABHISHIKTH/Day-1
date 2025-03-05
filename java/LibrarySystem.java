import java.util.*;


abstract class User {
    protected String name;
    protected String userId;
    protected String role; 

    public User(String name, String userId, String role) {
        this.name = name;
        this.userId = userId;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public abstract void displayDetails();
}


class Student extends User {
    public Student(String name, String userId) {
        super(name, userId, "Student");
    }

    @Override
    public void displayDetails() {
        System.out.println("Student Name: " + name + ", ID: " + userId);
    }
}

class Librarian extends User {
    public Librarian(String name, String userId) {
        super(name, userId, "Librarian");
    }

    @Override
    public void displayDetails() {
        System.out.println("Librarian Name: " + name + ", ID: " + userId);
    }
}


class Book {
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() { isAvailable = false; }
    public void returnBook() { isAvailable = true; }

    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Category: " + category + ", Available: " + isAvailable);
    }
}


interface Borrowable {
    boolean borrowBook(User user);
    boolean returnBook(User user);
}


class Library implements Borrowable {
    private static Library instance;
    private List<Book> books;
    private Map<String, List<Book>> borrowedBooks;

    private Library() {
        books = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    
    public void addBook(Book book) {
        books.add(book);
    }

   
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        for (Book book : books) {
            book.displayDetails();
        }
    }

 
    public boolean borrowBook(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title to borrow: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.borrowBook();
                borrowedBooks.computeIfAbsent(user.getUserId(), k -> new ArrayList<>()).add(book);
                System.out.println(user.getUserId() + " borrowed: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Book not available.");
        return false;
    }

    
    public boolean returnBook(User user) {
        List<Book> borrowed = borrowedBooks.get(user.getUserId());
        if (borrowed == null || borrowed.isEmpty()) {
            System.out.println("No books to return.");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title to return: ");
        String title = scanner.nextLine();

        for (Book book : borrowed) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                borrowed.remove(book);
                System.out.println(user.getUserId() + " returned: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Book not found in borrowed list.");
        return false;
    }

   
    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books are currently borrowed.");
            return;
        }

        for (Map.Entry<String, List<Book>> entry : borrowedBooks.entrySet()) {
            System.out.println("User " + entry.getKey() + " borrowed:");
            for (Book book : entry.getValue()) {
                System.out.println(" - " + book.getTitle());
            }
        }
    }
}


public class LibrarySystem {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        Scanner scanner = new Scanner(System.in);

        
        library.addBook(new Book("Java Basics", "James Gosling", "Science"));
        library.addBook(new Book("Harry Potter", "J.K. Rowling", "Fiction"));

        
        Student student = new Student("John Doe", "S101");
        Librarian librarian = new Librarian("Alice Smith", "L201");

        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. List Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show Borrowed Books");
            System.out.println("5. Add Book (Librarian Only)");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    library.borrowBook(student);
                    break;
                case 3:
                    library.returnBook(student);
                    break;
                case 4:
                    library.showBorrowedBooks();
                    break;
                case 5:
                    if (!librarian.getRole().equals("Librarian")) {
                        System.out.println("Only librarians can add books.");
                    } else {
                        System.out.println("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.println("Enter author name: ");
                        String author = scanner.nextLine();
                        System.out.println("Enter category: ");
                        String category = scanner.nextLine();
                        library.addBook(new Book(title, author, category));
                        System.out.println("Book added successfully!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Library System.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
