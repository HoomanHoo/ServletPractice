package handler.boardHandler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import bean.MabDataPostBean;
import bean.MabDataReplyBean;
import handler.CommandHandler;

public class BoardContentHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = (String)session.getAttribute("passwd");
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		System.out.println(postNum);
		MabDBBean dao = MabDBBean.getInstance();
		int checkId = dao.checkLogin(id, passwd);
		String url = null;
		
		if(checkId == 1) {
			MabDataPostBean dto = dao.getArticle(postNum);
			ArrayList<MabDataPostBean> dtos = dao.getList();
			ArrayList<MabDataReplyBean> reDtos = dao.getReplies(postNum);
			request.setAttribute("dto", dto);
			request.setAttribute("dtos", dtos);
			request.setAttribute("reDtos", reDtos);
			url = "/board/content.jsp";
		}
		else if(checkId == -5){
			request.setAttribute("checkId",  checkId);
			url = "/member/errorPage.jsp";
		}
		
		return url;
	}

}
