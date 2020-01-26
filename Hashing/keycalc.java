import java.io.*;
import java.util.*;

class keycalc {

    public static ArrayList listkeycalci(ArrayList<String> token) {
        ArrayList<Integer> key = new ArrayList<>();
        Iterator iterator = token.iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            key.add(asciivaluecalc(name));
        }
        return key;
    }

    public static int asciivaluecalc(String name) {
        char[] n = name.toCharArray();
        int ascii = 0;
        for (char c : n) {
            ascii += (int) c;
        }
        return ascii;
    }
}
