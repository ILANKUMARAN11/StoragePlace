package com.tcs.infy.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ItemEANcode")
public class EANcode {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="ItemID")
	private long itemId;
	
	@Column(name="EANcode")
	private String eanCode;
	
	@Column(name="Delstatus")
    private String delStatus;
	
	@Column(name="Modifiedby")
    private String modifiedBy;
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ModifiedAt")
    private Date modifiedAt;
	
	
	
	public EANcode() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getEanCode() {
		return eanCode;
	}

	public void setEanCode(String eanCode) {
		this.eanCode = eanCode;
	}

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
	
	@OneToOne(mappedBy="itemEANcode",cascade=CascadeType.ALL)
    private ItemMaster itemMaster;



	public ItemMaster getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	
	public String toString() {
		return " ID: "+this.id +" , ItemID : "+this.itemId+" , EanCode : "+this.eanCode+" , DeltedStatus : "+this.delStatus+" , ModifiedBy : "+this.modifiedBy;
	}
	

}
