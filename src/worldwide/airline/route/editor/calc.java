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
     * Saves the file from the specified link to the destination File. 
     * Returns false if an error occured
     * 
     * @param fileURL
     * @param destinationFile
     * @return operation successfull
     */
    static boolean saveFile(String fileURL, String destinationFile){
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
        }
        catch(Exception e){
            return false;
        }
    }
}
