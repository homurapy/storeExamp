angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/store/api/v1';

    $scope.saveItem= function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/item', $scope.NewItem)
            .then(function (resp){
                $scope.NewItem = null
                $scope.fillTable();
            })

    };
    $scope.deleteItemById = function (id) {
        $http.delete(contextPath + '/item/' + id)
            .then(function (){
                $scope.fillTable();
            });
    };
    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath + '/item',
            method: 'GET',
            params: {
                'name': $scope.filter ? $scope.filter.name : null,
                'price': $scope.filter ? $scope.filter.price : null,
                'page-number': pageIndex
            }
        }).then(function (response) {
            $scope.ItemsPage = response.data;

            let minPageIndex = pageIndex - 1;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 1;
            if (maxPageIndex > $scope.ItemsPage.totalPages) {
                maxPageIndex = $scope.ItemsPage.totalPages;
            }

            $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.generatePagesIndexes = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.fillTable();

    $scope.fillCategory = function () {
        $http({
            url: contextPath + '/category',
            method: 'GET',
        }).then(function (response) {
            $scope.Categories = response.data;
        });
    };
    $scope.addItemToCart = function (id) {
        $http.get(contextPath + '/cart/' + id)
    };
    $scope.fillTable();
    $scope.fillCategory();
});