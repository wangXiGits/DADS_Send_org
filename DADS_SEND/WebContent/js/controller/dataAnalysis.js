var AbnormalCtrl = function ($scope, Data, GetUserStatisticData, GetResetRecordData, GetResetPersonsPerDay, GetResetTimesPerPerson) {
    $scope.exportDate = moment().format('YYYY-MM-DD');
    $scope.data = [];
    $scope.tabList = ['连续未上传用户', '数据异常用户', '每日异常人数', '用户异常次数'];
    $scope.date = moment().format('YYYY-MM-DD');
    $scope.startDate = moment().subtract('months', 1).format('YYYY-MM-DD');
    $scope.endDate = moment().format('YYYY-MM-DD');
    $scope.filterType = [
        {},
        {},
        {},
        {}
    ];
    $scope.filterData = 'data[$index] | filter: filterType[$index]';
    $scope.update = function (index, type) {
        if (type) {
            $scope.date = moment().subtract('days', index).format('YYYY-MM-DD');
        }
        var serviceList = [GetUserStatisticData, GetResetRecordData, GetResetPersonsPerDay, GetResetTimesPerPerson],
            obj = {
                date: $scope.date,
                startDate: $scope.startDate,
                endDate: $scope.endDate
            };
        serviceList[index].query({data: JSON.stringify(obj), random: Math.random()}, function (data) {
            $scope.data[index] = data;
            Data.selectPage($scope.data[index], 1);
        });
    };
    $scope.url = function () {
        return 'analysisExportExcel.json?data=' + JSON.stringify({date: $scope.exportDate});
    };
};

var ActiveCtrl = function ($scope, Data, GetUserActivateInfo) {
    $scope.data = [];
    $scope.tabList = ['已激活已上传用户', '已激活未上传用户', '未激活已上传用户', '未激活未上传用户'];
    $scope.date = moment().format('YYYY-MM-DD');
    $scope.startDate = moment().subtract('months', 1).format('YYYY-MM-DD');
    $scope.endDate = moment().format('YYYY-MM-DD');
    $scope.filterType = [
        {companyName: ''},
        {companyName: ''},
        {companyName: ''},
        {companyName: ''}
    ];
    $scope.filterData = 'data[$index] | filter: filterType[$index]';
    $scope.update = function (index) {
        $scope.index = index;
        var list = [1, 1, 0, 0, 1, 0, 1, 0],
            obj = {
                isActivate: list[index],
                isUpload: list[index + 4]
            };
        GetUserActivateInfo.query({data: JSON.stringify(obj), random: Math.random()}, function (data) {
            Data.sort(data, ['lastTime'], true);
            $scope.data[index] = data;
            Data.selectPage($scope.data[index], 1);
        });
    };
    $scope.exportUrl = function () {
        var companyName = $scope.filterType[$scope.index] ? $scope.filterType[$scope.index].companyName : '';
        return 'activateExportExcel.json?data=' + JSON.stringify({companyName: companyName});
    };
    $scope.sort = function (index) {
        $scope.data[index] = $scope.data[index].reverse();
        Data.selectPage($scope.data[index], 1);
    };
};