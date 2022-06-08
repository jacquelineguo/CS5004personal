package problem2;
/**
 * Time is a class represents the trip time that includes hour, minutes, and seconds.
 */

public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    public static int ZERO = 0;

    /**
     * Constructor that creates a validated time.
     * @param hour - the hour.
     * @param minutes - the minutes.
     * @param seconds - the seconds.
     */

    public Time (int hour, int minutes, int seconds) {
        this.hour = Time.validateHour(hour);
        this.minutes = Time.validateMS(minutes);
        this.seconds = Time.validateMS(seconds);
    }

    /**
     * validateHour valid if hour is between 0 and 23.
     * If not, return the given number modulo 24
     * @param hour - the given hour
     * @return a number in the range (0, 23)
     */

    private static int validateHour(int hour) {
        int HOURT = 24;
        if (hour >= ZERO) {
            return hour % HOURT;
        } else {
            return hour % HOURT + HOURT;
        }
    }

    /**
     * validateMS valid if minutes or seconds is between 0 and 59.
     * If not, return the given number modulo 60
     * @param num - the given minute or second
     * @return a number in the range (0, 59)
     */

    private static int validateMS(int num) {
        int TIMETRA = 60;
        if (num >= ZERO) {
            return num % TIMETRA;
        } else {
            return num % TIMETRA + TIMETRA;
        }
    }

    /**
     * @return The hour
     */

    public int getHour() {
        return this.hour;
    }

    /**
     * @param hour the hour
     */

    public void setHour(int hour) {
        this.hour = validateHour(hour);
    }

    /**
     * @return the minute
     */

    public int getMinutes() {
        return this.minutes;
    }

    /**
     * @param minute - the minute
     */

    public void setMinutes(int minute) {
        this.minutes = validateMS(minute);
    }

    /**
     * @return the second
     */

    public int getSeconds() {
        return this.seconds;
    }

    /**
     * @param second - the second
     */

    public void setSeconds(int second) {
        this.seconds = validateMS(second);
    }

    /**
     * Check if two Time objects are equal.
     */

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour &&
                minutes == time.minutes &&
                seconds == time.seconds;
    }
}
