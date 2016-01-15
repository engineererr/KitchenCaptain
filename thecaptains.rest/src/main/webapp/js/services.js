'use strict';

var services = angular.module('services', ['ngResource']);

services.factory('Category', ['$resource', function ($resource) {
    return $resource('rest/categories/:categoryId', {authorId:'@id'}, {
        'update': {method: 'PUT'}
    });
}]);