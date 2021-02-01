package cabbooking;
import java.util.*;
public class Booking extends Thread{
	public int bid;
	public char pp;
	public char dp;
	public int ptime;
	public int dtime;
	public Taxi t;
	public Booking(){
		
	}
	public Booking(int bid,char pp,char dp,int ptime,int dtime,Taxi t){
		this.bid=bid;
		this.pp=pp;
		this.dp=dp;
		this.ptime=ptime;
		this.dtime=dtime;
		this.t=t;
	}
	public void setBid(int bid){
		this.bid=bid;
	}
	public void setPp(char pp){
		this.pp=pp;
	}
	public void setDp(char dp){
		this.dp=dp;
	}
	public void setPtime(int ptime){
		this.ptime=ptime;
	}
	public void setDtime(int dtime){
		this.dtime=dtime;
	}
	public void setTaxi(Taxi t){
		this.t=t;
	}
	public int getBid(){
		return bid;
	}
	public char getPp(){
	return pp;
	}
	public char getDp(){
		return dp;
	}
	public int getPtime(){
		return ptime;
	}
	public int getDtime(){
		return dtime;
	}
	public Taxi getTaxi(){
		return t;
	}
	public void run(){
		t.setAvail(false);
		try{
		Thread.sleep((15000)*(Math.abs(pp-dp)));
		t.setAvail(true);
		t.setStation(dp);
		t.stime = dtime;
		}catch(Exception e){
			System.out.println("Interrupted");
		}
		
	}
	public String toString(){
		return "Booking Id- "+bid+" PickUp Point- "+pp+" Drop Point- "
				+dp+" Pickup Time- "+ptime+" Drop Time- "+dtime+" Taxi-"+t;
	}
	
	
}