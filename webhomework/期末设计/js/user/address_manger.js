$('#table').bootstrapTable({
  toolbar: '#toolbar',
  // cardView:true,
  ajax: function (request) {
    $.ajax({
      type: "GET",
      url: "http://localhost:7070/untitled2_war/user_msg",
      data: {
        token: $.cookie('name'),
        method: "getaddressmsg"
      },
      jsonp: 'callback',
      success: function (msg) {
        request.success({
          row: JSON.parse(msg)
        });
        $('#table').bootstrapTable('load', JSON.parse(msg));
        data = JSON.parse(msg)
        console.log(data)
      },
    });
  },
  columns: [

    {
      field: 'shoppinger',
      title: '收货人',
      width: 80
    },
    {
      field: 'shopping_address',
      title:'地址',
    },
    {
      field:'phone',
      title:'手机号',
      width:100
    },
    {
      field:'operation',
      title:'操作',
      events:
      {
        'click .edit': function (e, value, row, index)
        {
          $(".phone").val(row.phone);
          $(".address").val(row.shopping_address);
          $(".shoppinger").val(row.shoppinger);
        },
        'click .del': function (e, value, row, index)
        {
          console.log("删除")
        }
      },
      formatter: function (value, item, index) {
        item.id = false;
        var btnfix = '<button type="button" class="btn shadow-none edit" style="margin-left:-10px"  data-toggle="modal" data-target="#address_edit"> <img src="/img/bootstrap-icons-1.2.1/Pencil-square.svg " class="text-success" alt="" width="22" height="22" > </button>'
        +'<button type="button" class="btn shadow-none del"> <img src="/img/bootstrap-icons-1.2.1/Trash.svg " class="text-success" alt="" width="22" height="22" > </button>'
           return btnfix
      },
    }
  ],
})

$(".address_confirm").click(function (e) { 
  e.preventDefault();
   console.log("edit address")
  
});

$(".add_address").click(function (e) { 
  e.preventDefault();
 console.log("add address")
});