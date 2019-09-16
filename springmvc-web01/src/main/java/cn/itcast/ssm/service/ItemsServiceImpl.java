package cn.itcast.ssm.service;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.pojo.Items;

@Service(value = "asdf")
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemMapper;

	@Override
	public List<Items> queryItemList() {
		// 从数据库查询商品数据
		List<Items> list = this.itemMapper.selectByExample(null);

		return list;
	}
	
	@Test
	public void testsercce() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml","spring/applicationContext-service.xml");
		ItemsServiceImpl bean = (ItemsServiceImpl) classPathXmlApplicationContext.getBean("asdf");
		List<Items> queryItemList = bean.queryItemList();
		System.out.println(queryItemList);
	}

	@Override
	public Items querybyid(int id) {
		  Items items = this.itemMapper.querybyid(id);

			return items;
	}
	
	public int updateItemsbyid(Items items) {
		  int updateByPrimaryKey = this.itemMapper.updateItemsbyid(items);

			return updateByPrimaryKey;
	}

	
}