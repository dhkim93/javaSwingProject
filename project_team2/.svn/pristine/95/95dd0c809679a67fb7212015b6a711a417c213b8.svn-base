/* 
 * =============================
 * 프로그램 설명 : 후기나 Q&A를 작성할수있도록 기능구현  
 * プログラムの説明 : コメントやQ&Aを作成できるように機能の具現
 * 작성자 : 오내훈,박신영   
 * 作成者 : オ・ネフン、パク・シンヨン
 * 최초 작성일자 :  2017-07-19  
 * 最初の作成日付 :2017-07-19
 * 최종 수정일 :    
 * 最終の修正日 :
 * 수정 내용 :    
 * 修正の内容 :
 * =============================
 * */

package com.bs.board.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

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

public class BoardInsert extends JPanel implements ActionListener,ItemListener, MouseListener {

	private JTextField[] jt = new JTextField[3];
	private JLabel[] jl = new JLabel[5];
	private JButton jb1 = new JButton("登録する");//"등록하기"
	private JButton jb2 = new JButton("キャンセル"); //"취소하기"
	private JButton jb3 = new JButton("メインに移動");//"메인으로"
	private JCheckBox jc1, jc2;
	private JTextArea jta;
	private int i;
	private int qa = 3;
	private ButtonGroup butg;
	private NoticeBoardVO nbvo = null;
	private	Calendar today = Calendar.getInstance();
	private String today2;
	
	public BoardInsert(MainFrame win) {
		setBackground(Color.WHITE);

		
		// 등록하기 버튼 클릭했을때　　
		// 登録するボタンをクリックしたとき
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticeBoardVO nbvo = null;
				BoardDetailDAO bdao = null;
				if (e.getSource() == jb1) { // 등록하기 버튼 클릭했을때　　
							    // 登録するボタンをクリックしたとき
					try {
						System.out.println("@@@@@@@@@@@@@@ 작성자"
								+ jt[1].getText());
						System.out.println("@@@@@@@@@@@@@@ 제목"
								+ jt[0].getText());
						System.out.println("@@@@@@@@@@@@@@ 제목" + jta.getText());

						nbvo = new NoticeBoardVO(jt[1].getText() // 작성자　　
											 // 作成者
								, jt[0].getText() // 제목　　
										  // タイトル
								, jta.getText() // 내용　　
										// 内容
								, qa); // 게시글 분류　　
								       // 書き込みを分類

						if (jt[0].getText().equals(null)
								|| jt[0].getText().equals("")) {			
							JOptionPane.showMessageDialog(null, "タイトルを入力してください。","警告", i);//"제목을 입력해주세요","경고"
							return;

						} else if (qa == 3) {									
							JOptionPane.showMessageDialog(null, "チェックボックスを確認してください。","警告", i);//"체크박스를 확인해주세요","경고"

						} else if (jta.getText().equals(null)
								|| jta.getText().equals("")) {				
							JOptionPane.showMessageDialog(null, "内容を入力してください。","警告", i);//"내용을 입력해주세요","경고"

						} else {
							bdao = new BoardDetailDAO();
								if(qa ==2){						//Q&A체크박스를 체크했을 때　　
															//Q&Aチェックボックスをチェックしたとき
									nbvo.setSubject("Q&A))"+jt[0].getText());
								}else if(qa ==0){				//후기체크박스를 체크했을 때　　
														//コメントチェックボックスをチェックしたとき
									nbvo.setSubject("コメント ))"+jt[0].getText());
								}
								bdao.setBoardDetail(nbvo);			
							
							
																					
							JOptionPane.showMessageDialog(null, "セーブしますか。 ","お知らせ", i);//"저장하시겠습니까?", "알림"

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

		//취소하기 버튼 눌렀을때　　
		//キャンセルボタンを押した時
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == jb2) {		//게시판 화면으로 돌아감　　
										//掲示板の画面に戻る
						win.panelChange("Board", MainFrame.id);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		//메인으로 버튼 눌렀을때　　
		//メインに移動ボタンを押した時
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == jb3) {		//메인 화면으로 돌아감　　
										//メイン画面に戻る
						win.panelChange("LoginPage", MainFrame.id);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

	}
	
	public void getRefresh(String id){

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
		jl[4] = new JLabel("掲示板");
		jl[4].setBounds(120,10,100,300);
		jl[4].setFont(new Font("굴림", Font.PLAIN, 72));
		today2 = today.get(Calendar.YEAR)+ "-"+ (today.get(Calendar.MONTH)+1)+ "-"+today.get(Calendar.DAY_OF_MONTH);
		
										
		jt[0] = new JTextField("タイトルを入力してください。", 100);//"제목을 입력해 주세요"
		jt[0].setBounds(37, 80, 417, 21);
		jt[0].addMouseListener((MouseListener) this);
		
		jt[1] = new JTextField(10);
		jt[1].setBounds(476, 80, 156, 21);
		System.out.println("####################" + MainFrame.id);
		
		//jt[1].setText("♥"+MainFrame.id +" 様"+ "♥"); // 0
		jt[1].setText(MainFrame.id ); // 0
		
		jt[2] = new JTextField(today2,10);
		jt[2].setBounds(650, 80, 208, 21);

		//TextField 비활성화(글씨수정못하게막음)　　
		//TextFieldを無効化(字の修正ができないように阻止する)
		jt[1].setEditable(false);
		jt[2].setEditable(false);
		
		
		jta = new JTextArea(); // 게시판내용창　　
				       // 掲示板の内容画面
		jta.setBounds(37, 133, 821, 309);
		
		Color b=new Color(127,255,212);
		jta.setBackground(b);
		add(jta);

		jb1.setBounds(457, 475, 124, 23);
		jb2.setBounds(592, 475, 124, 23);
		jb3.setBounds(728, 475, 124, 23); // 버튼을 눌렀을 때 메인화면으로 돌아감　　
						  // ボタンを押した時のメイン画面に戻る
		
		butg = new ButtonGroup();
		butg.add(jc1);
		butg.add(jc2);
		
		jc1 = new JCheckBox("Q&A)) 知りたいことは何でも聞いてください。");//"Q&A)) 궁금한건 무엇이든 물어보세요 ŏםŏ"
		jc1.setBounds(37, 475, 300, 23);
		jc1.setBackground(Color.WHITE);
//		jc1.setBounds(Color.WHITE);
		jc1.addItemListener((ItemListener) this);
		jc2 = new JCheckBox("コメント )) ありがとうございます. (ฅ•0•ฅ)♡");//후기 )) 감사합니다 (ฅ•0•ฅ)♡"
		jc2.setBounds(37, 500, 300, 23);
		jc2.addItemListener((ItemListener) this);
		jc2.setBackground(Color.WHITE);

		add(jl[0]);
		add(jl[1]);
		add(jl[2]);
		add(jl[3]);
		add(jl[4]);
		add(jt[0]);
		add(jt[1]);
		add(jt[2]);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jc1);
		add(jc2);

		setVisible(true);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {	//"제목을입력해주세요"가 적혀있을때 마우스를 대면 초기화시키는 마우스이벤트　　
							//"タイトルを入力してください"が書かれているときにマウスを当てると初期化させるマウスイベント
		// TODO Auto-generated method stub
		if(jt[0].getText().equals("タイトルを入力してください。") || jt[0].getText().equals("タイトルを入力してください。")){
		jt[0].setText("");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	

}
