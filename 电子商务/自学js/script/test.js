
var data
var value



$('#table').bootstrapTable({
        striped : false, //是否显示行间隔色
        pageNumber : 1, //初始化加载第一页
        pagination : true,//是否分页
        pageSize : 10,//单页记录数
        showRefresh : true,
        showColumns:true,
        showColumnsToggleAll:true,
        url:"http://localhost:7070/untitled_war_exploded/test",
        method:"GET",
        columns: [
        {
            checkbox:true
        },
        {
        field: 'testid',
        title: '学号',
        align:'center'
        }, {
        field: 'testname',
        title: '姓名',
        align:'center'
        }, {
        field: 'testtext',
        title: '电话号码',
        align:'center'
        },
        {
            field:"opertin",
            title:"操作",
            events:
            {
                'click .delk': function(e, value, row, index) 
                {
                    // $(".apply_cause").val(row.testname);
                    data=(row.testid)
                    console.log($(".apply_cause").val())

                }
            },
            formatter:function(value,item,index)
            {
                var btn="<button class='delk' data-toggle='modal' data-target='#myModal' >删除</button>"
                return btn
            }
        }
        ],
        })




        
$(".summit_apply").click(function (e) { 
    console.log(data)
    apply_cause=$(".apply_cause").val();
    $.ajax({
        type: "post",
        url: "http://localhost:7070/untitled_war_exploded/test",
        data: {
            id:data,
            apply_cause:apply_cause
        },
        dataType: "json",
        success: function (response) {
            $(".apply_cause").val("");
        }
    });
});
