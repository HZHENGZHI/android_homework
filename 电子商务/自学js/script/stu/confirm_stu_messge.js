window.onload=function()
{
    $.ajax({
        type: "post",
        url: "http://localhost:7070/untitled_war_exploded/comfirm_stu_message",
        data: {

        },
        dataType: "text",
        success: function (response) {
            var obj=JSON.parse(response);
            $("#department").val(obj[0].department);
            $("#profession").val(obj[0].profession);
            $("#uid").val(obj[0].uid);
            $("#uname").val(obj[0].uname);
            $("#uclass").val(obj[0].uclass);
            $("#dormitory_building").val(obj[0].dormitory_building);
            $("#dormitory_num").val(obj[0].dormitory_num);
            $("#BedId").val(obj[0].BedId);
        }
    });
}