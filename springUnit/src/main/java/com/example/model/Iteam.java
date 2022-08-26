package com.example.model;

public class Iteam {

	private int id;
	private String name;
	private int prize;
	private int quantity;

	public Iteam(int id, String name, int prize, int quantity) {
		this.id=id;
		this.name=name;
		this.prize=prize;
		this.quantity=quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Iteam[%d,%s,%d,%d]", id,name,prize,quantity);
	}
	

}
