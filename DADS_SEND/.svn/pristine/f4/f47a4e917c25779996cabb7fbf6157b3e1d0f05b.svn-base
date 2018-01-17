var ThreadManageCtrl = function ($scope, Data, ChangeThreadState, StartSendThread) {
    $scope.status = false;
    $scope.unClock = function () {
        if (prompt('请输密码') === Data.password) {
            $scope.status = true;
        } else {
            alert('密码错误！');
        }
    };
    $scope.updateThread = function (name, type) {
        var obj = {
            "threadName": name,
            "isStart": type
        };
        ChangeThreadState.get({data: JSON.stringify(obj), random: Math.random()});
    };
    $scope.openThread = function () {
        StartSendThread.get({random: Math.random()});
    };
};