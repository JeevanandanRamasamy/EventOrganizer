package eventorganizer;

public enum Timeslot {
    MORNING (10, 30, "am"),
    AFTERNOON (2, 0, "pm"),
    EVENING (6, 30, "pm");

    private final int hour;
    private final int minute;
    private final String am_pm;

    Timeslot(int hour, int minute, String am_pm) {
        this.hour = hour;
        this.minute = minute;
        this.am_pm = am_pm;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public boolean isAM() {
        return this.am_pm.equals("am");
    }

    @Override
    public String toString() {
        String min = (this.minute == 0) ? "00" : "" + this.minute;
        return this.hour + ":" + min + this.am_pm;
    }
}
