 //品牌控制层 
app.controller('baseController' ,function($scope){	
	
	$scope.AppUrl = 'https://www.zzw777.com/webProject';
	$scope.loginUser={avatar:''};
    //重新加载列表 数据
    $scope.reloadList=function(){
    	//切换页码  
    	$scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	   	
    }
    
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 10,
         itemsPerPage: 10,
         perPageOptions: [10, 20, 30, 40, 50],
         onChange: function(){
        	 $scope.reloadList();//重新加载
     	 }
	}; 
	
	$scope.selectIds=[];//选中的ID集合 
	
	$scope.formateDate = function (value) {
		value =  new Date(value);
		var year = value.getFullYear()
		var month = value.getMonth() + 1
		var day = value.getDate()
		var hour = value.getHours()
		var minute = value.getMinutes()
		var seconds = value.getSeconds()
		if(month < 10)  month = '0' + month;
		if(day < 10)    day = '0' + day;
		if(hour < 10)   hour = '0' + hour;
		if(minute < 10) minute = '0' +minute;
		if(seconds < 10) seconds = '0' + seconds;
		var t = year + '-' + month + '-' + day 
		return t;
	}
	
	$scope.sessionUser = function (){
		var loginUser = localStorage.getItem('loginUser');
		if (!loginUser) {
			return null;
		} else {
			return JSON.parse(loginUser)
		}
		
	}
	
	$scope.formatedate = function (value) {
		value =  new Date(value);
		var year = value.getFullYear()
		var month = value.getMonth() + 1
		var day = value.getDate()
		var hour = value.getHours()
		var minute = value.getMinutes()
		var seconds = value.getSeconds()
		if(month < 10)  month = '0' + month;
		if(day < 10)    day = '0' + day;
		if(hour < 10)   hour = '0' + hour;
		if(minute < 10) minute = '0' +minute;
		if(seconds < 10) seconds = '0' + seconds;
		var t = year + '-' + month + '-' + day  +' ' + hour +  ':' + minute
		return t;
	}
	
	//更新复选
	$scope.updateSelection = function($event, id) {		
		if($event.target.checked){//如果是被选中,则增加到数组
			$scope.selectIds.push( id);			
		}else{
			var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除 
		}
	}
	
	
	$scope.jsonToString=function(jsonString,key){
		
		var json= JSON.parse(jsonString);
		var value="";
		
		for(var i=0;i<json.length;i++){
			if(i>0){
				value+=",";
			}			
			value +=json[i][key];			
		}
				
		return value;
	}
	
	
	// 根据一个键去查对象
	$scope.searchObjectByKey = function (list, key ,value) {
		for (var i=0;i<list.length;i++) {
			if (list[i][key] == value) {
				return list[i];
			}
		}
		return null;
	} 
	
});	