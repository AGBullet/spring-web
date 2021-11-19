angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProducts = function (productId) {
        $http.get(contextPath + '/p/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }




    $scope.loadStudents();
});