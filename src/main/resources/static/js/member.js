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
      title:'小组数量时间变化图'
     }
     var data = [number_groups]
    Plotly.newPlot('Member-TimeLineChart', data,layout);
  
  
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
    
    Plotly.newPlot('Member-ScatterChart', data, layout);
  
   }