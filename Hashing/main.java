	import java.io.*;
	import java.util.*;

	class main{
	 public static void main(String[] args) {
	    ArrayList<String> x = reader.filereader();
	    System.out.println("****************GENERATED TOKENS from file:****************\n" + x+"\n");
	    ArrayList<String> token = LengthAdjust.createadjustedlist(x);
	    //System.out.println("***************ADJUSTED TOKENS:***********\n"+token);
	    ArrayList<Integer> key = keycalc.listkeycalci(token);
	    ArrayList<Integer> homekey = Homekeycalc.listhomekeycalci(key);
	    System.out.println("****************GENERATED HOMEKEYS:****************\n" + homekey+"\n");
	    int m = Homekeycalc.getmvalue();
	    //System.out.println("**************FUNCTION FOLLOWED: h(k)=(h(k)+i)%" + m+"*********************");
	    HashTable abc = new HashTable(x, homekey);
	    abc.generatehashtable();
	    ArrayList<String> binary = Binarygeneration.binarylist(key);
	    //System.out.println(binary);
	    /*Bucket x1=new Bucket();
	    Bucket x2=new Bucket("000",3);
	    System.out.println(x1+"\n"+x2);
	    Directory d=new Directory(5);
	    d.addbucket(x2);
	    System.out.println(d);
	    ExtendibleHashing hash=new ExtendibleHashing(2);
	    Iterator iterator = x.iterator();
	    int i=1;
	    while (iterator.hasNext()&& i<14) {
	        String name = (String) iterator.next();
	        hash.insert(name);
	        i++;
	    }
	   System.out.println(hash.search("stdio"));
	   System.out.println(hash.delete("scanf"));
	   System.out.println(hash.delete("not"));*/

	    // for linear probing:
	    System.out.println("****************INITIAL HASH TABLE GENERATED****************");
	    int choice = 0;
	    while (choice != 5) {
	        System.out.println("***LINEAR PROBING: \nENTER CHOICE 1.insert 2.delete 3.search 4.print 5.exit***");
	        Scanner sc = new Scanner(System.in);
	        choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	                System.out.println("ENTER TOKEN TO BE INSERTED:");
	                String insert = sc.next();
	                String adjustedtoken = LengthAdjust.adjust(insert);
	                int ascii = keycalc.asciivaluecalc(adjustedtoken);
	                int index = Homekeycalc.hashfunctioncal(ascii);
	                abc.insert(index, insert);
	                abc.printtable(abc.h);
	                break;
	            case 2:
	                System.out.println("ENTER TOKEN TO BE DELETED:");
	                String delete = sc.next();
	                abc.delete(delete);
	                abc.printtable(abc.h);
	                break;
	            case 3:
	                System.out.println("ENTER TOKEN TO BE SEARCHED:");
	                String search = sc.next();
	                int found=abc.search(search);
	                if(found==-1){
	                    System.out.println("****************ELEMENT NOT FOUND****************");
	                }
	                else{
	                    System.out.println("****************ELEMENT FOUND AT::  "+  found  +"  ****************");
	                }
	                break;
	            case 4:
	                abc.printtable(abc.h);
	                break;
	            case 5:
	                System.out.println("****************EXITING****************");
	                break;
	        }

	    }

	    System.out.println("EXTENDIBLE HASHING: INITIAL DIRECTORY CREATED WITH GAINFACTOR=2 AND BUCKET SIZE=3");
	    ExtendibleHashing hash=new ExtendibleHashing(2);
	    choice = 0;
	    while (choice != 5) {
	        System.out.println("***EXTENDIBLE HASHING: \nENTER CHOICE 1.insert 2.delete 3.search 4.print 5.exit***");
	        Scanner sc = new Scanner(System.in);
	        choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	               //System.out.println("ENTER TOKEN TO BE INSERTED:");
	               //String insert = sc.next();
					Iterator iterator = x.iterator();
					int i=1;
					while (iterator.hasNext()&& i<14) {
					String name = (String) iterator.next();
					hash.insert(name);
					i++;
					}
	    			//hash.insert(insert);
	                break;
	            case 2:
	                System.out.println("ENTER TOKEN TO BE DELETED:");
	                String delete = sc.next();
						//System.out.println(hash.delete("scanf"));
						// System.out.println(hash.delete("not"));
	                hash.delete(delete);
	                break;
	            case 3:
	                System.out.println("ENTER TOKEN TO BE SEARCHED:");
	                String search = sc.next();
	                //System.out.println(hash.search("stdio"));
	                String found=hash.search(search);
	                if(found.equals("NO")){
	                    System.out.println("****************ELEMENT NOT FOUND****************");
	                }
	                else{
	                    System.out.println("****************ELEMENT FOUND AT"+found+"*****************");
	                }
	                break;
	            case 4:
	                System.out.println(hash.d);
	                break;
	            case 5:
	                System.out.println("***********EXITING****************");
	                break;
	        }

	    }

	}

	public static void print(String[] x) {
	    int i = 0;
	    for (String v : x) {
	        System.out.println("index:" + i + " value " + v);
	        i++;
	    }
	}
	}