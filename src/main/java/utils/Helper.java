package utils;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static int parseStringToInt(String inputString) {
        Pattern pattern = Pattern.compile("[\\d.]+");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            String numericPart = matcher.group();
            try {
                numericPart = numericPart.replaceAll(",", "");
                double doubleValue = Double.parseDouble(numericPart);
                return (int) doubleValue;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return 0;
    }


    //რაკი mssql - ში სხვა ფორმატის date იყო საჭირო და რეგისტრაციის ინფუთში სხვა ამიტომ ამ ფორმატ მეთოდს ვიყენებ
    public static String formatSqlDate(Date sqlDate, String targetFormat) {
        try {
            SimpleDateFormat targetDateFormat = new SimpleDateFormat(targetFormat);
            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
            return targetDateFormat.format(utilDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
