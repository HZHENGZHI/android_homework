$('#table').bootstrapTable({
  toolbar: 'toolbar',
  cardView:true,
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
  ],
})