$('#table').bootstrapTable({
    search:true,
    pagination:true,
    paginationLoop:true,
    toolbar:'toolbar',
    local:'zh-CN',
    url:"",
    method:"GET",
    
   
columns: [{
    field: 'id',
    title: '序号',
    checkbox:true,

}, {
    field: 'book_name',
    title: '书名',
    width:300,
    clickToSelect:true,
}, 
{
    field:'category',
    title:"类别",
    sortable:true,
},
{
    field: 'book_price',
    title: '价钱',
    sortable:true,
},
{
    field:'opertion',
    title:'操作',
    events:
    {
       'click .back':function(e,value,row,index)
       {
        //    console.log(row);
       }
    },
    formatter:function(value,item,index)
        {
            item.id=false;
            var btnfix=" <button type='button' class='btn btn-primary back' style='margin-right: 15px;'>加入购物车</button>"
            return btnfix
        },
}
],
data: [
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'Item 2',
    category:"计算机",
    book_price: '$2'
},
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
{
    id: '',
    book_name: 'kk',
    category:"计算机",
    book_price: 'java',
}, 
]
})
$(".back").click(function (e) { 
    var data=$("#table").bootstrapTable('getSelections')
    var k=JSON.stringify(data)
    if(data==null)
    {
        console.log("null");
    }
    for(i=0;i<data.length;i++)
    {
        console.log(data[i]);
    }
    
});
