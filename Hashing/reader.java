
import java.io.*;
import java.util.*;

class reader{

	 public static ArrayList filereader(){
	        ArrayList<String> list=new ArrayList<String>();
	       String line;
	       try{
	       	 	FileReader f=new FileReader(new File("newc"));
	       		BufferedReader b= new BufferedReader(f);
	       		while((line=b.readLine())!=null){
                   String[] arr=line.trim().split("[\\n{}\\s+#%&=/,\"*+-<>.();]");
                   Collections.addAll(list,arr);
               }
	       		}
	       		catch(FileNotFoundException e){
	       			System.out.println("FileNotFound");
	       		}
	       		catch(IOException e){
	       			System.out.println("IOException");
	       		}
	       		list.removeAll(Collections.singleton(" "));
	       		list.removeAll(Collections.singleton(""));
	       		Set<String> set = new HashSet<>(list);
				list.clear();
				list.addAll(set);
	       return list;
	   }

	}
