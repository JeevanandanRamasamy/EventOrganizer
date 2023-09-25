package eventorganizer;

/**
 * Represents a date with year, month, and day
 * @author Jeeva Ramasamy, Parth Patel
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    private static final int FIRST_DAY_OF_MONTH = 1;

    private static final int JANUARY = 1;
//    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUARTERCENTENNIAL = 400;

    private static final int FEBRUARY_DAYS = 28;
    private static final int FEBRUARY_DAYS_LEAP_YEAR = 28;

    /**
     * Creates a Date object with the specified year, month, and day
     * @param year the year in the date of format yyyy
     * @param month the month in the date of format mm
     * @param day the day in the date of format dd
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Checks whether the year of the event is a leap year or not
     * @return true if leap year, false otherwise
     */
    private boolean isLeapYear() {
        if (this.year % QUADRENNIAL == 0) {
            if (this.year % CENTENNIAL == 0) {
                return this.year % QUARTERCENTENNIAL == 0;
            }
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the date is a valid calendar date
     * @return true if valid date, false otherwise
     */
    public boolean isValid()  {
        // Checks if the month is valid
        if (this.month < JANUARY || this.month > DECEMBER) {
            return false;
        }

        // Checks if the day is valid
        if (this.day < FIRST_DAY_OF_MONTH) {
            return false;
        }
        else if (this.month == JANUARY || this.month == MARCH || this.month == MAY
                 || this.month == JULY || this.month == AUGUST || this.month == OCTOBER
                 || this.month == DECEMBER) {
            return this.day <= 31; // Change 31
        }
        else if (this.month == APRIL || this.month == JUNE || this.month == SEPTEMBER
                 || this.month == NOVEMBER) {
            return this.day <= 30; // Change 30
        }
        else {
            if (isLeapYear() && this.day > FEBRUARY_DAYS_LEAP_YEAR) {
                return false;
            }
            else {
                return this.day <= FEBRUARY_DAYS;
            }
        }
    }

    /**
     * Compares this date with the specified date
     * @param date the object to be compared.
     * @return 1 if this date occurs after the specified date,
     *         -1 if this date occurs before the specified date,
     *         0 if the dates are the same
     */
    @Override
    public int compareTo(Date date) {
        if (this.year > date.year) {
            return 1; // Check if allowed
        }
        else if (this.year < date.year) {
            return -1;
        }
        else {
            if (this.month > date.month) {
                return 1;
            }
            else if (this.month < date.month) {
                return -1;
            }
            else {
                return Integer.compare(this.day, date.day);
            }
        }
    }

    /**
     * Returns a string representation of the date
     * @return string version of date in format mm/dd/yyyy
     */
    @Override
    public String toString() {
        return "" + this.month + '/' + this.day + '/' + this.year;
    }

    /**
     * Testbed main used as the driver to test public methods
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Date d1 = new Date(2023, 9, 23);
        System.out.println(d1);
    }
}
