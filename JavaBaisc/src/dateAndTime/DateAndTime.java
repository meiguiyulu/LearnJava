package dateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date today = new Date();
        System.out.println(format.format(today));
    }
}
