package problem2;
/**
 * Trip is a class represents a trip that has a starting location and ending location of a trip. And a method to
 * calculate the duration of the trip.
 */

public class Trip {
    private String startLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;

    /**
     * Constructor that creates a new trip with starting location, ending location, and duration.
     * @param startLocation - starting location of the trip.
     * @param endLocation - ending location of the trip.
     * @param startTime - the starting time of the trip.
     * @param endTime - the ending time of the trip.
     */

    public Trip (String startLocation, String endLocation, Time startTime, Time endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Get the duration of the trip.
     * @param h - the given hour
     * @param m - the given minutes
     * @param s - the given seconds
     * @return the duration of the trip.
     */

    public Time getDuration() {
        int h, m, s;
        int ZERO = 0;
        int TIMETRSFER = 60;
        h = this.endTime.getHour() - this.startTime.getHour();
        m = this.endTime.getMinutes() - this.startTime.getMinutes();
        s = this.endTime.getSeconds() - this.startTime.getSeconds();
        // Handle overflow
        if (s < ZERO) {
            m--;
            s += TIMETRSFER;
        }
        if (m < ZERO) {
            h--;
            m += TIMETRSFER;
        }
        return new Time(h, m, s);
    }

    /**
     * @return The starting location of the trip.
     */

    public String getStartLocation() {
        return this.startLocation;
    }

    /**
     * @return The ending location of the trip.
     */

    public String getEndLocation() {
        return this.endLocation;
    }

    /**
     * Set The starting location of the trip.
     */

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Set The ending location of the trip.
     */

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * @return The starting time of the trip.
     */

    public Time getStartTime() {
        return this.startTime;
    }

    /**
     * @return The ending time of the trip.
     */

    public Time getEndTime() {
        return  this.endTime;
    }

    /**
     * Set The starting time of the trip.
     */

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * Set The ending time of the trip.
     */

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
