var app = angular.module('staffs',[]);

app.controller("StaffSearchController", [
    '$scope','$http',
    function($scope , $http) {

        var page = 0;

        $scope.staffs = [];
        $scope.search = function(searchTerm) {
            $scope.loading = true;
            if (searchTerm.length < 2) {
                return;
            }

            $http.get("/staffs.json",
                { "params": { "keywords": searchTerm, "page": page } }
            ).success(
                function(data,status,headers,config) {
                    $scope.staffs = data;
                    $scope.loading = false;
                }).error(
                function(data,status,headers,config) {
                    $scope.loading = false;
                    alert("There was a problem: " + status);
                });
        }

        $scope.previousPage = function() {
            if (page > 0) {
                page = page - 1;
                $scope.search($scope.keywords);
            }
        }
        $scope.nextPage = function() {
            page = page + 1;
            $scope.search($scope.keywords);
        }
    }
]);