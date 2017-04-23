package com.ly.springMVC;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.picture.PicturesRepository;
import com.ly.picture.bean.Pictures;
import com.ly.springMVC.bean.Person;


@Controller
@RequestMapping("/SpringMVC")
public class SpringMVCContronller {

	@Autowired
	private HttpServletRequest mHttpServletRequest;
	@ResponseBody
	@RequestMapping("/GetPictures")
	public Pictures GetPictures(String KEY_WORD,String PAGE_NO,String PAGE_COUNT){
		
		System.out.println("SpringMVCContronller GetPictures thread name " + Thread.currentThread().getName());
		System.out.println("SpringMVCContronller GetPictures thread id " + Thread.currentThread().getId());

		PicturesRepository picturesRepository = new PicturesRepository();
		
		System.out.println("keyword " + KEY_WORD);
		System.out.println("pnString " + PAGE_NO);
		System.out.println("countString " + PAGE_COUNT);
		
		Pictures pictures = new Pictures();
		pictures.setClientName(mHttpServletRequest.getRemoteAddr());
		pictures.setServerName("SpringMVCContronller/GetPictures");
		
		
		if(KEY_WORD == null){
			KEY_WORD = "Android";
		}
		
		int counts = 20;
		
		if(PAGE_COUNT != null){
			try {
				counts = Integer.parseInt(PAGE_COUNT);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		pictures.setPictures(picturesRepository.getAllPictures(KEY_WORD,PAGE_NO,counts));
		pictures.setRealCounts(picturesRepository.realResponsCounts);
		
		return pictures;
		
	}
	
	@RequestMapping("/springMVC")
	public String springMVC(){
		System.out.println("SpringMVCContronller springMVC thread name " + Thread.currentThread().getName());
		System.out.println("SpringMVCContronller springMVC thread id " + Thread.currentThread().getId());

		return "springMVC";
	}
	
	@RequestMapping("/person")
	public String toPerson(Person person){
		System.out.println("SpringMVCContronller toPerson thread name " + Thread.currentThread().getName());
		System.out.println("SpringMVCContronller toPerson thread id " + Thread.currentThread().getId());

		System.out.println("name = " + person.getName());
		System.out.println("age = " + person.getAge());
		return "springMVC";
	}
	
	@RequestMapping("/date")
	public String date(Date date){	
		System.out.println("SpringMVCContronller date thread name " + Thread.currentThread().getName());
		System.out.println("SpringMVCContronller date thread id " + Thread.currentThread().getId());

		System.out.println("date is " + date);
		return "springMVC";
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		System.out.println("SpringMVCContronller initBinder thread name " + Thread.currentThread().getName());
		System.out.println("SpringMVCContronller initBinder thread id " + Thread.currentThread().getId());

		System.out.println(System.currentTimeMillis());
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-DD"), true));
	}
	
	@RequestMapping("/showPerson")
	public String showPerson(Map<String, Person> map) {
		
		System.out.println("SpringMVCContronller showPerson thread name " + Thread.currentThread().getName());
		System.out.println("SpringMVCContronller showPerson thread id " + Thread.currentThread().getId());
		
		Person person = new Person();
		person.setName("Spring MVC show Person");
		person.setAge(30);
		
		map.put("person", person);
		return "springMVC";
	}
}
