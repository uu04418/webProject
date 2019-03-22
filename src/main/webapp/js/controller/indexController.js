 //控制层 
app.controller('indexController' ,function($scope,$controller , loginService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.loginUser={}
    //读取列表数据绑定到表单中  
	$scope.loginName=function(){
		loginService.loginName().success(
			function(response){
				$scope.loginUser=response.loginUser;
			}			
		);
	}   
	
	$scope.login=function(){
		alert($scope.entity.username);
		loginService.login($scope.entity).success(
			function(response){
				$scope.loginUser=response.loginUser;
			}			
		);
	}   
	
	$scope.toPage = function (attr) {
		loginService.toPage(attr).success(
			function (response) {
				alert(response);
			}
		);
		
	}
	
	
    
});	
