var SendDataCtrl = function ($scope, $http) {
    $scope.scroll = 'top';
    $scope.selectData = ['ALL', 'bloodPressure', 'bloodGlucose', 'heartFunction', 'dailyExercise', 'ECG',
                         'weight', 'SPO2', 'sports', 'sleep'];
//    $scope.dataType = $scope.selectData[0];
   	$scope.date = moment().format('YYYY-MM-DD');
    $scope.send=function () {
        $scope.loading = true;
        $http.get('sendData.json', {params: {dataType: $scope.dataType, deviceId: $scope.deviceId, date: $scope.date, random: Math.random()}}).success(function (data) {
            $scope.loading = false;
            $scope.data = data.split('\r\n');
        });
    };
};