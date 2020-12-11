$('#table').bootstrapTable({
    search:true,
    pagination:true,
    paginationLoop:true,
   
columns: [{
    field: 'id',
    title: '序号',
    sortable:true,
}, {
    field: 'book_name',
    title: '书名',
    width:300
}, 
{
    fielid:"category",
    title:"类别"
},
{
    field: 'book_price',
    title: '价钱',
    sortable:true,
},
{
    field:'opertion',
    title:'操作'
}
],
data: [{
    id: 1,
    book_name: '<img src="https://img2.doubanio.com/view/ark_article_cover/retina/public/24283113.jpg?v=0" class="img-fluid" alt="Responsive image" style="height: 60px; width: 50px;"> 哈姆雷特',
    book_price: 'java'
}, {
    id: 2,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 3,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 4,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 5,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 6,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 7,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 8,
    book_name: 'Item 2',
    book_price: '$2'
},

{
    id: 9,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 10,
    book_name: 'Item 2',
    book_price: '$2'
},
{
    id: 11,
    book_name: 'Item 2',
    book_price: '$2'
},
]
})
