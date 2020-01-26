import java.io.*;
import java.util.*;

class HashEntry {

    String key = "null";
    int value = -1;

    HashEntry() {
    }

    HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getkey() {
        return key;
    }

    public int getvalue() {
        return value;
    }
}