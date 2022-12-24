package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberLoginProSerivce {


	public boolean loginMember(MemberBean member) {
		//1.boolean 변수 선언
		boolean isLoginSuccess = false;
		
		//2. 공통객체 가져오기
		Connection con = JdbcUtil.getConnection();
		
		//3. 공통 DAO 객체 가져오기
		MemberDAO dao = MemberDAO.getInstance();
		
		dao.setConnection(con);
		
		System.out.println("1111");
		//4.MemberDAO 객체의 loginMember() 호출 . 
		int loginMember = dao.selectMember(member);
		
		if(loginMember > 0) {
			JdbcUtil.commit(con);
			isLoginSuccess = true;
			
		} else {
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		
		return isLoginSuccess;
	}
	
	
	
	
	
	
}
