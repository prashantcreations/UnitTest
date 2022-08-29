package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Iteam")
public class Iteam {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "prize")
	private int prize;
	@Column(name = "quantity")
	private int quantity;

	@Transient // if u dont want t osave that column
	private int value;
	
	public Iteam() {
		// TODO Auto-generated constructor stub
	}

	public Iteam(int id, String name, int prize, int quantity) {
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.quantity = quantity;
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
		return String.format("Iteam[%d,%s,%d,%d]", id, name, prize, quantity);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
