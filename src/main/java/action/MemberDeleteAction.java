package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import svc.MemberDeleteProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
			
		try {
			
			String id = request.getParameter("id");
			
			System.out.println(id);
			
			MemberDeleteProService service = new MemberDeleteProService();
			boolean isDeleteSuccess = service.isDeleteMember(id);
//		System.out.println(isDeleteSuccess);
			
			if(!isDeleteSuccess) { //멤버 삭제 실패 시
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('회원 탈퇴 실패!')");
				out.println("history.back()");
				out.println("</script>");
			
			} else { //멤버 삭제 성공 시 
				forward = new ActionForward();
				forward.setPath("MemberList.me");
				forward.setRedirect(true);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return forward;
	}

}
