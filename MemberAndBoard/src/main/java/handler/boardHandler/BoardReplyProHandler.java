package handler.boardHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import handler.CommandHandler;

public class BoardReplyProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String passwd = (String) session.getAttribute("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		int checkId = dao.checkLogin(id, passwd);
		if(checkId == 1) {
			int contentId = Integer.parseInt(request.getParameter("postNum"));
			String Content = request.getParameter("reply");
			int result = dao.insertReply(contentId, Content);
			if(result == 1) {
				request.setAttribute("postNum", contentId);
				url = "/board/replyPro.jsp";
			}
			else {
				request.setAttribute("result", result);
				url = "/member/errorPage.jsp"; 
			}
		}
		else {
			
			request.setAttribute("checkId", checkId);
			url = "/member/errorPage.jsp"; 
		}

		
		
		
		return url;
	}

}
