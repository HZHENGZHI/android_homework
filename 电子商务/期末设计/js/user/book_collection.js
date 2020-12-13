
var path=[];
path[0]="https://img2.doubanio.com/view/ark_article_cover/retina/public/24283113.jpg?v=0"

var temp=0


const TYPES = ['info', 'warning', 'success', 'error'],
TITLES = {
    'info': '注意！',
    'success': '成功！',
    'warning': '库存不足!',
    'error': '出现未知错误!'
},
CONTENT = {
    'info': 'Hello, world! This is a toast message.',
    'success': '加入购物车成功!',
    'warning': '加入购物车失败!',
    'error': '库存不足!'
},
POSITION = ['top-right', 'top-left', 'top-center', 'bottom-right', 'bottom-left', 'bottom-center'];

$.toastDefaults.position = 'bottom-right';
$.toastDefaults.dismissible = true;
$.toastDefaults.stackable = true;
$.toastDefaults.pauseDelayOnHover = true;



$('#table').bootstrapTable({
    search:true,
    uniqueId:'IBSN',
    columns: [
   
    {
        field:'picture',
        title:'书本封面',
        formatter:function(value,item,index)
        {
            item.id=false;
            if(temp<path.length)
            {
                var img="<img src="+path[temp]+" class='img-fluid' alt='Responsive image'style='height: 75px; width: 50px;'>"
                temp++;
            }
           
            return img
        },
        width:80
    },
    {
        field:'name',
        title:'书籍名称',
        width:400,
        cellStyle:{
            css:
            {
               " text-align":"center",
               "font-size": "x-large"
            }
        }
    },
    {
        field:'IBSN',
        title:'IBSN',
        width:400,
        cellStyle:{
            css:
            {
               "text-align":"center",
               "font-size": "x-large"
            }
        }
    },
    {
        field:'price',
        title:'价格',
        cellStyle:{
            css:
            {
               " text-align":"center",
               "font-size": "x-large"
            }
        }
    },
    {
        field:'opertion',
        title:'操作',
        events:
        {
           'click .delmove':function(e,value,row,index)
           {
            alert("是否移出收藏夹")
            console.log(temp);
            $('#table').bootstrapTable('removeByUniqueId',row.IBSN)
            temp=index+1;
            console.log(temp);
           },
           'click .bttn':function(e,value,row,index)
           {
            var rng = 1,
            type = TYPES[2],
            title = TITLES[type],
            content = CONTENT[type];

            if (rng === 1) {
            $.toast({
                type: type,
                title: title,
                subtitle: '',
                content: content,
                delay: 5000
            });
        }
           }

        },
        formatter:function(value,item,index)
            {
                item.id=false;
                var btnfix=" <button type='button' class='btn btn-primary bttn' style='margin-right: 15px;'>加入购物车</button>"
                +"<button type='button' class='btn btn-primary delmove' style='margin-right: 15px;'>移出收藏</button>"
                return btnfix
            },
            width:500,
    }
    ],
    data:
    [
        {
            
            name:'哈姆雷特',
            IBSN:'9787552701074',
            price:'123'
        }
    ]
    
})