package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import handler.CommandHandler;

public class DeleteProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = request.getParameter("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		String url = null;
		int result = dao.deleteMember(id, passwd);
		
		if(result == 1) {
			request.setAttribute("result", result);
			session.setAttribute("id", null);
			session.setAttribute("passwd", null);
			url = "/member/deletePro.jsp";
			
		}
		else if(result == 0){
			url = "/member/errorPage.jsp";
		}
		else if(result == -1) {
			request.setAttribute("result", result);
			url = "/member/deletePro.jsp";
			
		}
		
		return url;
	}

}
