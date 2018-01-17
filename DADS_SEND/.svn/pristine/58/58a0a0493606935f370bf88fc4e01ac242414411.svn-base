var DataStatisticCtrl = function ($scope, Data, GetStatisticData) {
    $scope.filterType = {};
    $scope.filterData = 'data | filter: filterType';
    $scope.startDate = moment().subtract('days', 6).format('YYYY-MM-DD');
    $scope.endDate = moment().format('YYYY-MM-DD');
    $scope.update = function () {
        $scope.data = GetStatisticData.query({data: {"startDate": $scope.startDate, "endDate": $scope.endDate}, random: Math.random()}, function (data) {
            if (data.length) {
                $scope.data = data;
                Data.selectPage($scope.data, 1);
            } else {
                alert('没有数据！');
            }
        });
    };
};