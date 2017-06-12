/**
 * * Created by Administrator on 2017/6/6.
 */
$(function () {
    var pageNum = 1;

    getData(pageNum)

    function getData(pageNum) {
        $.ajax({
            type: "GET",
            url: "/v1/board/getAllBoard",
            async:false,
            // data: {conditionType:"all",conditionValue:0,pageSize:10,pageNum:pageNum},
            success: function (result) {
                showTable(pageNum,result);
            }
        });
    }
    
    function showTable(pageNum,result) {
        // var list = result.content;
        // var totalPages = result.totalPages;
        var contentHtml = '';
        $.each(result,function (v,item) {
            contentHtml +='<tr>' +
                '<td>'+item.id +'</td>' +
                '<td>'+item.name+'</td>' +
                '<td>'+item.description+'</td>' +
                '<td>'+item.stateDisplay+'</td>' +
                '<td>'+item.createTime+'</td>' +
                '<td><a  class="updateBtn" href="javascript:void(0)" title="'+item.id+'"><i class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#xe642;</i></a></td>' +
                '<th><a  class="deleteBtn" href="javascript:void(0)" title="'+item.id+'"><i class="layui-icon" style="font-size: 30px; color: #FF0000;">&#x1006;</i></a></td>' +
                '</tr>';
        });
        $("#view").html(contentHtml);
    }

    $(".deleteBtn").click(function () {
        // alert(this.title);
        var obj = $(this);
        $.ajax({
            url:"/v1/board/deleteBoardById",
            type:"POST",
            data:{id:this.title},
            success:function (msg) {
                if(msg.success){
                    obj.parent().parent().remove();
                }
                layui.use('layer',function () {
                    layer.msg(msg.content);
                })
            }
        });
    });

    $(".updateBtn").click(function () {
        var obj = this.title;
        layui.use('layer',function () {
            layer.open({
                title:"修改版块信息",
                type: 2
                ,area: ['500px', '400px']
                ,shade: 0
                ,maxmin: true,
                content: '/admin/editBoard.html?id='+obj,
                cancel: function(index){
                    // if(confirm('确定要关闭么')){
                        layer.close(index)
                    // }
                    return false;
                }
            });
        });
    });

});