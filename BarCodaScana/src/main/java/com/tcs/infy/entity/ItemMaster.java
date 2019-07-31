package com.tcs.infy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "item_master")
public class ItemMaster {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="ItemDescription")
    private String itemDesc;
	
	@Column(name="PrintName")
    private String printName;
	
	@Column(name="Type")
    private String type;
	
	@Column(name="Weight")
    private String weight;
	
	@Column(name="Unit")
    private String unit;
	
	
	@Column(name="BulkItem")
    private int bulkItem;
	
	
	@Column(name="Delstatus")
    private String delStatus;
	
	@Column(name="Modifiedby")
    private String modifiedBy;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ModifiedAt")
    private Date modifiedAt;
	
	
	@Column(name="HSNCode")
    private String hsnCode;
	
	
	@Column(name="MinimumQtyAlert")
    private int minAlert;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userdefID")
    private EANcode itemEANcode;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category")
    private Category itemCategory;
	
    
    public ItemMaster() {
  
    }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public String getItemDesc() {
		return itemDesc;
	}


	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}


	public String getPrintName() {
		return printName;
	}


	public void setPrintName(String printName) {
		this.printName = printName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public int getBulkItem() {
		return bulkItem;
	}


	public void setBulkItem(int bulkItem) {
		this.bulkItem = bulkItem;
	}
/*
	@Column(name="UserdefID")
    private String userdefID;
	
	@Column(name="Category")
    private int category;

	public String getUserdefID() {
		return userdefID;
	}


	public void setUserdefID(String userdefID) {
		this.userdefID = userdefID;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}

*/

	public String getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Date getModifiedAt() {
		return modifiedAt;
	}


	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	public String getHsnCode() {
		return hsnCode;
	}


	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}


	public int getMinAlert() {
		return minAlert;
	}


	public void setMinAlert(int minAlert) {
		this.minAlert = minAlert;
	}


	public EANcode getItemEANcode() {
		return itemEANcode;
	}


	public void setItemEANcode(EANcode itemEANcode) {
		this.itemEANcode = itemEANcode;
	}


	public Category getItemCategory() {
		return itemCategory;
	}


	public void setItemCategory(Category itemCategory) {
		this.itemCategory = itemCategory;
	}
	
	
	
	
	public String toString() {
		System.out.println(this.itemEANcode.toString());
		System.out.println(this.itemCategory.toString());
		return "ID : "+this.id+" , ItemDesc : "+this.itemDesc+" , PrintName : "+this.printName+", ModifiedBy : "+this.modifiedBy+" , MinAlert : "+this.minAlert;
	}
 
   
	
 
}

