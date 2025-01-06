import java.util.Scanner;

public class LibraryManager {
    private Library library;
    private UserManager userManager;
    private LoanManager loanManager;
    private Scanner scanner;

    public LibraryManager() {
        library = new Library();
        userManager = new UserManager();
        loanManager = new LoanManager();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int option;
        do {
            System.out.println("1- Manage Books");
            System.out.println("2- Manage Users");
            System.out.println("3- Manage Loans");
            System.out.println("4- Exit");
            System.out.println("Enter an option:");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    manageBooks();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    manageLoans();
                    break;
            }
        } while (option != 4);
    }

    private void manageBooks() {
        int option;
        do {
            System.out.println("1- Add Book");
            System.out.println("2- Delete Book");
            System.out.println("3- Edit Book");
            System.out.println("4- Search Book");
            System.out.println("5- Return to Main Menu");
            System.out.println("Enter an option:");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    searchBook();
                    break;
            }
        } while (option != 5);
    }

    private void addBook() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        System.out.println("Enter book genre:");
        String genre = scanner.nextLine();
        System.out.println("Is the book available? (true/false):");
        boolean isAvailable = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        Book book = new Book(title, author, genre, isAvailable);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private void deleteBook() {
        System.out.println("Enter book title to delete:");
        String title = scanner.nextLine();
        library.deleteBook(title);
        System.out.println("Book deleted successfully.");
    }

    private void editBook() {
        System.out.println("Enter book title to edit:");
        String title = scanner.nextLine();
        System.out.println("Enter new book title:");
        String newTitle = scanner.nextLine();
        System.out.println("Enter new book author:");
        String newAuthor = scanner.nextLine();
        System.out.println("Enter new book genre:");
        String newGenre = scanner.nextLine();
        System.out.println("Is the book available? (true/false):");
        boolean newAvailability = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        library.editBook(title, newTitle, newAuthor, newGenre, newAvailability);
        System.out.println("Book edited successfully.");
    }

    private void searchBook() {
        System.out.println("Enter search criteria (title/author/genre):");
        String criteria = scanner.nextLine();
        System.out.println("Enter search value:");
        String value = scanner.nextLine();

        switch (criteria.toLowerCase()) {
            case "title":
                library.searchBooksByTitle(value).forEach(System.out::println);
                break;
            case "author":
                library.searchBooksByAuthor(value).forEach(System.out::println);
                break;
            case "genre":
                library.searchBooksByGenre(value).forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid search criteria.");
        }
    }

    private void manageUsers() {
        int option;
        do {
            System.out.println("1- Register User");
            System.out.println("2- Verify User");
            System.out.println("3- Return to Main Menu");
            System.out.println("Enter an option:");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    verifyUser();
                    break;
            }
        } while (option != 3);
    }

    private void registerUser() {
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        System.out.println("Enter user ID:");
        String id = scanner.nextLine();
        System.out.println("Enter user contact:");
        String contact = scanner.nextLine();

        User user = new User(name, id, contact);
        userManager.registerUser(user);
        System.out.println("User registered successfully.");
    }

    private void verifyUser() {
        System.out.println("Enter user ID to verify:");
        String id = scanner.nextLine();
        if (userManager.userExists(id)) {
            System.out.println("User exists.");
        } else {
            System.out.println("User does not exist.");
        }
    }

    private void manageLoans() {
        int option;
        do {
            System.out.println("1- Register Loan");
            System.out.println("2- Check Book Availability");
            System.out.println("3- Record Return");
            System.out.println("4- Return to Main Menu");
            System.out.println("Enter an option:");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    registerLoan();
                    break;
                case 2:
                    checkBookAvailability();
                    break;
                case 3:
                    recordReturn();
                    break;
            }
        } while (option != 4);
    }

    private void registerLoan() {
        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter user ID:");
        String userId = scanner.nextLine();
        System.out.println("Enter loan date (yyyy-mm-dd):");
        String loanDate = scanner.nextLine();

        Book book = library.searchBooksByTitle(title).stream().findFirst().orElse(null);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        User user = userManager.userExists(userId) ? userManager.getUserById(userId) : null;
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        Loan loan = new Loan(book, user, loanDate);
        loanManager.registerLoan(loan);
        System.out.println("Loan registered successfully.");
    }

    private void checkBookAvailability() {
        System.out.println("Enter book title to check availability:");
        String title = scanner.nextLine();

        Book book = library.searchBooksByTitle(title).stream().findFirst().orElse(null);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (loanManager.isBookAvailable(book)) {
            System.out.println("Book is available.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    private void recordReturn() {
        System.out.println("Enter book title to record return:");
        String title = scanner.nextLine();

        Book book = library.searchBooksByTitle(title).stream().findFirst().orElse(null);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        loanManager.recordReturn(book);
        System.out.println("Return recorded successfully.");
    }

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.displayMenu();
    }
}
