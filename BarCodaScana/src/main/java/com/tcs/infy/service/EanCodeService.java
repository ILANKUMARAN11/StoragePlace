package com.tcs.infy.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.infy.entity.Category;
import com.tcs.infy.entity.EANcode;
import com.tcs.infy.entity.ItemMaster;
import com.tcs.infy.repo.ItemEanCodeRepo;
import com.tcs.infy.repo.ItemMasterRepo;

@Service
public class EanCodeService {
	
	@Autowired
	ItemMasterRepo itemMasterRepo;
	
	@Autowired
	ItemEanCodeRepo itemEanCodeRepo;
	
	
	
	@Transactional
	public EANcode getByEanCode(String ean)
	{
		return itemEanCodeRepo.findByEanCode(ean).orElse(null);
	}
	
	
	@Transactional
	public ItemMaster saveItem()
	{
		
		EANcode en=new EANcode();
		en.setDelStatus("detStatus");
		en.setModifiedBy("admin");
		en.setModifiedAt(new Date());
		en.setDelStatus("detStatus");
		en.setEanCode("1005");
		
		Category ct=new Category();
		ct.setDelStatus("detStatus");
		ct.setModifiedBy("admin");
		ct.setModifiedAt(new Date());
		ct.setDelStatus("detStatus");
		ct.setCategory("House & Furniture");
		
		ItemMaster im=new ItemMaster();
		im.setItemDesc("Condom");
		im.setPrintName("Moods");
		im.setUnit("12");
		im.setModifiedBy("admin");
		im.setDelStatus("detStatus");
		im.setBulkItem(0);
		im.setHsnCode("");
		im.setMinAlert(0);
		im.setItemEANcode(en);
		im.setModifiedAt(new Date());
		im.setItemCategory(ct);
		
		return itemMasterRepo.save(im);
	}

}
