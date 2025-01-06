import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoanManager {
    private List<Loan> loans;

    public LoanManager() {
        loans = new ArrayList<>();
    }

    public void registerLoan(Loan loan) {
        if (loan.getBook().isAvailable()) {
            loans.add(loan);
            loan.getBook().setAvailable(false);
        } else {
            System.out.println("Book is not available for loan.");
        }
    }

    public boolean isBookAvailable(Book book) {
        return book.isAvailable();
    }

    public void recordReturn(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loan.getBook().setAvailable(true);
                loans.remove(loan);
                break;
            }
        }
    }

    public void saveLoansToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(loans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadLoansFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            loans = (List<Loan>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
