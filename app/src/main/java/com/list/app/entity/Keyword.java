package com.list.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "keywords")
public class Keyword {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String itemName;
	private int catid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}
}
