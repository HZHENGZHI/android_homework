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

// $(".box").mouseenter(function () { 
//     $(this).addClass("bg");
// }).mouseleave(function () { 
//     $(this).removeClass("bg");
// });