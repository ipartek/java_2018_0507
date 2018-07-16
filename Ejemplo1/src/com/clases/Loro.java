package com.clases;

public class Loro extends Ave{
	public char region; 
	public String color;
	public void cantar(){
		System.out.println(	"pio pio pio soy un pajarito");
	}
	public Loro(char sexo,int edad,char region,String color){
		super(sexo,edad);
		this.region=region;
		this.color=color;
	}
	public char getRegion() {
		return region;
	}
	public void setRegion(char region) {
		this.region = region;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char deDondeEres(){
		return this.region;
	}
}