var app = angular.module('rakhat-project', []);

app.controller('ProductCtrl', function($scope, $http) {
    $scope.productList = [];
    $scope.categoryList = [];

    $scope.getProducts = function() {
        $http({
            url: 'http://127.0.0.1:5000/product',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.productList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };

    $scope.getCategories = function() {
        $http({
            url: 'http://127.0.0.1:5000/category',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.categoryList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };

    $scope.getProductsByCategory = function(categoryID) {
        $http({
            url: 'http://127.0.0.1:5000/product/category/' + categoryID,
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.productList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };

    $scope.getCategories();
    $scope.getProducts();



    $scope.auth = {
        username: '',
        password: ''
    };

    $scope.customer = {};

    $scope.login = function(auth) {
        console.log(auth);
        $http({
            url: 'http://127.0.0.1:5000/login',
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            },
            data: auth
        })
            .then(function (response) {
                    $scope.auth = response.data;
                    $scope.getMe();
                },
                function (response) { // optional
                    $scope.auth = {};
                });
    };

    $scope.getMe = function() {
        $http({
            url: 'http://127.0.0.1:5000/customer/me',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Auth": $scope.auth.token
            }
        })
            .then(function (response) {
                    $scope.customer = response.data;
                },
                function (response) { // optional
                    console.log(response);
                    $scope.customer = {}
                    document.location.href = "index.html";
                });
    };

    let orderItemList = {};

    $scope.incrementProduct = function (product) {
        if(orderItemList[product.id] === undefined) orderItemList[product.id] = {productID: product.id, price: product.price, quantity: 0};
        orderItemList[product.id].quantity = orderItemList[product.id].quantity + 1;
    };



    $scope.sendOrders = function () {
        console.log(orderItemList);

        let totalPrice = 0;
        angular.forEach(orderItemList, function (value) {
            totalPrice += value.price * value.quantity;
        });
        console.log(totalPrice);
    }

});
