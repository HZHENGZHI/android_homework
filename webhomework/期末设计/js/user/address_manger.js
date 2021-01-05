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
           $.ajax({
             type: "post",
             url: "http://localhost:7070/untitled2_war/shopping_address",
             data: {
               token: $.cookie('name'),
               phone:row.phone,
               address:row.shopping_address,
               shoppinger:row.shoppinger,
               method: "del_address"
             },
             dataType: "text",
             success: function (response) {
                alert("提示:正在执行删除地址")
                $('#table').bootstrapTable('load', JSON.parse(response));
              
             }
           });
        }
      },
      formatter: function (value, item, index) {
        item.id = false;
        var btnfix ='<button type="button" class="btn shadow-none del"> <img src="/img/bootstrap-icons-1.2.1/Trash.svg " class="text-success" alt="" width="22" height="22" > </button>'
           return btnfix
      },
    }
  ],
})

function phoneFun(phones) {
  var myreg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
  if (!myreg.test(phones)) {
    return false;
  } else {
    return true;
  }
}

$(".add_address").click(function (e) 
{ 
  e.preventDefault();
  if ($(".add_phone").val() == "" || $(".add_address1").val()=="" || $(".add_shoppinger").val()=="")
  {
      alert("提示:收货地址/收货人/手机号不为空")
  }
  else if (phoneFun($(".add_phone").val())==false)
  {
      alert("提示:手机号码格式不正确")
  }
  else if ($(".add_address1").val() && $(".add_shoppinger").val() && phoneFun($(".add_phone").val()))
  {
    $.ajax({
      type: "post",
      url: "http://localhost:7070/untitled2_war/shopping_address",
      data: 
      {
        token:$.cookie('name'),
        phone:$(".add_phone").val(),
        address:$(".add_address1").val(),
        shoppinger:$(".add_shoppinger").val(),
        method:"add_address"
      },
      dataType: "text",
      success: function (response) {
        $('#table').bootstrapTable('load', JSON.parse(response));
        alert("提示:正在添加地址数据")
      }
    });
  }
   $(".add_phone").val("")
   $(".add_address1").val("")
   $(".add_shoppinger").val("")
});