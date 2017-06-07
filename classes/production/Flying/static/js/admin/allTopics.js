/**
 * * Created by Administrator on 2017/6/6.
 */
$(function () {
    var pageNum = 1;

    getData(pageNum)

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
        var contentHtml = '<table class="layui-table"><colgroup><col width="50"/><col width="150"/><col width="150"/><col width="200"/><col/></colgroup>'+
            '<thead><tr><th><input name="" lay-skin="primary" lay-filter="allChoose" type="checkbox"/><div class="layui-unselect layui-form-checkbox" lay-skin="primary">' +
            '<i class="layui-icon"></i></div></th><th>编号</th><th>标题</th><th>发表时间</th><th>内容</th></tr></thead>'+
            '<tbody id="view">';
        $.each(list,function (v,item) {
            contentHtml +='<tr><td><input name="" lay-skin="primary" type="checkbox"/><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><i class="layui-icon"></i></div></td>' +
                '<td>'+item.id +'</td><td>'+item.title+'</td><td>'+item.postTime+'</td><td>'+item.content+'</td></tr>';
        });
        contentHtml = contentHtml+'</tbody></table>';
        $("#tableContent").html(contentHtml);

        layui.use('form',function () {
            var form = layui.form();
            //全选
            form.on('checkbox(allChoose)', function (data) {
                var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
                child.each(function (index, item) {
                    item.checked = data.elem.checked;
                });
                form.render('checkbox');
            });
        });

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
