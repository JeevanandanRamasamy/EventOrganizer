package eventorganizer;

/**
 *
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    private static final int FIRSTDAYOFMONTH = 1;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
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

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     *
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
        if (this.day < FIRSTDAYOFMONTH) {
            return false;
        }
        else if (this.month == JANUARY || this.month == MARCH || this.month == MAY
                || this.month == JULY || this.month == AUGUST || this.month == OCTOBER
                || this.month == DECEMBER) {
            return this.day <= 31; // Change 31
        }
        else if (this.month == APRIL || this.month == JUNE || this.month == SEPTEMBER
                || this.month == NOVEMBER) {
            return this.day <= 30;
        }
        else {
            if (isLeapYear() && this.day > 29) { // Change 29
                return false;
            }
            else {
                return this.day <= 28; // Change 28
            }
        }
    }

    public int compareTo(Date other) {
        if (this.year > other.year) {
            return 1;
        }
        else if (this.year < other.year) {
            return -1;
        }
        else {
            if (this.month > other.month) {
                return 1;
            }
            else if (this.month < other.month) {
                return -1;
            }
            else {
                return Integer.compare(this.day, other.day);
            }
        }
    }

    @Override
    public String toString() {
        return "" + this.month + '/' + this.day + '/' + this.year;
    }

    public static void main(String[] args) {
        Date d1 = new Date(2023, 9, 23);
        System.out.println(d1);
    }
}
