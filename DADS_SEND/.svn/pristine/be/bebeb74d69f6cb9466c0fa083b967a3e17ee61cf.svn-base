var DataViewCtrl = function ($scope, Data, GetData) {
    $scope.status = true;
    $scope.filterType = {};
    $scope.filterData = 'data | filter: filterType';
    $scope.selectData = ['bloodPressure', 'bloodGlucose', 'heartFunction', 'dailyExercise', 'ECG',
        'weight', 'SPO2', 'sports', 'sleep'];
    $scope.data = [];
    $scope.unClock = function () {
        if (prompt('请输密码') === Data.password) {
            $scope.status = false;
        } else {
            alert('密码错误！');
        }
    };
    $scope.reset = function () {
        $scope.obj = {
            "dataType": 'bloodPressure',
            "beginRecTime": '',
            "endRecTime": '',
            "beginSendTime": '',
            "endSendTime": '',
            "patientId": '',
            "packNum": '',
            "deviceId": '',
            "sendFlag": '',
            "company": '',
            "page": '1',
            "pageSize": '100'
        };
    };
    $scope.updateCheck = function () {
        $.each($scope.data, function (key, value) {
            value.check = $scope.check;
        });
    };
    $scope.update = function () {
        if ($scope.obj.beginRecTime !== '' && !Data.dateVerify($scope.obj.beginRecTime)) {
            alert('开始接收日期格式错误！');
        } else if ($scope.obj.endRecTime !== '' && !Data.dateVerify($scope.obj.endRecTime)) {
            alert('结束接收日期格式错误！');
        } else if ($scope.obj.beginSendTime !== '' && !Data.dateVerify($scope.obj.beginSendTime)) {
            alert('开始发送日期格式错误！');
        } else if ($scope.obj.endSendTime !== '' && !Data.dateVerify($scope.obj.endSendTime)) {
            alert('结束发送日期格式错误！');
        } else if (!/^[1-9]\d*$/.test($scope.obj.pageSize)) {
            alert('查询数量格式错误！');
        } else {
            $scope.loading = true;
            GetData.query({data: $scope.obj, random: Math.random()}, function (data) {
                var type = $scope.obj.dataType;
                $scope.loading = false;
                $scope.modelShow = false;
                $scope.reset();
                $scope.obj.dataType = type;
                if (data.length) {
                    $scope.data = data;
                    Data.selectPage($scope.data, 1);
                } else {
                    alert('没有数据！');
                }
            });
        }
    };
};