 //控制层 
app.controller('buildingController' ,function($scope,$controller ,buildingService , userService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		buildingService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	$scope.userList = function (){
		var page = 1;
		var rows = 1000000;
		var searchEntity = {type:1}
		userService.search(page,rows,searchEntity).success(
				function(response){
					var list = response.rows;
					$scope.userArry= list
					$scope.paginationConf.totalItems=response.total;//更新总记录数
				}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		buildingService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=buildingService.update( $scope.entity ); //修改  
		}else{
			serviceObject=buildingService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
	        	
				if(response.success){
				}else{
					alert(response.message);
				}
				$scope.reloadList();//重新加载
			}		
		);				
	}
	
	
	
	
	
	
    
});	
