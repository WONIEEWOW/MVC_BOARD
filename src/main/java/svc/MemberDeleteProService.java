package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberDeleteProService {

	public boolean isDeleteMember(String id) {
		
		
		boolean isDeleteSuccess = false;
		
		//1. 공통작업1 - Connection 객체 가져오기
		Connection con = JdbcUtil.getConnection();
		
		//2. 공통작업2 - MemberDAO 객체 가져오기 
		MemberDAO dao = MemberDAO.getInstance();
		
		//3. 공통작업3- MemberDAO 객체에 Connection 객체 전달하기
		dao.setConnection(con);
		
		//* MemberDAO 의 deleteMember() 메서드를 호출하여 패스워드 확인 작업 수행
		// => 파라미터 : 아이디  리턴타입 : boolean(isDeleteSucess)
		int deleteCount = dao.deleteMember(id);
		
		//리턴받은 결과를 판별하여 commit, rollback
		if(deleteCount > 0) { // 성공 시
			JdbcUtil.commit(con);
			isDeleteSuccess = true;
		} else {  // 실패 시
			JdbcUtil.rollback(con);
		}
		
		
		// 공통작업-4. Connection 객체 반환하기
		JdbcUtil.close(con);
		
		return isDeleteSuccess;
	}


}
