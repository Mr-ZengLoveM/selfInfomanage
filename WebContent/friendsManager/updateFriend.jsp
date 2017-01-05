<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——修改通讯录</title>
</head>
<body background="pink">
      <hr noshade>
<div align="center">
        <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
        <tr>
        <td width="20%">
         <a href="<c:url value='/friendManager/addFriend.jsp'/>">增加联系人</a>
                                                     
        </td>
        <td width="20%">
        <a href="<c:url value='/friendManager/lookFriend.jsp'/>">查看联系人</a>
        </td>
        <td width="20%">
                                      修改联系人
        </td>
        <td width="20%">
        <a href="<c:url value='/friendManager/deleteFriend.jsp'/>">删除联系人</a>
        </td>
        </table>
      </div>
      <hr noshade>
      <br><br>
      <form action="<c:url value='/UpdateFriendsServlet'/>" method="post">
          <table border="2" cellspacing="0" cellpadding="0" width="60%" align="center">
      <tr align="center">
      <td align="center" height="130">
      <p>请输入要修改的姓名</p>
                        姓名<input type="text" name="friendName"/><br>
             </td>
             </tr>           
      <tr>
      <td align="center">
           <input type="submit" value="确定"size="12"/>
                   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input type="reset" value="取消"size="12"/>
    </td>
    </tr>
    </table>
    </form>
</body>
</html>