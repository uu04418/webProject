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
