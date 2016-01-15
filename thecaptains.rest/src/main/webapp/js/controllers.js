'use strict';

var controllers = angular.module('controllers', ['services']);

controllers.controller('CategoryController', ['$scope', 'Category', function($scope, Category) {
    $scope.currentCategory = new Category();
    $scope.categorys = Category.query();
    $scope.showId = false;

    $scope.cancel = function () {
        $scope.currentCategory = new Category();
    };

    $scope.save = function () {
        var isNew = $scope.currentCategory.id == null;
        if (isNew) {
            $scope.currentCategory = Category.save($scope.currentCategory);
            $scope.categorys.push($scope.currentCategory);
        } else {
            $scope.currentCategory = Category.update($scope.currentCategory);
        }
        $scope.cancel();
    };

    $scope.edit = function (category) {
    	$scope.currentCategory = category;
    };

    $scope.remove = function (index, id) {
		$scope.categorys.splice(index, 1);
		Category.remove({categoryId:id});
    };
}]);