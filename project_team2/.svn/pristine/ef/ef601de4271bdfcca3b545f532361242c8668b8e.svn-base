/* 
 * =============================
 * 프로그램 설명 : 충전 요청 테이블을 생성하기 위한 클래스 
 * プログラムの説明:  充電要請のテーブルを生成するためのクラス
 * 작성자 : 오내훈 
 * 作成者 : オ・ネフン
 * 최초 작성일자 :  2017-07-27
 * 最初の作成日付　:　 2017-07-27　
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.adminpage.control;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bs.vo.AdminPageVO;

public class WalletModel extends AbstractTableModel {

	static Object[][] data;
	private Object[] columnName = { "ID", "BALANCE", "充電金額"};// 
	private AdminPageDAO apdao = new AdminPageDAO();
	private AdminPageVO apvo;
	private ArrayList<AdminPageVO> list;

	public WalletModel(AbstractTableModel model) throws Exception {

		// 열의 개수와 행의 개수를 알아야 2차원 배열선언//列の数と行の数を知ってこそ、2次元配列宣言
		// 테이블에서 컬럼이름을 얻어와서 1차원 배열 선언//テーブルでコラム名を得てきて1次元配列宣言
		list = apdao.getWalletList();
		int rowCount = list.size();
		data = new Object[rowCount][3];

		// 배열에 데이터 입력//配列にデータ入力
		for (int index = 0; index < rowCount; index++) {
			apvo = list.get(index);
			data[index][0] = apvo.getId();
			data[index][1] = apvo.getBalance();
			data[index][2] = apvo.getRequestCash();
		}
	}

	// 컬럼 카운트 반환 메서드 구현//ColumnCount返還メソッド具現
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if (columnName == null)
			return 0;
		else
			return columnName.length;
	}

	// 로우 카운트 반환 메서드 구현//RowCount返還メソッド具現
	public int getRowCount() {
		// TODO Auto-generated method stub
		if (data == null)
			return 0;
		else
			return data.length;
	}

	// getValue 메서드 구현//getValueメソッド具現
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	// 컬럼네임 반환 메서드 구현//ColumnName返還メソッド具現
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String) columnName[column];
	}

	// 셀 수정을 위한 메서드 구현
//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		return true;
//
//	}
//
//	// 셀 수정을 위한 메서드 구현
//	@Override
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		
//	
//	}
}