 //控制层 
app.controller('indexController' ,function($scope,$controller ,monthService, loginService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.userType = ['超级管理' , '普通管理' , '普通用户']
	$scope.entity={avatar:''}
	$scope.loginUser={avatar:''};
	$scope.registerUser={}
    
	//读取用户信息渲染页面
	$scope.getUserMessage=function(){
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
		} else {
			loginService.getUserMessage(userid).success(
			function(response){
				if (response.success) {
					$scope.loginUser = response.data;
				}else {
					alert(response.message);
					localStorage.clear();
					window.location.href='login.html';
				}
				
			}			
		);
		}
	}   
	
	$scope.uploadFile =function () {
		loginService.uploadFile().success(
				function(response){
					alert(response.msg);
					$scope.entity.avatar = response.obj;
				}			
			);
	}
	$scope.setUserMess=function () {
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
		} else {
			loginService.getUserMessage(userid).success(
			function(response){
				if (response.success) {
					$scope.entity = response.data;
					$scope.entity.password='';
				}else {
					alert(response.message);
					localStorage.clear();
					window.location.href='login.html';
				}
				
			}			
		);
		}
		
	}
	
	$scope.login=function(){
		loginService.login($scope.entity).success(
			function(response){
				localStorage.setItem('userid', $scope.loginUser.userid);
				$scope.loginUser=response.loginUser;
			}			
		);
	} 
	
	$scope.register=function(){
		loginService.register($scope.registerUser).success(
			function(response){
				alert(response.msg);
				
			}			
		);
	}   
	
	$scope.logout=function(){
		window.location.href='login.html';
		localStorage.clear();
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
	
	
	// 用户登录,登录成功以后把用户信息存入location
	$scope.userlogin=function () {
		loginService.userlogin($scope.loginUser).success(
				function (response) {
					if (response.code == 200) {
						localStorage.setItem('userid',response.obj);
						window.location.href='https://www.zzw777.com/webProject/admin/index.html';
					}else {
						alert(response.msg);
					}
					
				}
			);
	}
	
	
	$scope.showloginPage =function () {
		
		 $('#loginModal').modal('show');
	}
	
	$scope.uploadApp=function(index) {
		if (index == 1) {
			window.location.href='https://www.zzw777.com/upload/app/qiuxia_iphone.1.3.6.apk';
		}
		if (index==2) {
			window.location.href='https://www.zzw777.com/upload/app/qiuxia_android.1.3.6.apk';
		}
		
	}
	
	
    
});	
