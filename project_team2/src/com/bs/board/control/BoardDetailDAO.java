/* 
 * =============================
 * 프로그램 설명 : DB에 있는 데이터를 가져오는 DAO  
 * プログラムの説明 : DBにあるデータをもってくるDAO
 * 작성자 : 오내훈, 박신영　　
 * 作成者 : オ・ネフン、パク・シンヨン
 * 최초 작성일자 : 　2017-07-11　
 * 最初の作成日付 : 2017-07-11
 * 최종 수정일 : 　　
 * 最終の修正日 :
 * 수정 내용 : 　　　
 * 修正の内容 :
 * =============================
 * */

package com.bs.board.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.util.DBUtil;
import com.bs.vo.NoticeBoardVO;

public class BoardDetailDAO {

	public NoticeBoardVO setBoardDetail(NoticeBoardVO nbvo) throws Exception {
		// 데이터 처리를 위한 SQL 문　　
		// データ処理のためのSQL文

		String dml = "INSERT INTO NOTICE_BOARD " + ""
				+ "(NO "   
				+ ", WRITER"
				+ ", SUBJECT" 
				+ ", CONTENT" 
				+ ", DATE" 
				+ ", FLAG"
				+ ") VALUES ("
				+ "  null"
				+ ", ?"
				+ ", ?"
				+ ", ?"
				+ ", DATE_FORMAT(now(), '%Y-%m-%d')"
				+ ", ? )";

		Connection con = null;
		PreparedStatement pstmt = null;

		NoticeBoardVO retval = null;
		try {
			// DBUtil이라는 클래스의 getConnection( )메서드로 데이터베이스와 연결　　
			// DBUtilというクラスのgetConnection( )メソッドにデータベースと連結
			con = DBUtil.getConnection();
			// 입력받은 사용자 정보를 처리하기 위하여 SQL문장을 생성　
                        // 入力されたユーザの情報を処理するためにSQL文章を生成

//			pstmt.setInt(1, nbvo.getNo());
			pstmt.setString(1, nbvo.getWriter());
			pstmt.setString(2, nbvo.getSubject());
			pstmt.setString(3, nbvo.getContent());
			pstmt.setInt(4, nbvo.getFlag());
			// SQL문을 수행후 처리 결과를 얻어옴　　
  			// SQL文を実行してから処理結果を得る
			int i = pstmt.executeUpdate();

			retval = new NoticeBoardVO();
			// retval.setStatus(i + "");
			System.out.println(retval.getSubject());

		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
			e.printStackTrace();
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제　　
				// データベースとの連結に使用されたオブジェクトを解除
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		}
		return retval;
	}

	//게시판 리스트를 조회한다.　　
	//掲示板のリストを照会する。
	public ArrayList<NoticeBoardVO> getBoardList() throws Exception {

		ArrayList<NoticeBoardVO> list = new ArrayList<NoticeBoardVO>();
		String dml = "select * from notice_board ";

		Statement stmt = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBoardVO retval = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(dml);
			// pstmt.setString(3, subject);
//			System.out.println("no\t유저\t제목\t내용\t날짜\t플래그");
			while (rs.next()) {
				retval = new NoticeBoardVO(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));

				list.add(retval);
				System.out.print(rs.getInt(1) + "\t");// rs.get자료형(속성순서 or 속성명)　　
								      // rs.getの資料型(属性の順序　or　属性名）　
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.println();
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {

			}

		}
		return list;
	}
	
	
	//게시물을 수정하는 메서드 　　
	//掲示物を修正するメソッド
	public int updateBoardDetail(NoticeBoardVO nbvo) throws Exception {
		// 데이터 처리를 위한 SQL 문　　
		//　データを処理のためのSQL文
		String dml = "UPDATE NOTICE_BOARD "
				+ "   SET    SUBJECT = ? "
				+ "        , CONTENT = ? "
				+ "   WHERE  NO      = ? ";

		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			// DBUtil이라는 클래스의 getConnection( )메서드로 데이터베이스와 연결　　
			// DBUtilというクラスのgetConnection( )メソッドにデータベースと連結
			con = DBUtil.getConnection();
			// 입력받은 사용자 정보를 처리하기 위하여 SQL문장을 생성　
			// 入力されたユーザの情報を処理するためにSQL文章を生成
			pstmt = con.prepareStatement(dml);

//			pstmt.setInt(1, nbvo.getNo());
			pstmt.setString(1, nbvo.getSubject());
			pstmt.setString(2, nbvo.getContent());
			pstmt.setInt(3, nbvo.getNo());
			// SQL문을 수행후 처리 결과를 얻어옴　　
			// SQL文を実行してから処理の結果を得る
			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
			e.printStackTrace();
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제　　　
				// データベースとの連結に使用されたオブジェクトを解除
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		}
		return i;
	}

	//내 옷장의 정보를 조회하는 메서드 　　
	//私のたんすの情報を照会するためのメソッド
	public ArrayList<NoticeBoardVO> getBoardDetail(int no) throws Exception {
		//id 조건 설정 　
		//idの条件を設定
		ArrayList<NoticeBoardVO> list = new ArrayList<NoticeBoardVO>();
		String dml = "SELECT WRITER"
				+ "				   , SUBJECT"
				+ "				   , CONTENT "
				+ "				   , DATE "
				+ "				   , FLAG "
				+ "	      FROM NOTICE_BOARD"
				+ "		  WHERE NO = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBoardVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(dml);
			//조회 조건 　　
			//照会の条件
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				retval = new NoticeBoardVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(retval);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return list;
	}
	
	

}
