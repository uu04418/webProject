package com.webproject.util;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class UploadUtil {
	
	
	public static final String ACCESS_KEY = "r8DLGf0BLmN3QjnAoSCe-PiYzNfARLQZD4BccI2i";

	public static final String SECRET_KEY = "o8llqqKfAMyd3BU86hGL-IPjtn25IGETLjoADIEl";
	
	public static final String qcc_bucketName = "genealogy";
	
	public static final String return_path = "http://www.hadoop.zzw777.com/";

	public static final String VIDEO = "video";
	
	static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY );
	// 构造一个带指定Zone对象的配置类
	// zone2华南 zone0华东
	static Configuration cfg = new Configuration(Zone.zone0());
	static UploadManager uploadManager = new UploadManager(cfg);
	
	

	/**
	 * 获取凭证
	 * 
	 * @param bucketName
	 *            空间名称
	 * @return
	 */
	public static String getUpToken(String bucketName, String key) {
		StringMap putPolicy = new StringMap();
		putPolicy.put("insertOnly", 1);
		return auth.uploadToken(bucketName, key, 3600, putPolicy);

	}
	/**
	 *七牛云删除图片
	 *@param url : 图片的完整路径
	 * **/
	public  static void deleteimage(String url) {
        BucketManager bucketMgr = new BucketManager(auth, cfg);
        try {
			bucketMgr.delete(qcc_bucketName, url);
		} catch (QiniuException e) {
		}
	}
	
	
	

	/**
	 * 上传
	 * 
	 * @param filePath : 文件的路径
	 * @param key  : 上传到七牛云后的名称
	 * @param bucketName ： 上传空间
	 */
	@SuppressWarnings("unused")
	public static void upload(String filePath, String key) {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(filePath, key, getUpToken(qcc_bucketName, key));
			// 打印返回的信息
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException qe) {
				// ignore
				e.printStackTrace();
			}
		}
	}

	

	 

	public static String getuploadpictoken(String bucketName) {
		return auth.uploadToken(bucketName);
	}

	@SuppressWarnings("unused")
	public static void doUpload(MultipartFile file, String key) {
		try {
			Response res  = uploadManager.put(file.getBytes(), key, getUpToken(qcc_bucketName,key));
		} catch (QiniuException e) {
			Response r = e.response;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
