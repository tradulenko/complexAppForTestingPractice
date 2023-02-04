package libs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static String getDateAndTimeFormatted() {

        return getDateAndTime("yyyyMMddHHmmss");
    }

    public static String formatDateToAnotherFormat(String originalDate) throws ParseException {
        DateFormat originalFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("M/d/yyyy");
        Date date = originalFormat.parse(originalDate);
        String formattedDate = targetFormat.format(date);
        return formattedDate;
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
