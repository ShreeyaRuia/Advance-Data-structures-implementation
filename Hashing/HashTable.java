import java.io.*;
import java.util.*;

class HashTable {

    int m;
    HashEntry[] h;
    int[] flag;
    ArrayList<String> token;
    ArrayList<Integer> homekey;

    HashTable(ArrayList<String> token, ArrayList<Integer> homekey) {
        this.token = token;
        this.homekey = homekey;
        m = Homekeycalc.getmvalue();
        flag = new int[m];
        Arrays.fill(flag, 0);
        h = new HashEntry[m];
        flag = new int[m];
        Arrays.fill(h, new HashEntry());
        System.out.println("FUNCTION FOLLOWED: h(k)=(h(k)+i)%" + m);
    }

    public void insert(int index, String token) {
        int f=0;
        if (search(token) == -1) {
            int check = index;
            if (flag[index] == 0) {
                h[index] = new HashEntry(token, index);
                flag[index] = 1;
                f=1;
            } else {
                int i = 0;
                while (i < m) {
                    if (flag[check] == 0) {
                        flag[check] = 1;
                        f=1;
                        h[check] = new HashEntry(token, index);
                        break;
                    }
                    i++;
                    check++;
                    if (check == m) {
                        check = 0;
                    }
                }
            }
                if(f==0){
                    System.out.println("**************HASH TABLE FULL CANNOT INSERT**********");
                }
                else{
                    System.out.println("**************ELEMENT INSERTED AT: "+check+" **********");
                }

        }
        else{
            System.out.println("**************ELEMENT ALREADY PRESENT**********");
        }
    }

    public void generatehashtable() {
        Iterator ikey = homekey.iterator();
        Iterator itoken = token.iterator();
        while (ikey.hasNext() && itoken.hasNext()) {
            int key = (int) ikey.next();
            String tok = (String) itoken.next();
            insert(key, tok);
        }
    }

    public int search(String search) {
        String adjustedtoken = LengthAdjust.adjust(search);
        int ascii = keycalc.asciivaluecalc(adjustedtoken);
        int index = Homekeycalc.hashfunctioncal(ascii);
        int check = index;
        HashEntry x = h[index];
        if (x.getkey().equals(search)) {
            return index;
        } else {
            int i = 0;
            while (i < m) {
                HashEntry y = h[check];
                if (y.getkey().equals(search)) {
                    return check;
                }
                i++;
                check++;
                if (check == m) {
                    check = 0;
                }
            }
        }

        return -1;
    }

    public void delete(String delete) {
        int index = search(delete);
        if (index == -1) {
            System.out.println("ELEMENT NOT FOUND");
        } else {
            h[index] = new HashEntry("DEL", -1);
            System.out.println("ELEMENT DELETED");
        }

    }

    public void printtable(HashEntry[] x) {
        int i = 0;
        for (HashEntry v : x) {
            System.out.println("index:" + i + " key: " + v.getkey() + "         value: " + v.getvalue());
            i++;
        }
    }

}