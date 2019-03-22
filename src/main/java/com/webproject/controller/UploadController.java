package com.webproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.webproject.util.CheckDataUtil;
import com.webproject.util.IDUtils;
import com.webproject.util.ResultMap;



@Controller
public class UploadController {
	
	public static final String ACCESS_KEY = "r8DLGf0BLmN3QjnAoSCe-PiYzNfARLQZD4BccI2i";

	public static final String SECRET_KEY = "o8llqqKfAMyd3BU86hGL-IPjtn25IGETLjoADIEl";
	
	public static final String gene_bucketName = "genealogy";
	
	public static final String return_path = "http://www.genealogy.zzw777.com/";
	
	static Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
	// 构造一个带指定Zone对象的配置类
	// zone2华南 zone0华东
	static Configuration cfg = new Configuration(Zone.zone0());
	static UploadManager uploadManager = new UploadManager(cfg);
	
	
	
	@RequestMapping( "/uploadFile")
	@ResponseBody
	public ResultMap videoUpload(MultipartFile file  ) {
		if (file.isEmpty()) 
			return ResultMap.build(400, "选择文件");
		String returnPath = "";
		
			
			String originName  = file.getOriginalFilename();
			if (originName.contains(".jpg")
					|| originName.contains(".png")) {
				// 获取文件后缀
				String lastName = originName.substring(originName.lastIndexOf("."), originName.length());
				// 设置上传的key
				String key = IDUtils.genItemId() + lastName;
				// 上传到远程服务器
				doUpload(file ,key);
				// 设置返回的路径
				returnPath  += return_path + key +"," ;
			
		}	
		if (CheckDataUtil.checkNotEmpty(returnPath)) 
			returnPath = returnPath.substring(0,returnPath.length()-1);
		return ResultMap.IS_200(returnPath);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**视频上传*/
	@SuppressWarnings("unused")
	public static String doUpload (MultipartFile file , String key) {
		try {
			Response res  = uploadManager.put(file.getBytes(), key, getUpToken(gene_bucketName,key));
		} catch (QiniuException e) {
			Response r = e.response;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}


	public static String getUpToken(String bucketName, String key) {
		StringMap putPolicy = new StringMap();
		putPolicy.put("insertOnly", 1);
		return auth.uploadToken(bucketName, key, 3600, putPolicy);

	}

}
