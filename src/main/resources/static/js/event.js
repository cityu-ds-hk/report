//plotly.js 画图部分
onload_frame = function(){

    // Event分城市饼图
    var group_pie_data = [{
      values: [19, 26, 55],
      labels: ['Residential', 'Non-Residential', 'Utility'],
      type: 'pie'
    }];
  
    var layout = {
      height: 400,
      width: 500
    };
  
    Plotly.newPlot('Event-PieChart',group_pie_data, layout);

    //Event分category柱状图
    var group_bar_data = [
      {
        x: ['giraffes', 'orangutans', 'monkeys'],
        y: [20, 14, 23],
        type: 'bar'
      }
    ];
    
    Plotly.newPlot('Event-BarChart', group_bar_data,layout);
  
    //event数量时间变化图
      var number_groups = {
        x: [1, 2, 3, 4],
        y: [10, 15, 13, 17],
        type: 'scatter'
      };
     var layout ={
      title:'小组数量时间变化图'
     }
     var data = [number_groups]
    Plotly.newPlot('Event-TimeLineChart', data,layout);
  
  
    //分地区的event数量统计图（分category）
    var trace1 = {
      x: [1, 2, 3, 4, 5],
      y: [1, 6, 3, 6, 1],
      mode: 'markers',
      type: 'scatter',
      name: 'Team A',
      text: ['A-1', 'A-2', 'A-3', 'A-4', 'A-5'],
      marker: { size: 12 }
    };
    
    var trace2 = {
      x: [1.5, 2.5, 3.5, 4.5, 5.5],
      y: [4, 1, 7, 1, 4],
      mode: 'markers',
      type: 'scatter',
      name: 'Team B',
      text: ['B-a', 'B-b', 'B-c', 'B-d', 'B-e'],
      marker: { size: 12 }
    };
    
    var data = [ trace1, trace2 ];
    
    var layout = {
      xaxis: {
        range: [ 0.75, 5.25 ]
      },
      yaxis: {
        range: [0, 8]
      },
      title:'The number of events in different cities'
    };
    
    Plotly.newPlot('Event-ScatterChart', data, layout);

    //Event地图
    var data = [{
        type:'scattermapbox',
        lat:['45.5017'],  //要填入的数据
        lon:['-73.5673'],  //要填入的数据
        mode:'markers',
        marker: {
            size:14
        },
        text:['Montreal']
    }]

    var event_map_layout = {
        autosize: true,
        height:600,
        width:800,
        title:'Event Map',
        hovermode:'closest',
        mapbox: {
            // style:'dark',
            bearing:0,
            center: {
                lat:33.78,
                lon:-122.42
            },
            pitch:0,
            zoom:5
        },
    }

    Plotly.setPlotConfig({
        mapboxAccessToken: "pk.eyJ1IjoibmFuYmVpNjI5IiwiYSI6ImNrM2ZrMDZxaDA1OTYzbm80cmFocGRuaTcifQ.sxVwhNQvZvSv93ZxQljNIQ"
    })
    Plotly.plot('Event-Map', data, event_map_layout)

    plot_pie_city('Event-PieChart', base_path + 'event/areaCount')
    var layout ={
        title:'Event number with time'
    }
    plot_time_line('Event-TimeLineChart', base_path + 'event/increasedCountTrend?', layout)

    var layout = {
        title:'Event distribution with different categories in three cities'
    };

    plot_category_scatter('Event-ScatterChart', base_path + 'event/categoryGroups', layout);

    plot_bar_category('Event-BarChart', base_path + 'event/categoryCount');

    // plot_bar_city_group('Event-Map', base_path + 'group/cityGroupSize/San Francisco', event_bar_layout);

    plot_map('Event-Map', base_path +'event/cityEventMap/San Francisco', event_map_layout);

}

onload_frame()

layui.use(['element','laydate','layer','form'], function() {
    var element = layui.element;
    var laydate = layui.laydate;
    var $ = layui.$;
    var layer = layui.layer;
    var form = layui.form;

    //执行一个laydate实例
    laydate.render({
        elem: '#start-time' //指定元素
    });

    laydate.render({
        elem: '#end-time' //指定元素
    });

    form.on('select(eventCity)', function(data){
        var cityName = data.value;
        var event_map_layout = {
            autosize: true,
            height:600,
            width:800,
            title:'Event Map',
            hovermode:'closest',
            mapbox: {
                bearing:0,
                center: {
                    lat:33.78,
                    lon:-122.42
                },
                pitch:0,
                zoom:5
            },
        }
        plot_map('Event-Map', base_path +'event/cityEventMap/'+cityName, event_map_layout);
    })

})