$('#table').bootstrapTable({
    // search:true,
    // pagination:true,
    // paginationLoop:true,
    // toolbar:'toolbar',
    // local:'zh-CN',
    // url:"",
    // method:"GET",
    // toolbar:'#toolbar',//工具栏
   
columns: [
    {
    field: 'id',
    title: '序号',
    checkbox:true,
    },
    {
        field:'name',
        title:'商品名称',
        cellStyle: {
            css: {
                // "text-align": "center",
                "font-size": "x-large"
            }
        },
       
    },
    {
        field:'nums',
        title:'商品数量',
        cellStyle: {
            css: {
                // "text-align": "center",
                "font-size": "x-large"
            }
        }
    },
    {
        field:'price',
        title:'商品金额',
        cellStyle: {
            css: {
                // "text-align": "center",
                "font-size": "x-large"
            }
        }
    },
    {
        field:'operation',
        title:'操作',
        events:
        {
            'click .del': function (e, value, row, index)
            {
                console.log(row)
            }
        },
        formatter: function (value, item, index) {
            item.id = false;
            var btnfix = '<button type="button" class="btn shadow-none del"> <img src="/img/bootstrap-icons-1.2.1/trash.svg " class="text-success" alt="" width="28" height="28" > </button>'
            return btnfix
        },
        width:360
    }
],
    data:
    [
        {
            name:'232',
            nums:'1',
            price:'1',
        },
        {
            name:"1222",
            nums:"2323",
            price:'123',
        },
        {
            name:"123",
            nums:"13",
            price:"2222"
        }
    ]
})
$(".total").click(function (e) { 
    var getcol_data=$("#table").bootstrapTable('getSelections')
    var total_nums=0
    for(var i=0;i<getcol_data.length;i++)
    {
        total_nums += parseInt(getcol_data[i].price*getcol_data[i].nums)
        
    }
    $(".total_num").html(total_nums);
});