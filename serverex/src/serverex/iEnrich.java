package serverex;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.Vector;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JComboBox;

public class iEnrich extends JFrame {

	/**
	 * 
	 * @변수명 : serialVersionUID
	 * 
	 * @설명 : 직렬화시 필요한 변수 선언
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @변수명 : data
	 * 
	 * @설명 : 테이블에 표시될 데이터를 저장하는 벡터 변수 선언
	 * 
	 */

	@SuppressWarnings("rawtypes")

	private Vector data = null;

	/**
	 * 
	 * @변수명 : title
	 * 
	 * @설명 : 테이블에 표시될 타이틀을 저장하는 벡터 변수 선언
	 * 
	 */

	@SuppressWarnings("rawtypes")

	private Vector title = null;

	private JTable table = null;

	/**
	 * 
	 * @변수명 : model
	 * 
	 * @설명 : 테이블에 표시될 타이틀과 데이터를 저장하는 모델 객체 변수 선언
	 * 
	 */

	private DefaultTableModel model = null;

	/**
	 * 
	 * @변수명 : btnAdd
	 * 
	 * @설명 : 추가 버튼 객체 변수 선언
	 * 
	 */

	private JButton btnAdd = null;

	/**
	 * 
	 * @변수명 : btnDel
	 * 
	 * @설명 : 삭제 버튼 객체 변수 선언
	 * 
	 */

	private JButton btnDel = null;

	/**
	 * 
	 * @변수명 : btnUpdate
	 * 
	 * @설명 : 수정 버튼 객체 변수 선언
	 * 
	 */

	private JButton btnUpdate = null;

	/**
	 * 
	 * @변수명 : btnClear
	 * 
	 * @설명 : 초기화 버튼 객체 변수 선언
	 * 
	 */

	private JButton btnClear = null;

	/**
	 * 
	 * @변수명 : cd
	 * 
	 * @설명 : 번호를 표시하는 TextField 변수 선언
	 * 
	 */

	/**
	 * 
	 * @변수명 : grcm
	 * 
	 * @설명 : 코드을 표시하는 TextField 변수 선언
	 * 
	 */

	private JTextField grcm = null;

	/**
	 * 
	 * @변수명 : grcm
	 * 
	 * @설명 : 거래처명을 표시하는 TextField 변수 선언
	 * 
	 */
	private JTextField cd = null; // 거래처 코드 입력
	private JTextField ph1 = null;// 전화번호1
	private JTextField saupnum = null;// 사업자번호
	private JTextField jsaupjnum = null;// 종사업자번호
	private JTextField sh = null;// 상호
	private JTextField dp = null;// 대표
	private JTextField postnum = null; // 우편번호
	private JTextField Address1 = null; // 주소1
	private JTextField Address2 = null; // 주소2
	private JTextField ut = null; // 업태
	private JTextField jm = null; // 종목
	private JTextField ph2 = null; // 전화번호2
	private JTextField FAX = null; // FAX
	private JTextField dd1 = null; // 담당1
	private JTextField ch1 = null; // 휴대폰1
	private JTextField email1 = null; // 이메일1
	private JTextField email2 = null; // 이메일2
	private JTextField dd2 = null; // 담당2
	private JTextField ch2 = null; // 휴대폰2
	private JTextField memo = null;// 메모

	// 레이블 변수 선언

	private JLabel lblcd = null;

	private JLabel lblgrcm = null;

	private JLabel lblja = null;
	private JLabel lblgb = null;
	private JLabel lblswcd = null;
	private JLabel lblddsw = null;
	private JLabel lbljvcd = null;
	private JLabel lbljkjjb = null;
	private JLabel lblsaupnum = null;
	private JLabel lbljsaupjnum = null;
	private JLabel lblsh = null;
	private JLabel lbldp = null;
	private JLabel lblpostnum = null;
	private JLabel lblAddress1 = null;
	private JLabel lblAddress2 = null;
	private JLabel lblut = null;
	private JLabel lbljm = null;
	private JLabel lblph2 = null;
	private JLabel lblFAX = null;
	private JLabel lbldd1 = null;
	private JLabel lblch1 = null;
	private JLabel lblemail1 = null;
	private JLabel lblemail2 = null;
	private JLabel lbldd2 = null;
	private JLabel lblch2 = null;
	private JLabel lblgcja = null;
	private JLabel lbljjja = null;
	private JLabel lblmemo = null;
	private JLabel lblgrdd = null;
	private JLabel lblgrcgv = null;
	private JLabel lblcrdk = null;
	private JLabel lblgsgv = null;

	/**
	 * 
	 * @변수명 : Url
	 * 
	 * @설명 : 데이터베이스 연동시 필요한 URL 저장하는 변수와 유저 정보
	 * 
	 */

	private String Url = "jdbc:mysql://localhost:3306/재고관리"; // URL 정보 저장 변수

	private String user = "root"; // user 정보 저장 변수 -> hr

	private String password = "비밀번호"; // password 정보 저장 변수 -> hr

	/**
	 * 
	 * @변수명 : conn
	 * 
	 * @설명 : 데이터베이스 연동 Connection 객체 변수 선언
	 * 
	 */

	private Connection conn = null;

	/**
	 * 
	 * @변수명 : stmt
	 * 
	 * @설명 : 데이터베이스 연동 후 쿼리 결과를 구하는 Statement 객체 변수 선언
	 * 
	 */

	private Statement stmt = null;

	/**
	 * 
	 * @변수명 : pstmtAdd
	 * 
	 * @설명 : 추가(insert) 쿼리 실행하는 PreparedStatement 객체 변수 선언
	 * 
	 */

	private PreparedStatement pstmtAdd = null;

	/**
	 * 
	 * @변수명 : pstmtDel
	 * 
	 * @설명 : 삭제(delete) 쿼리 실행하는 PreparedStatement 객체 변수 선언
	 * 
	 */

	private PreparedStatement pstmtDel = null;

	/**
	 * 
	 * @변수명 : pstmtUpdate
	 * 
	 * @설명 : 수정(update) 쿼리 실행하는 PreparedStatement 객체 변수 선언
	 * 
	 */

	private PreparedStatement pstmtUpdate = null;

	/**
	 * 
	 * @생성자명 : JdbcVectorTableEvnetSample
	 * 
	 * @설명 : Frame 초기화, 패널 생성, 테이블 생성, 모델 생성, 화면에 필요한 컴포넌트 생성 및
	 * 
	 *     초기화
	 * 
	 */

	public iEnrich() {

		super("179141 김건우 거래처 관리");

//		데이터베이스 연동 Connection, Statement, 

//		각각의 PreparedStatement 생성, 초기화 메소드 , 중요 확인 필요

		preDbTreatment();

//		테이블에 표시될 데이터 벡터 생성

		data = new Vector<>();

//		테이블에 표시될 타이틀 벡터 생성, 초기화 

		title = new Vector<>();

		title.add("코드");
		title.add("거래처명");
		title.add("전화1");
		title.add("사업자번호");
		title.add("종사업장번호");
		title.add("상호");
		title.add("대표");
		title.add("우편번호");
		title.add("주소1");
		title.add("주소2");
		title.add("업태");
		title.add("종목");
		title.add("전화2");
		title.add("FAX");
		title.add("담당1");
		title.add("휴대폰1");
		title.add("e-mail1");
		title.add("담당2");
		title.add("휴대폰2");
		title.add("e-mail2");
		title.add("출고등급");
		title.add("과세포함");
		title.add("메모");

//		테이블에 표시될 모델 객체 생성

		model = new DefaultTableModel();

//		selectAll() : 데이터베이스  Member 테이블에 있는 모든 데이터를 가지고 오는 메소드

//		벡터 result에 저장

		Vector result = selectAll();

//		모델에 변경된 데이터(result)를 새로 적용

		model.setDataVector(result, title);

//		모델을 통해 테이블 생성

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

//		테이블에 스크롤팬 생성 

		JScrollPane sp = new JScrollPane(table);

//		테이블에 마우스 클릭(mouseClicked)시 처리될 이벤트 등록

		table.addMouseListener(new MouseAdapter() {

//			마우스 클릭시 처리를 담당하는 메소드 재정의

			@Override

			public void mouseClicked(MouseEvent e) {

//				getSelectedRow() : 테이블에서 선택된 줄의 값을 가지고 오는 메소드(0부터 시작됨) 

				int index = table.getSelectedRow();

//				현재 테이블에 표시되고 있는 data(모델)에서 index(현재 선택된 줄값)로 

//				1개의 레코드(줄) 전체를 벡터로 저장해서 in 벡터 변수에 대입

				Vector in = (Vector) data.get(index);

//				in 벡터에 들어있는 값을 각각의 String 변수에 대입 

				String 거래처코드 = (String) in.get(0);

				String 거래처명 = (String) in.get(1);

				String 상호 = (String) in.get(2);

				String 대표 = (String) in.get(5);
				String 사업자번호 = (String) in.get(3);
				String 종사업자번호 = (String) in.get(4);
				String 우편번호 = (String) in.get(6);
				String 주소one = (String) in.get(7);
				String 주소two = (String) in.get(8);
				String 업태 = (String) in.get(9);
				String 종목 = (String) in.get(10);
				String 담당one = (String) in.get(11);
				String 휴대폰one = (String) in.get(12);
				String 이메일one = (String) in.get(13);
				String 담당two = (String) in.get(14);
				String 휴대폰two = (String) in.get(15);
				String 이메일two = (String) in.get(16);
				String 전화one = (String) in.get(17);
				String 전화two = (String) in.get(18);
				String 팩스 = (String) in.get(19);
				String 메모 = (String) in.get(20);
//				화면에 표시된 각각의 TextField(번호, 이름, 주소)에 

//				값 setting

				cd.setText(거래처코드);

				grcm.setText(거래처명);

				sh.setText(상호);
				dp.setText(대표);
				saupnum.setText(사업자번호);
				jsaupjnum.setText(종사업자번호);
				postnum.setText(우편번호);
				Address1.setText(주소one);
				Address2.setText(주소two);
				ut.setText(업태);
				jm.setText(종목);
				dd1.setText(담당one);
				ch1.setText(휴대폰one);
				email1.setText(이메일one);
				dd2.setText(담당two);
				ch2.setText(휴대폰two);
				email2.setText(이메일two);
				ph1.setText(전화one);
				ph2.setText(전화two);
				FAX.setText(팩스);
				memo.setText(메모);

//				번호는 setEditable(false)로 수정 방지 처리

				// cd.setEditable(false);

//				grcm.setEditable(false);

//				Address1.setEditable(false);

			}

		});

//		화면에 표시될 패널 생성

		JPanel panel = new JPanel();

//		Frame의 ContentPane 컨테이너 가지오기

		Container c = getContentPane();

		c.add(sp, BorderLayout.CENTER);

		c.add(panel, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 89, 0, 0, 0, 0, 0, 57, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		// 레이블 생성

		lblcd = new JLabel("거래처코드");
		GridBagConstraints gbc_lblcd = new GridBagConstraints();
		gbc_lblcd.anchor = GridBagConstraints.EAST;
		gbc_lblcd.insets = new Insets(0, 0, 5, 5);
		gbc_lblcd.gridx = 0;
		gbc_lblcd.gridy = 1;
		panel_1.add(lblcd, gbc_lblcd);

		// 값을 입력받거나 표시할 텍스트필드(번호, 이름, 주소) 생성

		cd = new JTextField(10);
		GridBagConstraints gbc_cd = new GridBagConstraints();
		gbc_cd.anchor = GridBagConstraints.WEST;
		gbc_cd.insets = new Insets(0, 0, 5, 5);
		gbc_cd.gridx = 1;
		gbc_cd.gridy = 1;
		panel_1.add(cd, gbc_cd);

		btnUpdate = new JButton("수정");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.anchor = GridBagConstraints.NORTH;
		gbc_btnUpdate.gridx = 10;
		gbc_btnUpdate.gridy = 1;
		panel_1.add(btnUpdate, gbc_btnUpdate);

		lblgrcm = new JLabel("거래처명");
		GridBagConstraints gbc_lblgrcm = new GridBagConstraints();
		gbc_lblgrcm.anchor = GridBagConstraints.EAST;
		gbc_lblgrcm.insets = new Insets(0, 0, 5, 5);
		gbc_lblgrcm.gridx = 0;
		gbc_lblgrcm.gridy = 2;
		panel_1.add(lblgrcm, gbc_lblgrcm);

		grcm = new JTextField(10);
		GridBagConstraints gbc_grcm = new GridBagConstraints();
		gbc_grcm.anchor = GridBagConstraints.WEST;
		gbc_grcm.insets = new Insets(0, 0, 5, 5);
		gbc_grcm.gridx = 1;
		gbc_grcm.gridy = 2;
		panel_1.add(grcm, gbc_grcm);

		lblsh = new JLabel("상호");
		GridBagConstraints gbc_lblsh = new GridBagConstraints();
		gbc_lblsh.anchor = GridBagConstraints.EAST;
		gbc_lblsh.insets = new Insets(0, 0, 5, 5);
		gbc_lblsh.gridx = 0;
		gbc_lblsh.gridy = 3;
		panel_1.add(lblsh, gbc_lblsh);

		sh = new JTextField(10);
		GridBagConstraints gbc_sh = new GridBagConstraints();
		gbc_sh.anchor = GridBagConstraints.NORTHWEST;
		gbc_sh.insets = new Insets(0, 0, 5, 5);
		gbc_sh.gridx = 1;
		gbc_sh.gridy = 3;
		panel_1.add(sh, gbc_sh);

		JLabel lbldp = new JLabel("대표자명");
		GridBagConstraints gbc_lbldp = new GridBagConstraints();
		gbc_lbldp.anchor = GridBagConstraints.EAST;
		gbc_lbldp.insets = new Insets(0, 0, 5, 5);
		gbc_lbldp.gridx = 6;
		gbc_lbldp.gridy = 3;
		panel_1.add(lbldp, gbc_lbldp);

		dp = new JTextField();
		GridBagConstraints gbc_dp = new GridBagConstraints();
		gbc_dp.insets = new Insets(0, 0, 5, 5);
		gbc_dp.fill = GridBagConstraints.HORIZONTAL;
		gbc_dp.gridx = 7;
		gbc_dp.gridy = 3;
		panel_1.add(dp, gbc_dp);
		dp.setColumns(10);

		// 버튼(추가, 삭제, 수정, 초기화) 생성

		btnAdd = new JButton("추가");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 10;
		gbc_btnAdd.gridy = 3;
		panel_1.add(btnAdd, gbc_btnAdd);

		JLabel lblsaupnum = new JLabel("사업자등록번호");
		GridBagConstraints gbc_lblsaupnum = new GridBagConstraints();
		gbc_lblsaupnum.anchor = GridBagConstraints.EAST;
		gbc_lblsaupnum.insets = new Insets(0, 0, 5, 5);
		gbc_lblsaupnum.gridx = 0;
		gbc_lblsaupnum.gridy = 4;
		panel_1.add(lblsaupnum, gbc_lblsaupnum);

		saupnum = new JTextField();
		GridBagConstraints gbc_saupnum = new GridBagConstraints();
		gbc_saupnum.insets = new Insets(0, 0, 5, 5);
		gbc_saupnum.fill = GridBagConstraints.HORIZONTAL;
		gbc_saupnum.gridx = 1;
		gbc_saupnum.gridy = 4;
		panel_1.add(saupnum, gbc_saupnum);
		saupnum.setColumns(10);

		JLabel lbljsaupjnum = new JLabel("종사업장번호");
		GridBagConstraints gbc_lbljsaupjnum = new GridBagConstraints();
		gbc_lbljsaupjnum.anchor = GridBagConstraints.EAST;
		gbc_lbljsaupjnum.insets = new Insets(0, 0, 5, 5);
		gbc_lbljsaupjnum.gridx = 6;
		gbc_lbljsaupjnum.gridy = 4;
		panel_1.add(lbljsaupjnum, gbc_lbljsaupjnum);

		jsaupjnum = new JTextField();
		GridBagConstraints gbc_jsaupjnum = new GridBagConstraints();
		gbc_jsaupjnum.insets = new Insets(0, 0, 5, 5);
		gbc_jsaupjnum.fill = GridBagConstraints.HORIZONTAL;
		gbc_jsaupjnum.gridx = 7;
		gbc_jsaupjnum.gridy = 4;
		panel_1.add(jsaupjnum, gbc_jsaupjnum);
		jsaupjnum.setColumns(10);

		btnDel = new JButton("삭제");
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.insets = new Insets(0, 0, 5, 0);
		gbc_btnDel.gridx = 10;
		gbc_btnDel.gridy = 4;
		panel_1.add(btnDel, gbc_btnDel);

		JLabel lblAddress1 = new JLabel("사업장소재지");
		GridBagConstraints gbc_lblAddress1 = new GridBagConstraints();
		gbc_lblAddress1.anchor = GridBagConstraints.EAST;
		gbc_lblAddress1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress1.gridx = 0;
		gbc_lblAddress1.gridy = 5;
		panel_1.add(lblAddress1, gbc_lblAddress1);

		postnum = new JTextField();
		GridBagConstraints gbc_postnum = new GridBagConstraints();
		gbc_postnum.insets = new Insets(0, 0, 5, 5);
		gbc_postnum.fill = GridBagConstraints.HORIZONTAL;
		gbc_postnum.gridx = 1;
		gbc_postnum.gridy = 5;
		panel_1.add(postnum, gbc_postnum);
		postnum.setColumns(10);

		btnClear = new JButton("초기화");
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 10;
		gbc_btnClear.gridy = 5;
		panel_1.add(btnClear, gbc_btnClear);

		Address1 = new JTextField();
		GridBagConstraints gbc_Address1 = new GridBagConstraints();
		gbc_Address1.gridwidth = 4;
		gbc_Address1.insets = new Insets(0, 0, 5, 5);
		gbc_Address1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Address1.gridx = 1;
		gbc_Address1.gridy = 6;
		panel_1.add(Address1, gbc_Address1);
		Address1.setColumns(10);

		Address2 = new JTextField();
		GridBagConstraints gbc_Address2 = new GridBagConstraints();
		gbc_Address2.gridwidth = 4;
		gbc_Address2.insets = new Insets(0, 0, 5, 5);
		gbc_Address2.fill = GridBagConstraints.HORIZONTAL;
		gbc_Address2.gridx = 1;
		gbc_Address2.gridy = 7;
		panel_1.add(Address2, gbc_Address2);
		Address2.setColumns(10);

		JLabel lblut = new JLabel("업태");
		GridBagConstraints gbc_lblut = new GridBagConstraints();
		gbc_lblut.anchor = GridBagConstraints.EAST;
		gbc_lblut.insets = new Insets(0, 0, 5, 5);
		gbc_lblut.gridx = 0;
		gbc_lblut.gridy = 8;
		panel_1.add(lblut, gbc_lblut);

		ut = new JTextField();
		GridBagConstraints gbc_ut = new GridBagConstraints();
		gbc_ut.insets = new Insets(0, 0, 5, 5);
		gbc_ut.fill = GridBagConstraints.HORIZONTAL;
		gbc_ut.gridx = 1;
		gbc_ut.gridy = 8;
		panel_1.add(ut, gbc_ut);
		ut.setColumns(10);

		JLabel lbljm = new JLabel("종목");
		GridBagConstraints gbc_lbljm = new GridBagConstraints();
		gbc_lbljm.anchor = GridBagConstraints.EAST;
		gbc_lbljm.insets = new Insets(0, 0, 5, 5);
		gbc_lbljm.gridx = 6;
		gbc_lbljm.gridy = 8;
		panel_1.add(lbljm, gbc_lbljm);

		jm = new JTextField();
		GridBagConstraints gbc_jm = new GridBagConstraints();
		gbc_jm.insets = new Insets(0, 0, 5, 5);
		gbc_jm.fill = GridBagConstraints.HORIZONTAL;
		gbc_jm.gridx = 7;
		gbc_jm.gridy = 8;
		panel_1.add(jm, gbc_jm);
		jm.setColumns(10);

		JLabel lbldd1 = new JLabel("담당1");
		GridBagConstraints gbc_lbldd1 = new GridBagConstraints();
		gbc_lbldd1.anchor = GridBagConstraints.EAST;
		gbc_lbldd1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldd1.gridx = 0;
		gbc_lbldd1.gridy = 10;
		panel_1.add(lbldd1, gbc_lbldd1);

		dd1 = new JTextField();
		GridBagConstraints gbc_dd1 = new GridBagConstraints();
		gbc_dd1.insets = new Insets(0, 0, 5, 5);
		gbc_dd1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dd1.gridx = 1;
		gbc_dd1.gridy = 10;
		panel_1.add(dd1, gbc_dd1);
		dd1.setColumns(10);

		JLabel lblch1 = new JLabel("휴대폰1");
		GridBagConstraints gbc_lblch1 = new GridBagConstraints();
		gbc_lblch1.gridwidth = 2;
		gbc_lblch1.anchor = GridBagConstraints.EAST;
		gbc_lblch1.insets = new Insets(0, 0, 5, 5);
		gbc_lblch1.gridx = 5;
		gbc_lblch1.gridy = 10;
		panel_1.add(lblch1, gbc_lblch1);

		ch1 = new JTextField();
		GridBagConstraints gbc_ch1 = new GridBagConstraints();
		gbc_ch1.gridwidth = 2;
		gbc_ch1.insets = new Insets(0, 0, 5, 5);
		gbc_ch1.fill = GridBagConstraints.HORIZONTAL;
		gbc_ch1.gridx = 7;
		gbc_ch1.gridy = 10;
		panel_1.add(ch1, gbc_ch1);
		ch1.setColumns(10);

		JLabel lblemail1 = new JLabel("e-mail1");
		GridBagConstraints gbc_lblemail1 = new GridBagConstraints();
		gbc_lblemail1.anchor = GridBagConstraints.EAST;
		gbc_lblemail1.insets = new Insets(0, 0, 5, 5);
		gbc_lblemail1.gridx = 0;
		gbc_lblemail1.gridy = 11;
		panel_1.add(lblemail1, gbc_lblemail1);

		email1 = new JTextField();
		GridBagConstraints gbc_email1 = new GridBagConstraints();
		gbc_email1.gridwidth = 3;
		gbc_email1.insets = new Insets(0, 0, 5, 5);
		gbc_email1.fill = GridBagConstraints.HORIZONTAL;
		gbc_email1.gridx = 1;
		gbc_email1.gridy = 11;
		panel_1.add(email1, gbc_email1);
		email1.setColumns(10);

		JLabel lbldd2 = new JLabel("담당2");
		GridBagConstraints gbc_lbldd2 = new GridBagConstraints();
		gbc_lbldd2.anchor = GridBagConstraints.EAST;
		gbc_lbldd2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldd2.gridx = 0;
		gbc_lbldd2.gridy = 12;
		panel_1.add(lbldd2, gbc_lbldd2);

		dd2 = new JTextField();
		GridBagConstraints gbc_dd2 = new GridBagConstraints();
		gbc_dd2.insets = new Insets(0, 0, 5, 5);
		gbc_dd2.fill = GridBagConstraints.HORIZONTAL;
		gbc_dd2.gridx = 1;
		gbc_dd2.gridy = 12;
		panel_1.add(dd2, gbc_dd2);
		dd2.setColumns(10);

		JLabel lblch2 = new JLabel("휴대폰2");
		GridBagConstraints gbc_lblch2 = new GridBagConstraints();
		gbc_lblch2.gridwidth = 2;
		gbc_lblch2.anchor = GridBagConstraints.EAST;
		gbc_lblch2.insets = new Insets(0, 0, 5, 5);
		gbc_lblch2.gridx = 5;
		gbc_lblch2.gridy = 12;
		panel_1.add(lblch2, gbc_lblch2);

		ch2 = new JTextField();
		GridBagConstraints gbc_ch2 = new GridBagConstraints();
		gbc_ch2.gridwidth = 2;
		gbc_ch2.insets = new Insets(0, 0, 5, 5);
		gbc_ch2.fill = GridBagConstraints.HORIZONTAL;
		gbc_ch2.gridx = 7;
		gbc_ch2.gridy = 12;
		panel_1.add(ch2, gbc_ch2);
		ch2.setColumns(10);

		JLabel lblemail2 = new JLabel("e-mail2");
		GridBagConstraints gbc_lblemail2 = new GridBagConstraints();
		gbc_lblemail2.anchor = GridBagConstraints.EAST;
		gbc_lblemail2.insets = new Insets(0, 0, 5, 5);
		gbc_lblemail2.gridx = 0;
		gbc_lblemail2.gridy = 13;
		panel_1.add(lblemail2, gbc_lblemail2);

		email2 = new JTextField();
		GridBagConstraints gbc_email2 = new GridBagConstraints();
		gbc_email2.gridwidth = 3;
		gbc_email2.insets = new Insets(0, 0, 5, 5);
		gbc_email2.fill = GridBagConstraints.HORIZONTAL;
		gbc_email2.gridx = 1;
		gbc_email2.gridy = 13;
		panel_1.add(email2, gbc_email2);
		email2.setColumns(10);

		JLabel lblph1 = new JLabel("전화번호1");
		GridBagConstraints gbc_lblph1 = new GridBagConstraints();
		gbc_lblph1.anchor = GridBagConstraints.EAST;
		gbc_lblph1.insets = new Insets(0, 0, 5, 5);
		gbc_lblph1.gridx = 0;
		gbc_lblph1.gridy = 15;
		panel_1.add(lblph1, gbc_lblph1);

		ph1 = new JTextField();
		GridBagConstraints gbc_ph1 = new GridBagConstraints();
		gbc_ph1.gridwidth = 2;
		gbc_ph1.insets = new Insets(0, 0, 5, 5);
		gbc_ph1.fill = GridBagConstraints.HORIZONTAL;
		gbc_ph1.gridx = 1;
		gbc_ph1.gridy = 15;
		panel_1.add(ph1, gbc_ph1);
		ph1.setColumns(10);

		JLabel lblph2 = new JLabel("전화번호2");
		GridBagConstraints gbc_lblph2 = new GridBagConstraints();
		gbc_lblph2.gridwidth = 2;
		gbc_lblph2.anchor = GridBagConstraints.EAST;
		gbc_lblph2.insets = new Insets(0, 0, 5, 5);
		gbc_lblph2.gridx = 5;
		gbc_lblph2.gridy = 15;
		panel_1.add(lblph2, gbc_lblph2);

		ph2 = new JTextField();
		GridBagConstraints gbc_ph2 = new GridBagConstraints();
		gbc_ph2.gridwidth = 2;
		gbc_ph2.insets = new Insets(0, 0, 5, 5);
		gbc_ph2.fill = GridBagConstraints.HORIZONTAL;
		gbc_ph2.gridx = 7;
		gbc_ph2.gridy = 15;
		panel_1.add(ph2, gbc_ph2);
		ph2.setColumns(10);

		JLabel lblFAX = new JLabel("FAX");
		GridBagConstraints gbc_lblFAX = new GridBagConstraints();
		gbc_lblFAX.anchor = GridBagConstraints.EAST;
		gbc_lblFAX.insets = new Insets(0, 0, 5, 5);
		gbc_lblFAX.gridx = 0;
		gbc_lblFAX.gridy = 16;
		panel_1.add(lblFAX, gbc_lblFAX);

		FAX = new JTextField();
		GridBagConstraints gbc_FAX = new GridBagConstraints();
		gbc_FAX.gridwidth = 2;
		gbc_FAX.insets = new Insets(0, 0, 5, 5);
		gbc_FAX.fill = GridBagConstraints.HORIZONTAL;
		gbc_FAX.gridx = 1;
		gbc_FAX.gridy = 16;
		panel_1.add(FAX, gbc_FAX);
		FAX.setColumns(10);

		JLabel lblcgdk = new JLabel("출고등급");
		GridBagConstraints gbc_lblcgdk = new GridBagConstraints();
		gbc_lblcgdk.anchor = GridBagConstraints.EAST;
		gbc_lblcgdk.insets = new Insets(0, 0, 5, 5);
		gbc_lblcgdk.gridx = 6;
		gbc_lblcgdk.gridy = 19;
		panel_1.add(lblcgdk, gbc_lblcgdk);

		String cg[] = { "출고가_A", "출고가_B", "출고가_C", "출고가_E", "출고가_F" };
		JComboBox cgdk = new JComboBox(cg);
		GridBagConstraints gbc_cgdk = new GridBagConstraints();
		gbc_cgdk.insets = new Insets(0, 0, 5, 5);
		gbc_cgdk.fill = GridBagConstraints.HORIZONTAL;
		gbc_cgdk.gridx = 7;
		gbc_cgdk.gridy = 19;
		panel_1.add(cgdk, gbc_cgdk);

		JLabel lblgrcgv = new JLabel("거래처구분");
		GridBagConstraints gbc_lblgrcgv = new GridBagConstraints();
		gbc_lblgrcgv.anchor = GridBagConstraints.EAST;
		gbc_lblgrcgv.insets = new Insets(0, 0, 5, 5);
		gbc_lblgrcgv.gridx = 0;
		gbc_lblgrcgv.gridy = 20;
		panel_1.add(lblgrcgv, gbc_lblgrcgv);

		String gb[] = { "매출처", "매입처", "혼합처" };
		JComboBox grcgv = new JComboBox(gb);
		GridBagConstraints gbc_grcgv = new GridBagConstraints();
		gbc_grcgv.insets = new Insets(0, 0, 5, 5);
		gbc_grcgv.fill = GridBagConstraints.HORIZONTAL;
		gbc_grcgv.gridx = 1;
		gbc_grcgv.gridy = 20;
		panel_1.add(grcgv, gbc_grcgv);

		JLabel lblgsgv = new JLabel("과세구분");
		GridBagConstraints gbc_lblgsgv = new GridBagConstraints();
		gbc_lblgsgv.anchor = GridBagConstraints.EAST;
		gbc_lblgsgv.insets = new Insets(0, 0, 5, 5);
		gbc_lblgsgv.gridx = 0;
		gbc_lblgsgv.gridy = 21;
		panel_1.add(lblgsgv, gbc_lblgsgv);

		String gg[] = { "포함", "별도", "면세", "영세율", "없음" };
		JComboBox gsgv = new JComboBox(gg);
		GridBagConstraints gbc_gsgv = new GridBagConstraints();
		gbc_gsgv.insets = new Insets(0, 0, 5, 5);
		gbc_gsgv.fill = GridBagConstraints.HORIZONTAL;
		gbc_gsgv.gridx = 1;
		gbc_gsgv.gridy = 21;
		panel_1.add(gsgv, gbc_gsgv);

		JLabel lblmemo = new JLabel("메모");
		GridBagConstraints gbc_lblmemo = new GridBagConstraints();
		gbc_lblmemo.anchor = GridBagConstraints.EAST;
		gbc_lblmemo.insets = new Insets(0, 0, 0, 5);
		gbc_lblmemo.gridx = 1;
		gbc_lblmemo.gridy = 23;
		panel_1.add(lblmemo, gbc_lblmemo);

		memo = new JTextField();
		GridBagConstraints gbc_memo = new GridBagConstraints();
		gbc_memo.gridwidth = 8;
		gbc_memo.insets = new Insets(0, 0, 0, 5);
		gbc_memo.fill = GridBagConstraints.HORIZONTAL;
		gbc_memo.gridx = 2;
		gbc_memo.gridy = 23;
		panel_1.add(memo, gbc_memo);
		memo.setColumns(10);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 370, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 57, 0 };
		gbl_panel_2.rowHeights = new int[] { 23, 23, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		// 컨테이너에 테이블, 패널(텍스트필드, 번트이 포함된 패널) 추가

		JLabel label = new JLabel("    거래처 관리", SwingConstants.LEFT);
		label.setFont(new Font("굴림", Font.BOLD, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridheight = 2;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_2.add(label, gbc_label);

		JButton btnNewButton_1 = new JButton("일괄 거래처 수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 1;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton("일괄 거래처 삭제");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 9;
		gbc_btnNewButton_2.gridy = 1;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_4 = new JButton("출력");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 10;
		gbc_btnNewButton_4.gridy = 1;
		panel_2.add(btnNewButton_4, gbc_btnNewButton_4);

		JButton btnNewButton_3 = new JButton("액셀");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 11;
		gbc_btnNewButton_3.gridy = 1;
		panel_2.add(btnNewButton_3, gbc_btnNewButton_3);

		JButton btnNewButton = new JButton("종료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 12;
		gbc_btnNewButton.gridy = 1;
		panel_2.add(btnNewButton, gbc_btnNewButton);

		// 초기화 버튼 이벤트(클릭시) 처리 -> 텍스트필드 초기화, 번호텍스트필드에 커서 위치

		btnClear.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				// 초기화

				cd.setText("");
				grcm.setText("");
				sh.setText("");
				dp.setText("");
				saupnum.setText("");
				jsaupjnum.setText("");
				postnum.setText("");
				Address1.setText("");
				Address2.setText("");
				ut.setText("");
				jm.setText("");
				dd1.setText("");
				ch1.setText("");
				email1.setText("");
				dd2.setText("");
				ch2.setText("");
				email2.setText("");
				ph1.setText("");
				ph2.setText("");
				FAX.setText("");
				memo.setText("");

				// 수정가능하게 변경

				cd.setEditable(true);
				grcm.setEditable(true);
				sh.setEditable(true);
				dp.setEditable(true);
				saupnum.setEditable(true);
				jsaupjnum.setEditable(true);
				postnum.setEditable(true);
				Address1.setEditable(true);
				Address2.setEditable(true);
				ut.setEditable(true);
				jm.setEditable(true);
				dd1.setEditable(true);
				ch1.setEditable(true);
				email1.setEditable(true);
				dd2.setEditable(true);
				ch2.setEditable(true);
				email2.setEditable(true);
				ph1.setEditable(true);
				ph2.setEditable(true);
				FAX.setEditable(true);
				memo.setEditable(true);
				// 번호텍스트필드에 커서 위치

				cd.requestFocus();

			}

		});

		// 삭제 버튼에 이벤트(클릭시) 처리 -> 텍스트 필드에 입력된 번호값으로 데이터베이스에

		// 해당 번호의 레코드를 삭제(Delete) 하는 영역

		btnDel.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				// 텍스트필드에 있는 번호값 변수에 대입

				String 거래처코드 = cd.getText();

				// 번호값으로 데이터베이스에서 해당 레크드를 삭제하는 메소드

				delete(거래처코드);

				// 삭제처리 데이터를 데이터베이스에서 다시 읽어와서 result 벡터에 저장

				Vector result = selectAll();

				// 변경된 데이터(벡터)로 모델 갱신 -> 테이블 표시 갱신됨

				model.setDataVector(result, title);

			}

		});

		// 추가버튼에 이벤트(클릭시) 처리 -> 텍스트필드에 입력된 정보를 데이터베이스에

		// 저장(Insert)하는 영역

		btnAdd.addActionListener(new ActionListener() {

			// actionPerformed(ActionEvent e) : 추가 버튼 클릭시 호출될 메소드

			// 추가버튼을 클릭하면 처리할 내용 작성

			@Override

			public void actionPerformed(ActionEvent e) {

				// 현재 텍스트 필드에 있는 값을 각각의 변수에 대입

				String 거래처코드 = cd.getText(); // 거래처코드

				String 거래처명 = grcm.getText(); // 거래처명

				String 상호 = sh.getText(); //
				String 대표 = dp.getText();
				String 사업자번호 = saupnum.getText();
				String 종사업자번호 = jsaupjnum.getText();
				String 우편번호 = postnum.getText();
				String 주소one = Address1.getText();
				String 주소two = Address2.getText();
				String 업태 = ut.getText();
				String 종목 = jm.getText();
				String 담당one = dd1.getText();
				String 휴대폰one = ch1.getText();
				String 이메일one = email1.getText();
				String 담당two = dd2.getText();
				String 휴대폰two = ch2.getText();
				String 이메일two = email2.getText();
				String 전화one = ph1.getText();
				String 전화two = ph2.getText();
				String 팩스 = FAX.getText();
				String 메모 = memo.getText();

				// 각각의 변수에 저장된 값을 데이터베이스에 Insert하는 메소드

				insert(거래처코드, 거래처명, 상호, 대표, 사업자번호, 종사업자번호, 우편번호, 주소one, 주소two, 업태, 종목, 담당one, 휴대폰one, 이메일one, 담당two,
						휴대폰two, 이메일two, 전화one, 전화two, 팩스, 메모);

				// 신규 저장된 데이터를 데이터베이스에서 다시 읽어와서 result 벡터에 저장

				Vector result = selectAll();

				// 변경된 데이터(벡터)로 모델 갱신 -> 테이블 표시 갱신됨

				model.setDataVector(result, title);
				System.out.println(업태);

			}

		});

		// 수정버튼에 이벤트(클릭시) 처리 -> 텍스트 필드에 입력된 번호값으로 데이터베이스에

		// 해당 번호의 레크드를 수정(Update) 하는 영역

		btnUpdate.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				// 텍스트필드에 있는 값들을 변수에 저장

				String 거래처코드 = cd.getText();

				String 거래처명 = grcm.getText();

				String 상호 = sh.getText();
				String 대표 = dp.getText();
				String 사업자번호 = saupnum.getText();
				String 종사업자번호 = jsaupjnum.getText();
				String 우편번호 = postnum.getText();
				String 주소one = Address1.getText();
				String 주소two = Address2.getText();
				String 업태 = ut.getText();
				String 종목 = jm.getText();
				String 담당one = dd1.getText();
				String 휴대폰one = ch1.getText();
				String 이메일one = email1.getText();
				String 담당two = dd2.getText();
				String 휴대폰two = ch2.getText();
				String 이메일two = email2.getText();
				String 전화one = ph1.getText();
				String 전화two = ph2.getText();
				String 팩스 = FAX.getText();
				String 메모 = memo.getText();

				// 번호를 기준으로 수정된 이름과 주소를 수정하는 메소드

				update(거래처코드, 거래처명, 상호, 대표, 사업자번호, 종사업자번호, 우편번호, 주소one, 주소two, 업태, 종목, 담당one, 휴대폰one, 이메일one, 담당two,
						휴대폰two, 이메일two, 전화one, 전화two, 팩스, 메모);

				// 삭제처리 데이터를 데이터베이스에서 다시 읽어와서 result 벡터에 저장

				Vector result = selectAll();

				// 변경된 데이터(벡터)로 모델 갱신 -> 테이블 표시 갱신됨

				model.setDataVector(result, title);

			}

		});

//		프레임 종료시 처리될 이벤트 처리 

		addWindowListener(new WindowAdapter() {

			@Override

			public void windowClosing(WindowEvent w) {

				try {

					stmt.close(); // Statement 객체 닫기

					conn.close(); // Connection 객체 닫기

					setVisible(false); // 화면 닫기

					dispose(); // 자원 반납

					System.exit(0); // 종료 처리

				} catch (Exception e) {

				}

			}

		});

	}

	/**
	 * 
	 * @Method Name : selectAll
	 * 
	 * @return : data
	 * 
	 * @설명 : 데이터베이스에서 검색된 데이터를 data Vector에 담아 리턴
	 * 
	 */

	private Vector selectAll() {

		data.clear();

		try {

			ResultSet rs = stmt.executeQuery("select * from 사업자관련 order by 거래처코드");

			while (rs.next()) {

				Vector in = new Vector<String>(); // 1개의 레코드 저장하는 벡터 생성

				String 거래처코드 = rs.getString(1); // 데이터베이스에서 번호값 가지고 와서 num 변수에 저장
				String 거래처명 = rs.getString(2);
				String 상호 = rs.getString(3);
				String 대표 = rs.getString(4);
				String 종사업자번호 = rs.getString(5);
				String 우편번호 = rs.getString(6);
				String 주소one = rs.getString(7);
				String 주소two = rs.getString(8);
				String 업태 = rs.getString(9);
				String 종목 = rs.getString(10);
				String 담당one = rs.getString(11);
				String 휴대폰one = rs.getString(12);
				String 이메일one = rs.getString(13);
				String 담당two = rs.getString(14);
				String 휴대폰two = rs.getString(15);
				String 이메일two = rs.getString(16);
				String 전화one = rs.getString(17);
				String 전화two = rs.getString(18);
				String 팩스 = rs.getString(19);
				String 메모 = rs.getString(20);

//				String address = rs.getString("address");

//				벡터에 각각의 값 추가

				in.add(거래처코드);
				in.add(거래처명);
				in.add(상호);
				in.add(대표);
				in.add(종사업자번호);
				in.add(우편번호);
				in.add(주소one);
				in.add(주소two);
				in.add(업태);
				in.add(종목);
				in.add(담당one);
				in.add(휴대폰one);
				in.add(이메일one);
				in.add(담당two);
				in.add(휴대폰two);
				in.add(이메일two);
				in.add(전화one);
				in.add(전화two);
				in.add(팩스);
				in.add(메모);
//				전체 데이터를 저장하는 벡터에 in(1명의 데이터 저장) 벡터 추가

				data.add(in);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return data; // 전체 데이터 저장하는 data 벡터 리턴

	}

	/**
	 * 
	 * @Method Name : insert
	 * 
	 * @param num     :번호 텍스트필드에 입력받은 값
	 * 
	 * @param name    : 이름 텍스트필드에 입력받은 값
	 * 
	 * @param address : 주소 텍스트필드에 입력받은 값
	 * 
	 * @설명 : 각각의 텍스트필드에 입력된 값을 파라미터로 받아서 데이터베이스에
	 * 
	 *     insert 처리하는 메소드
	 * 
	 */

	private void insert(String 거래처코드, String 거래처명, String 상호, String 대표, String 사업자번호, String 종사업자번호, String 우편번호,
			String 주소one, String 주소two, String 업태, String 종목, String 담당one, String 휴대폰one, String 이메일one, String 담당two,
			String 휴대폰two, String 이메일two, String 전화one, String 전화two, String 팩스, String 메모) {
		//
		try {

//			PreparedStatement 생성-> conn은 preDbTreatment() 메소드를 통해 생성되어 있음
			String sql = "insert into 사업자관련(거래처코드, 거래처명, 상호, 대표자명, 사업자등록번호, 종사업장번호, 우편번호, 사업장소재지1, 사업장소재지2, 업태, 종목, 담당1, 휴대폰1, 이메일1, 담당2, 휴대폰2, 이메일2, 전화1, 전화2, FAX, 메모) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmtAdd = conn.prepareStatement(sql);

//			insert into member values(? -> 1 ,? -> 2, ? -> 3)" 각각의 ? 에 값 대입

			pstmtAdd.setString(1, 거래처코드);
			pstmtAdd.setString(2, 거래처명);
			pstmtAdd.setString(3, 상호);
			pstmtAdd.setString(4, 대표);
			pstmtAdd.setString(5, 사업자번호);
			pstmtAdd.setString(6, 종사업자번호);
			pstmtAdd.setString(7, 우편번호);
			pstmtAdd.setString(8, 주소one);
			pstmtAdd.setString(9, 주소two);
			pstmtAdd.setString(10, 업태);
			pstmtAdd.setString(11, 종목);
			pstmtAdd.setString(12, 담당one);
			pstmtAdd.setString(13, 휴대폰one);
			pstmtAdd.setString(14, 이메일one);
			pstmtAdd.setString(15, 담당two);
			pstmtAdd.setString(16, 휴대폰two);
			pstmtAdd.setString(17, 이메일two);
			pstmtAdd.setString(18, 전화one);
			pstmtAdd.setString(19, 전화two);
			pstmtAdd.setString(20, 팩스);
			pstmtAdd.setString(21, 메모);

//			대입받은 쿼리를 실행 -> 입력 (insert)

			pstmtAdd.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * @Method Name : delete
	 * 
	 * @param num : 번호 텍스트필드에 입력받은 값
	 * 
	 * @설명 : 번호값을 파라미터를 받아 해당 번호의 데이터를 디비에서 삭제(delete) 하는 메소드
	 * 
	 */

	private void delete(String 거래처코드) {

		try {

//			PreparedStatement 생성-> conn은 preDbTreatment() 메소드를 통해 생성되어 있음

			pstmtDel = conn.prepareStatement("delete from 사업자관련 where 거래처코드 = ?");

//			num 값을 비교해서 삭제함

			pstmtDel.setString(1, 거래처코드);

// 			대입받은 쿼리를 실행-> 삭제 (delete)

			pstmtDel.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private void update(String 거래처코드, String 거래처명, String 상호, String 대표, String 사업자번호, String 종사업자번호, String 우편번호,
			String 주소one, String 주소two, String 업태, String 종목, String 담당one, String 휴대폰one, String 이메일one, String 담당two,
			String 휴대폰two, String 이메일two, String 전화one, String 전화two, String 팩스, String 메모) {

		try {

//			PreparedStatement 생성-> conn은 preDbTreatment() 메소드를 통해 생성되어 있음

			pstmtUpdate = conn.prepareStatement("update 사업자관련 set 거래처코드 = ?, 거래처명 = ?, 대표 = ? 사업자번호 = ?, 종사업장번호 = ? , 우편번호 = ?, 주소1= ? , 주소2 = ?, 업태 = ?, 종목 = ?, 담당1 = ?, 휴대폰1 = ?, 이메일1 = ?, 담당2 = ?, 휴대폰2 = ?, 이메일2 = ?, 전화1 = ?, 전화2 = ?, 팩스 = ?, 메모 = ? where 상호 = '?'");

//			값 대입

			pstmtUpdate.setString(1, 거래처코드);

			pstmtUpdate.setString(2, 거래처명);

//			? 순서 중요 확인 필요함

			pstmtUpdate.setString(3, 상호);
			pstmtUpdate.setString(4, 대표);
			pstmtUpdate.setString(5, 사업자번호);
			pstmtUpdate.setString(6, 종사업자번호);
			pstmtUpdate.setString(7, 우편번호);
			pstmtUpdate.setString(8, 주소one);
			pstmtUpdate.setString(9, 주소two);
			pstmtUpdate.setString(10, 업태);
			pstmtUpdate.setString(11, 종목);
			pstmtUpdate.setString(12, 담당one);
			pstmtUpdate.setString(13, 휴대폰one);
			pstmtUpdate.setString(14, 이메일one);
			pstmtUpdate.setString(15, 담당two);
			pstmtUpdate.setString(16, 휴대폰two);
			pstmtUpdate.setString(17, 이메일two);
			pstmtUpdate.setString(18, 전화one);
			pstmtUpdate.setString(19, 전화two);
			pstmtUpdate.setString(20, 팩스);
			pstmtUpdate.setString(21, 메모);

//			쿼리 실행

			pstmtUpdate.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * @Method Name : preDbTreatment
	 * 
	 * @설명 : 데이터베이스 연동 및 Connection, Statement 생성
	 * 
	 */

	private void preDbTreatment() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(Url, user, password);

			stmt = conn.createStatement();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {

		iEnrich frame = new iEnrich();

//		내부 컴포넌트의 크기와 정렬 상태에 따라 프레임의 크기를 정함

		frame.pack();

		frame.setVisible(true);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
