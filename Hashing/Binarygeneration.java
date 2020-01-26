import java.io.*;
import java.util.*;

class Binarygeneration{
	static int paddingsize=10;

	public static String binary(int key){
			String x=Integer.toBinaryString(key);
			if(x.length()<paddingsize){
				while(x.length()!=paddingsize){
					x="0"+x;
				}
			}
			return x;
	}

	public static ArrayList<String> binarylist( ArrayList<Integer> key){
		ArrayList<String> binarykeys=new ArrayList<>();
		Iterator ikey = key.iterator();
		while (ikey.hasNext()) {
            int keys = (int) ikey.next();
            binarykeys.add(binary(keys));
        }
        return binarykeys;
	}
}


