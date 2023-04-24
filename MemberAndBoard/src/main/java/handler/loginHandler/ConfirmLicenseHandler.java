package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MabDBBean;
import handler.CommandHandler;

public class ConfirmLicenseHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String license = request.getParameter("license");
		
		MabDBBean dao = MabDBBean.getInstance();
		int result = dao.checkMultipleLicence(license);
		request.setAttribute("result", result);
		
		return "/member/confirmlicense.jsp";
	}

}
