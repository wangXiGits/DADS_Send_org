var UserManageCtrl = function ($scope, $timeout, Data, GetPeople, DeletePeopleInfo, UpdateOrSavePeopleInfo, ActivateInfoSyno) {
    $scope.status = true;
    $scope.filterType = {};
    $scope.filterData = 'data | filter: filterType';
    $scope.timeout = function () {
        $timeout(function () {
            for (var i = 0; i < 20 && i < $scope.copy.length; i++) {
                $scope.data.push($scope.copy[i]);
            }
            $scope.copy.splice(0, 20 || $scope.copy.length);
            if ($scope.data.length <= 20) {
                Data.selectPage($scope.data, 1);
            }
            if ($scope.copy.length) {
                $scope.timeout();
            }
        }, 0);
    };
    $scope.init = function () {
        $scope.loading = true;
        GetPeople.query({data: '{}', random: Math.random()}, function (data) {
            $scope.loading = false;
            $.each(data, function (key, value) {
                value.show = false;
            });
            $scope.copy = data;
            $scope.data = [];
            $scope.timeout();
        });
    };
    $scope.unClock = function () {
        var text = prompt('请输密码');
        if (text === Data.password) {
            $scope.status = false;
        } else if (text !== null) {
            alert('密码错误！');
        }
    };
    $scope.updateCheck = function () {
        $.each($scope.data, function (key, value) {
            value.check = $scope.check;
        });
    };
    $scope.importExcel = function () {
        if ($scope.status) {
            return;
        }
        $.upload({
            url: 'importPeopleInfo.json',
            fileName: 'fileData',
            dataType: 'json',
            onComplate: function (data) {
                if (data.status) {
                    alert('导入成功！');
                }
            }
        });
    };
    $scope.del = function () {
        if ($scope.status) {
            return;
        }
        if (confirm('是否停用？')) {
            $scope.delList = [];
            $.each($scope.$eval($scope.filterData), function (key, value) {
                if (value.check) {
                    $scope.delList.push(value.id);
                }
            });
            if ($scope.delList.length) {
                DeletePeopleInfo.get({data: JSON.stringify($scope.delList), random: Math.random()}, function (data) {
                    $.each($scope.data, function (key, value) {
                        if (value.check) {
                            value.deviceUseFlag = '0';
                        }
                    });
                    Data.selectPage($scope.$eval($scope.filterData), 1);
                    $scope.$broadcast('selectPage', 1);
                    alert('停用' + (data.status ? '成功!' : '失败!'));
                });
            } else {
                alert('请选择数据！');
            }
        }
    };
    $scope.edit = function () {
        if ($scope.status) {
            return;
        }
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
            $scope.modelShow = true;
        }
    };
    $scope.updateData = function () {
        if ($scope.status) {
            return;
        }
        UpdateOrSavePeopleInfo.get({data: $scope.editData, random: Math.random()}, function (data) {
            if (data.status) {
                $scope.modelShow = false;
                alert('修改成功！');
            }
        });
    };
    $scope.editReset = function () {
        $scope.editData = angular.copy($scope.copyData);
    };
    $scope.add = function () {
        if ($scope.status) {
            return;
        }
        $scope.addData = {
            "company": '',
            "companyName": '',
            "teamName": '',
            "pname": '',
            "patientId": '',
            "email": '',
            "deviceUseFlag": '',
            "deviceId": '',
            "deviceType": ''
        };
        $scope.modelShow2 = true;
    };
    $scope.insertData = function () {
        if ($scope.status) {
            return;
        }
        UpdateOrSavePeopleInfo.get({data: $scope.addData, random: Math.random()}, function (data) {
            if (data.status) {
                $scope.modelShow2 = false;
                $scope.data.unshift($scope.addData);
                Data.selectPage($scope.$eval($scope.filterData), 1);
                $scope.$broadcast('selectPage', 1);
                alert('新增成功！');
            }
        });
    };

    $scope.activeUser = function () {
        ActivateInfoSyno.get({random: Math.random()},function (data) {
            var flag = '';
            $.each(data, function (key, value) {
                if (value !== 'success' && key.indexOf('$') < 0) {
                    flag += ',' + key;
                }
            });
            if (flag.length) {
                flag = flag.slice(1);
                alert(flag + '激活同步失败！');
            } else {
                alert('激活同步成功！');
            }
        });
    };
};

var PageCtrl = function ($scope) {
    $scope.$on('selectPage', function (event, page) {
        $scope.currentPage = page;
    });
};