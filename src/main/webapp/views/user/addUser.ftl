<#assign ctx = request.contextPath />
<!DOCTYPE html>
<html>
<head lang="zh">
    <base id="ctx" href="${ctx}">
    <title>用户信息</title>
    <script type="text/javascript" src="${ctx}/js/common/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        function addUser(){
            var form = document.forms[0];
            form.action = "${ctx}/user/addUser.form";
            form.method="post";
            form.submit();
        }
    </script>
</head>
<body>
<h1>添加用户</h1>
<form action="" name="userForm">
    姓名：<input type="text" name="name">
    邮箱：<input type="text" name="email">
    年龄：<input type="text" name="age">
    <input type="button" value="添加" onclick="addUser()">
</form>
</body>
</html>