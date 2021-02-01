import cabbooking.*; // it was donw in notepad++ so please change while execution
import java.util.*;
public class View {
	char pp;
	char dp;
	int ptime;
	int dtime;
	int earn;
	int bid=1;
	ArrayList<Taxi>taxi = new ArrayList<>();
	ArrayList<Booking>book = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	static View v = new View();
	public View(){
		System.out.println("Enter Number of Taxi");
		int n = in.nextInt();
		for(int i =1;i<=n;i++){
			taxi.add(new Taxi(i,'A',0,0,true));
		}
		
	}
	public static void main(String [] args){
		v.welcome();
	}
	public void welcome(){
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------");
		System.out.println("----------------------WELCOME CAB BOOKING---------");
		System.out.println("1)Booking");
		System.out.println("2)Cancel");
		System.out.println("3)Earnings");
		System.out.println("4)Exit");
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------");
		int ch = in.nextInt();
		switch(ch){
			case 1:v.Booking();
					break;
			case 2:v.Cancel();
					break;
			case 3:v.printearn();
					break;
			case 4:System.exit(0);
				
		}
	}
	public void Booking(){
		v.getDetails();
		Taxi ready =v.isAvail(pp);
		if(ready==null){
			System.out.println("Sorry...No cab is Available");
			v.welcome();
		}
		else{
			
			System.out.println("Taxi- "+ready.getTaxi()+" is Booked");
			int earned = earning(pp,dp);
			ready.setEarn(ready.getEarn()+earned);
			Booking bok = new Booking(bid++,pp,dp,ptime,dtime,ready);
			book.add(bok);
			bok.start();
			v.welcome();
			return;
			
		}
		
	}
	public void Cancel(){
		System.out.println("Enter Booking Id");
		int cbid = in.nextInt();
		Taxi r = null;
		for(Booking b : book){
			if(b.bid==cbid){
				b.interrupt();
				r = b.getTaxi();
				r.setAvail(true);
				r.setStime(b.getDtime()-r.getStime());
				int earned = earning(b.getPp(),b.getDp());
				r.setEarn(r.getEarn()-earned);
				book.remove(b);
				break;
			}
		}
			v.welcome();
			return;
		
		
	}
	public void printearn(){
		int n = taxi.size();
		for(int i=0;i<n;i++){
			Taxi m = taxi.get(i);
			System.out.println("Taxi No: "+(i+1)+"       "+"Total Earnings= "+m.getEarn());
			System.out.println("BookingID	From	To	PickupTime	DropTime		Amount");
			for(Booking b:book){
				if(b.getTaxi().taxi==(i+1)){
				System.out.println("    "+b.getBid()+"		 "+(char)b.getPp()+"	 "+(char)b.getDp()
				+"    	    "+b.getPtime()+"		   "+b.getDtime()+"		  "+(((Math.abs(b.pp-b.dp)*15)-5)*10+100));
				}
			}
			
		}
		v.welcome();
		return;
	}
	public Taxi isAvail(char pp){
		Taxi small1=null,small2=null,small3=null;
		Taxi t1[] = freetaxis((int)pp);
		if(t1.length>0){
			small1 = lowesttaxi(t1);
			return small1;
		}
		
		
		for(int i = (int)pp+1;i<=(int)'F';i++){
			Taxi t2[] = freetaxis(i);
			if(t2.length>0){
			 small2 = lowesttaxi(t2);
				break;
			}
		}
		for(int i =(int)pp-1;i>=(int)'A';i--){
			
			Taxi t3[] = freetaxis(i);
			if(t3.length>0){
			 small3 = lowesttaxi(t3);
				break;
			}
			
		}
		if(small2!=null||small3!=null){
		if(small2==null){
			return small3;
		}else if(small3==null){
			return small2;
		}
		else{
			if(small2.getEarn()>small3.getEarn()){
				return small3;
			}else{
				return small2;
			}
		}
		}
		
		return null;
	}
	public Taxi[] freetaxis(int p){
		Taxi t1[] = new Taxi[taxi.size()];
		int k =0;
		for(Taxi t:taxi){
			if(t.getAvail()==true){
				if(t.getStation()==(char)p){
					t1[k++]=t;
				}
			}
			
		}
		Taxi t2[] = new Taxi[k];
		if(t1[0]!=null){
		
		for(int i =0;i<k;i++){
			t2[i]=t1[i];
		}
		}
		return t2; 
		
	}
	public Taxi lowesttaxi(Taxi[] t1){
		Taxi small = t1[0];
		
		for(int i =1;i<t1.length;i++)
		{
			if(small.getEarn()>t1[i].getEarn()){
				small = t1[i];
			}
		}
		return small;
	}
	
	
	public int earning(char pp,char dp){
		int total = ((Math.abs(pp-dp)*15)-5)*10+100;
		return total;
	}
	public void getDetails(){
		try{
		System.out.println("Enter Pickup Point");
		pp = in.next().charAt(0);
		System.out.println("Enter drop Point");
		dp = in.next().charAt(0);
		System.out.println("Enter Pickup Time");
		ptime = in.nextInt();
		dtime = (Math.abs(pp-dp))+ptime;
		if(dtime>=24){
			dtime=dtime-24;
		}}catch(Exception a){
			System.out.println(a);
		}
	}
	
}