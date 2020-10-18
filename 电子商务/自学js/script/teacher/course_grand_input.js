$(".fileupload").filesUpload({
    url:'http://up.qiniu.com',//上传地址
    multiple: true,  //是否多文件上传
    accept: '', //input accept属性
    fileTypes:'png,webp,mp4',//文件格式
    buttonText: '选择文件',  //按钮文字
    onUploadStart: function() {}, //请求开始
    onUploadSuccess: function() {},//请求成功
    onUploadComplete: function() {},//请求完成
    onUploadError:function(res, xhr){//请求错误
        console.log(res,xhr)
    }
})