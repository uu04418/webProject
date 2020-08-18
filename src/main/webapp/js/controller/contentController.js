 //控制层 
app.controller('contentController' ,function($scope,$controller,contentService ,financialService
		,loginService  , buildingService){	
	
	
	$scope.typestatus = ['未知','收入','支出'];
	$scope.stateList = ['正常','删除'];
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={};//定义搜索对象 
	$scope.searchfian = {type:1,userid:1};
	
    //读取列表数据绑定到表单中  
	$scope.search=function(page,rows){
		contentService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}   
	
	$scope.finanList = function () {
		financialService.search(1,10000,$scope.searchfian).success(
				function(response){
					$scope.finanList=response.rows;	
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
				var first = {id:'' , name:'全部'}
				var buildingList =response.rows;	
				buildingList.unshift(first)
				$scope.buildingList = buildingList
			}			
		);
	}
	
	
	//查询二级商品分类列表
	$scope.$watch('entity.financialid',function(newValue,oldValue){
		if (newValue != undefined) {
			financialService.findOne(newValue).success(
				function (response) {
					$scope.entity.title = $scope.typestatus[response.fatherid];
				}
			)
		}
		
		
	});
	
	
	//保存 
	$scope.save=function(){	
		var serviceObject;//服务层对象  				
		if($scope.entity.finandetailid!=null){//如果有ID
			serviceObject=contentService.update( $scope.entity ); //修改  
		}else{
			serviceObject=contentService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 //读取列表数据绑定到表单中  
	$scope.loginName=function(){
		loginService.loginName().success(
			function(response){
				if (response.success) {
					$scope.loginUser= response.data;
				}else {
				}
				
			}			
		);
	}   
	
	//查询实体 
	$scope.findOne=function(id){				
		contentService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	$scope.deleteDetail=function(id){				
		contentService.deleteDetail(id).success(
			function(response){
				$scope.reloadList();//刷新列表
			}
		);				
	}
	
	
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		contentService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	
	//查询二级商品分类列表
	$scope.$watch('searchEntity.buildingid',function(newValue,oldValue){
		if (newValue != undefined) {
			// 刷新列表
			$scope.searchEntity.houseid = null
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
