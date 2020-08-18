//服务层
app.service('userService',function($http){
	var requestUrl  =  localStorage.getItem('requestUrl');
	//增加 
	this.add=function(entity){
		return  $http.post(requestUrl +  '/user/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post(requestUrl+ '/user/update',entity );
	}
	
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post(requestUrl+ '/user/list?page='+page+"&rows="+rows, searchEntity);
	} 
	
	//查询实体
	this.findOne=function(id){
		return $http.get(requestUrl +  '/user/findOne?id='+id);
	}
	
	//查询实体
	this.deleteOne=function(id){
		return $http.get(requestUrl +  '/user/deleteOne?id='+id);
	}
	
	
});
