$(function() {
    layui.use('layer', function() {
        var $ = layui.jquery,
            layer = layui.layer;

        $('#video1').on('click', function() {
            layer.open({
                title: 'YouTube',
                maxmin: true,
                type: 2,
                content: 'video.html',
                area: ['800px', '500px']
            });
        });

    });
});