/**
 * *Created by Administrator on 2017/6/6.
 */
$(function () {
    var pageNum = 1;

    getData(pageNum)

    function getData(pageNum) {
        $.ajax({
            type: "GET",
            url: "/v1/user/getAllUserByStateWithPage",
            async:false,
            data: {state:0,pageSize:10,pageNum:pageNum},
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
                '<td>'+item.id +'</td><td>'+item.name+'</td>' +
                '<td>'+item.sex+'</td><td>'+item.email+'</td>' +
                '<td>'+item.phone+'</td><td>'+item.focusCount+'</td>' +
                '<td>'+item.registerTime+'</td><td>'+item.lastLoginTime+'</td>' +
                '<td>'+item.stateDisplay+'</td>' +
                '<td><a  class="updateBtn" href="javascript:void(0)" title="'+item.id+'"><i class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#xe642;</i></a></td>' +
                '<th><a  class="deleteBtn" href="javascript:void(0)" title="'+item.id+'"><i class="layui-icon" style="font-size: 30px; color: #FF0000;">&#x1006;</i></a></td>' +
                '</tr>';
        });
        $("#view").html(contentHtml);
        window.location.re

        // layui.use('form',function () {
        //     var form = layui.form();
        //     //全选
        //     form.on('checkbox(allChoose)', function (data) {
        //         var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
        //         child.each(function (index, item) {
        //             item.checked = data.elem.checked;
        //         });
        //         form.render('checkbox');
        //     });
        // });

        layui.use(['laypage'], function() {
            var laypage = layui.laypage;
            laypage({
                cont: 'pageDemo7', //分页容器的id
                pages: totalPages, //总页数
                skin: '#5FB878', //自定义选中色值
                curr: pageNum || 1,
                groups: 5,
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
