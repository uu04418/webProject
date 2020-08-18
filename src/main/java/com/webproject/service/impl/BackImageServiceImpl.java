package com.webproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Backimageurl;
import com.webproject.mapper.BackimageurlMapper;
import com.webproject.service.BackImageService;

@Service
public class BackImageServiceImpl implements BackImageService {
	
	@Autowired
	private BackimageurlMapper backimageurlMapper;

	public List<Backimageurl> searchList() {
		return backimageurlMapper.selectByExample(null);
	}

	@Override
	public String findImageName(String id) {
		return backimageurlMapper.selectByPrimaryKey(Long.valueOf(id)).getIamgename();
	}

}
