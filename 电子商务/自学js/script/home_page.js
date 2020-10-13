var obj="";
var kkk;
window.onload=function()
{
    $.ajax({
        type: "get",
        url: "http://localhost:7070/untitled_war_exploded/couse_detail",
        data: "",
        dataType: "text",
        success: function (kkk) {
            obj=JSON.parse(kkk)
            console.log(obj)
            var courseList=new Array(5)
            for(var i=0;i<courseList.length;i++)
            {
              courseList[i]=new Array(15)
            }
            for (var i=0;i<courseList.length;i++)
            {
              for(var j=0;j<courseList[0].length;j++)
              {
                courseList[i][j]=""
              }
            }
            for(var i=0;i<obj.length;i++)
            {
              var due_time=obj[i].end-obj[i].start+1;
              var week_Name=obj[i].days-1
              console.log("周:"+week_Name)

              for(var j=obj[i].start-1;j<obj[i].end;j++)
              {
                courseList[week_Name][j]=""+obj[i].course_name+""
              }
              console.log(obj[i].course_name+":"+due_time)
            }
            var week = window.innerWidth > 360 ? ['周一', '周二', '周三', '周四', '周五','周六','周日'] : ['一', '二', '三', '四', '五','六','日'];
            var day = new Date().getDay();
            var courseType = [
              [{
                index: '1',
                name: '8:00'
              }, 1],
              [{
                index: '2',
                name: '8:50'
              }, 1],
              [{
                index: '3',
                name: '9:45'
              }, 1],
              [{
                index: '4',
                name: '10.35'
              }, 1],
              [{
                index: '5',
                name: '11:20'
              }, 1],
              [{
                index: '6',
                name: '12:50'
              }, 1],
              [{
                index: '7',
                name: '13:40'
              }, 1],
              [{
                index: '8',
                name: '14:30'
              }, 1],
              [{
                index: '9',
                name: '15:15'
              }, 1],
              [{
                index: '10',
                name: '16:10'
              }, 1],
              [{
                index: '11',
                name: '16:55'
              }, 1],
              [{
                index: '12',
                name: '18:45'
              }, 1],
              [{
                index: '13',
                name: '19:30'
              }, 1]
              ,[{
                index: '14',
                name: '20:15'
              }, 1],
              [{
                index: '15',
                name: '21:05'
              }, 1],
            ];
            // 实例化(初始化课表)
            var Timetable = new Timetables({
              el: '#coursesTable',
              timetables: courseList,
              week: week,
              timetableType: courseType,
              highlightWeek: day,
             
            });
                }
            });

}
// $(".btn").click(function (e) { 
//     e.preventDefault();
//     console.log("yes")
//     $.removeCookie('name')
//     alert($.cookie("name"))
//     window.location.href="../html/login.html"
// });