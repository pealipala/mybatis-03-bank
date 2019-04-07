<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/4/7
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="/transfer" method="post">
      转账账户:<input type="text" name="accOutAccNo"/><br/>
      密码:       <input type="password" name="accOutPassword"/><br/>
      金额:       <input type="text" name="accOutBalance"/><br/>
      收款账号:<input type="text" name="accInAccNo"/><br/>
      收款姓名:<input type="text" name="accInName"/><br/>
      <input type="submit" value="转账">
    </form>
  </body>
</html>
