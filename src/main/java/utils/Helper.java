package utils;

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
}
