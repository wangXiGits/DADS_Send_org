var DataManageCtrl = function ($scope, Data, GetPacks, ReSendPacks, UpdateORSavePack, DeletePacks) {
    $scope.status = true;
    $scope.filterType = {};
    $scope.filterData = 'data | filter: filterType';
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
            GetPacks.query({data: $scope.obj, random: Math.random()}, function (data) {
            	console.log(JSON.stringify(data));
                $scope.loading = false;
                $scope.modelShow = false;
                $scope.reset();
                if (data.length) {
                    $scope.data = data;
                    Data.selectPage($scope.data, 1);
                } else {
                    alert('没有数据！');
                }
            });
        }
    };
    $scope.send = function () {
        $scope.sendList = [];
        $.each($scope.$eval($scope.filterData), function (key, value) {
            if (value.check) {
                $scope.sendList.push(value.id);
            }
        });
        if ($scope.sendList.length) {
            ReSendPacks.get({data: JSON.stringify($scope.sendList), random: Math.random()}, function (data) {
                alert('重发' + (data.status ? '成功!' : '失败!'));
            });
        } else {
            alert('请选择数据！');
        }
    };
    $scope.edit = function () {
        $scope.editList = [];
        $.each($scope.$eval($scope.filterData), function (key, value) {
            if (value.check) {
                $scope.editList.push(value);
            }
        });
        if ($scope.editList.length === 0) {
            alert('请选择数据！');
        } else if ($scope.editList.length > 1) {
            alert('只能选择一条数据修改！');
        } else {
            $scope.editData = $scope.editList[0];
            $scope.copyData = angular.copy($scope.editList[0]);
            $scope.modelShow2 = true;
        }
    };
    $scope.del = function () {
        $scope.delList = [];
        $.each($scope.$eval($scope.filterData), function (key, value) {
            if (value.check) {
                $scope.delList.push(value.id);
            }
        });
        if ($scope.delList.length) {
            DeletePacks.get({data: JSON.stringify($scope.delList), random: Math.random()}, function (data) {
                var list = [];
                $.each($scope.data, function (key, value) {
                    if (!value.check) {
                        list.push(value);
                    }
                });
                $scope.data = list;
                Data.selectPage($scope.$eval($scope.filterData), 1);
                alert('删除' + (data.status ? '成功!' : '失败!'));
            });
        } else {
            alert('请选择数据！');
        }
    };
    $scope.editReset = function () {
        $scope.editData = angular.copy($scope.copyData);
    };
    $scope.updateData = function () {
        UpdateORSavePack.get({data: $scope.editData, random: Math.random()}, function (data) {
            if (data.status) {
                $scope.modelShow2 = false;
                alert('修改成功！');
            }
        });
    };
};