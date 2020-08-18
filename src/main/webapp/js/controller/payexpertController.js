 //控制层 
app.controller('payexpertController' ,function($scope,$controller , 
		payexpertService , buildingService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={buildingid:null};//定义搜索对象 
	$scope.deleteId = ''
	
	//搜索
	$scope.search=function(page,rows){			
		payexpertService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.payexpertid!=null){//如果有ID
			serviceObject=payexpertService.update( $scope.entity ); //修改  
		}else{
			serviceObject=payexpertService.add( $scope.entity  );//增加 
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
	
	$scope.deleteOne = function (id) {
		$scope.deleteId = id
	}
	
	$scope.suredeleteOne = function (){
		//获取选中的复选框			
		payexpertService.deleteOne( $scope.deleteId ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.deleteId = ''
				}						
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
	
	//查询二级商品分类列表
	$scope.$watch('entity.buildingid',function(newValue,oldValue){
		if (newValue != undefined) {
			buildingService.searchHouseByBuildingId(newValue).success(
				function (response) {
					$scope.houseList=response.rows;	
				}
			)
		}
	});
	
	//查询二级商品分类列表
	$scope.$watch('searchEntity.buildingid',function(newValue,oldValue){
		if (newValue != undefined) {
			// 刷新列表
			$scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
			buildingService.searchHouseByBuildingId(newValue).success(
					function (response) {
						
						$scope.searchHouseList=response.rows;	
					}
			)
		}
	});
	
	//查询二级商品分类列表
	$scope.$watch('searchEntity.houseid',function(newValue,oldValue){
		if (newValue != undefined) {
			// 刷新列表
			$scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
		}
	});
	
});	
