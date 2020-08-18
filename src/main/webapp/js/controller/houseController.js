 //控制层 
app.controller('houseController' ,function($scope,$controller ,houseService , buildingService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={buildingid:null};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		houseService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//搜索
	$scope.buildingList=function(page,rows){
		page = 1 
		rows = 1000000
		var entity = {}
		buildingService.search(page,rows,entity).success(
			function(response){
				$scope.buildingList=response.rows;	
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		houseService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.houseid!=null){//如果有ID
			serviceObject=houseService.update( $scope.entity ); //修改  
		}else{
			serviceObject=houseService.add( $scope.entity  );//增加 
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
	
	
	//查询二级商品分类列表
	$scope.$watch('searchEntity.buildingid',function(newValue,oldValue){
		if (newValue != undefined) {
			$scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
		}
	});
});	
