package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int result = (Integer)request.getAttribute("result");
		request.setAttribute("result", result);
		
		
		return "/member/errorPage.jsp";
	}

}
