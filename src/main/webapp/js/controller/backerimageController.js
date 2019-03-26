 //控制层 
app.controller('backerimageController' ,function($scope,$controller,$interval  ,backerimageService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.second=0;
	$scope.showEntity = {};
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		backerimageService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	$scope.findOne=function (entity) {
		$scope.showEntity = entity;
	}
	
	$scope.uploadFile =function (id) {
		$scope.showMessage={showTipMessage:'正在操作中请稍候.....'};//定义搜索对象 
		backerimageService.uploadFile(id).success(
				function(response){
					if (response.code ==200) { 
						$scope.findAll();
					}
					
					
					$scope.showMessage.showTipMessage =  response.msg +'  窗口即将关闭：';
					$scope.second = 3 ;
					time= $interval(function(){ 
						  if($scope.second>0){ 
							  $scope.second =$scope.second-1;
						  }else{
							  $interval.cancel(time); 		  
							  $('#showMessage').modal('hide');
						  }
					},1000);	
					
				}			
			);
	}
	
	
	
	
	$scope.deleteFile =function (id) {
		$scope.showMessage={showTipMessage:'正在操作中请稍候.....'};//定义搜索对象 
		backerimageService.deleteFile(id).success(
				function(response){
					if (response.code ==200) { 
						$scope.findAll();
					}
					
					
					$scope.showMessage.showTipMessage =  response.msg +'  窗口即将关闭：';
					$scope.second = 3 ;
					time= $interval(function(){ 
						  if($scope.second>0){ 
							  $scope.second =$scope.second-1;
						  }else{
							  $interval.cancel(time); 		  
							  $('#showMessage').modal('hide');
						  }
					},1000);	
					
				}			
		);
	}
	
	
	$scope.showMessage={showTipMessage:'正在操作中请稍候.....'};//定义搜索对象 
	
	
    
});	
