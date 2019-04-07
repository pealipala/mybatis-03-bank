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
  <table align="center">
    <form action="/transfer" method="post">
      <tr>
        <td><font color="red">*</font>转账账户:</td>
        <td> <input type="text" name="accOutAccNo"/><br/></td>
      </tr>

      <tr>
        <td><font color="red">*</font> 密码:</td>
        <td> <input type="password" name="accOutPassword"/><br/></td>
      </tr>

      <tr>
        <td><font color="red">*</font> 金额:</td>
        <td> <input type="text" name="accOutBalance"/><br/></td>
      </tr>

      <tr>
        <td><font color="red">*</font> 收款账号:</td>
        <td> <input type="text" name="accInAccNo"/><br/></td>
      </tr>

      <tr>
        <td><font color="red">*</font> 收款姓名:</td>
        <td><input type="text" name="accInName"/><br/></td>
      </tr>

      <tr>
        <td><input type="submit" value="转账">
          <a href="/show">转账记录</a></td>
      </tr>
    </form>
  </table>
  </body>
</html>
