package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import handler.CommandHandler;

public class MainPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = (String)session.getAttribute("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		int result = dao.checkLogin(id, passwd);
		
		request.setAttribute("result", result);
		
		return "/member/mainPage.jsp";
	}

}