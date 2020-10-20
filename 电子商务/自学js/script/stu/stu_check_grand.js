
var per_class=[];

var GPA_detail={"select_credit":"96", "areadly_credit":"96", "avg_grade":"85.73", "avg_GAP":"3.57"};



$(".btn").click(function (e) { 
    
    var teams=$("#teams").val()
    var start_years=$("#start_class").val()
    console.log(teams)
    console.log(start_years)

    $.ajax({
        type: "post",
        url: "http://localhost:7070/untitled_war_exploded/check_grand",
        data: 
           {
               years:$("#start_class").val(),
               team:$("#teams").val()
           }
        ,
        dataType: "text",
        success: function (response) {
            var json=JSON.parse(response)
            console.log(json[0])
            var tbody=document.getElementById('tbmain');

            if(json.length!=0)
            {
                $("td").remove();          
            for (var i=0;i<json.length;i++)
            {
            var trow=getDatarow_not_null(json[i]);
            tbody.appendChild(trow);
            }
            }

        }
    });
});





window.onload=function()
{
    if(GPA_detail.length==0)
    {
        document.getElementById("select_credit").innerHTML="";
        document.getElementById("areadly_credit").innerHTML="";
        document.getElementById("avg_grade").innerHTML="";
        document.getElementById("avg_GAP").innerHTML="";
    }
    else
    {
        document.getElementById("select_credit").innerHTML=GPA_detail["select_credit"];
        document.getElementById("areadly_credit").innerHTML=GPA_detail["areadly_credit"];
        document.getElementById("avg_grade").innerHTML=GPA_detail["avg_grade"];
        document.getElementById("avg_GAP").innerHTML=GPA_detail["avg_GAP"];
    }
    
    var tbody=document.getElementById('tbmain');
    if(per_class.length==0)
    {
        var trow=getDatarow_null();
        tbody.appendChild(trow);
    }
    else
    {
        for (var i=0;i<per_class.length;i++)
        {
        var trow=getDatarow_not_null(per_class[i]);
        tbody.appendChild(trow);
        }
    }
    
}

function getDatarow_null()
{
        var row=document.createElement("tr")
        
        var Course_name=document.createElement("td")
        Course_name.innerHTML="无";
        row.appendChild(Course_name)
    
        var nature_course=document.createElement("td")
        nature_course.innerHTML="";
        row.appendChild(nature_course)
    
        var course_credits=document.createElement("td")
        course_credits.innerHTML="";
        row.appendChild(course_credits)
    
        var normal_grades=document.createElement("td")
        normal_grades.innerHTML="";
        row.appendChild(normal_grades)
    
        var mid_term_grades=document.createElement("td")
        mid_term_grades.innerHTML="";
        row.appendChild(mid_term_grades)
    
        var final_grades=document.createElement("td")
        final_grades.innerHTML="";
        row.appendChild(final_grades)
    
        var overall_grands=document.createElement("td")
        overall_grands.innerHTML="";
        row.appendChild(overall_grands)

        var grade_point=document.createElement("td")
        grade_point.innerHTML="";
        row.appendChild(grade_point)
        return row;
}


function getDatarow_not_null(h)
{
    var row=document.createElement("tr")
    // 创建行
    {
    var Course_name=document.createElement("td")
    Course_name.innerHTML=h.coursename;
    row.appendChild(Course_name)

    var nature_course=document.createElement("td")
    nature_course.innerHTML=h.coursenature;
    row.appendChild(nature_course)

    var course_credits=document.createElement("td")
    course_credits.innerHTML=h.coursecredit;
    row.appendChild(course_credits)

    var normal_grades=document.createElement("td")
    normal_grades.innerHTML=h.usualgrand;
    row.appendChild(normal_grades)

    var mid_term_grades=document.createElement("td")
    mid_term_grades.innerHTML=h.midgrand;
    row.appendChild(mid_term_grades)

    var final_grades=document.createElement("td")
    final_grades.innerHTML=h.finalgrand;
    row.appendChild(final_grades)

    var overall_grands=document.createElement("td")
    overall_grands.innerHTML=h.totalgrand;
    row.appendChild(overall_grands)

    var grade_point=document.createElement("td")
    grade_point.innerHTML=h.GAP;
    row.appendChild(grade_point)


    }
    return row
}