/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ngApp = 'LGApp';
var angularApp = angular.module(ngApp, [
	ngApp + '.controllers',
        ngApp + '.services'
]);

var ngControllers = angular.module(ngApp + '.controllers', []);
var ngControllers = angular.module(ngApp + '.services', []);

ngControllers.controller('EmployeeController', ['$scope', function($scope) {
        
}]);
