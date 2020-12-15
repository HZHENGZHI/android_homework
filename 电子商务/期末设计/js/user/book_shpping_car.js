function object_data(name,nums,price)
{
   
    this.name = name;
    this.nums=nums;
    this.price=price;
}
var data=[]
data[0]=new object_data("1231","123","123");
data[1] = new object_data("1232", "123", "123");
data[2] = new object_data("1233", "123", "123")


$('#table').bootstrapTable({
    // search:true,
    // pagination:true,
    // paginationLoop:true,
    // toolbar:'toolbar',
    local:'zh-CN',
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
                var temp=new object_data(row.name,row.price,row.nums)
                console.log(data)
                data.splice(index,1);
                console.log(data)
                 $("#table").bootstrapTable('load', data)
            },
            'click .check_detail':function(e,value,row,index)
            {
               var origin = row.nums;
                $(".count_num").html(origin);
                $(".objectname").html(row.name);
            },
        },
        formatter: function (value, item, index) {
            item.id = false;
            var btnfix = '<button type="button" class="btn shadow-none del"> <img src="/img/bootstrap-icons-1.2.1/trash.svg " class="text-success" alt="" width="22" height="22" > </button>'
            +'<button type="button" class="btn shadow-none check_detail" data-toggle="modal" data-target="#exampleModal"> <img src="/img/bootstrap-icons-1.2.1/Pencil-square.svg " class="text-success" alt="" width="22" height="22" > </button>'
            return btnfix
        },
        width:360
    }
],
    data:data
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
$(".add").click(function (e) { 
    var data=parseInt($(".count_num").html())+1;
    $(".count_num").html(data);
});
$(".sub").click(function (e) { 
    var data = parseInt($(".count_num").html()) - 1;
    if(data<0)
    {
        data=0;
    }
    $(".count_num").html(data);
});

$(".total").click(function (e) { 
    console.log("结算完成")
    var data1=$("#table").bootstrapTable('getSelections')
    data.splice(0,data.length)
     $("#table").bootstrapTable('load', data)
    console.log(data1)
    alert("付款完成")
    $(".total_num").html(0);
});
var amoutn=0;
// onCheckSome
$('#table').on('check.bs.table', function (row, $element) {
    amoutn += $element.price * $element.nums
    $(".total_num").html(amoutn);
    // console.log($element.price)
    // ...
})
$('#table').on('uncheck.bs.table', function (row, $element) {
    amoutn -= $element.price * $element.nums
    $(".total_num").html(amoutn);
    // console.log($element.price)
    // ...
})

$('#table').on('check-all.bs.table', function (rowsAfter, rowsBefore) {
    amoutn=0;
    for(var i=0;i<rowsBefore.length;i++)
    {
        amoutn+=rowsBefore[i].price*rowsBefore[i].nums
        // console.log(rowsBefore[i])
    }
    $(".total_num").html(amoutn);
    // ...
})

$('#table').on('uncheck-all.bs.table', function (rowsAfter, rowsBefore) {
    amoutn = 0;
    $(".total_num").html(amoutn);
    // ...
})
// onUncheckSome