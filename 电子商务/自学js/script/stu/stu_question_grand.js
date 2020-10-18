
function dateFormat(fmt, date) {
    let ret;
    const opt = {
        "Y+": date.getFullYear().toString(),        // 年
        "m+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "H+": date.getHours().toString(),           // 时
        "M+": date.getMinutes().toString(),         // 分
        "S+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
    };
    for (let k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
            fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        };
    };
    return fmt;
}

$(".refresh").click(function () { 
    var data=new Date()
    var data1=dateFormat("YYYY-mm-dd HH:MM:SS", data)
    console.log(data1)
});

 function refresh_data()
 {
     //从后端数据库中获取数据，重新渲染表格
 }

 $(".add_question").click(function (e) { 

 });
 $(".summit_apply").click(function (e) { 
     var len=$(".apply_cause").val();
     var data=new Date()
     var time=(dateFormat("YYYY-mm-dd HH:MM:SS", data));
     if(len.length>=5)
     {
         $(".apply_cause").val("");
         alert("超出字数限制")
         $(".notice").css("color","red");
     }

     $.ajax({
         type: "post",
         url: "http://localhost:7070/untitled_war_exploded/check_question",
         data: 
        { 
             course_name : $(".course_name").val(),
             apply_caouse:$(".apply_cause").val(),
             apply_time: time
        },
         dataType: "text",
         success: function (response) {
             console.log("yes")
         }
     });
 });
 