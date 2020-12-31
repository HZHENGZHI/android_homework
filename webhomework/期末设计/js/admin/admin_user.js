$('#table').bootstrapTable({
    search:true,
    pagination:true,
    paginationLoop:true,
    toolbar:'toolbar',
    local:'zh-CN',
    toolbar:'#toolbar',//工具栏
    url: "http://localhost:7070/untitled2_war/admin_user",
    method:"GET",
   
columns: [{
    field: 'userid',
    title: '用户名',
}, {
    field: 'truename',
    title: '真实姓名',
    width:300,
    clickToSelect:true,
}, 
{
    field:'birthday',
    title:"生日",
    sortable:true,
},
{
    field: 'sex',
    title: '性别',
    sortable:true,
},
{
    field:'opertion',
    title:'操作',
    events:
    {
       'click .del':function(e,value,row,index)
       {
           alert("正在执行删除操作，且不可撤回")
           $.ajax({
               type: "post",
               url: "http://localhost:7070/untitled2_war/admin_user",
               data: {
                   userid:row.userid
                },
               dataType: "text",
               success: function (response) {
                $('#table').bootstrapTable('load', JSON.parse(response));
               }
           });

       }
       ,
    },
    formatter:function(value,item,index)
        {
            item.id=false;
             var btnfix = '<button type="button" class="btn shadow-none del"> <img src="/img/bootstrap-icons-1.2.1/Trash.svg " class="text-success" alt="" width="22" height="22" > </button>'
             return btnfix
        },
        width:300,
}
],
data:[
    {}
]
})
