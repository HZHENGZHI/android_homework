$(".btn").click(function(){
    console.log("hello world");
});

$("#IMG").click(function (e) { 
    $(this).attr("src","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1887369461,1234086596&fm=26&gp=0.jpg")
});
var img=["https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1819216937,2118754409&fm=26&gp=0.jpg","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1887369461,1234086596&fm=26&gp=0.jpg","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2839262297,1897381364&fm=26&gp=0.jpg"];
$("li").click(function (e) { 
    var i=$(this).index();
    console.log(i);
    $("#IMG").attr("src",img[i])
});

$(document).mousemove(function (e) { 
    // values: e.clientX, e.clientY, e.pageX, e.pageY
    console.log(e.pageX+"     "+e.pageY);
    $("#IMG").css({ "width": "100px", "height": "100px","position": "absolute", "left": e.pageX, "top": e.pageY });
});

$.ajax({
    type: "method",
    url: "url",
    data: "data",
    dataType: "dataType",
    success: function (response) {
        
    },
});