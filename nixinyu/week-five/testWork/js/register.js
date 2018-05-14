window.onload = function () {
    var usernameObj = document.getElementById("username")
    var passwordObj = document.getElementById("password")
    var repasswordObj = document.getElementById("repassword")
    var phonenumberObj = document.getElementById("phonenumber")
    var emailObj = document.getElementById("email")

    // 用户名已存在验证
    usernameObj.onblur = function () {
        isExistUser(usernameObj.value)
        //usernameObj.focus()
    }

    // 注册跳转
    var LoginHref = document.getElementById("LoginHref")
    LoginHref.onclick = function () {
        location.href = "login.html"
    }

    // 提交验证
    function verify(){
        // 匹配数字及特殊字符的正则表达式
        var ze = /[a-zA-Z][a-zA-Z0-9]*/;
        // 邮箱正则表达式
        var email_ze = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;

        if(usernameObj.value == "" || passwordObj.value == "" || phonenumberObj.value == "" || emailObj.value == ""){
            alert("表单不能有空项！")
            return false;
        }else if (!ze.test(usernameObj.value[0])){
            alert("用户名首字符不能为特殊字符及数字")
            return false;
        }else if (usernameObj.value.length < 6 || usernameObj.value.length > 12){
            alert("用户名长度在6~12之间！")
            return false;
        }else if (passwordObj.value.length < 6 || passwordObj.value.length > 12){
            alert("密码长度在6~12之间！")
            return false;
        }else if(passwordObj.value != repasswordObj.value){
            alert("两次密码不一致！")
            return false;
        }else if(phonenumberObj.value.length != 11){
            alert("手机号码长度没到11位！")
            return false
        }else if(!email_ze.test(emailObj.value)){
            alert("请输入正确的邮箱！")
            return false
        }
        return true
    }
    // 事件节点
    var subMit = document.getElementById("subMit")

    // 提交事件
    subMit.onclick = function () {
        var b = verify();
        if(b){
            var SendData = "username="+usernameObj.value+"&password="+passwordObj.value+"&phonenumber="+phonenumberObj.value+"&e-mail="+emailObj.value+"";
            SendDataAjax(SendData);
            alert("注册应该成功了……")
            //location.href = "login.html"
        }
    }
}

// 发送注册数据
function SendDataAjax(SendDataVal){
    // 1.声明异步请求对象
    var xmlHttp = null;
    if(window.ActiveXObject){
        // IE
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest()
    }
    if(xmlHttp!=null){
        xmlHttp.open("post","http://localhost:3000/users",true);
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlHttp.send(SendDataVal);
        xmlHttp.onreadystatechange = doResult;
    }
    var bool = false;
    function doResult(){
            if(xmlHttp.readyState ==4){
            if(xmlHttp.status ==200){
                //alert(xmlHttp.responseText)
            }
        }
    }
}


// 获取数据判断用户名是否存在
function isExistUser(usernameStr){
    // 1.声明异步请求对象
    var xmlHttp = null;
    if(window.ActiveXObject){
        // IE
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHttp = new XMLHttpRequest()
    }
    if(xmlHttp!=null){
        xmlHttp.open("get","http://localhost:3000/users",true);
        xmlHttp.send(null);
        xmlHttp.onreadystatechange = doResult;
    }

   function doResult(){
        if(xmlHttp.readyState ==4){
            if(xmlHttp.status ==200){
                var data = JSON.parse(xmlHttp.response)
                for (var i=0;i<data.length;i++){
                    if(data[i]["username"] == usernameStr){
                        alert("用户名已存在！")
                        var b = 1;
                        break
                    }
                }
                if(b != 1){
                    alert("用户名可用！")
                }
            }
        }
    }

}


