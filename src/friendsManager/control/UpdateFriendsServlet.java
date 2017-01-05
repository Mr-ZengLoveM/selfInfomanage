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
 * Servlet implementation class UpdateFriendsServlet
 */
@WebServlet("/UpdateFriendsServlet")
public class UpdateFriendsServlet extends HttpServlet {
	public void wrong1(){
	   	 String msg="������Ҫ�޸��˵�����";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="��Ϣ��ʾ";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);
		}
		public void wrong2(){
	   	 String msg="�������Ѳ����ڣ��޷��޸ģ�";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="��Ϣ��ʾ";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);	
		}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFriendsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String friendName=new String(request.getParameter("friendName").getBytes("ISO-8859-1"),"UTF-8");
	   	 
	   	if(friendName.length()==0){	
	   		wrong1();
	   		response.sendRedirect("c:url valu='/friendManager/updateFriend.jsp'");
	   	}else{
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
	   	 String sqll="select*from friends where name='"+friendName+"'";
	   	 rs=stmt.executeQuery(sqll);
	     rs.last();
	     int k=rs.getRow();
	    rs.beforeFirst();
	     if(k<1){
	    	 wrong2();
	    	 response.sendRedirect("c:url valu='/friendManager/updateFriend.jsp'");
	     }else{
	    	 HttpSession session=request.getSession();
	    	 ArrayList friendslist2=null;
	    	 friendslist2=new ArrayList();	
	     while(rs.next()){
			 LookFriendBean ff=new LookFriendBean();
			 ff.setId         (rs.getString("id"));
			 ff.setName       (rs.getString("name"));
			 ff.setPhone      (rs.getString("phone"));
			 ff.setEmail      (rs.getString("email"));
			 ff.setWorkPlace  (rs.getString("workPlace"));
			 ff.setPlace      (rs.getString("place"));
			 ff.setQQ         (rs.getString("QQ"));
			 friendslist2.add(ff);
			 session.setAttribute("friendslist2",friendslist2);
		 }
	     ArrayList friendslist3=null;
	     LookFriendBean nn=new LookFriendBean();
	     friendslist3=new ArrayList();
	     nn.setName(friendName);
	     friendslist3.add(nn);
	     session.setAttribute("friendslist3", friendslist3);
	     }
	     rs.close();
		 stmt.close();
		 con.close();
		 response.sendRedirect("c:url valu='/friendManager/updateFriendMessage.jsp'");
		 
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
