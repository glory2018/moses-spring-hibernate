<#assign ctx = request.contextPath />
<!DOCTYPE html>
<html>
<head lang="zh">
    <base id="ctx" href="${ctx}">
    <title>用户信息</title>
    <script type="text/javascript" src="${ctx}/js/common/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        function del(id) {
            $.get("${ctx}/user/delUser.form?id=" + id, function (data) {
                if ("success" == data.result) {
                    alert("删除成功");
                    window.location.reload();
                } else {
                    alert("删除失败");
                }
            });
        }
    </script>
</head>
<body>
<h3><a href="${ctx}/user/toAddUser.form">添加用户</a></h3>
<table border="1">
    <tbody>
    <tr>
        <th>姓名</th>
        <th>邮箱</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    </tbody>
     <#list userList as user>
      <tr>
          <td>${user.name }</td>
          <td>${user.email }</td>
          <td>${user.age }</td>
          <td>
              <a href="${ctx}/user/getUser.form?id=${user.id }">编辑</a>
              <a href="${ctx}/user/delUser.form?id=${user.id }">删除</a>
          </td>
      </tr>
     </#list>
</table>
</html>