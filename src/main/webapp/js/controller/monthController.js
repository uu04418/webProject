 //控制层 
app.controller('monthController' ,function($scope,$controller ,monthService ,$interval){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={};//定义搜索对象 
	$scope.showMessage={showTipMessage:'正在生成月度报表请稍候等待.....'};//定义搜索对象 
	$scope.second = 0 ;
	//搜索
	$scope.search=function(page,rows){		
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
			return ;
		} 
		$scope.searchEntity.userid = userid;
		monthService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//搜索
	$scope.updateMonth=function(entity){	
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
			return ;
		} 
		$scope.showMessage.showTipMessage = '正在生成月度报表请稍候等待.....';//定义搜索对象 
		monthService.updateMonth(entity ,userid).success(
			function(response){
				// 执行倒计时
				$scope.showMessage.showTipMessage =  response.message +'  窗口即将关闭：';
				$scope.second = 5 ;
				time= $interval(function(){ 
					  if($scope.second>0){ 
						  $scope.second =$scope.second-1;
					  }else{
						  $interval.cancel(time); 		  
						  $('#showMessage').modal('hide');
					  }
					},1000);
				//重新查询 
	        	$scope.reloadList();//重新加载
			}			
		);
	}
    
	
	//搜索
	$scope.save=function(){	
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
			return ;
		} 
		$scope.showMessage.showTipMessage = '正在生成月度报表请稍候等待.....';//定义搜索对象 
		monthService.updateMonth($scope.entity , userid).success(
			function(response){
				//$('#showMessage').modal('hide');
				
				$scope.showMessage.showTipMessage =  response.message +'  窗口即将关闭：';
				
				// 执行倒计时
				$scope.second = 5 ;
				time= $interval(function(){ 
					  if($scope.second>0){ 
						  $scope.second =$scope.second-1;
					  }else{
						  $interval.cancel(time); 		  
						  $('#showMessage').modal('hide');
					  }
					},1000);	
				
				//重新查询 
	        	$scope.reloadList();//重新加载
			}			
		);
	}
	
	
	
	
	
	
});;	
