package libs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String getDateAndTimeFormatted() {
        return getDateAndTime("yyyyMMddHHmm");
    }

    private static String getDateAndTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String dateFormated = dateFormat.format(date);
        return dateFormated;
    }

    public static String getDateBlockInfo(String dateOfPost) throws ParseException {
        DateFormat dateFormatActual = new SimpleDateFormat("yyyyMMddHHmm");
        DateFormat dateFormatExpected = new SimpleDateFormat("MM/dd/yyyy");
        Date dateActual = dateFormatActual.parse(dateOfPost);
        String dateResult = dateFormatExpected.format(dateActual);
        if (dateResult.startsWith("0")) {
            return dateResult.substring(1);
        } else {
            return dateResult;
        }

    }

    public static void waitABit(Integer second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
