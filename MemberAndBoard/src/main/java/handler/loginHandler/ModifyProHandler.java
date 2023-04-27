package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import handler.CommandHandler;

public class ModifyProHandler implements CommandHandler {

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

			passwd = request.getParameter("passwd");
			String tel1 = request.getParameter("tel1");
			String tel2 = request.getParameter("tel2");
			String tel3 = request.getParameter("tel3");
			String email1 = request.getParameter("email1");
			int email2 = Integer.parseInt(request.getParameter("email2"));
			String email = null;
			
			
			String tel = tel1 + "-" + tel2 + "-" + tel3;
			
			if(email2 == 0){
				email = email1;
			}
			else if(email2 == 1){
				email = email1 + "@daum.net";
			}
			else if(email2 == 2){
				email = email1 + "@naver.com";
			}
			else if(email2 == 3){
				email = email1 + "@gmail.com";
			}
			else if(email2 == 4){
				email = email1 + "@nate.com";
			}
			int result = dao.updateInfo(id, passwd, tel, email);
			
			if(result == 1) {
				url = "/member/modifyPro.jsp";
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
