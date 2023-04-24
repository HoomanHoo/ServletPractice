package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import bean.MabDataBean;
import handler.CommandHandler;

public class ModifyFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = (String)session.getAttribute("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		int result = dao.checkLogin(id, passwd);
		MabDataBean dto = new MabDataBean();
		dto = dao.getInfo(id);
		id = dto.getId();
		String name = dto.getName();
		String license = dto.getLicense();
		if(result == 1) {
			request.setAttribute("result", result);
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("license", license);
		}
		
		return "/member/modifyForm.jsp";
	}

}
