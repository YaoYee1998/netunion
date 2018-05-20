window.onload = function () {
        // 获取表单与事件
        var username = document.getElementById("username");
        var password = document.getElementById("password");

        // 获取事件按钮
        var LoginBtn = document.getElementById("LoginBtn")

        LoginBtn.onclick = function(){
            // 基本判断
            if(username.value == null || username.value == ""){
                alert("用户名不能为空！")
            }else if(password.value == null || password.value == ""){
                alert("密码不能为空！")
            }else {
                getData(username,password,LoginBtn)
            }
        }
        // 注册跳转
        var RegisterHref = document.getElementById("RegisterHref")
        RegisterHref.onclick = function () {
            location.href = "register.html"
        }
}

// ajax 获取数据
function getData(usernameVal,passwordVal){
    // 1.声明异步请求对象
    var xmlHttp = null;
    if(window.ActiveXObject){
        // IE
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest()
    }
    // 2.如果实例化成功，就调用open()方法
    if(xmlHttp!=null){
        xmlHttp.open("get","http://localhost:3000/users");
        //xmlHttp.open("post","http://training.shunzi.tech/login",true);
        xmlHttp.send(null);
        xmlHttp.onreadystatechange = doResult;
    }

    function doResult(){
        if(xmlHttp.readyState ==4){
            if(xmlHttp.status ==200){
                        // 获取数据
                        var data = JSON.parse(xmlHttp.responseText)
                        for(var i=0;i<data.length;i++){
                            if(data[i]["username"] == usernameVal.value && data[i]["password"] == passwordVal.value){
                                var b = true;
                                //location.href = "http://training.shunzi.tech/index.html"
                            }else{
                                var b = false;
                            }
                        }
                        b?alert("登录成功！"):alert("登录失败！")
                        location.href="index.html"
                    }
                }
            }
}
