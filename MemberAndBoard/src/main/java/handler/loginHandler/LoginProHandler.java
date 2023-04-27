package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import handler.CommandHandler;

public class LoginProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = null;
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MabDBBean dao = MabDBBean.getInstance();
		int result = dao.checkLogin(id, passwd);
		HttpSession session = request.getSession();
		if(result == 1) {
			session.setAttribute("id", id);
			session.setAttribute("passwd", passwd);
			url = "/member/loginPro.jsp";
		}
		else {
			request.setAttribute("loginResult", result);
			url = "/member/errorPage.jsp";
		}
		return url;
	}
}
