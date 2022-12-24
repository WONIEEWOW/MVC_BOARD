package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberListService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		MemberListService service = new MemberListService();
		
		ArrayList memberList = service.getMemberList();
		
//		System.out.println(memberList);
		
		//---------------------------------------------------------
		request.setAttribute("memberList", memberList);

		forward = new ActionForward();
		forward.setPath("member/member_list.jsp");
		forward.setRedirect(false); // 생략 가능
		
		return forward;
	}

}
