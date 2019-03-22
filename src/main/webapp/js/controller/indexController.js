 //控制层 
app.controller('indexController' ,function($scope,$controller , loginService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.loginUser={}
    //读取列表数据绑定到表单中  
	$scope.loginName=function(){
		loginService.loginName().success(
			function(response){
				if (response.success) {
					$scope.loginUser= response.data;
				}else {
					alert(response.message);
					window.location.href='login.html';
				}
				
			}			
		);
	}   
	
	$scope.uploadFile =function () {
		loginService.uploadFile().success(
				function(response){
					if (response.code ==200) { 
						
						$.scope.entity.avatar = response.obj;
					}
					
				}			
			);
	}
	
	$scope.setUserMess=function () {
		loginService.loginName().success(
				function(response){
					if (response.success) {
						response.data.password=null;
						$scope.entity= response.data;
					}else {
						alert(response.message);
						window.location.href='login.html';
					}
					
				}			
			);
		
	}
	
	$scope.login=function(){
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
	
	$scope.updateUser=function () {
		loginService.updateUser($scope.entity).success(
				function (response) {
					alert(response.message);
				}
			);
	}
	
	
    
});	
