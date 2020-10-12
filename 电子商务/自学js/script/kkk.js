$("#lodin").click(function (e) { 
    // var id=document.getElementById("id").value;
    // var pw=document.getElementById("pw").value;
    // if(id == "123" && pw == "123")
    // {
       
    //     window.location.href="..//html/home_page.html"
    // }
    // else
    // {
    //     alert("no")
    //     $("#id").val("");
    //     $("#pw").val("");

    // }
    $.ajax({
        type: "post",
        url: "http://localhost:7070/untitled_war_exploded/demo",
        data: {
            name:$("#id").val(),
            pw:$("#pw").val(),
            staut:0
        },
        dataType: "text",
        success: function (response) {
            if(response==1)
            {
                window.open("../html/home_page.html");
            }
            else
            {
                alert("登录失败")
            }
        }
    });

});

$("#rember_me").click(function (e) { 
    var staut=$("#rember_me").prop("checked")//记录当前checkbox状态
    console.log(staut);
});

