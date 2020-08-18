package com.webproject.service;

import com.webproject.entity.Payexpert;
import com.webproject.util.PageResult;
import com.webproject.util.Result;

public interface PayexpertService {

	Result add(Payexpert payexpert);

	PageResult list(Payexpert search, int page, int rows);

	Result deleteOne(String id);

}
