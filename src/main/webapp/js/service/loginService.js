//服务层
app.service('loginService',function($http){
	    	
	//显示登录用户名称
	this.loginName=function(){
		
		return $http.get('/webProject/login/userMessage');		
	}
	
	//显示登录用户名称
	this.login=function(entity){
		return $http.get('/webProject/login' ,entity);		
	}
	
	//上传文件
	this.uploadFile=function(){
		var formdata=new FormData();
		//var file = document.getElementById("file");
		formdata.append('file',file.files[0]);//file 文件上传框的name
		
		return $http({
			url:'/webProject/uploadFile',		
			method:'post',
			data:formdata,
			headers:{ 'Content-Type':undefined },
			transformRequest: angular.identity			
		});
		
	}
	
	//显示登录用户名称
	this.updateUser=function(entity){
		return $http.post('/webProject/updateUser' ,entity);		
	}
	
	
	
	//显示登录用户名称
	this.toPage=function(attr){
		//return $http.get('/webProject/showPage/' + attr);		
		return $http({
			type:'POST',
			url:'/webProject/showPage/' + attr ,
			head:{'Accept':"*/*"}
		});
	}
	
});
