package cn.zjf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zjf.bean.Express;
import cn.zjf.bean.Message;
import cn.zjf.service.ExpressService;

/**
 * Servlet implementation class ExpressUpdateServlet
 */
@WebServlet("/expressUpdate.do")
public class ExpressUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpressUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eNumber = req.getParameter("eNumber");
		String newEnumber = req.getParameter("newEnumber");
		String userName = req.getParameter("userName");
		String userPhone = req.getParameter("userPone");
		String company = req.getParameter("company");
		boolean flag =  ExpressService.updateByEnumber(eNumber, new Express(newEnumber,company,userName,userPhone,""));
		Message msg = null;
		if(flag) {
			msg = new Message(0,"修改成功");
		}else {
			msg = new Message(-1,"修改失败");
		}
		resp.getWriter().append(msg.toJSON());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
