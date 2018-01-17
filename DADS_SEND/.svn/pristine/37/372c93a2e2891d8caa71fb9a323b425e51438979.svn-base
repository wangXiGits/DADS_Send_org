var appDirective = angular.module('appDirective', []);

appDirective.directive('header', function () {
    return {
        templateUrl: 'html/header.html',
        replace: true
    };
});

appDirective.directive('footer', function () {
    return {
        templateUrl: 'html/footer.html',
        replace: true
    };
});

appDirective.directive('menu', function () {
    return {
        templateUrl: 'html/menu.html',
        replace: true
    };
});

appDirective.directive('focus', function () {
    return {
        link: function (scope, element) {
            scope.$watch('focus', function () {
                element[0].focus();
            });
        }
    };
});

appDirective.directive('placeholder', function () {
    return {
        restrict: 'A',
        link: function (scope, element) {
            element.placeholder();
        }
    };
});

appDirective.directive('spin', function () {
    return {
        restrict: 'A',
        template: '<div style="text-align: center"><span style="position: relative;top: 67px;font-size: 15px">loading...</span></div>',
        replace: true,
        link: function (scope, element) {
            var opts = {
                    lines: 17,
                    length: 20,
                    width: 11,
                    radius: 44,
                    corners: 1,
                    rotate: 0,
                    direction: 1,
                    color: '#000',
                    speed: 1.1,
                    trail: 18,
                    shadow: true,
                    hwaccel: false,
                    className: 'spinner',
                    zIndex: 2e9,
                    top: 0,
                    left: 0
                },
                spinner = new Spinner(opts).spin(element[0]);
        }
    };
});

appDirective.directive('datetimepicker', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            element.
                css({backgroundColor: '#ffffff', cursor: 'pointer'}).
                prop('readonly', true).
                datetimepicker({
                    autoclose: true,
                    endDate: moment().format('YYYY-MM-DD'),
                    format: 'yyyy-mm-dd',
                    language: 'zh-CN',
                    minView: 2,
                    pickerPosition: 'bottom-right',
                    startView: 2
                }).
                on('change', function () {
                    ngModel.$setViewValue(element.val());
                    scope.$apply();
                });
        }
    };
});

appDirective.directive('scroll', function () {
    return {
        link: function (scope, element, attrs) {
            scope.$watch(attrs.position, function () {
                if (scope.scroll === 'top') {
                    $(element).animate({scrollTop: 0});
                } else {
                    $(element).animate({scrollTop: element[0].scrollHeight});
                }
            });
        }
    };
});

appDirective.directive('switch', function () {
    return {
        link: function (scope, element, attrs) {
            element.wrap('<div class="switch switch-mini" data-on="success"/>').parent().bootstrapSwitch();
            element.parents('.switch').bootstrapSwitch('setActive', false);
            element.parents('.switch').on('switch-change', function () {
                scope.updateThread(attrs.name, element.prop('checked'));
            });
            scope.$watch('status', function () {
                element.parents('.switch').bootstrapSwitch('setActive', scope.status);
            });
            attrs.$observe('data', function (value) {
                element.parents('.switch').bootstrapSwitch('setState', value !== 'TERMINATED');
            });
        }
    };
});

appDirective.directive('threadchart', function (GetThreadState) {
    return {
        restrict: 'E',
        template: '<div></div>',
        replace: true,
        link: function (scope, element, attrs) {
            var init = function () {
                var i,
                    data = [],
                    time = (moment().format('X') / 1 + 60 * 60 * 8) * 1000;
                for (i = -20; i < 0; i++) {
                    data.push({x: time + i * 1000, y: 0});
                }
                return data;
            };
            var chart = new Highcharts.Chart({
                chart: {
                    backgroundColor: 'white',
                    borderWidth: 0,
                    plotBackgroundColor: 'white',
                    plotBorderWidth: 0,
                    plotShadow: false,
                    renderTo: element[0],
                    type: attrs.type,
                    zoomType: 'x',
                    animation: Highcharts.svg,
                    marginRight: 10,
                    events: {
                        load: function () {
                            var series = [this.series[0], this.series[1], this.series[2], this.series[3], this.series[4]];
                            setInterval(function () {
                                var list = [0, 0, 0, 0, 0],
                                    x = (moment().format('X') / 1 + 60 * 60 * 8) * 1000;
                                GetThreadState.query(function (data) {
                                    scope.data = data;
                                    $.each(data, function (key, value) {
                                        if (value.threadState === 'RUNNABLE') {
                                            list[0]++;
                                        }
                                        if (value.threadState === 'TERMINATED') {
                                            list[1]++;
                                        }
                                        if (value.threadState === 'NEW') {
                                            list[2]++;
                                        }
                                        if (value.threadState === 'BLOCKED') {
                                            list[3]++;
                                        }
                                        if (value.threadState === 'TIMED_WAITING' || value.threadState === 'WAITING') {
                                            list[4]++;
                                        }
                                    });
                                    for (var i = 0; i < 5; i++) {
                                        series[i].addPoint([x, list[i]], true, true);
                                    }
                                });

                            }, 1000);
                        }
                    }
                },
                legend: {
                    enabled: true
                },
                title: {
                    text: '线程实时监控'
                },
                xAxis: {
                    type: 'datetime',
                    tickPixelInterval: 150
                },
                yAxis: {
                    title: {
                        text: '线程数'
                    },
                    plotLines: [
                        {
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }
                    ],
                    min: 0
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' + this.series.name + '</b><br/>' + Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' + this.y;
                    }
                },
                series: [
                    {
                        name: '运行',
                        data: init()
                    },
                    {
                        name: '终止',
                        data: init()
                    },
                    {
                        name: '就绪',
                        data: init()
                    },
                    {
                        name: '阻塞',
                        data: init()
                    },
                    {
                        name: '等待',
                        data: init()
                    }
                ]
            });
        }
    };
});