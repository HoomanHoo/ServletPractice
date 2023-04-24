package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MabDBBean;
import handler.CommandHandler;

public class ConfirmIdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		
		MabDBBean dao = MabDBBean.getInstance();
		int result = dao.checkMultiple(id);
		
		request.setAttribute("result", result);
		
		return "/member/confirmid.jsp";
	}

}
