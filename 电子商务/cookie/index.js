$(".login").click(function (e) { 
    var id=$(".id").val();
    var pw=$(".pw").val();

  {  $.cookie('id',id,{expires:7});
    $.cookie("pw",pw,{expires:7});}

    console.log($.cookie("id"))
    console.log($.cookie('pw'))

    window.location.href="test.html"
});