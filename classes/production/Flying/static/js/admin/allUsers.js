/**
 * Created by Administrator on 2017/6/6.
 */

$(function () {
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

        $.ajax({
        type: "POST",
        url: "/v1/topic/getTopicByCondition",
        data: {conditionType:"all",conditionValue:0,pageSize:10,pageNum:0},
        success: function (msg) {
            console.log(msg);
            if(msg.success){
                console.log(msg);
                var data={
                    "title":msg
                    ,"list":[{"modname":"弹层","alias":"layer","site":"layer.layui.com"},{"modname":"表单","alias":"form"}]
                }
                // window.location = "/admin/index.html";
            }else{
                // alert(msg.content);
            }
        }
    });
});