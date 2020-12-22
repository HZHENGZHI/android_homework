$("#login").click(function (e) {
  $.ajax({
    type: "post",
    url: "http://localhost:7070/untitled2_war/login",
    data: {
      id: $("#id").val(),
      pw: $("#pw").val()
    },
    dataType: "json",
    success: function (response) {
      if(parseInt(response)==1)
      {
        window.location.href="/html/user/index1.html"
      }
      console.log(response)
    }
  });
});