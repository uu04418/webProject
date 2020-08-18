package com.webproject.service;

import com.webproject.entity.Building;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

public interface BuildingService {

	Result add(Building building);

	PageResult list(Building search, int page, int rows);

	Building findOne(String id);

	Result update(Building building);

	PageResult searchHouseByBuildingId(String id);

}
