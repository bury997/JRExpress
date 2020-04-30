package cn.zjf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zjf.bean.Courier;
import cn.zjf.bean.Message;
import cn.zjf.service.CourierService;

/**
 * Servlet implementation class CourierUpdateServlet
 */
@WebServlet("/CourierUpdateServlet")
public class CourierUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourierUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cPhone = req.getParameter("cPhone");
		String cName = req.getParameter("cName");
		String newCphone = req.getParameter("newCphone");
		String cCard = req.getParameter("cCard");
		String cPass = req.getParameter("cPass");
		String sex = req.getParameter("sex");
		Courier c = new Courier(cName,newCphone,cCard,cPass,sex);
		boolean flag = CourierService.cUpdateByCphone(cPhone, c);
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
