/*
      * 可传递参数
      * ajax({
      *     url: 连接
      *     type: get/post
      *     data: 参数
      *     dataType: "json" 默认JSON
      *     selfDeal： 服务器返回处理失败，即data.code !== 0的情况下
      *          =true: 则直接将data传给success()函数
      *          =false: 默认：弹出错误原因后， 再将data传给success()函数
      *     success: 成功回调
      *     error: 失败回调
      *          如果不为空则传递给error方法处理错误情况
      *          如果为空则弹出错误提示及原因
      * })
      */
layui.use(['jquery', 'form', 'layer'], function(){
    var $ = layui.$;
    var form = layui.form;
    var layer = layui.layer;
    //校验
    form.verify({
        userId: function (value, item) { //value：表单的值、item：表单的DOM对象
            if (value.length == 0) {
                return "user name can not be null";
            }
        },
        password: [
            /^[\S]{0,12}$/
            ,'the length of password must be within 0~12'
        ]
    });

    form.on('submit(login)', function(data){
        $.ajax({
            url: "doLogin",
            type: "POST",
            async: true,
            data: {'userName':$('#userName').val(), 'password': $('#password').val()},
            dataType: 'text',
            contentType: "application/x-www-form-urlencoded",
            success: function(result) {
                console.log(result.toString())
                if(result.toString().indexOf('<title>Meetup Data Analysis</title>') != -1){
                    window.location.href = "admin";
                }else{
                    window.location.href = "login";
                }
            },
            error: function (result) {
                console.log(result);
            }
        });
        return false;
    });
});