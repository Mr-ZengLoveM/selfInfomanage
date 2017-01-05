<%@page import="java.util.ArrayList"%>
<%@page import="friendsManager.model.LookFriendBean" %>

<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——增加通讯录</title>
</head>
<body background="cccfff">
      <hr noshade>
      <div align="center">
        <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
        <tr>
        <td width="20%">
        <a href="<c:url value='/friendManager/addFriend.jsp'/>">增加联系人</a>
        </td>
        <td width="20%">
                                    查看通讯录
        </td>
        <td width="20%">
        <a href="<c:url value='/friendManager/updateFriend.jsp'/>">修改联系人</a>
        </td>
        <td width="20%">
        <a href="<c:url value='/friendManager/deleteFriend.jsp'/>">删除联系人</a>
        </td>
        </table>
      </div>
      
      <hr noshade>
      <br><br>
       <table border="0" cellspacing="0" cellpadding="0" width="60%" align="center">
       <tr>
          <th height="30">用户姓名</th>
          <th height="30">用户电话</th>
          <th height="30">邮箱地址</th>
          <th height="30">用户单位</th>
          <th height="30">家庭住址</th>
          <th height="30">用户QQ</th>
          </tr>
          <%
          ArrayList friendslist=(ArrayList)session.getAttribute("friendslist");
          if(friendslist==null||friendslist.size()==0){
        
          %>
          <div align="center">
          <h1>你还没有任何联系人</h1>
          </div>
          <% 
          }else{
        	  for(int i=friendslist.size()-1;i>=0;i--){
        		  LookFriendBean ff=(LookFriendBean)friendslist.get(i);
          %>
          <tr>
          <td><%=ff.getName() %></td>
          <td><%=ff.getPhone() %></td>
          <td><%=ff.getEmail() %></td>
          <td><%=ff.getWorkPlace() %></td>
          <td><%=ff.getPlace() %></td>
          <td><%=ff.getQQ() %></td>
          <tr>
          <%
        	  }
          }
          %>
          
       </table>
</body>
</html>