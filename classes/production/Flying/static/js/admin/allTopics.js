/**
 * * Created by Administrator on 2017/6/6.
 */
$(function () {
    var pageNum = 1;

    getData(pageNum);

    function getData(pageNum) {
        $.ajax({
            type: "POST",
            url: "/v1/topic/getTopicByCondition",
            async:false,
            data: {conditionType:"all",conditionValue:0,pageSize:10,pageNum:pageNum},
            success: function (result) {
                showTable(pageNum,result);
            }
        });
    }
    
    function showTable(pageNum,result) {
        var list = result.content;
        var totalPages = result.totalPages;
        var contentHtml = '';
        $.each(list,function (v,item) {
            contentHtml +='<tr>' +
                '<td>'+item.id +'</td>' +
                '<td>'+item.title+'</td>' +
                '<td><a class="topic_board" style="color: #1E9FFF;" href="javascript:void(0)" title="'+item.board.id+'">'+item.board.name+'</a></td>' +
                '<td><a class="topic_user" style="color: #1E9FFF;" href="javascript:void(0)" title="'+item.user.id+'">'+item.user.name+'</a></td>' +
                '<td>'+item.postTime+'</td>' +
                '<td class="content">'+item.content+'</td>'+
                '<td >'+item.views+'</td>'+
                '<td >'+item.favorites+'</td>'+
                '<td><a class="topic-details" style="color: #1E9FFF;" href="javascript:void(0)">查看详情</a></td>' +
                '<td><a  class="updateBtn" href="javascript:void(0)" title="'+item.id+'"><i class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#xe642;</i></a></td>' +
                '<th><a  class="deleteBtn" href="javascript:void(0)" title="'+item.id+'"><i class="layui-icon" style="font-size: 30px; color: #FF0000;">&#x1006;</i></a></td>' +
                '</tr>';
        });
        $("#view").html(contentHtml);

        layui.use(['laytpl','laypage'], function() {
            var laypage = layui.laypage;
            laypage({
                cont: 'pageDemo', //分页容器的id
                pages: totalPages, //总页数
                skin: '#5FB878', //自定义选中色值
                curr: pageNum || 1,
                first: result.first,
                last:  result.last,
                skip: true, //开启跳页
                jump: function (obj, first) {
                    if (!first) {
                        getData(obj.curr);
                    }
                }
            });
        });
    }

    $(".topic_board").click(function () {

    });

    $(".topic_user").click(function () {

    });

    $(".topic-details").click(function () {
        var content = $(this).parent().parent().children(".content").text();

    });

    $(".deleteBtn").click(function () {
        // alert(this.title);
        // var obj = $(this);
        // $.ajax({
        //     url:"/v1/board/deleteBoardById",
        //     type:"POST",
        //     data:{id:this.title},
        //     success:function (msg) {
        //         if(msg.success){
        //             obj.parent().parent().remove();
        //         }
        //         layui.use('layer',function () {
        //             layer.msg(msg.content);
        //         })
        //     }
        // });
    });

    $(".updateBtn").click(function () {
        // var obj = this.title;
        // layui.use('layer',function () {
        //     layer.open({
        //         title:"修改版块信息",
        //         type: 2
        //         ,area: ['500px', '400px']
        //         ,shade: 0
        //         ,maxmin: true,
        //         content: '/admin/editBoard.html?id='+obj,
        //         cancel: function(index){
        //             // if(confirm('确定要关闭么')){
        //             layer.close(index)
        //             // }
        //             return false;
        //         }
        //     });
        // });
    });
});
