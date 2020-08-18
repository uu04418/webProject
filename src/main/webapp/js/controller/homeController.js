 //控制层 
app.controller('homeController' ,function($scope,$controller,homeService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={userid:1}
	//读取列表数据绑定到表单中  
	$scope.lodnMonthPanel=function(){
		homeService.lodnMonthPanel(1,6,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;
			}			
		);
	} 
	
	$scope.isActive = function (index) {
		if (index == 0) {
			return true;
		}
		return false;
	}
	
});	
