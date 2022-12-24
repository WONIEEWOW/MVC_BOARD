package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginProSerivce;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;
		
		try {
			
			MemberBean member = new MemberBean();
			member.setId(request.getParameter("id"));
			member.setPasswd(request.getParameter("passwd"));
//		System.out.println(member);
			
			//--------------------------------------------------------------
			
			MemberLoginProSerivce service = new MemberLoginProSerivce();
			boolean isLoginSuccess = service.loginMember(member);
			
			if(!isLoginSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('로그인 실패!')");
				out.println("history.back()");
				out.println("</script>");

			} else { //로그인 성공 시
				HttpSession session = request.getSession();
				session.setAttribute("sId", member.getId());
				
				forward = new ActionForward();
				forward.setPath("/MVC_Board");
				forward.setRedirect(true);
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return forward;
	}

}
