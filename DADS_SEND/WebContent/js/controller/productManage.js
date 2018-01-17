var ProductManageCtrl = function ($scope, Data, QueryProduct, DeleteProduct) {
    QueryProduct.query({random: Math.random()}, function (data) {
        Data.initList($scope, data, 0);
    });
    $scope.openModal = function (index, type) {
        $scope.index = index;
        $scope.type = type;
        $scope.modelShow = true;
    };
    $scope.deleteInfo = function (item) {
        if (confirm('确定删除？')) {
            DeleteProduct.get({data: JSON.stringify(item), random: Math.random()}, function (data) {
                if (data.status === 'SUCCESS') {
                    alert('删除成功！');
                    Data.deleteList($scope, item, 0);
                } else {
                    alert('删除失败！');
                }
            });
        }
    };
};

var ProductManageModalCtrl = function ($scope, Data, UpdateProduct, SaveProduct) {
    $scope.list = [
        {name: '开启', value: 'on'},
        {name: '关闭', value: 'off'}
    ];
    $scope.init = function () {
        if ($scope.type == 'add') {
            $scope.info = {appToggle: 'on'};
        } else {
            $scope.info = angular.copy($scope.sourceList[0][$scope.index]);
        }
    };
    $scope.addInfo = function () {
        if (!_.every(['appName', 'appDesc', 'appSendFlag', 'appUrl'], function (key) {
            return $scope.info[key];
        })) {
            alert('您没有填写必填信息！');
        } else {
            SaveProduct.save({random: Math.random()}, {data: JSON.stringify($scope.info)}, function (data) {
                if (data.status === 'SUCCESS') {
                    alert('添加成功！');
                    $scope.info.updateTime = moment().format('YYYY-MM-DD HH:mm:ss');
                    Data.sourceList[0].unshift($scope.info);
                    Data.initList($scope.$parent, Data.sourceList[0], 0);
                    $scope.$parent.modelShow = false;
                } else {
                    alert('添加失败！');
                }
            });
        }
    };
    $scope.modifyInfo = function () {
        if (!_.every(['appName', 'appDesc', 'appSendFlag', 'appUrl'], function (key) {
            return $scope.info[key];
        })) {
            alert('您没有填写必填信息！');
        } else {
            UpdateProduct.save({random: Math.random()}, {data: JSON.stringify($scope.info)}, function (data) {
                if (data.status === 'SUCCESS') {
                    alert('修改成功！');
                    Data.modifyList($scope.$parent, $scope.info, 0);
                    $scope.$parent.modelShow = false;
                } else {
                    alert('修改失败！');
                }
            });
        }
    };
};

var DataTypeCtrl = function ($scope, Data, QueryDatatype, DeleteDatatype) {
    QueryDatatype.query({random: Math.random()}, function (data) {
        Data.initList($scope, data, 0);
    });
    $scope.openModal = function (index, type) {
        $scope.index = index;
        $scope.type = type;
        $scope.modelShow = true;
    };
    $scope.deleteInfo = function (item) {
        if (confirm('确定删除？')) {
            DeleteDatatype.get({data: JSON.stringify(item), random: Math.random()}, function (data) {
                if (data.status === 'SUCCESS') {
                    alert('删除成功！');
                    Data.deleteList($scope, item, 0);
                } else {
                    alert('删除失败！');
                }
            });
        }
    };
};

var DataTypeModalCtrl = function ($scope, Data, SaveDatatype, UpdateDatatype) {
    $scope.init = function () {
        if ($scope.type == 'add') {
            $scope.info = {};
        } else {
            $scope.info = angular.copy($scope.sourceList[0][$scope.index]);
        }
    };
    $scope.addInfo = function () {
        if (!_.every(['dataTypeName', 'dataDesc', 'tableName'], function (key) {
            return $scope.info[key];
        })) {
            alert('您没有填写必填信息！');
        } else {
            SaveDatatype.save({random: Math.random()}, {data: JSON.stringify($scope.info)}, function (data) {
                if (data.status === 'SUCCESS') {
                    alert('添加成功！');
                    $scope.info.updateTime = moment().format('YYYY-MM-DD HH:mm:ss');
                    Data.sourceList[0].unshift($scope.info);
                    Data.initList($scope.$parent, Data.sourceList[0], 0);
                    $scope.$parent.modelShow = false;
                } else {
                    alert('添加失败！');
                }
            });
        }
    };
    $scope.modifyInfo = function () {
        if (!_.every(['dataTypeName', 'dataDesc', 'tableName'], function (key) {
            return $scope.info[key];
        })) {
            alert('您没有填写必填信息！');
        } else {
            UpdateDatatype.save({random: Math.random()}, {data: JSON.stringify($scope.info)}, function (data) {
                if (data.status === 'SUCCESS') {
                    alert('修改成功！');
                    Data.modifyList($scope.$parent, $scope.info, 0);
                    $scope.$parent.modelShow = false;
                } else {
                    alert('修改失败！');
                }
            });
        }
    };
};

var RelayControllerCtrl = function ($scope, Data, QueryProduct, QueryDatatype, QueryProductDatatype, UpdateProductDatatype, DeleteProductDatatype) {
    $scope.appList = QueryProduct.query({random: Math.random()});
    $scope.dataList = QueryDatatype.query({random: Math.random()});
    QueryProductDatatype.query({random: Math.random()}, function (data) {
        _.each(data, function (value) {
            value.datatypeId = value.datatype.datatypeId;
            value.productId = value.product.appId;
            value.appType = value.product.appName;
            value.dataType = value.datatype.dataTypeName
        });
        Data.initList($scope, data, 0);
    });
    $scope.modifyInfo = function (item) {
    	if(item.toggle == "on"){
    		item.toggle = "off";
    	}else{
    		item.toggle = "on";
    	}
        UpdateProductDatatype.save({random: Math.random()}, {data: JSON.stringify(item)});
    };
    $scope.openModal = function (index, type) {
        $scope.index = index;
        $scope.type = type;
        $scope.modelShow = true;
    };
    $scope.deleteInfo = function (item) {
        if (confirm('确定删除？')) {
            DeleteProductDatatype.get({data: JSON.stringify(item), random: Math.random()}, function (data) {
                if (data.status === 'SUCCESS') {
                    alert('删除成功！');
                    Data.deleteList($scope, item, 0);
                } else {
                    alert('删除失败！');
                }
            });
        }
    };
};

var RelayControllerModalCtrl = function ($scope, Data, SaveProductDatatype) {
    $scope.list = [
        {name: '开启', value: 'on'},
        {name: '关闭', value: 'off'}
    ];
    $scope.init = function () {
        if ($scope.type == 'add') {
            $scope.info = {
                toggle: 'on',
                product: $scope.appList[0],
                datatype: $scope.dataList[0]
            };
        } else {
            $scope.info = angular.copy($scope.sourceList[0][$scope.index]);
        }
    };
    $scope.addInfo = function () {
        $scope.info.productId = $scope.info.product.appId;
        $scope.info.datatypeId = $scope.info.datatype.datatypeId;
        SaveProductDatatype.save({random: Math.random()}, {data: JSON.stringify($scope.info)}, function (data) {
            if (data.status === 'SUCCESS') {
                alert('添加成功！');
                $scope.info.updatetTime = moment().format('YYYY-MM-DD HH:mm:ss');
                Data.sourceList[0].unshift($scope.info);
                Data.initList($scope.$parent, Data.sourceList[0], 0);
                $scope.$parent.modelShow = false;
            } else {
                alert('添加失败！');
            }
        });
    };
};