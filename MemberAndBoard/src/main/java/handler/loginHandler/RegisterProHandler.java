package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MabDBBean;
import handler.CommandHandler;

public class RegisterProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String url = null;
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String license = request.getParameter("license");
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
		
		MabDBBean dao = MabDBBean.getInstance();
		int result = 0;
		result = dao.insertInfo(id, passwd, name, tel, email, license);
		if(result == 1) {
			url = "/member/registerPro.jsp";
		}
		else {
			request.setAttribute("result", result);
			url = "/member/errorPage.jsp";
		}
		
		return url;
	}

}
