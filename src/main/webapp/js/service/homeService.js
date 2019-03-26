//服务层
app.service('homeService',function($http){
	
	//var AppUrl = 'http://localhost:8040/webProject';
	var AppUrl = 'https://www.zzw777.com/webProject';
	
	this.lodnMonthPanel=function(page,rows,entity){
		return $http.post( AppUrl + '/charpanel/belogin/monthChartlist?page='+page+"&rows="+rows,entity);
	}    	
});
