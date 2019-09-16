package cn.itcast.ssm.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>{

	public Date convert(String source) {
	
			// ���ַ���ת��Ϊ��������
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date;
				date = simpleDateFormat.parse(source);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		// ���ת���쳣�򷵻ؿ�
		return null;
	}
}
