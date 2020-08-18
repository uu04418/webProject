 //控制层 
app.controller('chartPanelController' ,function($scope,$controller ,chartPanelService ,loginService ,$interval 
		){	
	$scope.showMessage={showTipMessage:'正在生成年度报表请稍候等待.....'};//定义搜索对象 
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={yearstring:'',userid:''};//定义搜索对象 
	$scope.second = 0 ;
	
	//搜索
	$scope.search=function(page,rows){	
		chartPanelService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//保存 
	$scope.save=function(){	
		$scope.showMessage.showTipMessage='正在生成年度报表请稍候等待.....';//定义搜索对象 
		var serviceObject;//服务层对象  				
		serviceObject=chartPanelService.add( $scope.searchEntity  );//增加 
		serviceObject.success(
			function(response){
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
	
	
	//保存 
	$scope.update=function(yearString){	
		$scope.showMessage.showTipMessage='正在生成年度报表请稍候等待.....';//定义搜索对象
		var serviceObject;//服务层对象  				
		$scope.searchEntity.yearstring = yearString ;
		serviceObject=chartPanelService.add( $scope.searchEntity  );//增加 
						
		serviceObject.success(
			function(response){
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
				
				$scope.reloadList();//重新加载
			}		
		);				
	}
	
	

	

    
});	
