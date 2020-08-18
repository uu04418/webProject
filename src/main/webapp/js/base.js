var app=angular.module('pinyougou',[])
app.config(function($httpProvider ) {
	  var acctoken = ''
	  var loginUser = localStorage.getItem('loginUser');
	  if (loginUser) {
		  loginUser = JSON.parse(loginUser)
		  acctoken = loginUser.acctoken
	  }
  $httpProvider.defaults.headers.common = { 'Authorization' : acctoken}
})