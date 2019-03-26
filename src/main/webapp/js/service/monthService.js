//服务层
app.service('monthService',function($http){
	//var AppUrl = 'http://localhost:8040/webProject';    
	var AppUrl = 'https://www.zzw777.com/webProject';
	
	//读取列表数据绑定到表单中
	this.updateMonth=function(entity,userid){
		return $http.post(AppUrl+  '/charpanel/belogin/updateMontherPanel/'+userid , entity);		
	}
	
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post(AppUrl+ '/charpanel/belogin/monthChartlist?page='+page+"&rows="+rows, searchEntity);
	}  
	
	
});
