package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardReplyProService {

	//답글쓰기 작업 요청을 위한 registReplyBoard()
	public boolean registReplyBoard(BoardBean board) {
			
			// 1. 글쓰기 작업 요청 처리 결과를 저장할 boolean 타입 변수 선언
			boolean isWriteSuccess = false;
			
			// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
			// => 트랜잭션 처리를 Service 객체에서 수행하므로
			//    DAO 가 아닌 Service 가 Connection 객체를 관리함
			Connection con = JdbcUtil.getConnection();
			
			// 3. BoardDAO 클래스로부터 BoardDAO 객체 가져오기(공통)
			// => 싱글톤 디자인 패턴으로 구현되어 있는 객체를 getInstance() 메서드로 리턴받기
			BoardDAO dao = BoardDAO.getInstance();
			
			// 4. BoardDAO 객체의 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
			dao.setConnection(con);
						
			// 5. BoardDAO 객체의insertReplyBoard() 메서드를 호출하여 글쓰기 작업 요청 및 결과 리턴받기
			// => 파라미터 : BoardBean 객체   리턴타입 : int(insertCount)
			int insertCount = dao.insertReplyBoard(board);
			
			// 6. 작업 처리 결과에 따른 트랜잭션 처리
			if(insertCount > 0) { // 성공 시
				JdbcUtil.commit(con);
				isWriteSuccess = true;
			} else { // 실패 시
				JdbcUtil.rollback(con);
			}
			
			// 7. Connection Pool 로부터 가져온 Connection 자원 반환(공통)
			// => 주의! DAO 객체 내에서 Connection 객체를 반환하지 않도록 해야한다!
			JdbcUtil.close(con);
			
			// 작업 요청 처리 결과 리턴
			return isWriteSuccess; // BoardWriteProAction 으로 리턴
	
	}

	
}
