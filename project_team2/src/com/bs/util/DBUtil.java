/* 
 * =============================
 * 프로그램 설명 : DB 커넥션 객체 생성을 위한 클래스 
 * プログラムの説明　: DBのコネクションのオブジェクト生成のためのクラス
 * 작성자 : 오내훈
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :　　2017-07-21
 * 最初の作成日付　:　2017-07-21　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://192.168.0.167:3306/team2";

	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "team2", "1234"); //DB 접속정보//DBの接続情報
		return con;
	}
}
