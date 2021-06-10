angular.module('app', []).controller('CategoryController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/store/api/v1';

    $scope.deleteCategoryById = function (id) {
        $http.delete(contextPath + '/category/' + id)
            .then(function (){
                $scope.fillTable();
            });
    };
    $scope.fillTable = function () {
        $http({
            url: contextPath + '/category',
            method: 'GET',
        }).then(function (response) {
            $scope.Categories = response.data;
        });
    };
    $scope.saveCategory = function () {
        console.log($scope.NewCategory)
        $http.post(contextPath + '/category', $scope.NewCategory)
            .then(function (resp){
                $scope.NewCategory = null
                $scope.fillTable();
            })

    };

    $scope.fillTable();
});