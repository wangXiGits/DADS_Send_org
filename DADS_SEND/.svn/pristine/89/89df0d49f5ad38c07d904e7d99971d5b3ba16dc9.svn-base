var app = angular.module('app', ['ngRoute', 'ui.bootstrap', 'appService', 'appDirective']);

app.config(function ($httpProvider, $routeProvider) {
    $httpProvider.defaults.headers.post = {
        'Content-Type': 'application/x-www-form-urlencoded'
    };
    $httpProvider.defaults.transformRequest = function (obj) {
        var key,
            list = [];
        for (key in obj) {
            list.push(encodeURIComponent(key) + '=' + encodeURIComponent(obj[key]));
        }
        return list.join('&');
    };
    $routeProvider.
        when('/login', {controller: 'LoginCtrl', templateUrl: 'html/login.html'}).
        when('/dataManage', {controller: 'DataManageCtrl', templateUrl: 'html/dataManage.html', resolve: {
            delay: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '数据管理', '/dataManage');
                return defer.promise;
            }
        }}).
        when('/dataStatistic', {controller: 'DataStatisticCtrl', templateUrl: 'html/dataStatistic.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '上传统计', '/dataStatistic');
                return defer.promise;
            }
        }}).
        when('/userManage', {controller: 'UserManageCtrl', templateUrl: 'html/userManage.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '用户管理', '/userManage');
                return defer.promise;
            }
        }}).
        when('/threadManage', {controller: 'ThreadManageCtrl', templateUrl: 'html/threadManage.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '服务管理', '/threadManage');
                return defer.promise;
            }
        }}).
        when('/logManage/systemOperation', {controller: 'LogManageCtrl', templateUrl: 'html/logManage/systemOperation.html', resolve: {
            data: function ($rootScope, $q, Data) {
                $rootScope.type = 'platform';
                var defer = $q.defer();
                Data.pageJump(defer, '系统日志', '/logManage/systemOperation');
                return defer.promise;
            }
        }}).
        when('/logManage/dataGateway', {controller: 'LogManageCtrl', templateUrl: 'html/logManage/dataGateway.html', resolve: {
            data: function ($rootScope, $q, Data) {
                $rootScope.type = 'gateway';
                var defer = $q.defer();
                Data.pageJump(defer, '网关日志', '/logManage/dataGateway');
                return defer.promise;
            }
        }}).
        when('/dataAnalysis/abnormal', {controller: 'AbnormalCtrl', templateUrl: 'html/dataAnalysis/abnormal.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '异常分析', '/dataAnalysis');
                return defer.promise;
            }
        }}).
        when('/dataAnalysis/active', {controller: 'ActiveCtrl', templateUrl: 'html/dataAnalysis/active.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '激活分析', '/active');
                return defer.promise;
            }
        }}).
        when('/sendData', {controller: 'SendDataCtrl', templateUrl: 'html/testData/sendData.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '测试数据', '/sendData');
                return defer.promise;
            }
        }}).
        when('/dataView', {controller: 'DataViewCtrl', templateUrl: 'html/dataView.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '数据展示', '/dataView');
                return defer.promise;
            }
        }}).
        when('/productManage/productManage', {controller: 'ProductManageCtrl', templateUrl: 'html/productManage/productManage.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '产品管理', '/productManage');
                return defer.promise;
            }
        }}).
        when('/productManage/dataType', {controller: 'DataTypeCtrl', templateUrl: 'html/productManage/dataType.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '数据类型', '/dataType');
                return defer.promise;
            }
        }}).
        when('/productManage/relayController', {controller: 'RelayControllerCtrl', templateUrl: 'html/productManage/relayController.html', resolve: {
            data: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '转发控制', '/relayController');
                return defer.promise;
            }
        }}).
        when('/userSync', {controller: 'UserSyncCtrl', templateUrl: 'html/userSync.html', resolve: {
            delay: function ($q, Data) {
                var defer = $q.defer();
                Data.pageJump(defer, '用户同步', '/userSync');
                return defer.promise;
            }
        }}).
        otherwise({redirectTo: '/login'});
});

app.run(function ($templateCache) {
    $templateCache.put('html/header.html',
            '<div class="header" ng-controller="HeaderCtrl" ng-init="init()">' +
            '<div class="banner">' +
            '<div class="headerBody2"></div>' +
            '</div>' +
            '<div class="headerTop">' +
            '<a>欢迎您，{{userInfo.name}}&nbsp;|</a>' +
            '<a href="">&nbsp;帮助&nbsp;|</a>' +
            '<a href="" ng-click="loginOut()">&nbsp;退出&nbsp;</a>' +
            '</div>' +
            '<img src="img/chinamobilelogo.png" style="position: absolute;top: 5px;left: 5px">' +
            '<img src="img/logo.png" style="position: absolute;top: 44px;left: 140px;width: 150px;">' +
            '<img src="img/logo3.png" style="position: absolute;top: 40px;left: 100px;width: 25px;"/>' +
            '<img src="img/logo2.png" style="position: absolute;top: 18px;right: 0px;width: 150px;">' +
            '<span>{{time.now | date: "yyyy年MM月dd日 HH:mm:ss"}}</span>' +
            '<div class="navbar">' +
            '<div class="navbar-inner" style="border-radius: 0">' +
            '<div class="container">' +
            '<ul class="nav" style="position: relative;left: -20px;">' +
            '<li style="margin: 0" ng-repeat="item in navbarList" ng-class="item.css" ng-click="redirect($index)"><a href="" ng-show="$index%2==0">{{item.name}}</a></li>' +
            '</ul>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '<div style="position: absolute;top: 159px;left: 1px;width: 958px;height: 3px;background-color: #fb5640;"></div>' +
            '</div>');
    $templateCache.put('html/footer.html',
            '<div class="footer">' +
            '<div class="footerTop"></div>' +
            '<div class="footerBottom">' +
            '<a href="">关于我们&nbsp;&nbsp;</a>|' +
            '<a href="">&nbsp;&nbsp;商务合作&nbsp;&nbsp;</a>|' +
            '<a href="">&nbsp;&nbsp;在线商城&nbsp;&nbsp;</a>|' +
            '<a href="">&nbsp;&nbsp;团队博客&nbsp;&nbsp;</a>|' +
            '<a href="">&nbsp;&nbsp;使用条款&nbsp;&nbsp;</a>|' +
            '<a href="">&nbsp;&nbsp;常见问题&nbsp;&nbsp;</a><br />' +
            '<span>Copyright @ 2012-2020 中国移动</span>' +
            '</div>' +
            '<div style="position: absolute;top: 50px;">&nbsp;&nbsp;温馨提示：浏览器建议使用IE9+、Firefox、Chrome</div>' +
            '<div style="position: absolute;top: 50px;right: 5px;color: red">版本：v{{ userInfo.version }}</div>' +
            '</div>');
    $templateCache.put('html/menu.html',
            '<div align="center" style="position: absolute;top: 183px;width: 150px;box-shadow: 1px 1px 10px #dddddd;">' +
            '<div style="width: 95%;height: 40px;background-color: #fda702;margin: 0 auto;">' +
            '<div style="position: relative;top: 11px;left: -15px;color: #ffffff;font-size: 18px"><i class="icon-plus-sign"></i>&nbsp;{{title}}</div>' +
            '</div>' +
            '<div style="background: url(\'img/menuUp.png\');width: 146px;height: 205px;padding-top: 10px;">' +
            '<div style="position: relative;left: 1px;width: 90%;height: 40px;margin: 0 auto;" ng-repeat="item in menu" ng-class="item.css">' +
            '<a style="position: relative;top: 10px;color: #000000" ng-href="{{item.url}}"><span style="position: relative;top: -2px">{{item.name}}</span></a>' +
            '</div>' +
            '</div>');
});