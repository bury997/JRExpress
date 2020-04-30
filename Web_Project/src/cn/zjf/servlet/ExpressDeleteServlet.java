package cn.zjf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zjf.bean.Message;
import cn.zjf.service.ExpressService;

/**
 * Servlet implementation class ExpressDeleteServlet
 */
@WebServlet("/expressDelete.do")
public class ExpressDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpressDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eNumber = req.getParameter("eNumber");
		boolean flag =  ExpressService.deleteByEnumber(eNumber);
		Message msg = null;
		if(flag) {
			msg = new Message(0,"É¾³ý³É¹¦");
		}else {
			msg = new Message(-1,"É¾³ýÊ§°Ü");
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
