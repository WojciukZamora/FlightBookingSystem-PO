/**
 * @author Andrzej Zamora
 */
public class OurDate {
    private int day;
    private int month;
    private int year;
    private int hour;
    public OurDate(int day,int month,int year,int hour) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
    }

    public void increase(int hour) {
        this.hour = this.hour + hour;
        if(this.hour > 24) {
            this.day += this.hour/24;
            this.hour %= 24;
            if(this.day > 30) {
                this.month += this.day/30;
                this.day %= 30;
                if(this.month > 12) {
                    this.year += this.month/12;
                    this.month %= 12;
                }
            }
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year + " " + hour;
    }
}
