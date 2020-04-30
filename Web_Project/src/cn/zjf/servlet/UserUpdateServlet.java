package cn.zjf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zjf.bean.Message;
import cn.zjf.bean.User;
import cn.zjf.service.UserService;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/updateUser.do")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uPhone = request.getParameter("uPhone");
		String uName = request.getParameter("uName");
		String newUphone = request.getParameter("newUphone");
		String uPass = request.getParameter("uPass");
		String uSex = request.getParameter("uSex");
		System.out.println(uPhone+uName+newUphone+uPass+uSex);
		User u = new User(uName,newUphone,uPass,uSex);
		boolean flag = UserService.updateUserByUPhone(uPhone, u);
		Message msg = null;
		if(flag) {
			msg = new Message(0,"修改成功");
		}else {
			msg = new Message(-1,"修改失败");
		}
		response.getWriter().append(msg.toJSON());
	}

}
