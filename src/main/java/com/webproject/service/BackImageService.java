package com.webproject.service;

import java.util.List;


import com.webproject.entity.Backimageurl;

public interface BackImageService {
	
	public List<Backimageurl> searchList() ;

	public String findImageName(String id);

}
