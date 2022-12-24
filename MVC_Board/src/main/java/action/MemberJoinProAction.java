package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		MemberBean member = new MemberBean();
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setEmail(request.getParameter("email1")+"@"+request.getParameter("email2"));
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		System.out.println(member);
	
		
		//--------------------------------------------------------
		//MemberJoinProservice 클래스 인스턴스 생성 후
		//joinMember() 메서드 호출하여 회원가입 작업 요청
		//=> 파라미터 : MemberBean 객체   리턴타입 : boolean(isJoinSuccess)
		MemberJoinProService service = new MemberJoinProService();
		boolean isJoinSuccess = service.joinMember(member);
		
		try {
			//회원가입 처리결과 판별
			if(!isJoinSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('회원가입 실패!')");
				out.println("history.back()");
				out.println("</script>");
				
			} else { //회원가입 성공 시
				forward = new ActionForward();
				forward.setPath("member/member_join_result.jsp");
				forward.setRedirect(true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return forward;
	}

}
