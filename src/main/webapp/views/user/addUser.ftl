<#assign ctx = request.contextPath />
<!DOCTYPE html>
<html>
<head lang="zh">
    <base id="ctx" href="${ctx}">
    <title>Registration</title>
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
        function addUser() {
            var form = document.forms[0];
            form.action = "${ctx}/user/addUser.form";
            form.method = "post";
            form.submit();
        }
    </script>
</head>
<body>
<div class="container">
    <h1>Register</h1>
    <form action="${ctx}/user/addUser.form" name="userForm" method="post">
        <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input type="text" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label>Username:</label>
            <input type="text" class="form-control" name="username">
        </div>
        <div class="form-group">
            <label>Password:</label>
            <input type="password" class="form-control" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
        <button type="reset" class="btn btn-primary">Reset</button>
    </form>
</div>
</body>
</html>