var UserSyncCtrl = function ($scope, Data, FindUnpushPatient, PushUserToEMR) {
    FindUnpushPatient.query({random: Math.random()}, function (data) {
        Data.initList($scope, data, 0);
    });
    $scope.selectUser = function () {
        _.each(Data.sourceList[0], function (value) {
            value.selected = $scope.selected;
        })
    };
    $scope.pushUser = function () {
        $scope.loading = true;
        PushUserToEMR.get({data: JSON.stringify(_.filter(Data.sourceList[0], function (value) {
            return value.selected;
        })), random: Math.random()}, function (data) {
            $scope.loading = false;
            if (data.status == 'SUCCESS') {
                alert('推送成功！');
                FindUnpushPatient.query({random: Math.random()}, function (data) {
                    Data.initList($scope, data, 0);
                });
            } else {
                alert('推送失败！');
            }
        });
    };
};