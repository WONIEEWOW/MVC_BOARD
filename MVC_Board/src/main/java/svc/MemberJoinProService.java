package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberJoinProService {

	public boolean joinMember(MemberBean member) {
//		System.out.println(isJoinSuccess);
		
		//1.boolean타입 변수 선언
		boolean isJoinSuccess = false;
		
		//2. 공통객체 가져오기
		Connection con = JdbcUtil.getConnection();
		
		//3. 공통 DAO 객체 가져오기
		MemberDAO dao = MemberDAO.getInstance();
		
		dao.setConnection(con);
		
		//4.MemberDAO 객체의 insertMember() 호출 
		int insertCount = dao.insertMember(member);
		
		//5. 작업 처리결과에 따른 트랜젝션 처리
		
		if(insertCount > 0) { //성공시
			JdbcUtil.commit(con);
			isJoinSuccess = true;
			
		} else {
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		
		return isJoinSuccess;
	}

}
