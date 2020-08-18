package com.webproject.service;

import com.webproject.entity.House;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

public interface HouseService {

	Result add(House house);

	PageResult list(House house, int page, int rows);

	House findOne(String id);

	Result update(House house);

}
