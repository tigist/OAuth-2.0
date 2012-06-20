
var demo = angular.module('demo', ['ui'], function($routeProvider) {
});

demo.config(function($locationProvider) {  
  $locationProvider.hashPrefix('');
  window.prettyPrint && prettyPrint()
  
});

function ctrl($scope) {
 
	$scope.save = function(e) {
		var eventInfo = $scope.form; 
		var resource = eventInfo;
		gapi.client.load('calendar', 'v3', function() {	
		var request = gapi.client.calendar.events.insert({ 'calendarId': 'primary', 'resource': resource });
		request.execute(function(resp) {  
		console.log(resp);
		//alert(" You have created on event!");
		});
		});
	};
};
