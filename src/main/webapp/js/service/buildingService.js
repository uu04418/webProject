//服务层
app.service('buildingService',function($http){
	var requestUrl  =  localStorage.getItem('requestUrl');
	//增加 
	this.add=function(entity){
		return  $http.post(requestUrl +  '/building/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post(requestUrl+ '/building/update',entity );
	}
	
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post(requestUrl+ '/building/list?page='+page+"&rows="+rows, searchEntity);
	} 
	
	//查询实体
	this.findOne=function(id){
		return $http.get(requestUrl +  '/building/findOne?id='+id);
	}
	
	//查询实体
	this.searchHouseByBuildingId=function(id){
		return $http.get(requestUrl +  '/building/searchHouseByBuildingId?id='+id);
	}
	
});
