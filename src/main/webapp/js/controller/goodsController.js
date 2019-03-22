 //控制层 
app.controller('goodsController' ,function($scope,$controller,$location ,goodsService 
		,itemCatService ,typeTemplateService ){	
	
	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(){
		var id = $location.search()['id'];
		if (id == null) {return ;}
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;
				editor.html(response.goodsDesc.introduction);
				$scope.entity.goodsDesc.itemImages = JSON.parse($scope.entity.goodsDesc.itemImages);
				$scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.entity.goodsDesc.customAttributeItems);
				$scope.entity.goodsDesc.specificationItems = JSON.parse($scope.entity.goodsDesc.specificationItems);
				for (var i=0;i<$scope.entity.itemList.length;i++) {
					$scope.entity.itemList[i].spec =  JSON.parse($scope.entity.itemList[i].spec);
				}
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
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
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
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
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
	
	$scope.status=['未审核','已审核','审核未通过','已关闭'];
	
	$scope.itemCatList=[];//商品分类列表
	//查询商品分类列表
	$scope.findItemCatList=function(){
		itemCatService.findAll().success(
			function(response){
				for(var i=0;i<response.length;i++){
					$scope.itemCatList[response[i].id]=response[i].name;
				}
			}
		);
		
	}
	
	//更新状态
	$scope.updateStatus=function(status){
		var id = $location.search()['id'];
		if (id==null ) {
			id = $scope.selectIds;
		}
		goodsService.updateStatus( id ,status).success(
			function(response){
				if(response.success){
					//重新查询 
		        	alert('新增成功');
		        	location.href = "goods.html";
				}else{
					alert(response.message);
				}				
			}
		);		
	}
	
	
	//查询一级商品分类列表
	$scope.selectItemCat1List=function(){
		itemCatService.findByParentId(0).success(
			function(response){
				$scope.itemCat1List=response;			
			}
		);
		
	}
	
	//查询二级商品分类列表
	$scope.$watch('entity.goods.category1Id',function(newValue,oldValue){
		if (newValue != undefined) {
			itemCatService.findByParentId(newValue).success(
					function(response){
						$scope.itemCat2List=response;			
					}
			);
			
		}
		
		
	});
	
	//查询三级商品分类列表
	$scope.$watch('entity.goods.category2Id',function(newValue,oldValue){
		if (newValue != undefined) {
			itemCatService.findByParentId(newValue).success(
					function(response){
						$scope.itemCat3List=response;			
					}
			);
		}
	});
	

	
	//读取模板ID
	$scope.$watch('entity.goods.category3Id',function(newValue,oldValue){
		if(newValue == undefined) {return ;}
		itemCatService.findOne(newValue).success(
			function(response){
				$scope.entity.goods.typeTemplateId=response.typeId;
			}
		);		
	});
	

	//读取模板ID后，读取品牌列表 扩展属性  规格列表
	$scope.$watch('entity.goods.typeTemplateId',function(newValue,oldValue){
		if(newValue == undefined) {return ;}
		
		typeTemplateService.findOne(newValue).success(
			function(response){
				$scope.typeTemplate=response;// 模板对象 
								
				$scope.typeTemplate.brandIds= JSON.parse($scope.typeTemplate.brandIds);//品牌列表类型转换
				var id = $location.search()['id'];
				if (id==null) {
					//扩展属性
					$scope.entity.goodsDesc.customAttributeItems= JSON.parse($scope.typeTemplate.customAttributeItems);
				}
				
			}
		);
		//读取规格
		typeTemplateService.findSpecList(newValue).success(
			function(response){
				$scope.specList=response;
			}
		);		
		
	});
	
	$scope.checkArrtibuteValue = function (attributeName ,attributeValue ) {
		var items = $scope.entity.goodsDesc.specificationItems ;
		var object = $scope.searchObjectByKey(items , 'attributeName' ,attributeName);
		if (object !=null) {
			if (object.attributeValue.indexOf(attributeValue)>=0) {
				return true ;
			}
		}
		return false;
	}
	
});	
