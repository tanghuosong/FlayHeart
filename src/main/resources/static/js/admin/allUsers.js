/**
 * *Created by Administrator on 2017/6/6.
 */
$(function () {
    var msg ='';
    $.ajax({
        type: "GET",
        url: "/v1/user/getAllUserByStateWithPage",
        async:false,
        data: {state:0,pageSize:10,pageNum:0},
        success: function (result) {
             msg = result;
        }
    });

    layui.use('form',function () {
        var $ = layui.jquery,form = layui.form();
        //全选
        form.on('checkbox(allChoose)', function (data) {
            var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
            child.each(function (index, item) {
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
        });
    });
    layui.use(['laytpl','laypage'], function(){
        var laytpl = layui.laytpl,laypage = layui.laypage;
        var data ={
            "list":msg.content
        };
        var getTpl = demo.innerHTML;
        laytpl(getTpl).render(data, function(html){
            view.innerHTML = html;
        });

        //分页
        laypage({
            cont: 'pageDemo', //分页容器的id
            pages: msg.totalPages, //总页数
            skin: '#5FB878', //自定义选中色值
            first: msg.first,
            last:  msg.last,
            //skip: true, //开启跳页
            jump: function(obj, first){
                if(!first){
                    layer.msg('第'+ obj.curr +'页');
                }
            }
        });
    });
});
