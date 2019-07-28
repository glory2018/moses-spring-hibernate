<#assign ctx = request.contextPath />
<!DOCTYPE html>
<html>
<head lang="zh">
    <base id="ctx" href="${ctx}">
    <title>用户信息</title>
    <script type="text/javascript" src="${ctx}/js/common/jquery-3.3.1.min.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
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
<div class="container">
    <h3><a href="${ctx}/user/toAddUser.form">Add User</a> <a href="${ctx}/user/logout.form">Logout</a></h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Username</th>
            <th scope="col">Operation</th>
        </tr>
        </thead>
        <tbody>
        <#list userList as user>
            <tr>
                <td>${user.name }</td>
                <td>${user.email }</td>
                <td>${user.username }</td>
                <td>
                    <a href="${ctx}/user/getUser.form?id=${user.id }">Edit</a>
                    <a href="${ctx}/user/delUser.form?id=${user.id }">Delete</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</html>