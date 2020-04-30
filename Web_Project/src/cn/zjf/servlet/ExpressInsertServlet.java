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
import cn.zjf.sms.SendSms;

/**
 * Servlet implementation class ExpressInsertServlet
 */
@WebServlet("/expressInsert.do")
public class ExpressInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpressInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eNumber = req.getParameter("eNumber");
		String company = req.getParameter("company");
		String userName = req.getParameter("userName");
		String userPhone = req.getParameter("userPhone");
		String inputPhone = req.getParameter("inputPhone");
		Express e = new Express(eNumber,company,userName,userPhone,inputPhone==null?"-1":inputPhone);
		int code = ExpressService.insert(e);
		Message msg = null;
		if(code!=0) {
			boolean flag = SendSms.send(userPhone, code);
			if(flag) {
				msg = new Message(0,"快递录入成功,短信已发送");
			}else {
				msg = new Message(-1,"快递录入成功,短信发送失败");
			}
		}else {
			msg = new Message(-2,"快递录入失败,单号已存在");
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
