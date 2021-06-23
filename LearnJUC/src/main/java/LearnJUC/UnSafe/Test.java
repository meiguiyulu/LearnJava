package LearnJUC.UnSafe;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LYJ
 * @create 2021-05-06 20:41
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = format.parse("2020-11-10");
        Date date2 = format.parse("2021-05-06");
        System.out.println(((date2.getTime()-date1.getTime())/(1000*60*60*24)));
    }
}
