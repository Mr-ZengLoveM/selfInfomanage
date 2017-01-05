package friendsManager.control;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import friendsManager.model.LookFriendBean;


/**
 * Servlet implementation class LookFriendServlet
 */
@WebServlet("/LookFriendServlet")
public class LookFriendServlet extends HttpServlet {
	public void wrong1(){
   	 String msg="不允许有空，注册失败！";
   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
   	 String title="信息提示";
   	 JOptionPane.showMessageDialog(null,msg, title,type);
   			 
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try{
    		 Connection con=null;
    		 Statement stmt=null;
    		 ResultSet rs=null;
    		 Class.forName("com.microsoft.sqlserve.jdbc.SQLServerDriver");
	   		 String url = "jdbc:sqlserver://localhost:1433;databasename=friends";
	   	con=DriverManager.getConnection(url,"user","password");
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
    	 String sqll="select*from friends where userName='"+userName+"'";
    	 rs=stmt.executeQuery(sqll);
    	 ArrayList friendslist=null;
    	 if((ArrayList)session.getAttribute("friendslist")==null){
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
    	 rs.close();
    	 stmt.close();
    	 response.sendRedirect("c:url valu='/friendManager/lookFriend.jsp'");
    	 
    	 }catch(Exception e){
    		 e.printStackTrace();
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
