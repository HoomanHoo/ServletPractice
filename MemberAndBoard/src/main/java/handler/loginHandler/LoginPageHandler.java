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
		int result;
		if(id == null) {
			result = 0;
			request.setAttribute("result", result);
		}
		else {
			result = 1;
			request.setAttribute("result", result);
		}
		
		
		return "/member/loginPage.jsp";
	}

}
