//三个全局变量,方便后面做页面的验证
var flag_username=false;
var flag_pwd=false;
var flag_repwd=false;
window.onload=function(){
    //1.获得username的对象
    let usernameObj=document.getElementById("username");
    //2.构建onblur属性
    usernameObj.onblur=function(){
        //3.输入框的正则表达式和判断是否被注册
        let reg=/^[a-zA-Z][a-zA-Z0-9]{2,7}$/;
        //获得输入框的内容
        let username=usernameObj.value;
        //获得错误提示span对象
        let span=document.getElementById("err-username");
        //判定
        console.log(username)
        if(!reg.test(username)){
            console.log("格式错误!3-8数字字母首字符为字母")
            flag_username=false;
            span.innerText="格式错误!3-8数字字母首字符为字母"
            span.style.color="red";
        }else{
            //ajax判定是否被注册
            let xhr=getXHR();
            //定义请求
            xhr.open('get','/findByUsernameServlet?username='+username,true);
            //注册监听器
            xhr.onreadystatechange=function (){
                console.log("进来")
                if(xhr.readyState==4 && xhr.status==200){
                    let txt=xhr.responseText;
                    let txtStr=JSON.parse(txt);
                    if(txtStr){
                        console.log("输入合法")
                        flag_username=true;
                        span.innerText="输入合法"
                        span.style.color="green";
                    }else{
                        flag_username=false;
                        span.innerText="账号名被占用"
                        span.style.color="red";
                    }
                }
            };
            //发送请求
            xhr.send(null);
        }
    };

    //密码验证
    let pwdObj=document.getElementsByName("password")[0];
    //构建onblur属性,设置自定义检查
    pwdObj.onblur=function (){
        let reg=/^[a-zA-Z0-9]{6,18}$/;
        let span=document.getElementById("err-pwd");
        if(reg.test(pwdObj.value)){
            flag_pwd=true;
            span.innerText="输入合法";
            span.style.color="green"
        }else{
            flag_pwd=false;
            span.innerText="格式错误,6-18数字或字母";
            span.style.color="red"
        }
    };
    //判断是否一致
    //1.获得输入框对象
    let repwdObj=document.getElementsByName("repassword")[0];
    //2.获得上面的密码值
    console.log(repwdObj)
    //3.获得自己的值
    //4.比较
    repwdObj.onblur=function (){
        let span=document.getElementById("err-repwd");
        if (pwdObj.value== repwdObj.value){
            if (repwdObj.value == "undefined"){
                span.innerText="格式错误";
                span.style.color="red"
            }
            console.log("输入合法")
            flag_repwd=true;
            span.innerText="输入一致";
            span.style.color="green"
        }else{
            console.log("不一致")
            flag_repwd=false;
            span.innerText="两次输入的密码不一致";
            span.style.color="red"
        }
    };

    //form表单的onsubmit事件
    let myform=document.getElementsByTagName("form")[0];
    myform.onsubmit=function(){
        return flag_username && flag_pwd;
    };
}