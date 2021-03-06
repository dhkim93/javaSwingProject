/* 
 * =============================
 * 프로그램 설명 : 회원가입, 회원정보 조회, 수정을 위한 DAO  
 * プログラムの説明: 会員加入、会員情報の照会、修正のためのDAO  
 * 작성자 : 황경하, 김덕현　　
 * 作成者 : ファン・ギョンハ、キム・ドクヒョン
 * 최초 작성일자 :  2017-07-14
 * 最初の作成日付　:　2017-07-14　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.memberjoin.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bs.util.DBUtil;
import com.bs.vo.MemberVO;

public class MemberDAO {

   public MemberVO setMemberregiste(MemberVO evo) throws Exception {
      // 데이터 처리를 위한 SQL 문　　データ処理のためのSQL文
      String dml = "INSERT INTO MEMBER " + "(ID" + ", PASSWORD" + ", NAME" + ", PHONE" + ", ADMIN_FLAG" + ", EMAIL"
            + ", GENDER" + ") VALUES (?, ?, ?, ?, ?, ?, ?)";

      Connection con = null;
      PreparedStatement pstmt = null;

      MemberVO retval = null;
      try {
         // DBUtil이라는 클래스의 getConnection( )메서드로 데이터베이스와 연결
	 // DBUtilと言うクラスのgetConnection( )メソッドにデータベースと連結
         con = DBUtil.getConnection();
         // 입력받은 사용자 정보를 처리하기 위하여 SQL문장을 생성
	 // 入力されたユーザの情報を処理するためにSQL文章を生成
         pstmt = con.prepareStatement(dml);

         pstmt.setString(1, evo.getId());
         pstmt.setString(2, evo.getPassword());
         pstmt.setString(3, evo.getName());
         pstmt.setString(4, evo.getPhone());
         pstmt.setInt(5, evo.getAdmin_flag());
         pstmt.setString(6, evo.getEmail());
         pstmt.setInt(7, evo.getGender());
         // SQL문을 수행후 처리 결과를 얻어옴
	 // SQL文を遂行の後、処理結果を得る
		
         int i = pstmt.executeUpdate();

         retval = new MemberVO();
         // retval.setStatus(i + "");
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         try {
            // 데이터베이스와의 연결에 사용되었던 오브젝트를 해제 データベースとの連結に使用されたオブジェクトを解除	
            if (pstmt != null)
               pstmt.close();
            if (con != null)
               con.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return retval;
   }
   
   //회원 중복체크 메서드 　　
   //会員重複チェックメソッド
   public ArrayList<MemberVO> getMemberExist(String id) throws Exception {
      ArrayList<MemberVO> list = new ArrayList<MemberVO>();
      String dml = "SELECT ID,PASSWORD,NAME,PHONE,EMAIL FROM MEMBER WHERE ID =?";
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      MemberVO retval = null;

      try {
         con = DBUtil.getConnection();

         pstmt = con.prepareStatement(dml);
         // 조회 조건　　
	 // 照会の条件
         pstmt.setString(1, id);

         rs = pstmt.executeQuery();
         while (rs.next()) {
            retval = new MemberVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            list.add(retval);
         }
      } catch (SQLException se) {
         se.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (rs != null)
               rs.close();
            if (pstmt != null)
               pstmt.close();
            if (con != null)
               con.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }
      }
      return list;
   }
   //회원정보 수정　　
   //会員情報の修正
   public int setUpdateMember(MemberVO mvo)throws Exception{
      // 데이터 처리를 위한 SQL 문　　
      // データ処理のためのSQL文
            String dml = "UPDATE MEMBER " + "   SET    " + "          PASSWORD = ? " + "        , NAME = ? "
                  + "        , PHONE = ? " + "        , EMAIL = ? "
                  + "   WHERE  ID = ? ";

            Connection con = null;
            PreparedStatement pstmt = null;
            int i = 0;

            try {
               // DBUtil이라는 클래스의 getConnection( )메서드로 데이터베이스와 연결
	       // DBUtilと言うクラスのgetConnection( )メソッドにデータベースとの連結
               con = DBUtil.getConnection();
               // 입력받은 사용자 정보를 처리하기 위하여 SQL문장을 생성
	       // 入力されたユーザの情報を処理するためにSQL文章を生成
               pstmt = con.prepareStatement(dml);

               System.out.print("##########" + mvo.getId());
               System.out.print("##########" + mvo.getPassword());
               System.out.print("##########" + mvo.getName());
               System.out.print("##########" + mvo.getPhone());
               System.out.print("##########" + mvo.getEmail());
               System.out.println();

               pstmt.setString(1, mvo.getPassword());
               pstmt.setString(2, mvo.getName());
               pstmt.setString(3,  mvo.getPhone());
               pstmt.setString(4,  mvo.getEmail());
               pstmt.setString(5,  mvo.getId());

               // SQL문을 수행후 처리 결과를 얻어옴	
	       // SQL文を遂行の後、処理結果を得る
               i = pstmt.executeUpdate();

            } catch (SQLException e) {
               e.printStackTrace();
            } catch (Exception e) {
               e.printStackTrace();
            } finally {
               try {
                  // 데이터베이스와의 연결에 사용되었던 오브젝트를 해제//データベースとの連結に使用されたオブジェクトを解除	
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

}