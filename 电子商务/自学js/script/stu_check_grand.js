
var per_class=[];

var GPA_detail={"select_credit":"96", "areadly_credit":"96", "avg_grade":"85.73", "avg_GAP":"3.57"};


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
        var trow=getDatarow_null(per_class[i]);
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
    {
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
    
        var retake_grands=document.createElement("td")
        retake_grands.innerHTML="";
        row.appendChild(retake_grands)
    
        var minor_tag=document.createElement("td")
        minor_tag.innerHTML="";
        row.appendChild(minor_tag)
    
        var grade_point=document.createElement("td")
        grade_point.innerHTML="";
        row.appendChild(grade_point)
        }
        return row;
}


function getDatarow_not_null(h)
{
    var row=document.createElement("tr")
    // 创建行
    {
    var Course_name=document.createElement("td")
    Course_name.innerHTML=h.Course_name;
    row.appendChild(Course_name)

    var nature_course=document.createElement("td")
    nature_course.innerHTML=h.nature_course;
    row.appendChild(nature_course)

    var course_credits=document.createElement("td")
    course_credits.innerHTML=h.course_credits;
    row.appendChild(course_credits)

    var normal_grades=document.createElement("td")
    normal_grades.innerHTML=h.normal_grades;
    row.appendChild(normal_grades)

    var mid_term_grades=document.createElement("td")
    mid_term_grades.innerHTML=h.mid_term_grades;
    row.appendChild(mid_term_grades)

    var final_grades=document.createElement("td")
    final_grades.innerHTML=h.final_grades;
    row.appendChild(final_grades)

    var overall_grands=document.createElement("td")
    overall_grands.innerHTML=h.overall_grands;
    row.appendChild(overall_grands)

    var retake_grands=document.createElement("td")
    retake_grands.innerHTML=h.retake_grands;
    row.appendChild(retake_grands)

    var minor_tag=document.createElement("td")
    minor_tag.innerHTML=h.minor_tag;
    row.appendChild(minor_tag)

    var grade_point=document.createElement("td")
    grade_point.innerHTML=h.grade_point;
    row.appendChild(grade_point)
    }
    return row
}