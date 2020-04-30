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
 * Servlet implementation class CourierAddServlet
 */
@WebServlet("/addCourier.do")
public class CourierAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cName = req.getParameter("cName");
		String cPhone = req.getParameter("cPhone");
		String cCard = req.getParameter("cCard");
		String cPass = req.getParameter("cPass");
		String sex = req.getParameter("sex");
		Courier c = new Courier(cName,cPhone,cCard,cPass,sex);
		boolean flag =  CourierService.cInsert(c);
		Message msg = null;
		if(flag) {
			msg = new Message(0,"添加成功");
		}else {
			msg = new Message(-1,"添加失败");
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
