
function mylogin(){
    //1.获得内置对象xhr
    let xhr=getXHR();
    //2.用户名和密码和表单对象
    let username=document.getElementsByName("username")[0];
    let pwd=document.getElementsByName("password")[0];
    let myform=document.getElementsByTagName("form")[0];
    //获得是否选中的状态值
    // let remb=document.getElementById("remb").value;
    //3.登录成功才进行跳转,登录失败,则想直接显示账户名或者密码错误
    xhr.open('get',
        'loginServlet?username='+username.value+'&pwd='+pwd.value,
        true);
    //4.注册监听器
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status==200){
            let txt=xhr.responseText;
            // 解析json
            let flag=JSON.parse(txt);
            console.log(flag)
            //获得span提示节点
            let span=document.getElementById("err-login");
            if(flag){
                //成功直接跳转
                myform.submit();
            }else{
                //失败显示登陆错误
                span.innerText="管理员账号或者密码错误";
                span.style.color="red";
            }
        }
    };
    //5.发送请求
    xhr.send(null);
}
