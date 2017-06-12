/**
 ** Created by Administrator on 2017/6/8.
 */
$(function () {

    $("#state").val($("#selectValue").val());

    layui.use('form', function(){
        var form = layui.form();
        //监听提交
        form.on('submit(formDemo)', function(data){
            $.ajax({
                type: "POST",
                url: "/v1/board/updateBoard",
                async:true,
                data: {id:data.field.id,name:data.field.name,description:data.field.description,state:data.field.state},
                success: function (msg) {
                    if(msg.success){
                        layer.close(this);
                    }
                    layer.msg(msg.content);
                }
            });
            return false;
        });
    });
})