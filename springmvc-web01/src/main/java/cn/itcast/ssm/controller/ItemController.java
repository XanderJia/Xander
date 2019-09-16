package cn.itcast.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Items;
import cn.itcast.ssm.pojo.QueryVo;
import cn.itcast.ssm.service.ItemsService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemsService itemService;

	/**
	 * ��ʾ��Ʒ�б�
	 * 
	 * @return
	 */
	@RequestMapping("/itemList.action")
	public ModelAndView queryItemList() {
		// ��ȡ��Ʒ����
		List<Items> list = this.itemService.queryItemList();

		ModelAndView modelAndView = new ModelAndView();
		// ����Ʒ���ݷŵ�ģ����
		modelAndView.addObject("itemList", list);
		// �����߼���ͼ
		modelAndView.setViewName("itemList");

		return modelAndView;
	}
	
	@RequestMapping("/itemEdit.action")
	public ModelAndView querybyid(int id) {
		// ��ȡ��Ʒ����
		Items items= this.itemService.querybyid(id);

		System.out.println(items.getName());
		ModelAndView modelAndView = new ModelAndView();
		// ����Ʒ���ݷŵ�ģ����
		modelAndView.addObject("item", items);
		// �����߼���ͼ
		modelAndView.setViewName("editItem");

		return modelAndView;
	}
	
	@RequestMapping("/updateitem.action")
	public ModelAndView updateItemsbyid(HttpServletRequest request,Items items,MultipartFile pictureFile) throws IOException {
		String info =null;
		
		
	
			String picName = UUID.randomUUID().toString();
			String oriName = pictureFile.getOriginalFilename();
			String extName = oriName.substring(oriName.lastIndexOf("."));
			pictureFile.transferTo(new File("C:\\Users\\Xander\\Desktop\\img\\"+picName+extName));
	
			
			int updateItemsbyid = this.itemService.updateItemsbyid(items);
			 if (updateItemsbyid>0) {
					info = "�ϴ��ɹ�";
				}else {
					info = "�ϴ�ʧ��";
				}
			 request.setAttribute("info", info);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("item", items);
			
			
			modelAndView.setViewName("editItem");
	
			return modelAndView;
			
		
//		Items items = new Items(id,name,price,createtime,detail);
//		 int updateItemsbyid = this.itemService.updateItemsbyid(items);
//		 if (updateItemsbyid>0) {
//			info = "�޸ĳɹ�";
//		}else {
//			info = "�޸�ʧ��";
//		}
//		 req.setAttribute("info", info);
//		System.out.println(updateItemsbyid);
//		ModelAndView modelAndView = new ModelAndView();
//		
//		modelAndView.addObject("item", items);
//		
//		
//		modelAndView.setViewName("WEB-INF/jsp/editItem.jsp");
//
//		return modelAndView;
	}


}