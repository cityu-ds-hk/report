
layui.use(['jquery', 'form', 'layer','carousel'], function(){
  var $ = layui.$;
  var layer = layui.layer;
  var carousel = layui.carousel;
  //建造实例
  carousel.render({
    elem: '#test1'
    ,width: '100%' //设置容器宽度
    ,arrow: 'always' //始终显示箭头
    ,height: '490px'
    //,anim: 'updown' //切换动画方式
    });


    // 表单
 
    var form = layui.form;

});


//plotly.js 画图部分
window.onload = function(){ 

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
