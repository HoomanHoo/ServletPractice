package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.CommandHandler;

public class PageTopProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		session.setAttribute("id", null);
		session.setAttribute("passwd", null);
		return "/member/pageTopPro.jsp";
	}

}
