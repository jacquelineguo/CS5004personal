package problem3;
/**
 * Amount is a class that has a person's bank account account balance in dollars and cents.
 */

public class Amount {
    private int dollars;
    private int cents;
    public static int ZERO = 0;
    public static int CENTLIMIT = 99;
    public static int CENTOFFSET = 100;

    /**
     * Constructor that creates bank account balance in dollars and cents.
     * @param dollars - dollar amount of the account balance.
     * @param cents - cents amount of the account balance.
     */

    public Amount(int dollars, int cents) {
        if (dollars < ZERO){
            dollars = ZERO;
        }
        if (cents < ZERO) {
            cents = ZERO;
        } else if (cents > CENTLIMIT) {
            dollars += (cents / CENTOFFSET);
            cents %= CENTOFFSET;
        }
        this.dollars = dollars;
        this.cents = cents;
    }

    /**
     * Add the given amount to the account balance.
     * @param added - the amount to add.
     * @return new balance after added.
     */

    public Amount add(Amount added) {
        int curCents, addedCents;
        curCents = this.cents + (this.dollars * CENTOFFSET);
        addedCents = added.getCents() + (added.getDollars() * CENTOFFSET);
        int newCents = curCents + addedCents;

        int cents = newCents % CENTOFFSET;
        int dollars = newCents / CENTOFFSET;
        return new Amount(dollars, cents);
    }

    /**
     * Substract the given amount from the account balance.
     * @param subtracted - the amount to subtract.
     * @return new balance after subtracted.
     */

    public Amount subtract(Amount subtracted) {
        int curCents, minusCents;
        curCents = this.cents + (this.dollars * CENTOFFSET);
        minusCents = subtracted.getCents() + (subtracted.getDollars() * CENTOFFSET);
        int newCents = curCents - minusCents;

        if (newCents < ZERO) {
            return new Amount(0, 0);
        }
        int cents = newCents % CENTOFFSET;
        int dollars = newCents / CENTOFFSET;
        return new Amount(dollars, cents);
    }

    /**
     * @return the cents amount.
     */

    public int getCents() {
        return this.cents;
    }

    /**
     * @return the dollars amount.
     */

    public int getDollars() {
        return this.dollars;
    }

    /**
     * Check if two Amount objects are equal.
     */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return dollars == amount.dollars &&
                cents == amount.cents;
    }
}
