//服务层
app.service('loginService',function($http){
	
	var AppUrl = 'http://localhost:8040/webProject';
	//var AppUrl = 'https://www.zzw777.com/webProject';
	//显示登录用户名称
	this.getUserMessage=function(userid){
		return $http.get( AppUrl +  '/login/getUserMessage?userid='+userid);		
	}
	
	//用户登录
	this.register=function(entity){
		return $http.post( AppUrl +  '/register' ,entity);		
	}
	
	//用户登录
	this.userlogin=function(entity){
		return $http.post( AppUrl +  '/login' ,entity);		
	}
	
	//显示登录用户名称
	this.logout=function(){
		return $http.get( AppUrl + '/logout' );		
	}
	
	//上传文件
	this.uploadFile=function(){
		var formdata=new FormData();
		//var file = document.getElementById("file");
		formdata.append('file',file.files[0]);//file 文件上传框的name
		
		return $http({
			url: AppUrl + '/uploadFile',		
			method:'post',
			data:formdata,
			headers:{ 'Content-Type':undefined },
			transformRequest: angular.identity			
		});
		
	}
	
	//显示登录用户名称
	this.updateUser=function(entity){
		return $http.post(AppUrl +  '/updateUser' ,entity);		
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
