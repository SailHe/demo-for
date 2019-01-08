<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>上传</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!-- 本地资源，要加载webuploader.js、webuploader.css、webuploader.min.js、jquery.js -->
    <%--type="text/javascript" --%>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <%--<script type="text/javascript" src="utils/webuploader/webuploader.js"></script>--%>
    <%--<link rel="stylesheet" href="utils/webuploader/webuploader.css" type="text/css"/>--%>
    <%--<script type="text/javascript" src="utils/webuploader/webuploader.min.js"></script>--%>
    <script type="text/javascript" src="./webuploader.min.js"></script>
    <!--
        CDN资源
        <script scr="http://cdn.staticfile.org/webuploader/0.1.0/webuploader.js"></script>
        <script scr="http://cdn.staticfile.org/webuploader/0.1.0/webuploader.min.js"></script>
    -->

</head>
<body>
<div id="uploader" class="wu-example">
    <!--用来存放文件信息-->
    <div id="fileList" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择文件</div>
        <button id="filePickerBtn" class="btn btn-default">开始上传</button>
    </div>
</div>
</body>

<script type="text/javascript">

    $(function () {
        // @see http://fex.baidu.com/webuploader/
        /******  初始化    ******/
        let $ = jQuery,
            $list = $('#fileList'),
            $btn = $('#filePickerBtn'),
            state = 'pending',
            ratio = window.devicePixelRatio || 1,
            thumbnailWidth = 100 * ratio,
            thumbnailHeight = 100 * ratio,
            uploader;
        // 初始化
        uploader = WebUploader.create({

            // 选完文件后，是否自动上传。
            auto: false,

            // swf文件路径
            //swf: BASE_URL + '/js/Uploader.swf',

            // 文件接收服务端。
            server: 'UploadTestServletFileupload',

            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker',

            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });

        /******  选择文件    ******/
        // 当有文件添加进来的时候
        uploader.on('fileQueued', function (file) {
            let $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img src="">' +
                '<div class="info">' + file.name + '</div>' +
                '</div>'
                ),
                $img = $li.find('img');


            // $list为容器jQuery实例
            $list.append($li);

            // 创建缩略图
            // 如果为非图片文件，可以不用调用此方法。
            // thumbnailWidth x thumbnailHeight 为 100 x 100
            uploader.makeThumb(file, function (error, src) {
                if (error) {
                    $img.replaceWith('<span>不能预览</span>');
                    return;
                }

                $img.attr('src', src);
            }, thumbnailWidth, thumbnailHeight);
        });

        /******  上传状态    ******/
        // 文件上传过程中创建进度条实时显示。
        uploader.on('uploadProgress', function (file, percentage) {
            const $li = $('#' + file.id);
            let $percent = $li.find('.progress span');

            // 避免重复创建
            if (!$percent.length) {
                $percent = $('<p class="progress"><span></span></p>')
                    .appendTo($li)
                    .find('span');
            }

            $percent.css('width', percentage * 100 + '%');
        });

        // 文件上传成功，给item添加成功class, 用样式标记上传成功。
        uploader.on('uploadSuccess', function (file) {
            $('#' + file.id).addClass('upload-state-done');
        });

        // 文件上传失败，显示上传出错。
        uploader.on('uploadError', function (file) {
            const $li = $('#' + file.id);
            let $error = $li.find('div.error');

            // 避免重复创建
            if (!$error.length) {
                $error = $('<div class="error"></div>').appendTo($li);
            }

            $error.text('上传失败');
        });

        // 完成上传完了，成功或者失败，先删除进度条。
        uploader.on('uploadComplete', function (file) {
            $('#' + file.id).find('.progress').remove();
        });

        /******  上传按钮    ******/
        //上传的按键
        $btn.on('click', function () {
            console.log(state);
            if (state.toString() === 'uploading') {
                uploader.stop();
            } else {// pending
                uploader.upload();
            }
        });
    });
</script>
</html>
