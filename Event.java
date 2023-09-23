package eventorganizer;

public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes

    private static final int MAXHOUR = 12;
    private static final int MINUTESINHOUR = 60;
    private static final int SMALLESTDOUBLEDIGITNUM = 10;

    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    // check later
    @Override
    public boolean equals(Object other) {
        Event event = (Event) other;
        return this.date.compareTo(event.date) == 0
                && this.startTime.equals(event.startTime)
                && this.duration == event.duration
                && this.location.equals(event.location);
    }

    @Override
    public String toString() {
        // [Event Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]
        int endHour = this.startTime.getHour(), endMinute = this.startTime.getMinute();
        boolean isAM = this.startTime.isAM();

        endMinute += this.duration;
        while (endMinute >= MINUTESINHOUR) {
            ++endHour;
            endMinute -= MINUTESINHOUR;
            if (endHour >= MAXHOUR) {
                isAM = false;
            }
        }

        String endTime = endHour + ":";
        if (endMinute < SMALLESTDOUBLEDIGITNUM)
            endTime += "0";
        endTime += endMinute;
        endTime += isAM ? "am" : "pm";

        String output = "[Event Date: " + this.date + "] ";
        output += "[Start: " + this.startTime + "] ";
        output += "[End: " + endTime + "] ";
        output += "@" + this.location;
        output += "[Contact: " + this.contact + "]";
        return output;
    }

    /**
     *
     * @param other the object to be compared.
     * @return
     */
    public int compareTo(Event other) {
        if (this.date.compareTo(other.date) > 0) {
            return 1;
        }
        else if (this.date.compareTo(other.date) < 0) {
            return -1;
        }
        else {
            if (this.startTime.compareTo(other.startTime) > 0) {
                return 1;
            } else if (this.startTime.compareTo(other.startTime) < 0) {
                return -1;
            } else {
                return Integer.compare(this.duration, other.duration);
            }
        }
    }

}