var HeaderCtrl = function ($scope, $rootScope, $location, Time, Account) {
    $scope.time = Time;
    $scope.navbarList = [
        {name: '数据管理', url: '/dataManage'},
        {name: '', url: $location.path()},
        {"name": "上传统计", "url": '/dataStatistic'}             ,
        {"name": "", "url": $location.path()},
        {"name": "用户管理", "url": '/userManage'},
        {"name": "", "url": $location.path()},
        {"name": "服务管理", "url": '/threadManage'},
        {"name": "", "url": $location.path()},
        {"name": "日志管理", "url": '/logManage/systemOperation'},
        {"name": "", "url": $location.path()},
        {"name": "数据分析", "url": '/dataAnalysis/abnormal'},
        {"name": "", "url": $location.path()},
        {"name": "测试数据", "url": '/sendData'},
        {"name": "", "url": $location.path()},
        {"name": "数据展示", "url": '/dataView'},
        {"name": "", "url": $location.path()},
        {"name": "产品管理", "url": '/productManage/productManage'},
        {"name": "", "url": $location.path()},
        {"name": "用户同步", "url": '/userSync'},
        {"name": "", "url": $location.path()}
    ];
    $scope.init = function () {
        $.each($scope.navbarList, function (key, value) {
            value.css = key % 2 !== 0 ? 'divider-vertical' : ($location.path().split('/')[1] === value.url.split('/')[1] ? 'active' : '');
        });
    };
    $scope.loginOut = function () {
        Account.get({info: 'loginOut', random: Math.random()}, function (data) {
            if (data.info) {
                $rootScope.path = undefined;
                $location.path('/login');
            }
        });
    };
    $scope.redirect = function (index) {
        $.each($scope.navbarList, function (key, value) {
            if (key === index) {
                $location.path(value.url);
            }
        });
    };
};