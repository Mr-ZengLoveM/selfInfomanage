package friendsManager.control;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import friendsManager.model.LookFriendBean;

/**
 * Servlet implementation class deleteFriendServlet
 */
@WebServlet("/deleteFriendServlet")
public class deleteFriendServlet extends HttpServlet {
	public void wrong1(){
	   	 String msg="请输入你要删除的人姓名！";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="信息提示";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);
		}
		public void wrong2(){
	   	 String msg="此联系人不存在";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="信息提示";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);	
		}
		public void right(){
	   	 String msg="此联系人已成功删除！";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="信息提示";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);
		}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name=new
	   			 String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
	   	 
	   	if(name.length()==0){
	   			
	   		wrong1();
	   		response.sendRedirect("c:url valu='/friendManager/addFriend.jsp'");
	   	}else{
	   		try{
	   			Connection con=null;
	   			Statement stmt=null;
	   			ResultSet rs=null;
	   			Class.forName("com.microsoft.sqlserve.jdbc.SQLServerDriver");
	   		    String url = "jdbc:sqlserver://localhost:1433;databasename=friends";
	   	        con=DriverManager.getConnection(url,"user","psssword");
	   	        stmt=con.createStatement();
	   	        String userName="qian";
	 	   	    String password="";  
	        	HttpSession session=request.getSession();
	        	ArrayList login=(ArrayList)session.getAttribute("login");
	   	if(login==null || login.size()==0){
	   		response.sendRedirect("c:url valu='/login.jsp'");
	   		
	   	}else{
	   		for(int i=login.size()-1;i>=0;i--){
	   			LoginBean nn=(LoginBean)login.get(i);
	   			userName=nn.getUserName();
	   		}
	   	}
	   	
	   	 String sqll="select*from friends where name='"+name+"'and userName='"+userName+"'";
	   	 rs=stmt.executeQuery(sqll);
	     rs.last();
	     int k=rs.getRow();
	     
	     if(k<1){
	    	 wrong2();
	    	 response.sendRedirect("c:url valu='/friendManager/deleteFriend.jsp'");
	     }else{
	    	 
	     String sql3="delete*from friends where userName='"+userName+"'";
	     rs=stmt.executeQuery(sql3);
	     ArrayList friendslist=null;
	     rs.last();
	     int list=rs.getRow();
	     rs.beforeFirst();
	     if(list<1){
	    	 ArrayList friendlist=null;
	    	 session.setAttribute("friendslist",friendlist );
	     }else{
	    	 ArrayList friendlist=null;
	    	  friendslist=new ArrayList();
	     while(rs.next()){
			 LookFriendBean ff=new LookFriendBean();
			 ff.setId         (rs.getString("id"));
			 ff.setName       (rs.getString("name"));
			 ff.setPhone      (rs.getString("phone"));
			 ff.setEmail      (rs.getString("email"));
			 ff.setWorkPlace  (rs.getString("workPlace"));
			 ff.setPlace      (rs.getString("place"));
			 ff.setQQ         (rs.getString("QQ"));
			 friendslist.add(ff);
			 session.setAttribute("friendslist",friendslist );
	     }
	     }
	     }
	     rs.close();
		 stmt.close();
		 con.close();
		 response.sendRedirect("c:url valu='/friendManager/lookFriend.jsp'");
	     
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	   	
	     }
	     }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
