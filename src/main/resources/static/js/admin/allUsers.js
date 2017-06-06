/**
 * Created by Administrator on 2017/6/6.
 */
$(function () {
    var msg ='';
    $.ajax({
        type: "POST",
        url: "/v1/topic/getTopicByCondition",
        async:false,
        data: {conditionType:"all",conditionValue:0,pageSize:10,pageNum:0},
        success: function (result) {
             msg = result;
        }
    });
    layui.use('form', function() {

        var $ = layui.jquery, form = layui.form();
        //全选
        form.on('checkbox(allChoose)', function (data) {
            var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
            child.each(function (index, item) {
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
        });

    });

    layui.use('laytpl', function(){
        var laytpl = layui.laytpl;

        var data ={
            "list":msg.content
        }
        var getTpl = demo.innerHTML;
        laytpl(getTpl).render(data, function(html){
            view.innerHTML = html;
        })
    });
});
