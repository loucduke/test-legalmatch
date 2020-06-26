/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ngApp = 'LGApp';
var angularApp = angular.module(ngApp, [
	ngApp + '.controllers',
        ngApp + '.services',
        'ngResource'
]);

var ngControllers = angular.module(ngApp + '.controllers', []);
var ngServices = angular.module(ngApp + '.services', []);

ngControllers.controller('MainViewController', ['$scope', 'share', function($scope, share) {
        $scope.mainData = share;
        
}]);


ngControllers.controller('EmployeeListController', ['$scope', 'Employee', 'moment', 'share', function($scope, employee, moment, share) {
        var PAGE_LIMIT = 5;
        var searchParams = {perPage: PAGE_LIMIT, page: 1};
        var pagingInfo = { };
        
        $scope.searchParams = searchParams;
        $scope.employees = { };
        
       
        $scope.getPrimaryAddress = function(emp) {
            return emp.addresses.find(function(e){ return e.isPrimary; });
        }
        
        $scope.getPrimaryContact = function(emp) {
            return emp.contacts.find(function(e){ return e.isPrimary; });
        }
        
        $scope.getAge = function(emp) {
            return moment().diff(emp.birthDate, 'years');
        }

        $scope.getYears = function(emp) {
            var years = moment().diff(emp.dateHired, 'years');
            var months = moment().diff(emp.dateHired, 'months');
            var modMonth = months % 12;
            return (years + ' years ') + ( modMonth? (modMonth + ', months') : '');
        }
        
        $scope.openEmployee = function(emp) {
            share.employee = emp;
        }
        
        $scope.create = function() {
            share.employee = { };
        }

        $scope.delete = function(emp) {
            if(confirm('Delete?')){
                employee.delete({id: emp.id})
                    .$promise
                    .then(function(data) {
                        alert('Deleted')
                        $scope.first();
                    })
                    .catch(function() {
                        alert('Failed to delete')
                    });
            }
        }
        
        $scope.first = function() {
            searchParams.page = 1
            loadEmployees(searchParams)
        }

        $scope.last = function() {
            searchParams.page = pagingInfo.pageCount
            loadEmployees(searchParams)
        }

        $scope.next = function() {
            searchParams.page = searchParams.page >= pagingInfo.pageCount ? searchParams.page : (searchParams.page + 1)
            loadEmployees(searchParams)
        }
        
        $scope.prev = function() {
            searchParams.page = searchParams.page <= 1 ? searchParams.page : (searchParams.page - 1)
            loadEmployees(searchParams)
        }
        
        $scope.search = function() {
            searchParams.page = 1
            loadEmployees(searchParams);
        }
        
        

        var loadEmployees = function(params){
            employee.all(params)
                    .$promise
                    .then(function(data) {
                        $scope.employees = data.employees;
                        pagingInfo = {
                            totalCount: data.totalCount, 
                            pageCount: Math.ceil(data.totalCount / PAGE_LIMIT)
                        }
                    })
                    .catch(function() {
                        alert('Failed to get employees')
                    });
            
        }
        
        loadEmployees(searchParams);
        
}]);

ngControllers.controller('EmployeeInfoController', ['$scope', 'Employee', 'moment', 'share', 'genders', 'maritalStatuses', 
    function($scope, employee, moment, share, genders, statuses) {
        $scope.employee = share.employee;
        
        $scope.genders = genders;
        $scope.statuses = statuses;
        
        if($scope.employee) {
            $scope.employee.birthDate = moment($scope.employee.birthDate).toDate();
            $scope.employee.dateHired = moment($scope.employee.dateHired).toDate();
            $scope.employee.contacts = $scope.employee.contacts || [];
            $scope.employee.addresses = $scope.employee.addresses || []
            
            angular.forEach($scope.employee.contacts, function(v){
                v.employee = {id: $scope.employee.id};
            });
            
            angular.forEach($scope.employee.addresses, function(v){
                v.employee = {id: $scope.employee.id};
            })
            
        }
        
        $scope.returnToList = function() {
            delete share.employee;
        }
        
        $scope.addAddress = function() {
            $scope.employee.addresses.push({
                employee: {id: $scope.employee.id}
            })
        }

        $scope.addContact = function() {
            $scope.employee.contacts.push({
                employee: {id: $scope.employee.id}
            })
        }
        
        $scope.removeItem = function(list, item) {
            var idx = list.indexOf(item);
            list.splice(idx, 1);
        }
        
        $scope.delete = function() {
            if(confirm('Delete?')){
                employee.delete({id: $scope.employee.id})
                    .$promise
                    .then(function(data) {
                        alert('Deleted')
                        $scope.returnToList();
                    })
                    .catch(function() {
                        alert('Failed to delete')
                    });
            }
        }
        
        
        $scope.save = function() {
            if(!$scope.employee.id){
                employee.save({emp: $scope.employee}  )
                    .$promise
                    .then(function(data) {
                        alert('Saved')
                        $scope.returnToList();
                    })
                    .catch(function() {
                        alert('Failed to save')
                    });

            } else {
                employee.update({id : $scope.employee.id}, {emp: $scope.employee} )
                    .$promise
                    .then(function(data) {
                        console.log(data);
                        alert('Updated')
                    })
                    .catch(function() {
                        alert('Failed to Update')
                    });
            }
        }
}]);


ngServices.factory('Employee', ['$resource', function ($resource) {
    return $resource('rest/', {}, {
        all: {
            url: 'rest/employee.json',
            method: 'GET',
            isArray: false
        },
        save: {
            url: 'rest/employee.json',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            isArray: false            
        },
        update: {
            url: 'rest/employee/:id',
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            isArray: false
        },
        delete: {
            url: 'rest/employee/:id',
            method: 'DELETE',
            isArray: false
        }

    });
}]);

ngServices.factory('Address', ['$resource', function ($resource) {
    return $resource('rest/', {}, {
        all: {
            url: 'rest/employee.json',
            method: 'GET',
            isArray: true
        },
        save: {
            url: 'rest/employee',
            method: 'POST',
        },
        update: {
            url: 'rest/employee/:id',
            method: 'PUT',
        }

    });
}]);


angularApp.value('moment', moment);
angularApp.value('share', {});
angularApp.value('genders', ['Male', 'Female']);
angularApp.value('maritalStatuses', ['Single', 'Married']);
