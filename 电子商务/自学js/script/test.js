

$('#table').bootstrapTable({
    ajax:function (request)
    {
        $.ajax({
            type: "get",
            url: "http://localhost:7070/untitled_war_exploded/test",
            data: "",
            dataType: "json",
            success: function (response) {
                request.success(
                    {
                        row:response
                    }
                );
                $('#table').bootstrapTable('load', response);
            }
        });
    },
striped : false, //是否显示行间隔色
pageNumber : 1, //初始化加载第一页
pagination : true,//是否分页
pageSize : 10,//单页记录数
showRefresh : true,
showColumns:true,
showColumnsToggleAll:true,
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
            console.log("123")
            $(".apply_cause").val(row.testname);
            $(".summit_apply").click(function (e) { 
               console.log($(".apply_cause").val())
            });
            $("#table").bootstrapTable('updateCell', {index:index, field: 'testname', value: 'Updated Name'})//index列位置,field列id,value修改值
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


$(".fa").click(function (e) { 
    $.ajax({
        type: "get",
        url: "http://localhost:7070/untitled_war_exploded/test",
        data: "",
        dataType: "json",
        success: function (response) {
           (
                {
                    row:response
                }
            );
            $('#table').bootstrapTable('load', response);
        }
    });
});