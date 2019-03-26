 //控制层 
app.controller('financialController' ,function($scope,$controller ,financialService){	
	
	$scope.typestatus = ['未知','收入','支出'];
	$scope.seletModeltypestatus  = [{id:'1',text:'收入'},{id:'2',text:'支出'}]
	$scope.status = ['未知','正常','禁用'];
	$scope.seletModelstatus = [{id:'1',text:'正常'} ,{id:'2',text:'禁用'}];
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		financialService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.financialid!=null){//如果有ID
			serviceObject=financialService.update( $scope.entity ); //修改  
		}else{
			serviceObject=financialService.add( $scope.entity  );//增加 
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
	
	
	//查询实体 
	$scope.findOne=function(id){				
		financialService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	$scope.isSelect =function (id) {
		return "selected";
	};
	
	
	
	
    
});	
