//服务层
app.service('contentService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../content/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../financial/belogin/detailList?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../content/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../financial/belogin/addDetail',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../financial/belogin/updateDetail',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../content/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../financial/belogin/detailList?page='+page+"&rows="+rows, searchEntity);
	}    	
});
