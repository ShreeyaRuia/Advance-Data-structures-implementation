import java.io.*;
import java.util.*;
import java.lang.*;

class ExtendibleHashing{
	int gainfactor;
	Directory d;

	ExtendibleHashing(int gainfactor){
		this.gainfactor=gainfactor;
		d=new Directory(gainfactor);
		int ld=gainfactor;
		for(int i=0;i<Math.pow(2,gainfactor);i++){
 			String bname=Integer.toBinaryString(i);
 			while(bname.length()!=ld){
 			bname="0"+bname;
 		}
 		d.addbucket(new Bucket(bname,ld));
		}
		System.out.println(d);
	}

	public int insert(String token){
		String adjustedtoken = LengthAdjust.adjust(token);
        int ascii = keycalc.asciivaluecalc(adjustedtoken);
        int index = Homekeycalc.hashfunctioncal(ascii);
        String key=Binarygeneration.binary(index);
		int flag=1;
		Bucket b=null;
		String subkey=key.substring(key.length()-gainfactor);
		for (String dname: d.direct.keySet()){
 		if(dname.equals(subkey)){
 			if(flag==1){
 			b=d.direct.get(dname);
 			int check=b.add(token);
 			if(check==-1){
 			ArrayList<String> values=new ArrayList<>();
			values=b.buck;
			values.add(token);
			System.out.println("**********COLLISION AT:"+token+"***************");
 			collision(dname,b,values);
 			break;
 			}
 			flag=0;
 		}
 		d.direct.replace(dname,b);
 	}
	}
		System.out.println("*****************AFTER INSERTION:"+token+" : "+key+"***************************");
System.out.println(d);
	return 1;
}


public void collision(String coldirname,Bucket b,ArrayList<String> values){
	if(d.gd==b.ld){
		Directory newd=new Directory(gainfactor+1);
		for (String dname: d.direct.keySet()){
				newd.addbucket(d.direct.get(dname));
		}
		newd.direct.replace("0"+coldirname,new Bucket("0"+coldirname,gainfactor+1));
		newd.direct.replace("1"+coldirname,new Bucket("1"+coldirname,gainfactor+1));
		gainfactor++;
        d=newd;
		Iterator ival = values.iterator();
		while (ival.hasNext()) {
            String vals = (String) ival.next();
            insert(vals);
        }
    }
	else{
		d.direct.replace("0"+coldirname.substring(1),new Bucket("0"+coldirname.substring(1),b.ld+1));
		d.direct.replace("1"+coldirname.substring(1),new Bucket("1"+coldirname.substring(1),b.ld+1));
		Iterator ival = values.iterator();
		while (ival.hasNext()) {
            String vals = (String) ival.next();
            insert(vals);
	}
}
}

public String search(String token){
	String adjustedtoken = LengthAdjust.adjust(token);
        int ascii = keycalc.asciivaluecalc(adjustedtoken);
        int index = Homekeycalc.hashfunctioncal(ascii);
        String key=Binarygeneration.binary(index);
        String subkey=key.substring(key.length()-gainfactor);
        Bucket b=d.direct.get(subkey);
        if(b.buck.contains(token)){
        	return subkey + b.name;
        }
        else{
        	return "NO";
        }
}


public int delete(String token){
	String adjustedtoken = LengthAdjust.adjust(token);
        int ascii = keycalc.asciivaluecalc(adjustedtoken);
        int index = Homekeycalc.hashfunctioncal(ascii);
        String key=Binarygeneration.binary(index);
	if(search(token).equals("NO")){
		return -1;
	}
	else{
        String subkey=key.substring(key.length()-gainfactor);
        Bucket b=d.direct.get(subkey);
        b.buck.remove(token);
        d.direct.replace(subkey,b);
        String newsubkey;
        if(subkey.charAt(0)=='1'){
        	newsubkey="0"+subkey.substring(1);
        }
        else{
        	newsubkey="1"+subkey.substring(1);
        }
        Bucket newb=d.direct.get(newsubkey);
        if(b==newb){
            //checking if sibling exists //here no sibling so no chances of further changes.
        	d.direct.replace(newsubkey,b);
        }
        else{
        	if(b.ld==d.gd &&(b.buck.size()+newb.buck.size()<=3)){
        		b.ld--;
        		b.name=b.name.substring(1);
        		b.buck.addAll(newb.buck);
        		d.direct.replace(newsubkey,b);
        		d.direct.replace(subkey,b);
        	}
        	int i=0;
        	for(Bucket bx:d.direct.values()){
        		if(bx.ld==d.gd){
        			break;
        		}
        		i++;
        	}
        	if(i==Math.pow(2,gainfactor)){
        		Directory newd=new Directory(gainfactor-1);
        		for(Bucket bx:d.direct.values()){
        			newd.addbucket(bx);
        		}
        		d=newd;
        	}
        }
	}
	System.out.println("*****************AFTER DELETION:"+token+ " : "+key+"***************************");
	System.out.println(d);
	return 1;
}
}