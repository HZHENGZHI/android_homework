function book(picture, name, IBSN, price)
{
    this.picture = picture;
    this.name=name;
    this.IBSN=IBSN;
    this.price=price;
}


var data=[];
data[0] = new book("https://img2.doubanio.com/view/ark_article_cover/retina/public/24283113.jpg?v=0","哈姆雷特1", "9787552701074", "123")
data[1] = new book("https://img2.doubanio.com/view/ark_article_cover/retina/public/24283113.jpg?v=0", "哈姆雷特2", "9787552701074", "123")
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
            console.log(value)
            var img="<img src="+value+" class='img-fluid' alt='Responsive image' style='height: 75px; width: 50px;'>"
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

            if (rng === 1) 
            {
            $.toast({
                type: type,
                title: title,
                subtitle: '',
                content: content,
                delay: 5000
            });
            }
        },
        'click .del':function(e,value,row,index)
        {
            {
                $.toast({
                    type: TYPES[0],
                    title: TITLES[TYPES[0]],
                    subtitle: '',
                    content: "提示:已移出收藏夹",
                    delay: 5000
                });
            }
            data.splice(index,1)
            $("#table").bootstrapTable('load', data)
            console.log(temp)
            
            temp=0;
            console.log(data)
        }
        },
        formatter:function(value,item,index)
            {
                item.id=false;
                 var btnfix = '<button type="button" class="btn shadow-none bttn"> <img src="/img/bootstrap-icons-1.2.1/Cart-plus.svg " class="text-success" alt="" width="22" height="22" > </button>'+
                 '<button type="button" class="btn shadow-none del"> <img src="/img/bootstrap-icons-1.2.1/Trash.svg " class="text-success" alt="" width="22" height="22" > </button>'
                return btnfix
            },
            width:500,
    }
    ],
    data:data
    
})