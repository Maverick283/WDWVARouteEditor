/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import javafx.util.StringConverter;

/**
 *
 * @author patrickburkart
 */
public class calc {

    public static int StringToInt(String toConvert) {
        int toReturn = 0;
        toConvert = toConvert.trim();
        try {
            toReturn = Integer.parseInt(toConvert);
        } catch (NumberFormatException e) {
        }
        return toReturn;
    }

    public static double StringToDouble(String toConvert) {
        double toReturn = 0;
        toConvert = toConvert.replaceAll("[^0123456789.,]", "");

        try {
            toReturn = Double.parseDouble(toConvert);
        } catch (NumberFormatException e) {

        }
        return toReturn;
    }

    public static String IntToString(int toConvert) {
        return String.valueOf(toConvert);
    }

    public static boolean StringToBoolean(String toConvert) {
        return toConvert.equalsIgnoreCase("1");
    }

    public static String BooleanToStrin(boolean toConvert) {
        if (toConvert) {
            return "1";
        } else {
            return "0";
        }
    }

    public static boolean notInArray(String[] array, String toCheck) {
        boolean toReturn = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(toCheck)) {
                toReturn = false;
                return toReturn;
            }
        }
        return toReturn;
    }

    public static String[] addToArray(String[] array, String toAdd) {
        String[] newArray;
        if (array[0].equalsIgnoreCase("")) {
            array[0] = toAdd;
            newArray = array;
        } else {
            newArray = new String[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[array.length] = toAdd;
        }
        return newArray;

    }

    static String getCurrentTimeAsString(String format) {
        return new SimpleDateFormat(format).format(new java.util.Date());
    }

    static String getTempPath() {
        String property = "java.io.tmpdir";
        return System.getProperty(property) + "/WDWVA";
    }

    public static void openWebpage(String url) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    static String convertToHex(int rgb) {
        return Integer.toHexString(rgb);
    }

    /**
     * Saves the file from the specified link to the destination File. Returns
     * false if an error occured
     *
     * @param fileURL
     * @param destinationFile
     * @return operation successfull
     */
    static boolean saveFile(String fileURL, String destinationFile) {
        try {
            URL url = new URL(fileURL);

            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static StringConverter<Integer> getStringConverterToInt() {
        StringConverter<Integer> toReturn = new StringConverter<Integer>() {

            @Override
            public String toString(Integer object) {
                return String.valueOf(object);
            }

            @Override
            public Integer fromString(String string) {
                return Integer.parseInt(string);
            }
        };
        return toReturn;
    }

    static String getDuration(String startingTime, String endingTime) throws NumberFormatException {
        String startingTimeZone = getTimeZoneFromString(startingTime);
        String endingTimeZone = getTimeZoneFromString(endingTime);
        if (startingTimeZone.equalsIgnoreCase(endingTimeZone)) {
            int startingTimeInt = getTimeFromString(startingTime);
            int endingTimeInt = getTimeFromString(endingTime);
            int duration = endingTimeInt - startingTimeInt;
            return getStringFromTime(duration);
        } else {
            throw new NumberFormatException("The Timezones of " + startingTime + " and " + endingTime + " are not equal. Thus the duration could not be calculated");
        }
    }

    static String getTimePlusDuration(String startingTime, Float duration) {
        int starting = getTimeFromString(startingTime);
        String timeZone = getTimeZoneFromString(startingTime);
        int durationInt = getTimeIntFromFloat(duration);
        int endTime = (int) (starting + durationInt);
        return getStringFromTime(endTime, timeZone);
    }

    static String getTimeMinusDuration(String endingTime, Float duration) {
        int ending = getTimeFromString(endingTime);
        String endingtimeZone = getTimeZoneFromString(endingTime);
        int durationInt = getTimeIntFromFloat(duration);
        int startTime = (int) (ending - durationInt);
        return getStringFromTime(startTime, endingtimeZone);
    }

    static int getTimeFromString(String toConvert) {
        String hourString = toConvert.substring(0, toConvert.indexOf(":"));
        toConvert = toConvert.substring(toConvert.indexOf(":")+1);
        String minuteString = toConvert.substring(0, 2);
        int hour = Integer.parseInt(hourString);
        int minute = Integer.parseInt(minuteString);
        return (hour * 60) + minute;
    }

    static String getTimeZoneFromString(String timeWithTimeZone) {
        String timeZone = timeWithTimeZone.replaceAll("[0-9:]+", "");
        timeZone = timeZone.trim();
        return timeZone;
    }

    static String getStringFromTime(int time) {
        int hours = 0;
        int minutes = 0;
        while (time >= 60) {
            time = time - 60;
            hours++;
        }
        minutes = time;
        return String.valueOf(hours) + ":" + String.valueOf(minutes);
    }

    static String getStringFromTime(int endTime, String timeZone) {
        return getStringFromTime(endTime) + " " + timeZone.trim();
    }
    
    static String getFlightTimeFromString(String flightTime){
        flightTime = flightTime.replaceAll(":", ".");
        flightTime = flightTime.replaceAll("[^\\d.]", "");
        return flightTime;
    }

    static int getTimeIntFromFloat(Float duration) {
        int hour = 0;
        int min = 0;
        duration = duration * 100;
        while(duration >= 100){
            duration = duration -100;
            hour ++;
        }
        min = duration.intValue();
        return (hour * 60) + min;
    }
}
