
var path=[];
path[0]="https://img2.doubanio.com/view/ark_article_cover/retina/public/24283113.jpg?v=0"
path[1]="https://img1.doubanio.com/view/ark_article_cover/retina/public/28795069.jpg?v=0"
var temp=0

$('#table').bootstrapTable({
    columns: [
    // {
    //     field: 'id',
    //     title: '序号',
    //     checkbox:true,
    
    // },
    {
        field:'picture',
        title:'书本封面',
        formatter:function(value,item,index)
        {
            item.id=false;
            if(temp<path.length)
            {
                var btnfix="<img src="+path[temp]+" class='img-fluid' alt='Responsive image'style='height: 75px; width: 50px;'>"
                temp++;
            }
           
            return btnfix
        },
        width:80
    },
    {
        field:'name',
        title:'书籍名称',
    },
    {
        field:'IBSN',
        title:'I12N',
    },
    {
        field:'price',
        title:'价格'
    },
    {
        field:'opertion',
        title:'操作',
        // events:
        // {
        //    'click .back':function(e,value,row,index)
        //    {
        //     //    console.log(row);
        //    }
        // },
        formatter:function(value,item,index)
            {
                item.id=false;
                var btnfix=" <button type='button' class='btn btn-primary back' style='margin-right: 15px;'>加入购物车</button>"
                +"<button type='button' class='btn btn-primary back' style='margin-right: 15px;'>加入收藏</button>"
                return btnfix
            },
            width:500,
    }
    ],
    data:
    [
        {
        },
        {

        },
    ]
    
})