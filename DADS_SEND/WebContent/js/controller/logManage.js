var LogManageCtrl = function ($scope, $http) {
    $scope.scroll = 'top';
    if($scope.type=='gateway')
    	$scope.date = moment().format('YYYY-MM-DD');
    else 
    	$scope.date = moment().format('YYYY-MM-DD');
    $scope.$watch('date', function () {
        $scope.loading = true;
        $http.get('logger.json', {params: {info: 'detail', logType: $scope.type, logDate: $scope.date, random: Math.random()}}).success(function (data) {
            $scope.loading = false;
            $scope.data = data.split('\r\n');
        });
    });
};