package eventorganizer;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Calendar;

/**
 * Processes user input and runs program
 * @author Jeeva Ramasamy, Parth Patel
 */
public class EventOrganizer {

    private static final int MIN_DURATION = 30;
    private static final int MAX_DURATION = 120;

    /**
     * Runs the program
     */
    public void run() {
        System.out.println("Event Organizer running...");
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (input.hasNextLine() && isRunning) {
            EventCalendar calendar = new EventCalendar();
            StringTokenizer st = new StringTokenizer(input.nextLine());
            String command = st.nextToken();
            switch (command) {
                case "A":
                    addEvent(calendar, st);
                    break;
                case "R":
                    removeEvent(calendar, st);
                    break;
                case "P":
                    calendar.print();
                    break;
                case "PE":
                    calendar.printByDate();
                    break;
                case "PC":
                    calendar.printByCampus();
                    break;
                case "PD":
                    calendar.printByDepartment();
                    break;
                case "Q":
                    isRunning = false;
                    System.out.println("Event Organizer terminated.");
                    break;
                default:
                    System.out.println(command + " is an invalid command!");
            }
        }
    }

    /**
     * Adds the event to calendar if details are valid
     * @param calendar the current calendar of events
     * @param st list of parameters
     */
    private void addEvent(EventCalendar calendar, StringTokenizer st) {
        StringTokenizer dateTokens = new StringTokenizer(st.nextToken(), "/");
        int month = Integer.parseInt(dateTokens.nextToken()), day = Integer.parseInt(dateTokens.nextToken()),
                year = Integer.parseInt(dateTokens.nextToken());
        Date date = new Date(year, month, day);
        if (!date.isValid()) {
            System.out.println(date + ": Invalid calendar date!");
            return;
        }
        Timeslot startTime = findTimeSlot(st.nextToken().toUpperCase());
        if (startTime == null) {
            System.out.println("Invalid time slot!");
            return;
        }
        Location location = findLocation(st.nextToken().toUpperCase());
        if (location == null) {
            System.out.println("Invalid location!");
            return;
        }
        Department department = findDepartment(st.nextToken().toUpperCase());
        String email = st.nextToken();
        Contact contact = new Contact(department, email);
        if (department == null || !contact.isValid()) {
            System.out.println("Invalid contact information!");
            return;
        }
        int duration = Integer.parseInt(st.nextToken());
        if (duration < MIN_DURATION || duration > MAX_DURATION) {
            System.out.println("Event duration must be at least" + MIN_DURATION + "minutes and at most" +
                    MAX_DURATION + "minutes");
            return;
        }
        Event event = new Event(date, startTime, location, contact, duration);
        calendar.add(event);
        System.out.println("Event added to the calendar.");
    }

    /**
     * Removes the event from calendar if detail are valid
     * @param calendar the current calendar of events
     * @param st list of parameters
     */
    private void removeEvent(EventCalendar calendar, StringTokenizer st) {
        String date = st.nextToken(), timeslot = st.nextToken(), location = st.nextToken();

    }

    private Timeslot findTimeSlot(String timeslot) {
        for (Timeslot ts: Timeslot.values()) {
            if (ts.name().equals(timeslot)) {
                return ts;
            }
        }
        return null;
    }

    private Location findLocation(String location) {
        for (Location loc: Location.values()) {
            if (loc.name().equals(location)) {
                return loc;
            }
        }
        return null;
    }

    private Department findDepartment(String department) {
        for (Department dep: Department.values()) {
            if (dep.name().equals(department)) {
                return dep;
            }
        }
        return null;
    }

}
