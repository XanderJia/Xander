package cn.itcast.ssm.service;

import java.util.List;


import cn.itcast.ssm.pojo.Items;
public interface ItemsService {

	/**
	 * 查询商品列表
	 * 
	 * @return
	 */
	List<Items> queryItemList();

	Items querybyid(int id);

	int updateItemsbyid(Items items);

}