package cn.itcast.ssm.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	/**
	 * ��ת����¼ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}

	/**
	 * �û���¼
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("login.action")
	public String login(String username, String password, HttpSession session) {
		// У���û���¼
		System.out.println(username);
		System.out.println(password);

		// ���û����ŵ�session��
		session.setAttribute("username", username);

		return "redirect:/item/itemList.action";
	}

}