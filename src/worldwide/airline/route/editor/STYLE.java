/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldwide.airline.route.editor;

/**
 *
 * @author Patrick
 */
public class STYLE {

    public static String setBorder() {
        return "-fx-border-color: #C4C4C4";
    }

    public static String setBorder(String color) {
        if (verifyIsColor(color)) {
            color = color.toUpperCase();
            return "-fx-border-color: #" + color + ";";
        }
        return "";
    }

    public static String setBorder(int[] color) {
        return "-fx-border-color: #" + getColorFromRGB(color) + ";";
    }

    public static String setBorderTransparent() {
        return "-fx-background-color: transparent;";
    }

    static String setBackgroundTransparent() {
        return "-fx-background-color: transparent;";
    }

    static String setBackground(String color) {
        if (verifyIsColor(color)) {
            color = color.toUpperCase();
            return "-fx-background-color: #" + color + ";";
        }
        return "";
    }

    private static boolean verifyIsColor(String color) {
        return color.matches("[0-9A-Fa-f]+");
    }

    private static String getColorFromRGB(int[] rgb) {
        for (int i = 0; i < 3; i++) {
            if (rgb[i] < 0) {
                rgb[i] = 0;
            }
            if (rgb[i] > 255) {
                rgb[i] = 255;
            }
        }
        String red = calc.convertToHex(rgb[0]);
        String green = calc.convertToHex(rgb[1]);
        String blue = calc.convertToHex(rgb[2]);

        return red + green + blue;
    }

    static String setFontSize(String fontSizeString) {
        return "-fx-font-size:" + fontSizeString + ";";
    }

}
