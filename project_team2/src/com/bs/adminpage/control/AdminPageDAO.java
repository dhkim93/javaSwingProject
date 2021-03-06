/* 
 * =============================
 * 프로그램 설명 : 관리자 페이지 DAO  
 * プログラムの説明:  管理者ページDAO
 * 작성자 : 오내훈 
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :   2017-07-11
 * 最初の作成日付　:　2017-07-11　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.adminpage.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.util.DBUtil;
import com.bs.vo.AdminPageVO;
import com.bs.vo.CartVO;
import com.bs.vo.ClothBasicVO;
import com.bs.vo.MyDressRoomVO;

public class AdminPageDAO {

	public ArrayList<AdminPageVO> getAdminList() throws Exception {

		ArrayList<AdminPageVO> list = new ArrayList<AdminPageVO>();
		String dml = "SELECT " + "PRODUCT_CODE" + ", PRODUCT_NAME" + ", SIZE" + ", BRAND" + ", PRICE" + ", MATERIAL"
				+ ", BUYDATE " + "FROM CLOTH_BASIC";

		Statement stmt = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminPageVO retval = null;
		try {

			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(dml);
			// "코드\t상품\t사이즈\t브랜드\t가격\t플래그"//"コード\t商品\tサイズ\tブランド\tの価格\tフラグ"
			// System.out.println("コ-ド\t商品\tサイズ\tブランド\t価格\tフラグ");
			while (rs.next()) {
				retval = new AdminPageVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getString(7));
				list.add(retval);
				// System.out.print(rs.getString(1) +"\t");//rs.get자료형(속성순서 or
				// 속성명)
				// System.out.print(rs.getString(2) +"\t");
				// System.out.print(rs.getString(3) +"\t");
				// System.out.print(rs.getString(4) +"\t");
				// System.out.print(rs.getInt(5) +"\t");
				// System.out.print(rs.getString(6) +"\t");
				// System.out.print(rs.getString(5) +"\t");
				// System.out.println();
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

	// image테이블의 정보 가져옴// imageテーブルの情報もたらす
	public ArrayList<MyDressRoomVO> getImgList() throws Exception {

		ArrayList<MyDressRoomVO> list = new ArrayList<MyDressRoomVO>();
		String dml = "SELECT " + "IMAGE_NAME" + ", IMAGE_PATH" + ", XAXIS" + ", YAXIS " + "FROM IMAGE_TABLE";

		Statement stmt = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyDressRoomVO retval = null;
		try {

			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(dml);
			// "코드\t상품\t사이즈\t브랜드\t가격\t플래그"//"コード\t商品\tサイズ\tブランド\tの価格\tフラグ"
			// System.out.println("コ-ド\t商品\tサイズ\tブランド\t価格\tフラグ");
			while (rs.next()) {
				retval = new MyDressRoomVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(retval);
				// System.out.print(rs.getString(1) +"\t");//rs.get자료형(속성순서 or
				// 속성명)
				// System.out.print(rs.getString(2) +"\t");
				// System.out.print(rs.getString(3) +"\t");
				// System.out.print(rs.getString(4) +"\t");
				// System.out.print(rs.getInt(5) +"\t");
				// System.out.print(rs.getString(6) +"\t");
				// System.out.print(rs.getString(5) +"\t");
				// System.out.println();
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

	// 게시물을 수정하는 메서드//掲示物を修正するメソッド
	public int updateAdminPage(ArrayList list) throws Exception {
		// 데이터 처리를 위한 SQL 문//データ処理のためのSQL文
		String dml = "UPDATE CLOTH_BASIC " + "   SET    " + "          PRODUCT_NAME = ? " + "        , SIZE = ? "
				+ "        , BRAND = ? " + "        , PRICE = ? " + "        , MATERIAL = ? "
				+ "   WHERE  PRODUCT_CODE = ? ";

		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			// DBUtil이라는 클래스의 getConnection( )메서드로 데이터베이스와 연결//DBUtilというクラスのgetConnection( )メソッドにデータベースと連結
			con = DBUtil.getConnection();
			// 입력받은 사용자 정보를 처리하기 위하여 SQL문장을 생성//入力されたユーザ情報を処理するためにSQL文章を生成
			pstmt = con.prepareStatement(dml);

			System.out.print("##########" + list.get(0));
			System.out.print("##########" + list.get(1));
			System.out.print("##########" + list.get(2));
			System.out.print("##########" + list.get(3));
			System.out.print("##########" + Integer.parseInt((list.get(4)).toString()));
			System.out.println();

			pstmt.setString(1, (String) list.get(1));
			pstmt.setString(2, (String) list.get(2));
			pstmt.setString(3, (String) list.get(3));
			pstmt.setInt(4, Integer.parseInt((list.get(4)).toString()));
			pstmt.setString(5, (String) list.get(5));
			pstmt.setString(6, (String) list.get(0));

			// SQL문을 수행후 처리 결과를 얻어옴// SQL文を実行してから処理結果を得てきたこと
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

	// 옷정보 등록//服の情報を登録
	public AdminPageVO setAdminList(String productCode, String productName) throws Exception {

		String dml = "INSERT INTO CLOTH_BASIC " + " " + "(PRODUCT_CODE" + ", PRODUCT_NAME" + ", SIZE" + ", BRAND"
				+ ", PRICE" + ", MATERIAL" + ", BUYDATE)" + " VALUES "
				+ " (?, ?, '', '', 0, '', DATE_FORMAT(now(), '%Y-%m-%d'))";

		Connection con = null;
		PreparedStatement pstmt = null;
		AdminPageVO retval = null;
		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);

			pstmt.setString(1, productCode);
			pstmt.setString(2, productName);

			int i = pstmt.executeUpdate();
			retval = new AdminPageVO();
			retval.setStatus(i);

		} catch (SQLException se) {
			System.out.println(se);
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return retval;

	}

	// 이미지정보 등록//イメージ情報を登録
	public AdminPageVO setImageList(AdminPageVO avo) throws Exception {

		String dml = "INSERT INTO IMAGE_TABLE " + " " + "(IMAGE_NAME" + ", IMAGE_PATH" + ", XAXIS" + ", YAXIS)"
				+ " VALUES " + " (?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;
		AdminPageVO retval = null;
		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);

			pstmt.setString(1, avo.getProductCode());
			pstmt.setString(2, avo.getProductCode() + ".png");
			pstmt.setInt(3, avo.getxAxis());
			pstmt.setInt(4, avo.getyAxis());

			int i = pstmt.executeUpdate();
			retval = new AdminPageVO();
			retval.setStatus(i);

		} catch (SQLException se) {
			System.out.println(se);
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return retval;

	}

	// 옷정보 삭제//服の情報を削除
	public int getDeleteCloth(String pCode) throws Exception {
		// id 조건 설정//idの条件設定
		ArrayList<ClothBasicVO> list = new ArrayList<ClothBasicVO>();
		String dml = "delete from cloth_basic where product_code= ?";//

		Connection con = null;
		PreparedStatement pstmt = null;
		int status = 0;
		CartVO retval = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			// 조회 조건//照会条件
			pstmt.setString(1, pCode);
			status = pstmt.executeUpdate();// delete,insert 일 경우 사용//delete,insertの場合、用いる
			// System.out.println(status);
			if (status == 1) {// 해당 레코드가 삭제된 경우//該当レコードが削除された場合
				System.out.println("삭제 완료!");
			} else {// 해당 레코드가 삭제되지 않은 경우//該当のレコードが削除されていない場合
				System.out.println("삭제 할 내용을 찾을 수 없습니다.!");
			}
		} catch (SQLException se) {
			System.out.println(se);
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

	/*
	 * //image정보 삭제 public int getDeleteImage(String imgName) throws Exception {
	 * //id 조건 설정 ArrayList<AdminPageVO> list = new ArrayList<AdminPageVO>();
	 * String dml = "delete from IMAGE_TABLE where IMAGE_NAME= ?";//
	 * 
	 * Connection con = null; PreparedStatement pstmt = null; int status=0;
	 * CartVO retval = null;
	 * 
	 * try { con = DBUtil.getConnection();
	 * 
	 * pstmt = con.prepareStatement(dml); //조회 조건 pstmt.setString(1, imgName);
	 * status = pstmt.executeUpdate(); // System.out.println(status);
	 * if(status==1){//해당 레코드가 삭제된 경우 System.out.println("삭제 완료!"); } else{//해당
	 * 레코드가 삭제되지 않은 경우 System.out.println("삭제 할 내용을 찾을 수 없습니다.!"); } } catch
	 * (SQLException se) { System.out.println(se); se.printStackTrace(); } catch
	 * (Exception e) { System.out.println(e); } finally { try { if (pstmt !=
	 * null) pstmt.close(); if (con != null) con.close(); } catch (SQLException
	 * se) { se.printStackTrace(); } } return status; }
	 */
	
	//지갑 테이블 정보 조회//財布テーブルの情報照会
	public ArrayList<AdminPageVO> getWalletList() throws Exception {

		ArrayList<AdminPageVO> list = new ArrayList<AdminPageVO>();
		String dml = "SELECT W_ID,BALANCE, REQUESTCASH FROM WALLET WHERE CONFIRM ='N'";

		Statement stmt = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminPageVO retval = null;
		try {

			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(dml);
			while (rs.next()) {
				retval = new AdminPageVO(rs.getString(1), rs.getString(2), rs.getString(3));
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
	
	
	
	//충전 승인 메서드 //充電承認のメソッド
	public int setCashConfirm(String id) throws Exception {
		int i =  0;
		
		//기존 요청 값에 더해준다.//もとの要請の価格に加えてくれる。
		String dml = "UPDATE WALLET SET BALANCE = BALANCE + REQUESTCASH, REQUESTCASH=0, CONFIRM = 'Y' "
						+ " WHERE W_ID = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, id);
			 i = pstmt.executeUpdate();
			
		} catch (SQLException e) { //예외처리//例外処理
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return i;
	}

}
