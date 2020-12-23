function object_data(book_name,book_nums,book_price)
{
    this.book_name = book_name;
    this.book_nums = book_nums;
    this.book_price = book_price;
    this.setState = function (book_nums) {
        this.book_nums = book_nums;
    }
}

var data=[]
// data[0]=new object_data("1231","123","123");
var index1=0;




window.onload = function () 
{
    $.ajax({
        type: "get",
        url: "http://localhost:7070/untitled2_war//shopping_address",
        data: 
        {
            token:this.$.cookie('name')
        },
        dataType: "text",
        success: function (response) {
            data=JSON.parse(response)
            $(".address").html(data.shopping_address);
            $(".phone").html(data.phone);
            $(".shoppinger").html(data.shoppinger);
            
        }
    });
}

$('#table').bootstrapTable({
local:'zh-CN',
ajax: function (request) {
    $.ajax({
        type: "GET",
        url: "http://localhost:7070/untitled2_war/shopping_car",
        data: {
            token:$.cookie('name')
        },
        jsonp: 'callback',
        success: function (msg) {
            request.success({
                row: JSON.parse(msg)
            });
            $('#table').bootstrapTable('load', JSON.parse(msg));
            data = JSON.parse(msg)
            // console.log(data)
        },
    });
},
columns: [
    {
    field: 'id',
    title: '序号',
    checkbox:true,
    },
    {
        field:'book_name',
        title:'商品名称',
        cellStyle: {
            css: {
                // "text-align": "center",
                "font-size": "x-large"
            }
        },
       
    },
    {
        field:'book_nums',
        title:'商品数量',
        cellStyle: {
            css: {
                // "text-align": "center",
                "font-size": "x-large"
            }
        }
    },
    {
        field:'book_price',
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
                index1=index;
               console.log(index)
               var origin = row.book_nums;
                $(".count_num").html(origin);
                $(".objectname").html(row.book_name);
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
})



$(".total").click(function (e) { 
    var getcol_data=$("#table").bootstrapTable('getSelections')
    var total_nums=0
    for(var i=0;i<getcol_data.length;i++)
    {
        total_nums += parseInt(getcol_data[i].book_price*getcol_data[i].book_nums)
        
    }
    $(".total_num").html(total_nums);
    // console.log(car_data)
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
    amoutn += $element.book_price * $element.book_nums
    $(".total_num").html(amoutn);
})
$('#table').on('uncheck.bs.table', function (row, $element) {
    amoutn -= $element.book_price * $element.book_nums
    $(".total_num").html(amoutn);
})

$('#table').on('check-all.bs.table', function (rowsAfter, rowsBefore) {
    amoutn=0;
    for(var i=0;i<rowsBefore.length;i++)
    {
        amoutn+=rowsBefore[i].book_price*rowsBefore[i].book_nums
    }
    $(".total_num").html(amoutn);
})

$('#table').on('uncheck-all.bs.table', function (rowsAfter, rowsBefore) {
    amoutn = 0;
    $(".total_num").html(amoutn);
})
$(".close_btn").click(function (e) { 
    var count = parseInt($(".count_num").html());
    $.ajax({
        type: "post",
        url: "http://localhost:7070/untitled2_war/shopping_car",
        data: 
        {
            token:$.cookie('name'),
            book_name: $(".objectname").html(),
            book_nums:count
        },
        dataType: "text",
        success: function (response) {
            console.log(JSON.parse(response))
            $("#table").bootstrapTable('load', JSON.parse(response))
        }
    });
});