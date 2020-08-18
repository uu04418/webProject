//服务层
app.service('payexpertService',function($http){
	var requestUrl  =  localStorage.getItem('requestUrl');
	//增加 
	this.add=function(entity){
		return  $http.post(requestUrl +  '/payexpert/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post(requestUrl+ '/payexpert/update',entity );
	}
	
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post(requestUrl+ '/payexpert/list?page='+page+"&rows="+rows, searchEntity);
	} 
	
	//查询实体
	this.findOne=function(id){
		return $http.get(requestUrl +  '/payexpert/findOne?id='+id);
	}
	
	//查询实体
	this.deleteOne=function(id){
		return $http.get(requestUrl +  '/payexpert/deleteOne?id='+id);
	}
	
});
