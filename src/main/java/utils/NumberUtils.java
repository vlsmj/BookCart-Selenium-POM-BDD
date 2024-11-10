package utils;

public class NumberUtils {

    public static double convertPriceToDouble(String price) {
        return Double.parseDouble(price.replace("₹", "")
                .replace(",", ""));
    }
}
