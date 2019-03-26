 //控制层 
app.controller('contentController' ,function($scope,$controller,contentService ,financialService
		,loginService){	
	
	
	$scope.typestatus = ['未知','收入','支出'];
	$scope.state = ['正常','删除'];
	$controller('baseController',{$scope:$scope});//继承
	$scope.searchEntity={};//定义搜索对象 
	$scope.searchfian = {type:1,userid:1};
	
    //读取列表数据绑定到表单中  
	$scope.search=function(page,rows){
		
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
			return ;
		} 
		$scope.searchEntity.userid = userid;
		
		contentService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}   
	
	$scope.finanList = function () {
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
			return ;
		} 
		$scope.searchfian.userid = userid;
		financialService.search(1,10000,$scope.searchfian).success(
				function(response){
					$scope.finanList=response.rows;	
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
		var userid = localStorage.getItem('userid');
		if (userid ==null) {
			window.location.href='login.html';
			return ;
		} 
		$scope.entity.userid=userid ;
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
					alert(response.message);
					window.location.href='login.html';
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
    
});	
