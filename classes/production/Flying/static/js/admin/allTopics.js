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
                '<td>'+v+'</td>' +
                '<td>'+v+'</td>' +
                '<td>'+item.postTime+'</td>' +
                '<td>'+item.content+'</td>' +
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
});
