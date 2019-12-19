//plotly.js 画图部分
window.onload = function(){

  $.ajax({
        url: base_path + "common/allCount",
        dataType: "json",
        type: "GET",
        timeout: 2000,
        success: function (data) {
          if(data.status == 200){
            $('#Num-group').html(data.data['group'])
            $('#Num-member').html(data.data['member'])
            $('#Num-event').html(data.data['event'])
          }
        },
        error: function (msg) {}
      }
  )

  // group分城市饼图
  var group_pie_data = [{
    values: [19, 26, 55],
    labels: ['Residential', 'Non-Residential', 'Utility'],
    type: 'pie'
  }];

  var layout = {
    height: 400,
    width: 500
  };

  Plotly.newPlot('Group-PieChart',group_pie_data, layout);

  //group分category柱状图
  var group_bar_data = [
    {
      x: ['giraffes', 'orangutans', 'monkeys'],
      y: [20, 14, 23],
      type: 'bar'
    }
  ];
  
  Plotly.newPlot('Group-BarChart', group_bar_data,layout);

  //小组数量时间变化图
    var number_groups = {
      x: [1, 2, 3, 4],
      y: [10, 15, 13, 17],
      type: 'scatter'
    };
   var layout ={
    title:'小组数量时间变化图'
   }
   var data = [number_groups]
  Plotly.newPlot('Time-LineChart', data,layout);


  //分地区的小组数量统计图（分category）
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
    title:'不同城市各个category下小组数量统计'
  };
  
  Plotly.newPlot('Group-ScatterChart', data, layout);

  //GroupSize Barchart
  var group_bar_data = [
    {
      x: ['giraffes', 'orangutans', 'monkeys'],
      y: [20, 14, 23],
      type: 'bar'
    }
  ];

  var layout1 = {
    height: 400,
    width: 500
  };

  Plotly.newPlot('GroupSize-BarChart', group_bar_data,layout1);

  var layout = {
    height: 400,
    width: 500
  };
  plot_pie_city('Group-PieChart', 'group/areaCount', layout)
  plot_bar_category('Group-BarChart', 'group/categoryCount', layout)
  var layout ={
    title:'小组数量时间变化图'
  }
  plot_time_line('Time-LineChart', 'group/increasedCountTrend?', layout)

  var layout = {
    title:'不同城市各个category下小组数量统计'
  };

  plot_category_scatter('Group-ScatterChart', 'group/categoryGroups', layout);


  //GroupSize Barchart
  var group_bar_data = [
    {
      x: ['giraffes', 'orangutans', 'monkeys'],
      y: [20, 14, 23],
      type: 'bar'
    }
  ];

  var layout1 = {
    height: 400,
    width: 500
  };

  Plotly.newPlot('GroupSize-BarChart', group_bar_data,layout1);


  //GroupSize地图
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

  var layout = {
    autosize: true,
    hovermode:'closest',
    mapbox: {
      bearing:0,
      center: {
        lat:45,
        lon:-73
      },
      pitch:0,
      zoom:5
    },
  }

  Plotly.setPlotConfig({
    mapboxAccessToken: "pk.eyJ1IjoibmFuYmVpNjI5IiwiYSI6ImNrM2ZrMDZxaDA1OTYzbm80cmFocGRuaTcifQ.sxVwhNQvZvSv93ZxQljNIQ"
  })
  var layout = {
    height: 600,
    width: 800
  };
  Plotly.plot('GroupSize-Map', data, layout)


  //Top 20 Topics
  var trace1 = {
    x: [1, 2, 3, 4],
    y: [10, 11, 12, 13],
    mode: 'markers',
    marker: {
      size: [40, 60, 80, 100]
    }
  };

  var data = [trace1];

  var layout = {
    title: 'Marker Size',
    showlegend: false,
    height: 600,
    width: 600
  };

  Plotly.newPlot('TopTopics-Chart', data, layout);

}


  

//layui.js
//不同模块切换
layui.use(['element','laydate','layer','carousel'], function(){
  var element = layui.element;
  var laydate = layui.laydate;
  var $ = layui.$;
  var layer = layui.layer;
  var carousel = layui.carousel;
  var form = layui.form;

  //轮播图
  carousel.render({
    elem: '#test1'
    ,width: '100%' //设置容器宽度
    ,arrow: 'always' //始终显示箭头
    ,height: '490px'
    //,anim: 'updown' //切换动画方式
    });


    // 表单
    var form = layui.form;

  
  //执行一个laydate实例
  laydate.render({
    elem: '#start-time' //指定元素
  });

  laydate.render({
    elem: '#end-time' //指定元素
  });
});






