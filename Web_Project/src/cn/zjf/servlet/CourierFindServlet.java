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
 * Servlet implementation class CourierFindServlet
 */
@WebServlet("/findCourier.do")
public class CourierFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourierFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cPhone = req.getParameter("cPhone");
		Courier flag = CourierService.findCourierByCphone(cPhone);
		Message msg = null;
		if(flag==null) {
			msg = new Message(-1,"查询失败");
		}else {
			msg = new Message(0,"查询成功",flag);
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
