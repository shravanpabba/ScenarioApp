package com.list.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "KEYWORD")
public class Keyword {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "KEYWORD_NAME")
	private String itemName;
	@Column(name = "CATEGORY_ID")
	private int catid;
	@Column(name = "ACTIVE_SW")
	private String activeSW;
	
	public String getActiveSW() {
		return activeSW;
	}

	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}

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
