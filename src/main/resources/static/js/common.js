function basePath() {
    //获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPath = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/ems
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    //获取项目的basePath   http://localhost:8080/ems/
    var basePath = localhostPath + projectName + "/";
    return localhostPath;
};

var base_path = basePath() + "/";
console.log(base_path)

// 获取城市与类型的信息 cities={city_id:city_name} categories={category_id:category_name}
var metaData;
function meta_data() {
    $.ajax({
            async: false,
            url: base_path + "common/metaData",
            dataType: "json",
            type: "GET",
            timeout: 2000,
            success: function (data) {
                if(data.status == 200){
                    metaData = data.data
                }
            },
            error: function (msg) {}
        }
    )
}

meta_data()
//
// function sortMap(map) {
//     var arrayObj=Array.from(map);
//     arrayObj.sort(function(a,b){return a[0].localeCompare(b[0])});
//     return result = new Map(arrayObj.map(i => [i[0], i[1]]));
// }

function plot_pie_city(element_id, url, layout) {
    if(layout === undefined) {
        layout = {height: 400, width: 500}
    }
    $.ajax({
            url: url,
            dataType: "json",
            type: "GET",
            timeout: 20000,
            success: function (data) {
                if (data.status == 200) {
                    var result = data.data
                    var index = 0;
                    var values = new Array(result.length);
                    var labels = new Array(result.length);
                    for (var key in result) {
                        values[index] = result[key]
                        labels[index++] = metaData.cities[key]
                    }
                    var pie_data = [{
                        values: values,
                        labels: labels,
                        type: 'pie'
                    }];
                    Plotly.newPlot(element_id, pie_data, layout);
                }
            },
            error: function (msg) {}
        }
    )
}

function plot_bar_category(element_id, url, layout) {
    if(layout === undefined) {
        layout = {height: 400, width: 500}
    }
    $.ajax({
            url: url,
            dataType: "json",
            type: "POST",
            timeout: 20000,
            success: function (data) {
                if (data.status == 200) {
                    var result = data.data
                    var index = 0;
                    var values = new Array(result.length);
                    var labels = new Array(result.length);
                    for (var key in result) {
                        values[index] = result[key]
                        labels[index++] = metaData.categories[key]
                    }
                    var bar_data = [{
                        x: labels,
                        y: values,
                        type: 'bar'
                    }];
                    Plotly.newPlot(element_id, bar_data, layout);
                }
            },
            error: function (msg) {}
        }
    )
}


function plot_time_line(element_id, url, layout) {
    if(layout === undefined) {
        layout = {title: 'time line chart'}
    }
    $.ajax({
            url: url,
            dataType: "json",
            type: "POST",
            timeout: 20000,
            success: function (data) {
                if (data.status == 200) {
                    var result = data.data
                    var index = 0;
                    var x = new Array(result.length);
                    var y = new Array(result.length);
                    for (var key in result) {
                        x[index] = key
                        y[index++] = result[key]
                    }
                    var plot_data = [{
                        x: x,
                        y: y,
                        type: 'scatter'
                    }];
                    Plotly.newPlot(element_id, plot_data, layout);
                }
            },
            error: function (msg) {}
        }
    )
}

function plot_category_scatter(element_id, url, layout) {

    $.ajax({
            url: url,
            dataType: "json",
            type: "POST",
            timeout: 20000,
            success: function (data) {
                var trace_list = new Array()
                if (data.status == 200) {
                    var result = data.data
                    // Ids
                    var category_set = new Set()
                    // Ids
                    var city_set = new Set()
                    for(var category in result) {
                        category_set.add(category)
                        for(var city in result[category]) {
                            city_set.add(city)
                        }
                    }
                    var city_set_value = new Array()
                    for(var city of city_set) {
                        city_set_value.push(metaData.cities[city])
                    }
                    for(var category of category_set) {
                        var y = new Array()
                        for(var city of city_set) {
                            var y_value = result[category][city];
                            if(y_value === undefined) {
                                y_value = 0
                            }
                            y.push(y_value)
                        }

                        var trace = {
                            x: city_set_value,
                            y: y,
                            mode: 'markers',
                            type: 'scatter',
                            name: metaData.categories[category],
                            // text: ['A-1', 'A-2', 'A-3', 'A-4', 'A-5'],
                            marker: { size: 12 }
                        };
                        trace_list.push(trace)
                    }

                    console.log(trace_list)
                    Plotly.newPlot(element_id, trace_list, layout);
                }
            },
            error: function (msg) {}
        }
    )
}

function plot_bar_city_group(element_id, url, layout) {
    if(layout === undefined) {
        title:'Group Size'
    }
    $.ajax({
            url: url,
            dataType: "json",
            type: "POST",
            timeout: 20000,
            success: function (data) {
                if (data.status == 200) {
                    var result = data.data
                    var index = 0;
                    var xasix = {"0":"<100", "1":"<200",
                        "2":"<300", "3":"<400", "4":"<500",
                        "5":"<600", "6":"<700", "7":"<800",
                        "8":"<900", "9":"<1000", "10":"<100000"};
                    var values = new Array(result.length);
                    var labels = new Array(result.length);
                    for (var key in result) {
                        values[index] = result[key]
                        labels[index++] = xasix[key]
                    }
                    var bar_data = [{
                        x: labels,
                        y: values,
                        type: 'bar'
                    }];
                    Plotly.newPlot(element_id, bar_data, layout);
                }
            },
            error: function (msg) {
                console.log(msg.toString());
            }
        }
    )
}

function plot_map(element_id, url, layout) {
    if (layout === undefined) {
        title:'Event Map'
    }
    $.ajax({
            url: url,
            dataType: "json",
            type: "POST",
            timeout: 20000,
            success: function (data) {
                if (data.status == 200) {
                    var result = data.data
                    var index = 0;
                    var lats = result['vlat'];
                    var lons = result['vlon'];
                    var sizes = result['num'];
                    let new_sizes = sizes.map(item  => 0.1*item);
                    var center = result['center'];
                    var categories = result['category_id'];
                    var event_map_data = [{
                        type:'scattermapbox',
                        lat:lats,  //要填入的数据
                        lon:lons,  //要填入的数据
                        mode:'markers',
                        marker: {
                            size:new_sizes,
                            color:categories,
                            colorscale:'Blues',
                        },
                        text:sizes
                    }];
                    layout.mapbox.center.lat = center[0];
                    layout.mapbox.center.lon = center[1];
                    Plotly.newPlot(element_id, event_map_data, layout);
                }
            },
            error: function (msg) {
                console.log(msg.toString());
            }
        }
    )
}

