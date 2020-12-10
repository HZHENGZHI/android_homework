
function sortnum(a,b)
{
  return b-a;
}

window.onload = function()
{
  var arr=[5,4,3,2,1]
  var countarr = [];
  for (var i = 0; i < arr.length; i++) 
  {
    countarr[arr[i]]=0;
    countarr[arr[i]]++;
  }
  console.log(countarr);
}

var maxChunksToSorted = function (arr) {
  var countarr=[];
  for(var i=0;i<arr.length;i++)
  {
    countarr[arr[i]]++
  }

};

$(".login").click(function (e) { 
    var id=$(".id").val();
    var pw=$(".pw").val();

  {  $.cookie('id',id,{expires:7});
    $.cookie("pw",pw,{expires:7});}

    console.log($.cookie("id"))
    console.log($.cookie('pw'))

    window.location.href="test.html"
});