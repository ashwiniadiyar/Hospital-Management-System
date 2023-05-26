package com.jsp.hospital_app.dao;

import java.util.List;

import com.jsp.hospital_app.dto.Items;

public interface ItemsDao 
{
	public Items saveItems (int mid,Items items );

	public Items  getItems (int iid);

	public boolean deleteItems (int iid);

	public Items  updateItems (int iid, Items items );
	
	public List<Items> getAllItems();

}
