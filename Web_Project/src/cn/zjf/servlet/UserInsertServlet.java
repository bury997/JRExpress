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
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/insertUser.do")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("uName");
		String uPhone = request.getParameter("uPhone");
		String uPass = request.getParameter("uPass");
		String uSex = request.getParameter("uSex");
		User u = new User(uName,uPhone,uPass,uSex);
		boolean flag = UserService.insertUser(u);
		Message msg = null;
		if(flag) {
			msg = new Message(0, "添加成功");
		}else {
			msg = new Message(-1, "添加失败");
		}
		response.getWriter().append(msg.toJSON());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
