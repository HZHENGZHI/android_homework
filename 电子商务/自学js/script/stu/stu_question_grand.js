var obj=[]
var teachername=""
var coursename=""

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



$('#table').bootstrapTable({
    striped : false, //是否显示行间隔色
    pageNumber : 1, //初始化加载第一页
    pagination : true,//是否分页
   //单页记录数
    showColumnsToggleAll:true,
    pageSize : 10,//单页记录数
    showRefresh : true,
    url:"http://localhost:7070/untitled_war_exploded/check_question",
    method:"GET",
    search: true,
    columns: [
    {
        field:"uuid",
        title:"询疑编号",
        align:"center",
        cellStyle:{
            css:{
                "overflow": "hidden",
                "text-overflow": "ellipsis",
                "white-space": "nowrap"
                }
        }
    },
    {
    field: 'coursename',
    title: '课程名称',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    }, 
    {
    field: 'courseteacher',
    title: '任课老师',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    },
    {
    field: 'applycause',
    title: '申请原因',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    },
    {
    field: 'applytime',
    title: '申请时间',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    },
    {
    field: 'applystauts',
    title: '申请状态',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    },
    {
    field: 'checkname',
    title: '审核人名字',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    },
    {
    field: 'checkdetail',
    title: '审核说明',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    },
    {
    field: 'checktime',
    title: '预计审核时间',
    align:'center',
    cellStyle:{
        css:{
            "overflow": "hidden",
            "text-overflow": "ellipsis",
            "white-space": "nowrap"
            }
    }
    },

    {
        field:"opertin",
        title:"操作",
        events:
        {
            'click .back': function(e, value, row, index) 
            {
                // $(".apply_cause").val(row.testname);
                console.log(row.uuid)
                $.ajax({
                    type: "post",
                    url: "http://localhost:7070/untitled_war_exploded/delele_question_stu",
                    data:{
                        uuid:row.uuid
                    },
                    dataType: "text",
                    success: function (response) {

                    }
                });
            }
        },
        formatter:function(value,item,index)
        {
            var btnfix=" <button type='button' class='btn btn-primary back' style='margin-right: 15px;'>撤销</button>"
            return btnfix
        },
        align:'center'
    }
    ],
    })


    $(".my-select").selectpicker();
    $(".addbtn").click(function (e) { 
        $.ajax({
            type: "post",
            url: "http://localhost:7070/untitled_war_exploded/get_question_list",
            data: 
            {
                id:"182017242"
            },
            dataType: "text",
            success: function (response) {
                obj=JSON.parse(response)
                var str=""
                for(var i=0;i<obj.length;i++)
                {
                    str+='<option data-subtext='+obj[i].teacher+'>'+obj[i].coursename+'</option>'
                    $(".selectpicker").html(str);
                   
                }
                    $(".selectpicker" ).selectpicker('refresh');
                  
            }
        });
    });

    $('.selectpicker').on('changed.bs.select', function (e, clickedIndex, isSelected, previousValue) {
        teachername=obj[clickedIndex].teacher
        coursename=obj[clickedIndex].coursename
      });

      
    $(".summit_apply").click(function (e) { 
        var data=new Date();
        var matdata=dateFormat("YY-mm-dd",data)
        var text=$(".apply_cause").val();
        console.log(text)
        console.log(teachername)
        console.log(coursename)
        
        $.ajax({
            type: "post",
            url: "http://localhost:7070/untitled_war_exploded/check_question",
            data: 
            {
                coursename:coursename,
                teacher:teachername,
                data:matdata,
                coursetext:text,
                stuid:"182017242"
            },
            dataType: "text",
            success: function (response) {

            }
        });
        $(".apply_cause").val("");
    });