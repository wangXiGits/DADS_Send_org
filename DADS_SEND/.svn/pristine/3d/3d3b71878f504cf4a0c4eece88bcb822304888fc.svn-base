var appService = angular.module('appService', ['ngResource']);

appService.factory('Data', function ($rootScope, $location, Account) {
    var item = {
        size: 20,
        page: 1,
        password: 'admin1!',
        pageSize: 20,
        maxPageSize: 5,
        sizeList: [],
        sourceList: [],
        filterList: [],
        currentPageList: [],
        init: function () {
            $rootScope.currentPage = 1;
            $rootScope.maxSize = 5;
            $rootScope.opts = {
                backdropFade: true,
                dialogFade: true
            };
            $rootScope.Data = item;
            $rootScope.Util = item;
        },
        pageJump: function (defer, title, path) {
            $rootScope.title = title;
            $rootScope.path = path;
            Account.get({info: 'getSession', random: Math.random()}, function (data) {
                if (data.name) {
                    $rootScope.userInfo = data;
                    item.init(title);
                    defer.resolve();
                } else {
                    alert('您没有权限访问此页面！');
                    $location.path('/login');
                }
            });
        },
        sort: function (list, seq, desc) {
            var i = 0,
                j = list.length,
                k = seq.length,
                compare = function (i, a, b) {
                    var c = a[seq[i]],
                        d = b[seq[i]];
                    return (c === d && ++i < k) ? compare(i, a, b) : (c - d || String(c || '').localeCompare(String(d || '')));
                };
            list.sort(function (a, b) {
                return desc ? compare(0, b, a) : compare(0, a, b);
            });
            for (; i < j; i++) {
                list[i].index = i;
            }
        },
        noOfPages: function (length) {
            return Math.ceil(length / item.size);
        },
        noOfPages2: function (length, index) {
            return Math.ceil(length / this.sizeList[index]);
        },
        selectPage: function (data, page) {
            $.each(data, function (key, value) {
                value.show = key >= item.size * (page - 1) && key < item.size * page;
            });
        },
        initList: function (scope, source, index) {
            source.forEach(function (value, key) {
                value.index = key;
            });
            this.sizeList[index] = arguments[3] || this.pageSize;
            this.filterList[index] = this.sourceList[index] = angular.copy(source);
            this.currentPageList[index] = 1;
            scope.sourceList = scope.sourceList || [];
            scope.sourceList[index] = this.filterList[index].slice(0, this.sizeList[index]);
            scope.filterList = scope.filterList || [];
            scope.filterList[index] = {};
        },
        searchList: function (scope, index) {
            var obj = scope.filterList[index],
                sourceList = this.sourceList[index],
                filterList = [],
                i = 0,
                j = sourceList.length,
                key = '';
            for (; i < j; i++) {
                var valid = true,
                    source = sourceList[i];
                for (key in obj) {
                    if ((source[key].toUpperCase() || '').indexOf(obj[key].toUpperCase()) < 0) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    filterList.push(source);
                }
            }
            this.filterList[index] = filterList;
            this.selectList(scope, index, arguments[2] || 1);
        },
        selectList: function (scope, index, page) {
            var size = this.sizeList[index],
                start = size * (page - 1),
                end = size * page;
            this.currentPageList[index] = page;
            scope.sourceList[index] = this.filterList[index].slice(start, end);
        },
        modifyList: function (scope, source, index) {
            this.sourceList[index][source.index] = source;
            this.searchList(scope, index, this.currentPageList[index]);
        },
        deleteList: function (scope, source, index) {
            this.sourceList[index].splice(source.index, 1);
            this.sourceList[index].forEach(function (value, key) {
                value.index = key;
            });
            this.searchList(scope, index, this.currentPageList[index]);
        },
        dateVerify: function (date) {
            var year = date.substr(0, 4),
                month = date.substr(5, 2),
                day = date.substr(8, 2);
            if (date.length !== 10) {
                return false;
            } else if (year > moment().format('YYYY-MM-DD')) {
                return false;
            } else if (month > 12) {
                return false;
            } else if ('01,03,05,07,08,10,12'.indexOf(month) > -1 && day > 31) {
                return false;
            } else if ('04,06,09,11'.indexOf(month) > -1 && day > 30) {
                return false;
            } else if (month === '02' && (year % 400 === 0 || (year % 100 !== 0 && year % 4 === 0)) && day > 29) {
                return false;
            } else if (month === '02' && !(year % 400 === 0 || (year % 100 !== 0 && year % 4 === 0)) && day > 28) {
                return false;
            } else {
                return true;
            }
        }
    };
    return item;
});

appService.factory('Time', function ($timeout) {
    var item = {};
    (function tick() {
        item.now = new Date();
        $timeout(tick, 1000);
    }());
    return item;
});

appService.factory('Account', function ($resource) {
    return $resource('account.json', {}, {});
});

appService.factory('GetPacks', function ($resource) {
    return $resource('getPacks.json', {}, {});
});

appService.factory('GetData', function ($resource) {
    return $resource('getData.json', {}, {});
});

appService.factory('GetStatisticData', function ($resource) {
    return $resource('getStatisticData.json', {}, {});
});

appService.factory('ReSendPacks', function ($resource) {
    return $resource('reSendPacks.json', {}, {});
});

appService.factory('UpdateORSavePack', function ($resource) {
    return $resource('updateORSavePack.json', {}, {});
});

appService.factory('DeletePacks', function ($resource) {
    return $resource('deletePacks.json', {}, {});
});

appService.factory('GetPeople', function ($resource) {
    return $resource('getPeople.json', {}, {});
});

appService.factory('DeletePeopleInfo', function ($resource) {
    return $resource('deletePeopleInfo.json', {}, {});
});

appService.factory('UpdateOrSavePeopleInfo', function ($resource) {
    return $resource('updateOrSavePeopleInfo.json', {}, {});
});

appService.factory('GetThreadState', function ($resource) {
    return $resource('getThreadState.json', {}, {});
});

appService.factory('ChangeThreadState', function ($resource) {
    return $resource('changeThreadState.json', {}, {});
});

appService.factory('GetUserStatisticData', function ($resource) {
    return $resource('getUserStatisticData.json');
});

appService.factory('GetResetRecordData', function ($resource) {
    return $resource('getResetrecordData.json');
});

appService.factory('GetResetPersonsPerDay', function ($resource) {
    return $resource('getResetPersonsPerDay.json');
});

appService.factory('GetResetTimesPerPerson', function ($resource) {
    return $resource('getResetTimesPerPerson.json');
});

appService.factory('GetUserActivateInfo', function ($resource) {
    return $resource('getUserActivateInfo.json');
});

appService.factory('ActivateInfoSyno', function ($resource) {
    return $resource('activateInfoSyno.json');
});

appService.factory('QueryProduct', function ($resource) {
    return $resource('queryProduct.json');
});

appService.factory('QueryDatatype', function ($resource) {
    return $resource('queryDatatype.json');
});

appService.factory('QueryProductDatatype', function ($resource) {
    return $resource('queryProductDatatype.json');
});

appService.factory('UpdateProduct', function ($resource) {
    return $resource('updateProduct.json');
});

appService.factory('SaveProduct', function ($resource) {
    return $resource('saveProduct.json');
});

appService.factory('DeleteProduct', function ($resource) {
    return $resource('deleteProduct.json');
});

appService.factory('SaveDatatype', function ($resource) {
    return $resource('saveDatatype.json');
});

appService.factory('UpdateDatatype', function ($resource) {
    return $resource('updateDatatype.json');
});

appService.factory('DeleteDatatype', function ($resource) {
    return $resource('deleteDatatype.json');
});

appService.factory('SaveProductDatatype', function ($resource) {
    return $resource('saveProductDatatype.json');
});

appService.factory('DeleteProductDatatype', function ($resource) {
    return $resource('deleteProductDatatype.json');
});

appService.factory('UpdateProductDatatype', function ($resource) {
    return $resource('updateProductDatatype.json');
});

appService.factory('StartSendThread', function ($resource) {
    return $resource('startSendThread.json');
});

appService.factory('FindUnpushPatient', function ($resource) {
    return $resource('findUnpushPatient.json');
});

appService.factory('PushUserToEMR', function ($resource) {
    return $resource('pushUserToEMR.json');
});