package com.ly.picture;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ly.picture.bean.Pictures;

/**
 * Servlet implementation class GetPictures
 */
@WebServlet(description = "获取图片的址址给到客户端", urlPatterns = { "/GetPictures" })
public class GetPictures extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PicturesRepository mPicturesRepository = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPictures() {
        super();
        mPicturesRepository = new PicturesRepository();
        System.out.println("GetPictures() " + this + " thread current Name " + Thread.currentThread().getName());
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		mPicturesRepository.init();
		System.out.println("init(ServletConfig config) " + this + " config " + config + " thread current Name " + Thread.currentThread().getName());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy() " + this + " thread current Name " + Thread.currentThread().getName());
		mPicturesRepository.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() " + this + " request " + request + " response " + response + " thread current Name " + Thread.currentThread().getName());
		
		Pictures pictures = new Pictures();
		pictures.setClientName(request.getRemoteAddr());
		pictures.setServerName("GetPictures");
		pictures.setPictures(mPicturesRepository.getAllPictures());
		
		String jsonString = JSON.toJSONString(pictures);
		System.out.println(jsonString);
		
		response.getOutputStream().write(jsonString.getBytes());
	}

}
