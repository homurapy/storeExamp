angular.module('app', []).controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/store/api/v1';

    $scope.subProductById = function (id) {
        $http.delete(contextPath + '/cart/' + id)
            .then(function (){
                $scope.fillTable();
                $scope.fullPrice();
            });
    };
    $scope.addProductById = function (id) {
        $http.get(contextPath + '/cart/' + id)
            .then(function (){
                $scope.fillTable();
                $scope.fullPrice();
            });
    };
    $scope.fillTable = function () {
        $http({
            url: contextPath + '/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.Carts = response.data;
        });
    };
    $scope.fullPrice = function () {
        $http({
            url: contextPath + '/cart'+ '/fullprice',
            method: 'GET'
        }).then(function (response) {
            $scope.fullCartPrice = response.data;
        });
    };
    $scope.fillTable();
});