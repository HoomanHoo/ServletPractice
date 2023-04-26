package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import handler.CommandHandler;

public class LoginPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String url = null;
		if(id == null) {
			url = "/member/loginPage.jsp";
		}
		else {
			url = "/member/mainPage.jsp";
		}
		return url;
	}

}
