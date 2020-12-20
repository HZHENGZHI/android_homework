

function detail_k(name,nums)
{
    var temp=new Object();
    temp.name=name;
    temp.nums=nums;
    return temp;
}


$('#table').bootstrapTable({
    search:true,
    pagination:true,
    paginationLoop:true,
    local:'zh-CN',
    // showFooter:true,
    columns: [
        {
            field:'id',
            checkbox:true
        },
    {
        field: 'uuid',
        title: '序号',
    },
    {
        field:'order_time',
        title: '下单时间',
    },
    {
        field:'object_detail',
        title: '物品详细',
        formatter : function(value, row, index, field){
            return "<span title="+value+">"+value+"</span>";
            },
        cellStyle : function(value, row, index, field){
            return {
            css: {
            'min-width': '20px',
            'white-space': 'nowrap',
            'text-overflow': 'ellipsis',
            'overflow': 'hidden',
            'max-width':'30px'}
            };
            }
    },
    {
        field:'Merchant',
        title: '商家',
    },
    {
        field:'Shipping_address',
        title: '收货地址',
    },
    {
        field:'Shippinger',
        title: '收货人',
    },
    {
        field:'total_price',
        title: '商品总价',
        // 可以用在购物车中
        // footerFormatter:function(value)
        // {
        //     var count=0;
        //     for( var i in value)
        //     {
        //         count+=parseInt(value[i].total_price)
        //     }
        //     return count;
        // }
        
    },
    {
        field:'operation',
        title:'操作',
        width:400,
        events:
        {
           'click .back':function(e,value,row,index)
           {
               var k=row.object_detail
               var k1=k.split("-");
                console.log(k1);
                var index=0;
                var detail1=[]
                for(var i=0;i<k1.length;i++)
                {
                    if(i%2==0)
                   { detail1[index]= detail_k(k1[i],k1[i+1]);
                    index++;
                }
                }
                console.log(detail1);
                $('#detail_table').bootstrapTable('load',detail1); 
           }
        },

        formatter:function(value,item,index)
        {
            item.id=false;
            var btnfix = "<div class='row'><button type='button' class='btn back shadow-none' data-toggle='modal' data-target='#exampleModal'><img src='/img/bootstrap-icons-1.2.1/Cart4.svg' class='text-success' alt='' width='22' height='22'></button>"
            +"<button type='button' class='btn shadow-none' data-toggle='modal' data-target='#mark_evaluation'><img src='/img/bootstrap-icons-1.2.1/Chat-dots.svg' class='text-success' alt='' width='22' height='22'></button></div>"
            return btnfix
        },
    }
],
    data:[
        {
            uuid: '1',
            order_time:'2020-1-1',
            object_detail:'哈姆雷特-1件'+'-'+"java-1件"+"-"+"javac-1件",
            Merchant:'123',
            Shipping_address:'123',
            Shippinger:'123',
            total_price:'123',
        },
        {
            uuid: '1',
            order_time:'2020-1-1',
            object_detail:'哈姆雷特-1件',
            Merchant:'123',
            Shipping_address:'123',
            Shippinger:'123',
            total_price:'123',
        }
    ]
})
$('#table').on('dbl-click-row.bs.table', function (field, value, row, $element) {
    console.log(value);
    console.log(detail1);
  })


  $('#detail_table').bootstrapTable({
    pagination:true,
    paginationLoop:true,
    local:'zh-CN',
    // showFooter:true,
    columns: [
    // {
    //     field: 'uuid',
    //     title: '序号',
    // },
    {
        field:'name',
        title: '书籍名称',
    },
    {
        field:'nums',
        title: '书籍数量',
        // formatter : function(value, row, index, field){
        //     return "<span title="+value+">"+value+"</span>";
        //     },
        // cellStyle : function(value, row, index, field){
        //     return {
        //     css: {
        //     'min-width': '20px',
        //     'white-space': 'nowrap',
        //     'text-overflow': 'ellipsis',
        //     'overflow': 'hidden',
        //     'max-width':'30px'}
        //     };
        //     }
    },
],
})