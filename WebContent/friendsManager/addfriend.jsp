<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理系统——增加通讯录</title>

</head>
<body >
      <hr noshade>
<div align="center">
        <table border="0" cellspacing="0" cellpadding="0" width="100%" align="center">
        <tr>
        <td width="20%">
                                     增加联系人                   
        </td>
        <td width="20%">e
        <a href="<c:url value='/friendsManager/lookFriend.jsp'/>">查看联系人</a>
        </td>
        
        <td width="20%">
        <a href="<c:url value='/friendsManager/updateFriend.jsp'/>">修改联系人</a>
        </td>
        <td width="20%">
        <a href="<c:url value='/friendsManager/deleteFriend.jsp'/>">删除联系人</a>
        </td>
        </table>
      </div>
      <hr noshade>
      <br><br>
      <form action="<c:url value='/AddFriendServlet'/>" method="post">
         <table border="2" cellspacing="0" cellpadding="0" width="60%" align="center">
      
       <tr>
       <td>用户姓名</td>
      <td><input type="text" name="name"/></td>
      </tr>
       <tr>
       <td>用户电话</td>
      <td><input type="text" name="phone"/></td>
      </tr>
      <tr>
       <td>邮箱地址</td>
      <td><input type="text" name="email"/></td>
      </tr>
       <tr>
       <td>工作单位</td>
      <td><input type="text" name="workPlace"/></td>
      </tr>
   <tr>
   <td>家庭住址</td>
   <td>
   <select name="place" size="1">
       <option value="北京">北京</option>
       <option value="上海">上海</option>
       <option value="天津">天津</option>
       <option value="河北">河北</option>
       <option value="河南">河南</option>
       <option value="吉林">吉林</option>
       <option value="黑龙江">黑龙江</option>
       <option value="内蒙古">内蒙古</option>
       <option value="山东">山东</option>
       <option value="山西">山西</option>
       <option value="陕西">陕西</option>
       <option value="甘肃">甘肃</option>
       <option value="宁夏">宁夏</option>
       <option value="青海">青海</option>
       <option value="新疆">新疆</option>
       <option value="辽宁">辽宁</option>
       <option value="江苏">江苏</option>
       <option value="浙江">浙江</option>
       <option value="安徽">安徽</option>
       <option value="广东">广东</option>
       <option value="海南">海南</option>
       <option value="广西">广西</option>
       <option value="云南">云南</option>
       <option value="四川">四川</option>
       <option value="重庆">重庆</option>
       <option value="香港">香港</option>
       <option value="澳门">澳门</option>
       <option value="福建">福建</option>
       <option value="江西">江西</option>
       <option value="青海">青海</option>
       <option value="湖北">湖北</option>
       <option value="台湾">台湾</option>
       <option value="其他">北京</option>
   </select>省(直辖市)
 </td>
   </tr>
   <tr>
       <td>用户QQ</td>
      <td><input type="text" name="QQ"/></td>
      </tr>
   <tr>
   <td colspan="2" align="center">
   <input type="submit" value="确定" size="12">
   &nbsp; &nbsp; &nbsp; &nbsp;
   <input type="reset" value="取消" size="12">
   </td>
   </tr>
   
      </table>
      
      </form>
</body>
</html>