import java.io.*;
import java.util.*;

class Homekeycalc {

    static int m = 1;

    public static ArrayList listhomekeycalci(ArrayList<Integer> key) {
        ArrayList<Integer> homekey = new ArrayList<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157,
            163, 167, 173, 179, 181, 191, 193, 197, 199};
        int size = key.size();
        for (int findprime : prime) {
            if (findprime > size) {
                m = findprime;
                break;
            }
        }
        System.out.println("********SIZE OF LIST:*********" + size+"\n");
        System.out.println("**********M value:************" + m+"\n");
        Iterator iterator = key.iterator();
        while (iterator.hasNext()) {
            int x = (int) iterator.next();
            homekey.add(hashfunctioncal(x));
        }
        return homekey;
    }

    public static int hashfunctioncal(int x) {
        return x % m;
    }

    public static int getmvalue() {
        return m;
    }

}