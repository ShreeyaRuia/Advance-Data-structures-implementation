import java.io.*;
import java.util.*;

class LengthAdjust {

    public static ArrayList createadjustedlist(ArrayList<String> token) {
        ArrayList<String> adjustedtokens = new ArrayList<>();
        Iterator iterator = token.iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            adjustedtokens.add(adjust(name));
        }
        return adjustedtokens;
    }

    public static String adjust(String name) {
        if (name.length() < 10) {
            do {
                name += "*";
            } while (name.length() != 10);
        }
        if (name.length() > 10) {
            name = name.substring(0, 10);
        }
        return name;
    }
}