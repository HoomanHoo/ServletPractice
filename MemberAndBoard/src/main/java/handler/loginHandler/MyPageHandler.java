package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import bean.MabDataBean;
import handler.CommandHandler;

public class MyPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = (String)session.getAttribute("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		MabDataBean dto = new MabDataBean();
		dto = dao.getInfo(id);
		id = dto.getId();
		passwd = dto.getPasswd();
		String name = dto.getName();
		String[] email = dto.getEmail().split("@");
		String[] tel = dto.getTel().split("-");
		String license = dto.getLicense();
		
		String tel1 = tel[0];
		String tel2 = tel[1];
		String tel3 = tel[2];
		
		String email1 = email[0];
		String email2 = email[1];
		
		
		int result = dao.checkLogin(id, passwd);
		if(result == 1) {
			request.setAttribute("result", result);
			request.setAttribute("id", id);
			request.setAttribute("passwd", passwd);
			request.setAttribute("name", name);
			request.setAttribute("tel1", tel1);
			request.setAttribute("tel2", tel2);
			request.setAttribute("tel3", tel3);
			request.setAttribute("email1", email1);
			request.setAttribute("email2", email2);
			request.setAttribute("license", license);
		}
		
		return "/member/myPage.jsp";
	}

}
