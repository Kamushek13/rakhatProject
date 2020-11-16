var app = angular.module('rakhat-project', []);

app.controller('ProductCtrl', function($scope, $http) {
    $scope.productList = [];
    $scope.categoryList = [];
    $scope.statusList = [];


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
// HERE
    $scope.getStatus = function() {
        $http({
            url: 'http://127.0.0.1:5000/status',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.statusList = response.data;
                },
                function (response) {
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
                    console.log($scope.auth);
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

    $scope.orderItemList = {};
    $scope.mess = '';
    $scope.totalPrice = 0;

    $scope.incrementProduct = function (product) {
        if($scope.orderItemList[product.productId] === undefined) $scope.orderItemList[product.productId] = {productID: product.productId, price: product.price, quantity: 0};
        if($scope.orderItemList[product.productId].quantity < product.stock) {
            $scope.orderItemList[product.productId].quantity = $scope.orderItemList[product.productId].quantity + 1;
        }
        $scope.totalPrice = 0;
        angular.forEach($scope.orderItemList, function (value) {
            $scope.totalPrice += value.price * value.quantity;
        });
    };

    $scope.decrementProduct = function (product) {
        $scope.mess = '';
        if($scope.orderItemList[product.productId] === undefined) {
            $scope.mess = 'You cant delete product which is not in bin';
        } else {
            $scope.orderItemList[product.productId].quantity = $scope.orderItemList[product.productId].quantity - 1;
            if ($scope.orderItemList[product.productId].quantity == 0) {
                delete $scope.orderItemList[product.productId];
            }

        }
        $scope.totalPrice = 0;
        angular.forEach($scope.orderItemList, function (value) {
            $scope.totalPrice += value.price * value.quantity;
        });
    };

    let id = [];
    let ID = function (){
        angular.forEach($scope.orderItemList, function (value){
            id.push(value.productID);
        });
        console.log(id);
    }

    let quantity = [];
    let Quantity = function (){

        angular.forEach($scope.orderItemList, function (value){
            if (quantity[value.productID] === undefined) {
                quantity[value.productID] =  value.quantity;
            }
        });
        console.log(quantity);
    }

    $scope.sendOrders = function () {
        $scope.mess = '';
        if (Object.keys($scope.customer).length == 0) {
            $scope.mess = 'You are not authorized!';
        } else {
            if (Object.keys($scope.orderItemList).length == 0) {
                $scope.mess = 'There is no any products in bin';
            } else {
                send();
            }
        }
    }

    let send = function (){
        ID();
        Quantity();
        $http({
            url: 'http://127.0.0.1:5000/order/create',
            method: 'POST',
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "tokenOfAccount": $scope.auth.token
            },
            data: {
                "id" : id,
                "quantity": quantity
            }
        }).then(function (response){
            console.log(response);
            $scope.orderItemList = {};
            $scope.order = response.data;
            $scope.getProducts();
        }, function (response){
            console.log(response);
        })
    }


    /*HEREHEREHERE*/
    $scope.getOrdersByStatusId = function (statusID) {
        $http({
            url: 'http://127.0.0.1:5000/myOrders'+ statusID,
            method: 'GET',
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "tokenOfAccount": $scope.auth.token
            }
        }).then(function (response){
            console.log(response);
            $scope.stausList = response.data;
        }, function (response){
            console.log(response);
        })
    }

});

app.controller('AdminCtrl', function($scope, $http) {
    $scope.allOrders = function () {
        $http({
            url: 'http://127.0.0.1:5000/orders',
            method: 'GET',
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
            }
        }).then(function (response){
            console.log(response);
            $scope.orderList = response.data;
        }, function (response){
            console.log(response);
        })
    }
    $scope.allOrders();

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
    $scope.getProducts();

    $scope.changeStatus = function (token) {
        $http({
            url: 'http://127.0.0.1:5000/status/change',
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "OrderToken": token
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.allOrders();
                },
                function (response) {
                    console.log(response);
                });
    }

    $scope.addStock = function (pr, id){
        $http({
            url: 'http://127.0.0.1:5000/add/'+id+"/"+pr.stock,
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.getProducts();
                },
                function (response) {
                    console.log(response);
                });
    }

});
