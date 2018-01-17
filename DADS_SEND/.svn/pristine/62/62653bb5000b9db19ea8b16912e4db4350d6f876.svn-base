var LoginCtrl = function ($scope, $rootScope, $location, Account) {
    $rootScope.title = '登录';
    $rootScope.navbar = [];
    $scope.login = function () {
        Account.get({info: 'login', userEmail: $scope.userEmail,password: $scope.password, random: Math.random()}, function (data) {
            if (data.info) {
                $location.path('/dataManage');
            } else {
                $scope.reset();
                alert('账号或密码错误！');
            }
        });
    };
    $scope.reset = function () {
        $scope.userEmail = null;
        $scope.password = null;
        $scope.focus = Math.random();
    };
};