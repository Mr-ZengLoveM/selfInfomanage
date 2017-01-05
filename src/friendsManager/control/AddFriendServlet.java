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
 * Servlet implementation class AddFriendServlet
 */
@WebServlet("/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
	
	public void wrong1(){
	   	 String msg="�������пգ�ע��ʧ�ܣ�";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="��Ϣ��ʾ";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);
		}
		public void wrong2(){
	   	 String msg="�û��Ѵ��ڣ����ʧ�ܣ�";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="��Ϣ��ʾ";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);	
		}
		public void right(){
	   	 String msg="��д��Ϣ�ϸ���ӳɹ���";
	   	 int type=JOptionPane.YES_NO_CANCEL_OPTION;
	   	 String title="��Ϣ��ʾ";
	   	 JOptionPane.showMessageDialog(null,msg, title,type);
		}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	 String name=new
	   			 String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
	   	 String phone=new
	   			 String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
	   	String email=new
	  			 String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
	   	String workPlace=new
	  			 String(request.getParameter("workPlace").getBytes("ISO-8859-1"),"UTF-8");
	   	String place=new
	  			 String(request.getParameter("place").getBytes("ISO-8859-1"),"UTF-8");
	   	String QQ=new
	  			 String(request.getParameter("QQ").getBytes("ISO-8859-1"),"UTF-8");
	   	if(name.length()==0
	   			||phone.length()==0
	   			||email.length()==0
	   			||workPlace.length()==0
	   			||QQ.length()==0){
	   		wrong1();
	   		response.sendRedirect("friendsManager/addfriend.jsp");
	   	}else{
	   		try{
	   			Connection con=null;
	   			Statement stmt=null;
	   			ResultSet rs=null;
	   		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	   		 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=friends";
	   	con=DriverManager.getConnection(url,"user","password");
	   	stmt=con.createStatement();
	   	String userName="qian";
	   	String password="";
	   	HttpSession session=request.getSession();
	   	ArrayList login=(ArrayList)session.getAttribute("login");
	   	if(login==null || login.size()==0){
	   		response.sendRedirect("/login.jsp");
	   		
	   	}else{
	   		for(int i=login.size()-1;i>=0;i--){
	   			LoginBean nn=(LoginBean)login.get(i);
	   			userName=nn.getUserName();
	   		}
	   	}
	   	
	   	 String sqll="select*from friends where name="+name;
	   	 rs= stmt.executeQuery(sqll);
	     rs.last();
	     int k;
	     k=rs.getRow();
	     if(k>0){
	    	 wrong2();
	    	 response.sendRedirect("friendManager/addFriend.jsp");
	     }else{
	    	 String sql2=
	    	 "insert into friends(id,userName,name,phone,email,workPlace,place,QQ)values("+"'"+userName+"'"+","+"'"+name+"'"+","+"'"+phone+"'"+","+"'"+email+"'"+","+"'"+workPlace+"'"+","+"'"+place+"'"+","+"'"+QQ+"'"+")";
	    	 stmt.executeUpdate(sql2);
	     }
	     String sql3="select*from friends where userName='"+userName+"'";
	     rs=stmt.executeQuery(sql3);
	     ArrayList friendslist=null;
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
	     rs.close();
		 stmt.close();
		 response.sendRedirect("/friendManager/lookFriend.jsp");
		 
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
