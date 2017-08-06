/* 
 * =============================
 * 프로그램 설명 : 게시판 수정하기화면  
 * プログラムの説明 :  掲示板を修正する画面
 * 작성자 : 오내훈, 박신영    
 * 作成者 : オ・ネフン、パク・シンヨン
 * 최초 작성일자 :   2017-07-19
 * 最初の作成日付 :2017-07-19
 * 최종 수정일 :   
 * 最終の修正日 :
 * 수정 내용 :   
 * 修正の内容 :
 * =============================
 * */

package com.bs.board.control;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.bs.view.MainFrame;
import com.bs.vo.NoticeBoardVO;

public class BoardUpdate extends JPanel implements ActionListener, ItemListener {

	private JTextField[] jt = new JTextField[3];
	private JLabel[] jl = new JLabel[4];
	private JButton jb1 = new JButton("修正する");// "수정하기"
	private JButton jb2 = new JButton("キャンセル"); // "취소하기"
	private JButton jb3 = new JButton("メインに移動");// "메인으로"
	private JCheckBox jc1, jc2;
	private JTextArea jta;
	private int i;
	private int qa = 3;
	private ButtonGroup butg;
	private NoticeBoardVO nbvo = null;

	public BoardUpdate(MainFrame win) {
		setBackground(Color.WHITE);

		// 수정하기 버튼 클릭했을때　　
		// 修正するボタンをクリックしたとき
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticeBoardVO nbvo = null;
				BoardDetailDAO bdao = null;
				if (e.getSource() == jb1) { // 등록하기 버튼 클릭했을때　　
							    // 登録するボタンをクリックしたとき
					try {
						System.out.println("@@@@@@@@@@@@@@@@@2        "
								+ Board.selectedNum);

						nbvo = new NoticeBoardVO(jt[0].getText() // 제목　
										         // タイトル
								, jta.getText() // 내용　　
										// 内容
								, Board.selectedNum);

						if (jt[0].getText().equals(null)
								|| jt[0].getText().equals("")) {
							JOptionPane.showMessageDialog(null,
									"タイトルを入力してください.", "警告", i);// "제목을 입력해주세요","경고"
																
							return;

						} else if (qa == 3) {									
							JOptionPane.showMessageDialog(null, "チェックボックスを確認してください。","警告", i);//"체크박스를 확인해주세요","경고"

						}  else {

							bdao = new BoardDetailDAO();
							if (qa == 2) { // Q&A체크박스를 체크했을 때　　
								       // Q&Aチェックボックスをチェックしたとき
								nbvo.setSubject("Q&A))" + jt[0].getText());
							} else if (qa == 0) { // 후기체크박스를 체크했을 때　　
									      // コメントチェックボックスをチェックしたとき
								nbvo.setSubject("コメント ))" + jt[0].getText());
							}
							bdao.updateBoardDetail(nbvo);
							JOptionPane.showMessageDialog(null, "修正されました。",
									"お知らせ", 0);// "수정 되었습니다", "알림"
							Board.selectedNum = 0; // 선택한 로우넘 초기화　　
									       // 選択したselectedNumを初期化

							for (int i = 0; i < 3; i++) {
								jt[i].setText("");
							}

							jta.setText("");
							win.panelChange("Board", MainFrame.id);
						}

					} catch (Exception ea) {
						ea.printStackTrace();
					}
				}
			}
		});

		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == jb2) {
						win.panelChange("Board", MainFrame.id);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == jb3) {
						win.panelChange("LoginPage", MainFrame.id);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

	}

	public void getRefresh(String id) {

		// setBackground(Color.PINK);
		setBounds(new Rectangle(0, 0, 900, 600));
		setLayout(null);

		jl[0] = new JLabel("subject");
		jl[0].setBounds(37, 60, 417, 21);

		jl[1] = new JLabel("writer");
		jl[1].setBounds(476, 60, 417, 21);

		jl[2] = new JLabel("date");
		jl[2].setBounds(650, 60, 417, 21);

		jl[3] = new JLabel("content");
		jl[3].setBounds(37, 110, 208, 21);

		jt[0] = new JTextField(); // 제목　　
					  // タイトル
		jt[0].setBounds(37, 80, 417, 21);
		// jt[0].addMouseListener((MouseListener) this);

		jt[1] = new JTextField(10); // 이름　　
					    // 名前
		jt[1].setBounds(476, 80, 156, 21);

		System.out.println("####################" + MainFrame.id);

		jt[1].setText(MainFrame.id); // 0

		jt[2] = new JTextField(10); // 날짜　　
					    // 日付
		jt[2].setBounds(650, 80, 208, 21);

		jta = new JTextArea(); // 게시판내용창　　
				       // 掲示板の内容の画面
		jta.setBounds(37, 133, 821, 309);
		Color b=new Color(127,255,212);
		jta.setBackground(b);
		add(jta);

		jb1.setBounds(457, 475, 124, 23);
		jb2.setBounds(592, 475, 124, 23);
		jb3.setBounds(728, 475, 124, 23); // 버튼을 눌렀을 때 메인화면으로 돌아감　　
						  // ボタンを押した時、メイン画面に戻る

		butg = new ButtonGroup();
		butg.add(jc1);
		butg.add(jc2);

		jc1 = new JCheckBox("Q&A)) 知りたいことは何でも聞いてください。");//"Q&A)) 무엇이든지 물어보세요."
		jc1.setBounds(37, 475, 300, 23);
		jc1.addItemListener((ItemListener) this);
		jc1.setBackground(Color.WHITE);
		jc2 = new JCheckBox("コメント )) ありがとうございます. (ฅ•0•ฅ)♡"); //"후기 )) 감사합니다. (ฅ•0•ฅ)♡"
		jc2.setBounds(37, 500, 300, 23);
		jc2.addItemListener((ItemListener) this);
		jc2.setBackground(Color.WHITE);

		jt[1].setEditable(false); // 작성자　　
					  // 作成者
		jt[2].setEditable(false); // 날짜　　
					  // 日付

		add(jl[0]);
		add(jl[1]);
		add(jl[2]);
		add(jl[3]);
		add(jt[0]);
		add(jt[1]);
		add(jt[2]);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jc1);
		add(jc2);
		setVisible(true);

		try {
			ArrayList<NoticeBoardVO> list = new ArrayList<NoticeBoardVO>();
			BoardDetailDAO bddao = new BoardDetailDAO();
			list = bddao.getBoardDetail(Board.selectedNum);
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@" + Board.selectedNum);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {

					System.out.println("$$$$$$$$$$$$$$$$$$$$"
							+ list.get(i).getContent());
					System.out.println("@list.get(i).getSubject() : "
							+ list.get(i).getSubject());

					jt[0].setText(list.get(i).getSubject()); // 제목　　
										 // タイトル
					jta.setText(list.get(i).getContent()); // 내용　　
									       // 内容
					jt[1].setText(list.get(i).getWriter()); // 작성자　　
										// 作成者
					jt[2].setText(list.get(i).getDate()); // 날짜　　
									      // 日付
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 체크박스　　
	// チェックボックス
	public void itemStateChanged(ItemEvent e) {
		if ((e.getSource() == jc1) || e.getSource() == jc2) {
			if (jc1.isSelected()) { // Q&A를 선택했을 때　　
						// Q&Aを選択したとき
				qa = 2; // Q&A　
			} else {
				qa = 0;// 후기　
				       // コメント
			}
	}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 액션리스너　　
						     // アクションリスナー
		// TODO Auto-generated method stub

	}

}
