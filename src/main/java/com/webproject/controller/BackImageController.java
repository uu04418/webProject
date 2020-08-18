package com.webproject.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.webproject.entity.Backimageurl;
import com.webproject.service.BackImageService;
import com.webproject.util.ResultMap;

@Controller
@RequestMapping("/image")
@ResponseBody
public class BackImageController {
	
	@Autowired
	private BackImageService backImageService;
	
	@Autowired
	private HttpServletRequest request;
	
	/**项目路径**/
	 private static final String webAppPath = "https://www.zzw777.com/webProject/img/";
	//private static final String webAppPath = "http://localhost:8040/webProject/img/";
	
	@RequestMapping("/list")
	private List<Backimageurl> searchList () {
		
		 List<Backimageurl> list =  backImageService.searchList();
		 
		 for (Backimageurl image : list) {
			 File file = new File(SearchImageContentPath() + image.getIamgename());
			 String url = "" ;
			 if (file.exists()) {
				 url = webAppPath +  image.getIamgename() ;
			 }
			 image.setUrl(url);
		 }
		 
		 return list ;
		
	}
	
	
	@RequestMapping( "/upload/{id}")
	public ResultMap videoUpload(MultipartFile file ,@PathVariable String id ) {
		
		try {
			String imageName = backImageService.findImageName(id);
			String originName  = file.getOriginalFilename();
			if (originName.contains(".jpg")
					|| originName.contains(".png")) {
				String path = SearchImageContentPath() + imageName;
				file.transferTo(new File(path));
			}	
			return ResultMap.build(200, "恭喜你背景图片成功置换");
			
		} catch (Exception e) {
		}
		
		return ResultMap.build(400, "请上传JPG,PNG格式的图片");
	}
	
	
	
	@RequestMapping( "/deleteFile")
	public ResultMap deleteFile(String id ) {
		
		String imageName = backImageService.findImageName(id);
		 File file = new File(SearchImageContentPath() + imageName);
		 if (file.exists()) {
			 file.delete();
		 }
		 
		return ResultMap.build(200, "删除背景图片成功");
	}
	
	
	
	/**获取图片路径**/
	public String SearchImageContentPath () {
		String contentPath =  request.getSession().getServletContext().getRealPath("/img");
		contentPath = contentPath.replace("\\", "/");
		return contentPath+"/";
	}
	

}
