package problem3;
/**
 * Account is a class that has a person's bank account info which includes first name, last name, account balance.
 */

public class Account {
    private String firstName;
    private String lastName;
    private Amount balance;

    /**
     * Constructor that creates a new bank account with first name, last name, and account balance.
     * @param firstName - a person's first name.
     * @param lastName - a person's last name.
     * @param balance - the person's bank account balance.
     */

    public Account(String firstName, String lastName, Amount balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    /**
     * This method is adding money to the account balance.
     * @param depositAmount - the money for depositing.
     * @return new account balance.
     */

    public Account deposit(Amount depositAmount) {
        Amount newAmount = this.balance.add(depositAmount);
        return new Account(this.firstName, this.lastName, newAmount);
    }

    /**
     * This method is subtracting money from the bank account balance.
     * @param withdrawAmount - the money for withdrawing.
     * @return the new account balance.
     */

    public Account withdraw(Amount withdrawAmount) {
        Amount newAmount = this.balance.subtract(withdrawAmount);
        return new Account(this.firstName, this.lastName, newAmount);
    }

    /**
     * @return the account balance.
     */

    public Amount getBalance() {
        return this.balance;
    }

    /**
     * @return the account holder's first name.
     */

    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @return the account holder's last name.
     */

    public String getLastName() {
        return this.lastName;
    }


}
