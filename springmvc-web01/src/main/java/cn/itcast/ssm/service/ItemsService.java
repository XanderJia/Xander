package cn.itcast.ssm.service;

import java.util.List;


import cn.itcast.ssm.pojo.Items;
public interface ItemsService {

	/**
	 * ��ѯ��Ʒ�б�
	 * 
	 * @return
	 */
	List<Items> queryItemList();

	Items querybyid(int id);

	int updateItemsbyid(Items items);

}