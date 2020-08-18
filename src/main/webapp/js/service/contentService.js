//服务层
app.service('contentService',function($http){
	    	
	
	var requestUrl  =  localStorage.getItem('requestUrl');
	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../content/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get( requestUrl + '/financial/belogin/detailList?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get( requestUrl+ '/financial/belogin/oneDetail?id='+id);
	}
	
	this.deleteDetail =function(id){
		return $http.get( requestUrl + '/financial/belogin/deleteDetail?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post( requestUrl  + '/financial/belogin/addDetail',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post( requestUrl + '/financial/belogin/updateDetail',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get(requestUrl+  '/financial/belogin/updateDetailDelete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post(requestUrl+  '/financial/belogin/detailList?page='+page+"&rows="+rows, searchEntity);
	}    	
});
