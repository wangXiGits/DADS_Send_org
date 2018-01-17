var MenuCtrl = function ($scope) {
    $scope.init = function (navbar, menu) {
        if (navbar === 0) {
            $scope.title = '日志管理';
            $scope.menu = [
                {"name": '系统日志', "url": '#/logManage/systemOperation', "css": 'menu2'},
                {"name": '网关日志', "url": '#/logManage/dataGateway', "css": 'menu2'}
            ];
        } else if (navbar === 1) {
            $scope.title = '数据分析';
            $scope.menu = [
                {"name": '异常分析', "url": '#/dataAnalysis/abnormal', "css": 'menu2'},
                {"name": '使用情况', "url": '#/dataAnalysis/active', "css": 'menu2'}
            ];
        } else {
            $scope.title = '产品管理';
            $scope.menu = [
                {"name": '产品管理', "url": '#/productManage/productManage', "css": 'menu2'},
                {"name": '数据类型', "url": '#/productManage/dataType', "css": 'menu2'},
                {"name": '转发控制', "url": '#/productManage/relayController', "css": 'menu2'}
            ];
        }
        $scope.menu[menu].css = 'menu1';
    };
};