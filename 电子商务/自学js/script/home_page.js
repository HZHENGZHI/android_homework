var obj="";
window.onload=function()
{
    $.ajax({
        type: "get",
        url: "http://localhost:7070/untitled_war_exploded/couse_detail",
        data: "",
        dataType: "text",
        success: function (response) {
            obj=JSON.parse(response)
            console.log(obj)
            for(var i=0;i<obj.length;i++)
            {
                // console.log(obj[i].days+"  "+obj[i].course_name+"  "+obj[i].course_where+" "+obj[i].start+" "+obj[i].end)
               
            }
        }
    });


    var row=3;
    var trlist=$(".course_list").children("tr")
    console.log(trlist)
    var tdarr=trlist.eq(0).find("td");
    console.log(tdarr[0])
    console.log(tdarr.eq(1).find(".kka"))

    // $(".kkc").attr("rowSpan",row);
    // console.log(tdarr[1].innerText)
    // $(".kkc").attr("rowSpan",row);
    // for(var i=0;i<trlist.length;i++)
    // {
    //     var tdarr=trlist.eq(i).find("td");
    //     console.log(tdarr[0].innerText)
    //     $(".kkc").attr("rowSpan",row);
    // }

























    // console.log("ues")
    // if($.cookie('name')==null)
    // {
    //     alert("no")
    //     window.location.href="../html/login.html"
    // }
}
// $(".btn").click(function (e) { 
//     e.preventDefault();
//     console.log("yes")
//     $.removeCookie('name')
//     alert($.cookie("name"))
//     window.location.href="../html/login.html"
// });