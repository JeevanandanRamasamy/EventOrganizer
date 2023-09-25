package eventorganizer;

/**
 * Represents an event with a date, start time, location, contact, and duration
 * @author Jeeva Ramasamy, Parth Patel
 */
public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes

    private static final int MAX_HOUR = 12;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int SMALLEST_DOUBLE_DIGIT_NUM = 10;

    /**
     * Creates an Event object with the specified date, startTime, location, contact, and duration
     * @param date the date of the event
     * @param startTime the start time of the event
     * @param location the location of the event
     * @param contact the contact for the event
     * @param duration the duration of the event
     */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }

    /**
     * Returns the location that this event takes place in
     * @return location
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Returns the department that this event takes place in
     * @return department
     */
    public Department getDepartment() {
        return this.contact.getDepartment();
    }

    /**
     * Checks if this event is equal to the specified object
     * @param obj the specified object
     * @return true if equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            Event event = (Event) obj;
            return this.date.equals(event.date)
                    && this.startTime.equals(event.startTime)
                    && this.duration == event.duration
                    && this.location.equals(event.location);
        }
        return false;
    }

    /**
     * Returns a string representation of the event
     * @return string version of event in format
     *         [Event Date: date] [Start: start time] [End: end time] @location [Contact: contact]
     */
    @Override
    public String toString() {
        // [Event Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]
        int endHour = this.startTime.getHour(), endMinute = this.startTime.getMinute();
        boolean isAM = this.startTime.isAM();

        endMinute += this.duration;
        while (endMinute >= MINUTES_IN_HOUR) {
            ++endHour;
            endMinute -= MINUTES_IN_HOUR;
            if (endHour >= MAX_HOUR) {
                isAM = false;
            }
        }

        String endTime = endHour + ":";
        if (endMinute < SMALLEST_DOUBLE_DIGIT_NUM)
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
     * Compares this event with the specified event
     * @param event the object to be compared.
     * @return 1 if this event occurs after the specified event,
     *         -1 if this event occurs before the specified event,
     *         0 if the events occur at the same time
     */
    @Override
    public int compareTo(Event event) {
        if (this.date.compareTo(event.date) > 0) {
            return 1;
        }
        else if (this.date.compareTo(event.date) < 0) {
            return -1;
        }
        else {
            if (this.startTime.compareTo(event.startTime) > 0) {
                return 1;
            } else if (this.startTime.compareTo(event.startTime) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}