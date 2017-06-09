/**
 ** Created by Administrator on 2017/6/8.
 */
$(function () {
    layui.use('form', function(){
        var form = layui.form();
        //监听提交
        form.on('submit(formDemo)', function(data){
            // layer.msg(JSON.stringify(data.field));
            $.ajax({
                type: "POST",
                url: "/v1/board/saveBoard",
                async:true,
                data: {name:data.field.name,description:data.field.description},
                success: function (meg) {
                    if(meg.success){
                        $("input[name='name']").val("");
                        $("textarea[name='description']").val("");
                    }
                    layer.msg(meg.content);
                }
            });
            return false;
        });
    });
})