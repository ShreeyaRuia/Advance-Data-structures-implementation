import java.io.*;
import java.util.*;
import java.lang.*;

class Directory{
 int gd;
 HashMap<String,Bucket> direct;

 Directory(int gd){
 	this.gd=gd;
 	direct=new HashMap<>();
 	generatedirectory();
 }

 public void generatedirectory(){
 	for(int i=0;i<Math.pow(2,gd);i++){
 		String dname=Integer.toBinaryString(i);
 		while(dname.length()!=gd){
 			dname="0"+dname;
 		}
 		direct.put(dname,new Bucket());
 		}
 	}
 
 public void addbucket(Bucket b){
 	for (String dname: direct.keySet()){
 		if(dname.substring(dname.length()-b.ld).equals(b.name)){
 			direct.replace(dname,b);
 		}
 	}
 }

 @Override
	public String toString(){
		return " DIRECTORY DETAILS:\n"+  " global depth:"+gd+"\n directory data-\n"+ direct;
	}
}