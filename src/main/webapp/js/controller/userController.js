 //控制层 
app.controller('userController' ,function($scope,$controller   ,userService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.userTypes = ['超级管理','管理员','普通用户'];
	$scope.userStatus = ['正常' , '禁用']
	$scope.typeArray = [{id:0 ,name:'超级管理'} ,{id:1 ,name:'管理员'} ,{id:2,name:'普通用户'} ]
	$scope.errorSpan = ''
	$scope.deleteId = ''
	
	//查询实体 
	$scope.findOne=function(id){	
		$scope.errorSpan = ''
		userService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			} 
		);				
	}
	
	$scope.deleteOne = function (id) {
		$scope.deleteId = id
	}
	
	$scope.suredeleteOne = function (){
		//获取选中的复选框			
		userService.deleteOne( $scope.deleteId ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.deleteId = ''
				}						
			}		
		);			
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.userid!=null){//如果有ID
			serviceObject=userService.update( $scope.entity ); //修改  
		}else{
			serviceObject=userService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				$scope.errorSpan = response.message
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		userService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		userService.search(page,rows,$scope.searchEntity).success(
			function(response){
				var list = response.rows;
				$scope.list= list
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
