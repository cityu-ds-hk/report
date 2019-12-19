//plotly.js 画图部分
window.onload = function(){ 

    // member分城市饼图
    var group_pie_data = [{
      values: [19, 26, 55],
      labels: ['Residential', 'Non-Residential', 'Utility'],
      type: 'pie'
    }];
  
    var layout = {
      height: 400,
      width: 500
    };
  
    Plotly.newPlot('Member-PieChart',group_pie_data, layout);
  
    //小组数量时间变化图
      var number_groups = {
        x: [1, 2, 3, 4],
        y: [10, 15, 13, 17],
        type: 'scatter'
      };
     var layout ={
      width:1000,
      height:400
     }
     var data = [number_groups]
    Plotly.newPlot('Member-TimeLineChart', data,layout);
  
  
   }