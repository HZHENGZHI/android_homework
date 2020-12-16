$('#table').bootstrapTable({
  toolbar: 'toolbar',
  columns: [

    {
      field: 'getobjectman',
      title: '收货人',
      width: 80
    },
    {
      field:'address',
      title:'地址',
      width:100
    },
    {
      field:'phone',
      title:'手机号',
      width:100
    },
    {
      field:'operation',
      title:'操作',
      formatter: function (value, item, index) {
        item.id = false;
        var btnfix = " <button type='button' class='btn btn-primary bttn' style='margin-right: 15px;'>编辑</button>" 
        return btnfix
      },
      width:100
    }
  ],
  data: [
    {
      getobjectman:'黄政治',
      address:'广东省深圳市南山区华晖云门1栋20f',
      phone:'13049424341'
    },
    {
      getobjectman: '黄政治',
      address: '广东省深圳市南山区华晖云门1栋20f',
      phone: '13049424341'
    },
    {
      getobjectman: '黄政治',
      address: '广东省深圳市南山区华晖云门1栋20f',
      phone: '13049424341'
    }

  ]

})