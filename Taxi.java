package cabbooking;
public class Taxi {
	public int taxi;
	public char station;
	public int stime;
	public int earn;
	public boolean avail;
	public Taxi(){
		
		
	}
	public Taxi(int taxi,char station,int stime,int earn,boolean avail){
		this.taxi=taxi;
		this.station=station;
		this.stime=stime;
		this.earn=earn;
		this.avail=avail;
		
	}
	public void setTaxi(int taxi){
		this.taxi = taxi;
	}
	public void setStation(char station){
		this.station=station;
	}
	public void setStime(int stime){
		this.stime=stime;
	}
	public void setEarn(int earn){
		this.earn=earn;
		
	}
	public void setAvail(boolean avail){
	this.avail=avail;
	}
	public int getTaxi(){
		return taxi;
	}
	public char getStation(){
		return station;
	}
	public int getStime(){
		return stime;
	}
	public int getEarn(){
		return earn;
	}
	public boolean getAvail(){
		return avail;
	}
	
	public String toString(){
		return "taxi- "+taxi+" station- "+station+" Station Time- "+stime+" earnings- "+earn;
	}
	
	
	
}