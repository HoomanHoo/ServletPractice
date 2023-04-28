package handler.boardHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import handler.CommandHandler;

public class BoardWriteProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = (String)session.getAttribute("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		int checkId = dao.checkLogin(id, passwd);
		String url = null;
		
		if(checkId == 1) {
			System.out.println("insert session id");
			System.out.println(id);
			String subject = request.getParameter("inputSub");
			String Content = request.getParameter("inputContent");
			int result = dao.insertArticle(id, subject, Content);
			
			if(result == 1) {
				url = "/board/boardWritePro.jsp";
			}
			else {
				request.setAttribute("result", result);
				url = "/member/errorPage.jsp";
			}
		}
		else if(checkId == -5){
			request.setAttribute("checkId",  checkId);
			url = "/member/errorPage.jsp";
		}
		
		return url;
		
	}

}
