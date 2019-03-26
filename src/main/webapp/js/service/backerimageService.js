//服务层
app.service('backerimageService',function($http){
	    	
	//var AppUrl = 'http://localhost:8040/webProject';
	var AppUrl = 'https://www.zzw777.com/webProject';
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get( AppUrl + '/image/list');		
	}
	
	//读取列表数据绑定到表单中
	this.deleteFile=function(id){
		return $http.get( AppUrl + '/image/deleteFile?id='+id);		
	}
	
	
	//上传文件
	this.uploadFile=function(id){
		var formdata=new FormData();
		//var file = document.getElementById("file");
		formdata.append('file',file.files[0]);//file 文件上传框的name
		
		return $http({
			url: AppUrl + '/image/upload/'+id,		
			method:'post',
			data:formdata,
			headers:{ 'Content-Type':undefined },
			transformRequest: angular.identity			
		});
		
	}
	
});
