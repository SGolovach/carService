<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="loginForm" method="post" action="action">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password<br/>
    <input type="password" name="password" value=""/>
    <br/>
    <input type="submit" value="Log in"/>

</form><hr/>

</body>
</html>
