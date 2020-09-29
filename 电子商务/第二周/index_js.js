function register()
{
    var firstpw=document.getElementById("pw").value;
    var twopw=document.getElementById("enterpw").value;
    if(firstpw.length<6||firstpw!=twopw)
    {
        alert("密码出错");
        document.getElementById("pw").value="";
        document.getElementById("enterpw").value="";
    }
    else
    {
        alert("注册成功")
    }
}
function restart()
{
    document.getElementById("username").value="";
    document.getElementById("pw").value="";
    document.getElementById("enterpw").value="";
    document.getElementById("id_num").value="";
    document.getElementById("connection_num").value="";
    document.getElementById("phone_num").value="";

    document.getElementById("email_num").value="";
    document.getElementById("address").value="";
    document.getElementById("realyname").value="";
    document.getElementById("birthday").value="";
    document.getElementById("country").value="";
    document.getElementById("mail_num").value="";
    document.getElementById("city").value="";
}