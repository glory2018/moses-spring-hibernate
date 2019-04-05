<#assign ctx = request.contextPath />
<!DOCTYPE html>
<html>
<head lang="zh">
    <base id="ctx" href="${ctx}">
    <title>用户信息</title>
    <script type="text/javascript" src="${ctx}/js/common/jquery-3.3.1.min.js"></script>
</head>
<body>
<h1>编辑用户</h1>
<form action="${ctx}/user/updateUser.form" name="userForm" method="post">
    <input type="hidden" name="id" value="${user.id}">
    姓名：<input type="text" name="name" value="${user.name}">
    姓名：<input type="text" name="email" value="${user.email}">
    姓名：<input type="text" name="age" value="${user.age}">
    <input type="submit" value="编辑" >
</form>
</body>
</html>