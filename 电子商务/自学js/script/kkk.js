$("#lodin").click(function (e) { 
    var id=document.getElementById("id").value;
    var pw=document.getElementById("pw").value;
    if(id == "123" && pw == "123")
    {
       
        window.location.href="..//html/test.html"
    }
    else
    {
        alert("no")
        $("#id").val("");
        $("#pw").val("");

    }
});

$("#rember_me").click(function (e) { 
    var staut=$("#rember_me").prop("checked")//记录当前checkbox状态
    console.log(staut);
});