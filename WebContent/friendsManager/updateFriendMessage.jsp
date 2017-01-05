<%@page import="friendsManager.model.LookFriendBean" %>

<%@page import="java.util.ArrayList" %>
<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——修改通讯录</title>
</head>
<body background="cccfff">
      <hr noshade>
<div align="center">
        <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
        <tr>
        <td width="20%">
         <a href="<c:url value='/friendManager/addFriend.jsp'/>">增加联系人</a>
                                     增加联系人                   
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
     <form action="<c:url value='/UpdateFriendMessageServlet'/>" method="post">
         <table border="2" cellspacing="0" cellpadding="0" width="60%" align="center">
      <%
      ArrayList friendslist2=(ArrayList)
      session.getAttribute("friendslist2");
      if(friendslist2==null||friendslist2.size()==0){
    	  response.sendRedirect("<c:url value='friendManager/lookFriend.jsp'/>");
    	  
      }else{
    	  for(int i=friendslist2.size()-1;i>=0;i--){
    		  LookFriendBean ff=(LookFriendBean)friendslist2.get(i);
      %>
      <tr>
       <td  height="30">用户姓名</td>
       <td>< %=ff.getName() %>
      <tr>
        <td  height="30">用户电话</td>
        <td><input type="text" name="phone"value="< %=ff.getPhone() %>">
        </td>
        </tr>
        <tr>
        <td  height="30">邮箱地址</td>
        <td><input type="text" name="Email"value="< %=ff.getemail() %>">
        </td>
        </tr>
        <tr>
        <td  height="30">工作单位</td>
        <td><input type="text" name="WorkPlace"value="< %=ff.getworkPlace() %>">
        </td>
        </tr>
        <tr>
        <td  height="30">家庭住址</td>
        <td><input type="text" name="Place"value="< %=ff.getplace() %>">
        </td>
        </tr>
        <tr>
        <td  height="30">用户QQ</td>
        <td><input type="text" name="QQ"value="< %=ff.getQQ() %>">
        </td>
        </tr>
        
        <tr>
        <td colspan="2" align="center">
        <input type="submit" value="确定"size="12"/>
                   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <input type="reset" value="取消"size="12"/>
          </td>
          </tr>
          <%
    	  }
      }
          %>
      </table>
      </form>
</body>
</html>