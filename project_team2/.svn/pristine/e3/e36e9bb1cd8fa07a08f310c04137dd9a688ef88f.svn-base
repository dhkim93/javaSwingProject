/* 
 * =============================
 * 프로그램 설명 : 관리자 테이블 생성을 위한 클래스 
 * プログラムの説明: 管理者テーブル生成のためのクラス
 * 작성자 : 오내훈
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :   2017-07-23　
 * 最初の作成日付　: 2017-07-23　
 * 최종 수정일 :  
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.adminpage.control;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.bs.vo.AdminPageVO;

public class AdminModel extends AbstractTableModel {

	static Object[][] data;
	static ArrayList udtList = new ArrayList(); //수정된 행번호를 전달하기위한 리스트//修正された行の番号を伝えるためのリスト
	private Object[] columnName = { "モデル名", "品目名", "サイズ", "ブランド", "価格", "素材", "登録日" };//"모델명", "품목명", "사이즈", "브랜드", "가격", "소재", "등록일자"//"モデル名"、"品目名"、"サイズ"、"ブランド"、"価格"、"素材"、"登録日"
	private AdminPageDAO apdao = new AdminPageDAO();
	private AdminPageVO apvo;
	private ArrayList<AdminPageVO> list;

	public AdminModel(DefaultTableModel model) throws Exception {

		// 열의 개수와 행의 개수를 알아야 2차원 배열선언//列の数と行の数を知ってこそ、2次元配列宣言
		// 테이블에서 컬럼이름을 얻어와서 1차원 배열 선언//テーブルでコラム名を得てきて1次元配列宣言
		list = apdao.getAdminList();
		int rowCount = list.size();  //테이블 행수//テーブルの行数
		data = new Object[rowCount][7];

		// 배열에 데이터 입력//配列にデータ入力
		for (int index = 0; index < rowCount; index++) {
			apvo = list.get(index);
			data[index][0] = apvo.getProductCode(); //제품코드//製品コード
			data[index][1] = apvo.getProductName(); //제품명//製品名
			data[index][2] = apvo.getSize();	 //제품 사이즈//製品サイズ
			data[index][3] = apvo.getBrand(); //제품 브랜드//製品ブランド
			data[index][4] = apvo.getPrice(); //제품 가격//製品価格
			data[index][5] = apvo.getMaterial(); //제품 소재//製品素材
			data[index][6] = apvo.getBuydate(); //제품 등록일자//製品を登録日
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
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;

	}

	// 셀 수정을 위한 메서드 구현//セルの修正のためメソッド具現
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		System.out.println("@@@@@@@@@@@@@@@" + aValue);
		System.out.println("@@@@@@@@@@@@@@@" + rowIndex);
		System.out.println("@@@@@@@@@@@@@@@" + columnIndex);
//		if (columnIndex == 4) { // 가격
//			// && aValue.toString().length() > 10
//		}else if (!aValue.toString().matches("^[0-9]*$") || (Integer.parseInt(aValue.toString()) <= 0) || aValue.toString().length() > 10) {
//				JOptionPane.showMessageDialog(this, "10글자 이하의 0 이상의 숫자만 입력해주세요.", "경고", 0);// "경고"
//		}

		if (columnIndex == 0 || columnIndex == 6) { // 상품 코드와 등록일자는 변경할수 없다.//商品コードと登録日は変更できない。
			JOptionPane.showMessageDialog(null, "該当する情報は変更できません。", "警告", 0);// "해당하는 정보는 변경할수 없습니다","경고"
			return;

		} else if (columnIndex == 1 && aValue.toString().length() > 10) { // 제품명
			JOptionPane.showMessageDialog(null, "10文字以上入力できません。", "警告", 0);// "10글자 이상 입력할수 없습니다.","경고"
			return;

		} else if (columnIndex == 2 && aValue.toString().length() > 2) { // 사이즈
			JOptionPane.showMessageDialog(null, "2文字以上入力できません。", "警告", 0);//"2글자 이상 입력할수 없습니다.", "경고"
			return;

		} else if (columnIndex == 3 && aValue.toString().length() > 10) { // 브랜드
			JOptionPane.showMessageDialog(null, "10文字以上入力できません。", "警告", 0);// "10글자 이상 입력할수 없습니다.", "경고"
			return;

		} else if (columnIndex == 4 && (aValue.toString().length() > 10 || !aValue.toString().matches("^[0-9]*$") || (Integer.parseInt(aValue.toString()) <= 0))){
			JOptionPane.showMessageDialog(null, "10文字以下の0以上の数字だけを入力してください。", "警告", 0);// "10글자 이하의 0 이상의 숫자만 입력해주세요.", "경고"
			return;
			
		} else if (columnIndex == 5 && aValue.toString().length() > 10) { // 소재
			JOptionPane.showMessageDialog(null, "10文字以上入力できません。", "警告", 0);// "10글자 이상 입력할수 없습니다." "경고"
			return;

		} else {
			data[rowIndex][columnIndex] = aValue;
			udtList.add(rowIndex); //수정한 행만 업데이트 하기 위한 변수//修正した行だけをアップデートするための変数
//			udtFlag = true;
		}
	}
}
