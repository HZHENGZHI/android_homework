$("#lodin").click(function (e) { 
    $.ajax({
        type: "post",
        url: "http://localhost:7070/untitled_war_exploded/demo",
        data: {
            name:$("#id").val(),
            pw:$("#pw").val()
        },
        dataType: "text",
        success: function (response) {
            var obj=JSON.parse(response)
            if(obj.staut)
            {
               window.location.href="../html/home_page.html"
            }
            else
            {
                alert("登录失败")
            }
        },
        error:function()
        {
            alert("服务器出错")
        }
    });

});

$("#rember_me").click(function (e) { 
    var staut=$("#rember_me").prop("checked")//记录当前checkbox状态
    console.log(staut);
});
