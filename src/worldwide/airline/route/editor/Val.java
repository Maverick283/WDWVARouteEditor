/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

/**
 *
 * @author patrickburkart
 */
public class Val {

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
}
