//服务层
app.service('houseService',function($http){
	var requestUrl  =  localStorage.getItem('requestUrl');
	//增加 
	this.add=function(entity){
		return  $http.post(requestUrl +  '/house/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post(requestUrl+ '/house/update',entity );
	}
	
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post(requestUrl+ '/house/list?page='+page+"&rows="+rows, searchEntity);
	} 
	
	//查询实体
	this.findOne=function(id){
		return $http.get(requestUrl +  '/house/findOne?id='+id);
	}
	
});
