package libs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getDateAndTimeFormatted() {

        return getDateAndTime("yyyyMMddHHmmss");
    }

    /**
     * Method returned SystemDateAndTime
     *
     * @return
     */
    public static String getDateAndTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormated = dateFormat.format(date);
        return dateFormated;
    }

    public static void waitABit(Integer second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
