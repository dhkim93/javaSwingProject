/* 
 * =============================
 * 프로그램 설명 : 패널 화면을 불러와서 표시하는 메인프레임  
 * プログラムの説明　: 　パネルの画面を呼んできて表示するメインフレーム
 * 작성자 : 오내훈
 * 作成者 :  オ・ネフン
 * 최초 작성일자 :　　2017-07-19
 * 最初の作成日付　:　　2017-07-19
 * 최종 수정일 : 
 * 最終の修正日付　:
 * 수정 내용 : 	
 * 修正の内容 :
 * =============================
 * */

package com.bs.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.bs.adminpage.control.AdminPage;
import com.bs.adminpage.control.AdminPageDAO;
import com.bs.board.control.Board;
import com.bs.board.control.BoardDetail;
import com.bs.board.control.BoardInsert;
import com.bs.board.control.BoardUpdate;
import com.bs.loginpage.control.LoginPage;
import com.bs.memberjoin.control.MemberJoin;
import com.bs.mycart.control.MyCart;
import com.bs.mydressroom.control.MyDressRoom;
import com.bs.vo.AdminPageVO;

public class MainFrame extends JFrame implements Runnable{
	
	public static boolean autoSelect = false;
	
	public MainFrame() {
		Thread t = new Thread(this);
		t.setDaemon(true); //프로그램 종료시 데몬 종료//プログラム終了の時のデモンを終了
		t.start(); //데몬 스타트 //デーモンスタート
    }

	public AdminPage adminPage = null;  //관리자페이지//管理者ページ
	public LoginPage loginPage = null;  //로그인페이지//ログインページ
	public MyDressRoom myDressRoom = null; //내옷장 페이지//私のたんすページ
	public Board board = null;	//게시판 페이지//掲示板ページ
	public BoardDetail boardDetail = null; //게시판 상세보기 패널//掲示板詳細表示のパネル
	public BoardUpdate boardUpdate = null; //게시판 수정 패널//掲示板修正のパネル
	public BoardInsert boardInsert= null;  //게시판 글쓰기 패널 //掲示板書き込みのパネル
	public MyCart myCart = null; //장바구니 패널//カ-トのパネル
	public static String id;

	// 패널 변경 메서드//パネルの変更メソッド
	public void panelChange(String panelName, String id) throws Exception {
		this.id = id;

		if (panelName.equals("MyDressRoom")) { // 내옷장 화면//私のたんすの画面
			myDressRoom.getMyCloth(id);// 내 옷장에 있는 옷을 조회한다.//私のたんすにある服を照会する
			getContentPane().removeAll();
			getContentPane().add(myDressRoom);
			revalidate();
			repaint();

		} else if (panelName.equals("LoginPage")) { // 로그인 페이지//ログインページ
			
			loginPage.removeAll();
			int compCount = loginPage.refreshList();  //상품의 갯수//商品の数
			
			System.out.println("@@@@@@@compCount@@@@@@@ : "  +compCount + "@@@@@@@compCount@@@@@@@ : ");
			
			JScrollPane jsp = new JScrollPane(loginPage,					//스크롤 생성//スクロールを生成
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			jsp.getVerticalScrollBar().setUnitIncrement(16);    //스크롤 속도//スクロールの速度
			jsp.setBounds(0, 0, 890, 600); // 스크롤 페인 크기 지정//スクロール、スペインの大きさを指定
			Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성//サイズを指定するためのオブジェクトを生成
			size.setSize(880, compCount * 200 / 2);// 객체의 사이즈를 지정//オブジェクトのサイズを指定
			
			loginPage.setPreferredSize(size);// 사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈지정//サイズの情報を持っているオブジェクトを利用して、パネルのサイズを指定
			
			jsp.setViewportView(loginPage);  //스크롤 페인에 로그인 패널을 넣어준다.//スクロールペインにログインパネルを入れてあげる。
			
			getContentPane().removeAll();   //기존의 요소들을 삭제한다.//既存の要素を削除する。
			
			getContentPane().add(jsp); // 시작화면 = 로그인 화면//開始画面=ログイン画面
			
			// getContentPane().add(loginPage);
			revalidate();  //재설정//再設定
			repaint();	//다시 그리기//びを描く

		} else if (panelName.equals("Board")) { // 게시판 페이지//掲示板のページ

			board.removeAll(); //기존 board 게시판의 컴포넌트를 모두 지워준다//既存boardの掲示板のコンポーネントをすべて消してくれる
			board.getBoardRefresh(id); // 게시판을 다시 생성시켜준다.//掲示板を再び生成させてくれる
			getContentPane().removeAll(); //프레임의 컴포넌트 들을 모두 제거한다.//フレームのコンポーネントをすべて除去する
			getContentPane().add(board);  //board 프레임을 넣어준다.//boardフレームを入れてあげる
			revalidate();  //값초기화//価格を初期化
			repaint();     //다시쓰기//再び書き出し

		} else if (panelName.equals("MyCart")) { // 장바구니 페이지//カ-トのページ
			
			myCart.removeAll(); //기존에 있던 컴포넌트들을 제거한다.//既存のコンポーネントを除去する。
			myCart.revalidate();
			myCart.repaint();
			myCart.updateUI();
			myCart.getMyCartImage(id); // 카트에 담은 상품을 가져온다.//カートに入れた商品をもたらす。
			int comCount = myCart.getComponentCount(); // 가져온 컴포넌트 갯수//持ってきたコンポーネントの数

			JScrollPane jsp = new JScrollPane(myCart,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jsp.getVerticalScrollBar().setUnitIncrement(16);    //스크롤 속도//スクロールの速度
			jsp.setBounds(0, 0, 890, 600); // 스크롤 페인 크기 지정//スクロール、スペインの大きさ指定
			Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성//サイズを指定するためのオブジェクトを生成
			System.out.println("comCount 개수!!!!" + comCount);
			size.setSize(885, comCount * 200);// 객체의 사이즈를 지정//オブジェクトのサイズを指定

			myCart.setPreferredSize(size);// 사이즈 정보를 가지고 있는 객체를 이용해 패널의 사이즈 지정//サイズの情報を持っているオブジェクトを利用して、パネルのサイズを指定

			jsp.setViewportView(myCart);
			getContentPane().removeAll();
			getContentPane().add(jsp); //

			revalidate();
			repaint();
		} else if (panelName.equals("MemberJoin")) { // 회원 가입 페이지//会員加入ページ
			MemberJoin join = new MemberJoin();
			join.setVisible(true);
			join.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //종료시 프로세스제거 //終了の時プロセスを除去
			// this.setEnabled(false);
			
		} else if (panelName.equals("BoardDetail")) { // 게시판 상세 페이지//掲示板詳細ページ
			
			boardDetail.removeAll(); //기존 board 게시판의 컴포넌트를 모두 지워준다//既存boardの掲示板のコンポーネントをすべて消してくれる
			boardDetail.getRefresh(id); // 게시판을 다시 생성시켜준다.//掲示板を再び生成させてくれる。
			getContentPane().removeAll();
			getContentPane().add(boardDetail);
			revalidate();
			repaint();

		} else if (panelName.equals("BoardUpdate")) { // 게시판 수정 페이지//掲示板修正ページ
			
			boardUpdate.removeAll(); //기존 board 게시판의 컴포넌트를 모두 지워준다//既存boardの掲示板のコンポーネントをすべて消してくれる
			boardUpdate.getRefresh(id); // 게시판을 다시 생성시켜준다.//掲示板を再び生成させてくれる。
			getContentPane().removeAll();
			getContentPane().add(boardUpdate);
			revalidate();
			repaint();

		} else if (panelName.equals("BoardInsert")) { // 게시판 등록 페이지//掲示板登録ページ
			
			boardInsert.removeAll(); //기존 board 게시판의 컴포넌트를 모두 지워준다//既存boardの掲示板のコンポーネントをすべて消してくれる
			boardInsert.getRefresh(id); // 게시판을 다시 생성시켜준다.//掲示板を再び生成させてくれる。
			getContentPane().removeAll();
			getContentPane().add(boardInsert);
			revalidate();
			repaint();
		
		}else if (panelName.equals("AdminPage")) { // 관리자 페이지//管理者ページ
			
			adminPage.removeAll(); //기존 컴포넌트를 모두 지워준다//既存のコンポーネントをすべて消してくれる
			adminPage.getRefresh(id); // 다시 생성시켜준다.//再び生成させてくれる
			getContentPane().removeAll();
			getContentPane().add(adminPage);
			revalidate();
			repaint();
		
		}
			
	}

	public static void main(String[] args) throws Exception {
		
		MainFrame win = new MainFrame();
		win.setSize(900, 600);
		Dimension frameSize = win.getSize(); //프레임 사이즈 가져오기//フレームのサイズをもたらす
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //모니터 크기를 가져온다.//モニターの大きさをもたらす
		win.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); //윈도우 위치 계산//ウィンドウの位置計算
		win.setLayout(null); //레이아웃 없음 -> 동서남북 없애줌  //レイアウトない->東西南北なくす
		win.setTitle("2017 SUMMER SALE!"); //타이틀//タイトル
		
		win.adminPage = new AdminPage(win);  //로그인 페이지//ログインページ

		win.myDressRoom = new MyDressRoom(win); //내옷장//私のたんす
		win.board = new Board(win);	//게시판//掲示板
		win.boardDetail = new BoardDetail(win); //게시판 상세보기//掲示板詳細表示
		win.boardUpdate = new BoardUpdate(win);  //게시판 수정화면//掲示板修正画面
		win.boardInsert = new BoardInsert(win);  //게시판 등록화면//掲示板登録画面
		win.myCart = new MyCart(win);  //장바구니 화면//カ－トの画面
		win.loginPage = new LoginPage(win);  //로그인 페이지//ログインページ
		win.panelChange("LoginPage", id); // 시작화면은 로그인 페이지//開始画面は、ログインページ
		
		win.setVisible(true);
		win.setResizable(false); //리사이즈 금지//リサイズ禁止
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //종료시 프로세스제거 //終了の時プロセスを除去
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){

            if(autoSelect){
            	try {
					autoSelect();
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
            }
            
            try{
                Thread.sleep(5 * 1000);
            }catch(InterruptedException e){
            	e.printStackTrace();
            }
            
        }
	}
	
    private void autoSelect() throws Exception{
    	AdminPageDAO apdao = new AdminPageDAO();
    	ArrayList<AdminPageVO> list;
		list = apdao.getWalletList();
		
		if(list.get(0).getId()!=null){
//			JOptionPane.showMessageDialog(null, "캐쉬 충전 요청이 있습니다!!!", "警告", 0);//"패스워드가 틀렸습니다.", "경고"
			int dialogResult = JOptionPane.showConfirmDialog(null, "キャッシュ充電要請があります \n 管理者画面に行きませんか?", "お知らせ", 0); // "선택한 상품을 구매하시겠습니까?", "Warning"
			if (dialogResult == JOptionPane.YES_OPTION) {
				panelChange("AdminPage", MainFrame.id); // 관리자 페이지로 가기//管理者ページへ
				autoSelect = false; //메서드 실행안하기//メソッド実行しない
			}
		}
    }
}