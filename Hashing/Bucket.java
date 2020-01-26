import java.io.*;
import java.util.*;

class Bucket{
	String name;
	int ld;
	ArrayList<String> buck;

	Bucket(){
		name="null";
		ld=-1;
		buck=new ArrayList<>();
		buck.add("null");
		buck.add("null");
		buck.add("null");
	}

	Bucket(String n,int i){
		name=n;
		ld=i;
		buck=new ArrayList<>();
	}

	public int add(String token){
		if(buck.size()<3){
			buck.add(token);
			return 1;
		}
		else
			return -1;
	}
 
	@Override
	public String toString(){
		return "##BUCKET DETAILS:"+ " Name:"+name+" local depth:"+ld+" list of data"+buck+"\n";
	}
}