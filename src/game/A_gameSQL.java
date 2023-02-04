package game;

//import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class A_gameSQL {

	// DB접속을 위한 변수 con 선언
	Connection con = null;

	// 쿼리문 전송을 위한 변수 stmt, pstmt 선언
	Statement stmt = null;
	PreparedStatement pstmt = null;
	// PreparedStatement : 쿼리문에서 '?'를 문자로 인식

	// 조회(select)결과를 저장하기 위한 변수 rs 선언
	ResultSet rs = null;

	Scanner sc = new Scanner(System.in);
	// ==================================connect=============================================

	// 접속 메소드
	public void connect() {
		con = GameConnection.DBConnect();
	}// 메소드 종료

	// 접속해제 메소드
	public void conclose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// 메소드 종료

	// ==================================상점,상점구입,상점판매메소드=============================================
	// 상점 메소드
	public void shop(CHARCTERDTO ch, INVENTORYDTO in, MEDICIANDTO me) {
		boolean run = true;
		int menu = 0;
		while (run) {
			System.out.println("1. 구입  2. 판매  3. 메뉴로 돌아가기");
			System.out.print("메뉴를 입력하세요 >> ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				int count = 0;
				int store = 0;
				for(int i=0;i<in.getNum();i++){
					if (in.getMednum()[i] == me.getMEDNUM()[0]) { // 0번 인덱스의 mednum은 없음을 의미한다. {
						count += 1;
						store = i;
					}
				}
				shop_purchase(ch, in, me, store);
				break;
			case 2:
				shop_sell(ch, in, me);
				break;
			case 3:
				System.out.println("메뉴로 돌아갑니다.");
				run = false;
				break;
			default:
				System.out.println("잘못입력했습니다.");
				break;
			}
		}

	}// 메소드 종료

	// 상점판매메소드
	public void shop_sell(CHARCTERDTO ch, INVENTORYDTO in, MEDICIANDTO me) {
		int[] colnum = new int[in.getNum()];
		System.out.println("----------------------------------------");
		for (int i = 0; i < in.getNum(); i++) {
			for (int j = 0; j < me.getCount(); j++) {
				if (me.getMEDNUM()[j] == in.getMednum()[i]) {
					System.out.println((i + 1) + "번 : " + me.getMEDTYPE()[j]);
					System.out.println("판매가 : " + me.getMEDSELL()[j]);
					System.out.println();
					colnum[i] = j;
				} // if문
			} // j_for문
		} // i_for문

		System.out.println((in.getNum()+1)+"번 : 판매종료");
		System.out.println("----------------------------------------");
		System.out.print("판매할 번호 선택");
		int menu = sc.nextInt();
		if (menu < 1 || menu > in.getNum()) {
			// 번호 잘못 선택
		} else if (menu == in.getNum()+1) {
			// 판매 중지
		} else {
			// 판매
			// 돈을 추가합니다.
			int gold = ch.getGold() + me.getMEDSELL()[colnum[menu - 1]];
			ch.setGold(gold);

			// 아이템을 삭제합니다.
			int inventory[] = new int[in.getNum()];
			for (int i = 0; i < in.getNum(); i++) {
				if (i != (menu - 1))// 삭제하지 않을 아이템
				{
					inventory[i] = in.getMednum()[i];
				} else {
					System.out.println((i+1)+"번을 판매합니다.");
					inventory[i] = me.getMEDNUM()[0]; // 물약 테이블 가장 끝은 항상 빈칸을 의미한다.
				} // else문 종료 (인벤토리에 물약 제거)
			} // for문 종료
			in.setMednum(inventory);
		} // else문 종료(판매금 받기, 물약 제거)
	} // 메소드 종료

	// 상점구입메소드
	public void shop_purchase(CHARCTERDTO ch, INVENTORYDTO in, MEDICIANDTO me, int num) {
		// num은 비어있는 인벤토리 칸
		// cost는
		System.out.println("--------------------------");
		boolean run = true;
		boolean run2 = true;
		boolean run3 = true;
		int gold = ch.getGold();
		int a = 0;
		int b = 0;
		int c=0;
		for(int i=0;i<in.getNum();i++) {
			if(in.getMednum()[i]==me.getMEDNUM()[0]) {
				c=1;
			}
		}
		if(c==0){
			run=false;	//물약종류 선택
			run2=false;	//물약 성능선택
			run3=false;	//물약 구매
			
			System.out.println("인벤토리가 꽉찼습니다.");
		}
		
		while (run) {
			System.out.println("물약 종류를 선택하세요");
			System.out.println("1. hp물약  2. mp물약  3. 메뉴");
			a = sc.nextInt();
			switch (a) {
			case 1:
			case 2:
				run = false;
				break;
			case 3:
				System.out.println("메뉴로 돌아갑니다.");
				run = false;
				run2 = false;
				run3 = false;
				break;
			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}// switch문
		} // while문
		while (run2) {
			System.out.println("물약 성능를 선택하세요");
			System.out.println("1. 소형 2.  중형 3. 대형  4. 메뉴");
			b = sc.nextInt();
			switch (b) {
			case 1:
			case 2:
			case 3:
				run2 = false;
				break;
			case 4:
				System.out.println("메뉴로 돌아갑니다.");
				run2 = false;
				run3 = false;
				break;
			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}// switch문
		} // while문

		if (run3) {
			if (me.getMEDBUY()[a * 3 + b - 3] > gold) {
				System.out.println("잔액이 부족합니다.");
			} else {
				gold -= me.getMEDBUY()[a * 3 + b - 3];
				ch.setGold(gold);//돈이 빠집니다.
				
				int[] med = new int[in.getNum()];
				for (int i = 0; i < in.getNum(); i++) {
					if (i != num) {
						med[i] = in.getMednum()[i];
					} else {
						med[i] = me.getMEDNUM()[a * 3 + b - 3];
					} // else문
				} // for문
				in.setMednum(med);
			} // 잔액 있음
		} // run3_if문
		System.out.println("--------------------------");
	}// 메소드 종료
		// ==================================회복,퀘스트=============================================

	// 휴식
	public void rest(CHARCTERDTO recover) {

		int MHP = recover.getMaxhp();
		int MMP = recover.getMaxmp();

		recover.setMy_hp(MHP);
		recover.setMy_mp(MMP);
		System.out.println("회복되었습니다!");
	}// 메소드 종료

	// 퀘스트 메소드
	public void quest(CHARCTERDTO ch, QuestsDTO qu) {
		System.out.println("퀘스트 번호 : " + qu.getQuestsn());
		System.out.println("퀘스트 내용 : " + qu.getContens());
		System.out.println("퀘스트 진행도 : "+ch.getGoal()+"/"+qu.getGoal());
		System.out.println("퀘스트 보상(골드) : " + qu.getCOMPENSATION());

		System.out.println("1. 보상받기");
		System.out.println("2. 돌아가기");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			System.out.println("----------------------------------------");
			if (ch.getGoal() <= 0) {
				int gold=ch.getGold()+qu.getCOMPENSATION();
				ch.setGold(gold);//골드 보상을 받습니다.
				
				System.out.println("보상과 다음 퀘스트를 받습니다.");
				String sql = "SELECT * FROM siwon12.QUESTS WHERE QUESTSN=?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, qu.getQuestsn() + 1);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						qu.setQuestsn(rs.getInt(1));
						ch.setQuestnum(rs.getInt(1));
						qu.setContens(rs.getString(2));
						qu.setGoal(rs.getInt(3));
						ch.setGoal(rs.getInt(3));
						qu.setCOMPENSATION(rs.getInt(4));
						qu.setQMONNAME(rs.getString(5));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("퀘스트 목표를 달성하지 못했습니다.");
				System.out.println("전체 목표 갯수 : " + qu.getGoal());
				System.out.println("남은 목표 갯수 : " + ch.getGoal());
			}
			System.out.println("----------------------------------------");
			break;
		case 2:
			break;
		default:
			System.out.println("잘못 입력했습니다");
			break;
		}

	}// 메소드 종료

	// ==================================도박,강화=============================================
	// 강화 메소드
	public void enforce(CHARCTERDTO ch) {
		int menu = 0;
		boolean run = true;
		boolean run2 = true;
		int a = 0; // 강화할 장비 레벨

		while (run) {
			System.out.println("================장비 강화에 오신걸 환영합니다.===============");
			System.out.println("1.무기강화\t 2.갑옷강화 ");
			System.out.println("3.투구강화\t 4.신발강화\t 5.돌아가기 ");
			System.out.println("=====================================================");
			System.out.print("입력 : ");

			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("무기강화");
				a = ch.getEq1();
				run=false;
				break;
			case 2:
				System.out.println("갑옷강화");
				a = ch.getEq2();
				run=false;
				break;
			case 3:
				System.out.println("투구강화");
				a = ch.getEq3();
				run=false;
				break;
			case 4:
				System.out.println("신발강화");
				a = ch.getEq4();
				run=false;
				break;
			case 5:
				run = false;
				run2 = false;
				break;
			default:
				System.out.println("제대로 입력해주십시오.");
				break;
			}
		} // while문 종료

		if (run2) {
			int PERCENT = 0;
			int cost = 0;
			boolean run4=false;
			String sql = "SELECT * FROM siwon12.ENFORCE WHERE ENFORCELV = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, a);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("----------------------------");
					PERCENT = rs.getInt(2);
					if (PERCENT == 0) {
						System.out.println("장비 레벨이 만렙입니다.");
					}
					System.out.println("강화 확률은 : " + PERCENT+"%");
					cost = rs.getInt(3);
					if (rs.getInt(3) > ch.getGold()) {
						System.out.println("잔액이 부족합니다");
						run4=false;
					} else {
						run4=true;//돈이 충분합니다.
					}
					System.out.println("강화 비용 : " + rs.getInt(3));
					System.out.println("현재 골드 : " +ch.getGold() );
					System.out.println("----------------------------");
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (PERCENT == 0) {
			} else if(run4){
				System.out.println("강화 하시겠습니까? (y,n)");
				String abc = sc.next();

				if (abc.equals("y")) {
					int num = ch.getGold() - cost;
					ch.setGold(num);
					//System.out.println("강화시작.");
					int ENP = (int) (Math.random() * 100);
					System.out.println("----------------------------");
					if (ENP > PERCENT) {
						System.out.println("강화 실패");
					} // '강화실패' 종료
					else {
						System.out.println("강화 성공");
						e_statup(ch, menu);// 강화성공시 스텟 상승
						a++;//강화단계
						//System.out.println("강화 단계가 : "+a+" 이 되었습니다.");

						switch (menu) {
						case 1:
							ch.setEq1(a);// 무기
							break;
						case 2:
							ch.setEq2(a);// 갑옷
							break;
						case 3:
							ch.setEq3(a);// 투구
							break;
						case 4:
							ch.setEq4(a);// 신발
							break;
						default:
							break;
						}// switch문 종료
					} // '강화성공'종료
					System.out.println("해당 장비가 " + a + "레벨이 되었습니다");
					System.out.println("남은 금액은 " + ch.getGold());
					System.out.println("----------------------------");
				} // '강화시도' 종료
				else {
					System.out.println("----------------------------");
					System.out.println("강화를 하지 않습니다.");
					System.out.println("----------------------------");
				} // if-else 강화를 하는지 여부
			} // if-else 장비레벨이 만렙인지 여부

		} // if(run2)종료
	}// 메소드종료

	// 강화 성공시 스텟 상승 메소드
	public void e_statup(CHARCTERDTO ch, int i) {
		if (i == 1) {// 무기강화
			String sql = "SELECT * FROM siwon12.EQUIPMENT_W WHERE EQW_LV = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ch.getEq1());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					int attack = ch.getMy_attack() + rs.getInt(2);
					ch.setMy_attack(attack);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // if
		else if (i == 2) {// 갑옷강화
			String sql = "SELECT * FROM siwon12.EQUIPMENT_A WHERE EQA_LV = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ch.getEq2());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					int hp = ch.getMaxhp() + rs.getInt(2);
					int SHIELD = ch.getMy_shield() + rs.getInt(3);
					ch.setMaxhp(hp);
					ch.setMy_shield(SHIELD);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // elseif
		else if (i == 3) {// 투구강화
			String sql = "SELECT * FROM siwon12.EQUIPMENT_H WHERE EQH_LV = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ch.getEq2());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					int mp = ch.getMaxmp() + rs.getInt(2);
					int CRITICAL = ch.getMy_critical() + rs.getInt(3);
					ch.setMaxmp(mp);
					ch.setMy_critical(CRITICAL);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // elseif
		else if (i == 4) {// 신발강화
			String sql = "SELECT * FROM siwon12.EQUIPMENT_S WHERE EQS_LV = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ch.getEq1());
				rs = pstmt.executeQuery();

				if (rs.next()) {

					int EVASION = ch.getMy_evasion() + rs.getInt(2);
					ch.setMy_evasion(EVASION);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // elseif
	}// 메소드 종료

	// 도박 메소드
	public void gamble(CHARCTERDTO ch) {
		int Gold = 0;
		int corrent_gold = ch.getGold(); // 현재 가지고 있는 골드입니다.
		System.out.println("-------------------------------------");
		System.out.println("도박장에 오신것을 환영합니다.");
		System.out.println("주사위 1,2,3 : 꽝");
		System.out.println("주사위 4,5,6 : 2배");
		System.out.println("배팅할 골드를 입력하세요 : ");
		Gold = sc.nextInt();
		if (corrent_gold > Gold) {
			System.out.println("도박을 시작합니다.");
			int dice = (int) (Math.random() * 6) + 1;
			System.out.println("주사위의 값은 " + dice);

			if (dice > 3) {
				System.out.println(Gold+"GOLD를 얻으셨습니다.");
				corrent_gold += Gold;
				ch.setGold(corrent_gold);
			} else {
				System.out.println(Gold+"GOLD를 잃으셨습니다.");
				corrent_gold -= Gold;
				ch.setGold(corrent_gold);
			}
		} else {
			System.out.println("잔액이 부족합니다.");
		}
		System.out.println("-------------------------------------");
	}//메소드 종료

	// ==================================캐릭터_생성,로드,진행=============================================
	// 캐릭터 생성(캐릭터,인벤토리)
	public void CreateCharacter(CHARCTERDTO ch, DUNGEONDTO du, EnforceDTO en, eqDTO eq, FIGHTDTO fi, INVENTORYDTO in,
			LEVELUPDTO le, MEDICIANDTO me, MonsterDTO mo, QuestsDTO qu, SkillDTO sk) {
		boolean run = true; // 캐릭터 이름 입력 while문
		boolean run2 = true; // 직업 선택 while문
		boolean run3 = true; // 성별 선택 while문

		String nicname = null; // 생성될 캐릭터 닉네임
		String job = null; // 생성될 캐릭터 직업
		String gender = null; // 생성될 캐릭터 성별

		int count = 0; // 중복되는 캐릭터 닉네임 개수 확인
		int num = 0; // 직업 선택 switch문

		while (run) {
			System.out.print("생성할 캐릭터 이름을 선택하세요");
			nicname = sc.next();

			String sql = "SELECT COUNT(*) FROM siwon12.CHARACTER2 WHERE NICNAME=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, nicname);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					count = rs.getInt(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} // try-catch문 종료

			if (count == 0) {
				run = false;
			} else {
				System.out.println("캐릭터 이름이 중복됩니다.");
			} // if-else문 종료
		} // while문 종료

		while (run2) {
			num = 0;
			System.out.println("1.전사, 2.궁수, 3.마법사, 4.도적");
			System.out.print("직업을 선택하세요 >>");
			num = sc.nextInt();
			switch (num) {
			case 1:
				job = "전사";
				run2 = false;
				break;
			case 2:
				job = "궁수";
				run2 = false;
				break;
			case 3:
				job = "마법사";
				run2 = false;
				break;
			case 4:
				job = "도적";
				run2 = false;
				break;
			default:
				System.out.println("잘못 입력해셨습니다.");
				break;
			}// switch문 종료
		} // while문 종료

		while (run3) {
			num = 0;
			System.out.println("1.남자, 2.여자");
			System.out.print("성별을 선택하세요 >>");
			num = sc.nextInt();
			switch (num) {
			case 1:
				gender = "man";
				run3 = false;
				break;
			case 2:
				gender = "woman";
				run3 = false;
				break;
			default:
				System.out.println("잘못 입력해셨습니다.");
				break;
			}// switch문 종료
		} // while문 종료
		String sql2 = "INSERT INTO siwon12.CHARACTER2 "
				+ "(NICNAME,CJOB,CLEVEL,QUESTNUM,"
				+ "EQ1,EQ2,EQ3,EQ4,GENDER,EXPERIENCE,GOLD,MAXHP,MAXMP,"
				+ "MY_HP,MY_MP,MY_ATTACK,MY_SHIELD,MY_EVASION,MY_CRITICAL,GOAL) " 
				+ "VALUES(?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?)";
		
		String sql3 = "INSERT INTO siwon12.INVENTORY VALUES(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, nicname);// 닉네임
			pstmt.setString(2, job); // 직업
			pstmt.setInt(3, 1); // 레벨
			pstmt.setInt(4, 1); // 퀘스트넘버
			pstmt.setInt(5, 1); // 장비1
			pstmt.setInt(6, 1); // 장비2
			pstmt.setInt(7, 1); // 장비3
			pstmt.setInt(8, 1); // 장비4
			pstmt.setString(9, gender); // 성별
			pstmt.setInt(10, 0); // 경험치
			pstmt.setInt(11, 10000); // 골드

			pstmt.setInt(12, 120); // maxhp
			pstmt.setInt(13, 150); // maxmp
			pstmt.setInt(14, 100); // 현재hp
			pstmt.setInt(15, 40); // 현재mp
			pstmt.setInt(16, 45); // 공격력
			pstmt.setInt(17, 17); // 방어력
			pstmt.setInt(18, 10); // 회피
			pstmt.setInt(19, 10); // 치명
			pstmt.setInt(20, 1); // goal
			
			int result = pstmt.executeUpdate();

			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, nicname);// 닉네임
			pstmt.setInt(2, 1); // 인벤토리1
			pstmt.setInt(3, 1); // 인벤토리2
			pstmt.setInt(4, 1); // 인벤토리3
			pstmt.setInt(5, 1); // 인벤토리4
			pstmt.setInt(6, 1); // 인벤토리5		
			
			int result2 = pstmt.executeUpdate();
			
			
			
			if (result > 0 && result2>0) {
				System.out.println("캐릭터생성 성공!");

//				System.out.println("현생에서 알바하고 게임 하며 집가던 중 교통사고 -> \r\n" + "병원에서 혼수상태로 입원중 -> \r\n"
//						+ "자신이 하던 폰 게임에 들어가게 됨. 제일 쉬운 던전에 떨어지게 되는데, \r\n"
//						+ "자신이 하던 게임이라 생각하고 가진것 없이 맨몸으로 전투하려다 잡몹에게 기절 -> \r\n"
//						+ "눈 떠보니 어느 집 침대에서 일어나게 되는데, 치료도 받고 음식 대접도 후하게 받음. -> \r\n"
//						+ "감사 인사를 하며 떠나려는 데, 붙잡더니 대접받은 음식들과 치료비를 강제 청구함 -> \r\n"
//						+ "가진게 없는 주인공은 줄 수 있는게 없다고 하며 빠져나가려 하자 집주인이 신고하여 끌려가게됨 -> \r\n"
//						+ "주인공과 비슷한 빚쟁이들이 모여있는 곳에 가게 되는데, 그곳에서 기본장비를 받게 되며, \r\n"
//						+ "이것으로 던전과 퀘스트 등을 통해 돈을 벌고, 정해진 기간마다 빚을 갚도록 함.");
				
				System.out.println("\"하.. 오늘도 힘든 하루였다. . 고기 불판을 얼마나 갈았는지 모르겠네..\"");
				System.out.println("(횡단보도를 기다리며)\" 이런 힘든 날에는 역시 게임이지! 핸드폰으로 게임이나 해야겠다!! \"");
				System.out.println("(초록불이 켜지며)\"초록불이네 얼른 건너야지. \"");
				System.out.println("\" 악~!!~! 퍽 삐용삐용삐용...\"");
				System.out.println("\" 어?.. 여기는 어디지..? 분명 핸드폰을 보면서 길을 건너고 있었는데.. 여기는 내가 모바일게임 하는 곳이잖아?!?!?\"");
				System.out.println("\" 저 거대한거는 뭐지..? 어디서 많이 봤는데.. 한번 때려볼까..? (퍽퍽) 뭐야 피가 달지가 않잖아 (몬스터가 공격) 으악~! 눈이 감긴다..\"");
				System.out.println("\" 일어났어요? 우리집에서 편하게 쉬고 놀다가 가요~\"");
				System.out.println(".");
				System.out.println("..");
				System.out.println("(며칠 후)");
				System.out.println("(회복이 된 주인공)\"감사합니다 푹 쉬다가 갑니다!!\"");
				System.out.println("\" 어디가? 돈 내고 가야지 세상에 꽁짜는 없단다? 없으면 너는 신고야\"");
				System.out.println("(결국 신고 당하는 주인공)\"경비원 아저씨 저 어디로 팔려 가는거에요..? 좀 알려주세요.. \"");
				System.out.println("(그나마 친절한 경비원)\"내리세요. 다 왔습니다. 여기서 기본으로 주는 장비 받고 퀘스트하면서 정해진 기간마다 돈 갚으세요.\"");
				System.out.println("(절망하는 주인공)\"항상 외톨이였던 내가 이 세계에서 살아남을 수 있을까?!!? 안돼~~!!!\"");
				
				load(ch, du, en, eq, fi, in, le, me, mo, qu, sk, nicname);
			} else {
				System.out.println("캐릭터생성 실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// 메소드 종료

	// 캐릭터 로드(캐릭터,인벤토리,물약,퀘스트,스킬)
	public boolean load(CHARCTERDTO ch, DUNGEONDTO du, EnforceDTO en, eqDTO eq, FIGHTDTO fi, INVENTORYDTO in,
			LEVELUPDTO le, MEDICIANDTO me, MonsterDTO mo, QuestsDTO qu, SkillDTO sk, String nicname) {

		boolean result = false;
		// 캐릭터 로드
		String sql = "SELECT * FROM siwon12.CHARACTER2 WHERE NICNAME = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nicname);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				ch.setNICNAME(rs.getString(1));
				ch.setJob(rs.getString(2));
				ch.setLevel(rs.getInt(3));
				ch.setQuestnum(rs.getInt(4));
				ch.setEq1(rs.getInt(5));
				ch.setEq2(rs.getInt(6));
				ch.setEq3(rs.getInt(7));
				ch.setEq4(rs.getInt(8));
				ch.setGender(rs.getString(9));
				ch.setExperience(rs.getInt(10));
				ch.setGold(rs.getInt(11));
				ch.setMaxhp(rs.getInt(12));
				ch.setMaxmp(rs.getInt(13));
				ch.setMy_hp(rs.getInt(14));
				ch.setMy_mp(rs.getInt(15));
				ch.setMy_attack(rs.getInt(16));
				ch.setMy_shield(rs.getInt(17));
				ch.setMy_evasion(rs.getInt(18));
				ch.setMy_critical(rs.getInt(19));
				ch.setGoal(rs.getInt(20));
				result = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 인벤토리 로드
		String sql2 = "SELECT * FROM siwon12.INVENTORY WHERE I_NICNAME = ?";
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, nicname);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				in.setNICNAME(rs.getString(1));
				int mednum[] = new int[5];

				for (int i = 0; i < 5; i++) {
					mednum[i] = rs.getInt(2 + i);
				}

				in.setMednum(mednum);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 물약 로드
		String sql3 = "SELECT * FROM siwon12.MEDICIAN";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql3);

			int number = me.getCount();
			int MEDNUM[] = new int[number];
			String MEDTYPE[] = new String[number];
			int MEDBUY[] = new int[number];
			int MEDSELL[] = new int[number];
			int MEDHP[] = new int[number];
			int MEDMP[] = new int[number];
			int i = 0;

			while (rs.next()) {
				MEDNUM[i] = rs.getInt(1);
				MEDTYPE[i] = rs.getString(2);
				MEDBUY[i] = rs.getInt(3);
				MEDSELL[i] = rs.getInt(4);
				MEDHP[i] = rs.getInt(5);
				MEDMP[i] = rs.getInt(6);
				i++;
			}
			me.setMEDNUM(MEDNUM);
			me.setMEDTYPE(MEDTYPE);
			me.setMEDBUY(MEDBUY);
			me.setMEDSELL(MEDSELL);
			me.setMEDHP(MEDHP);
			me.setMEDMP(MEDMP);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 퀘스트 로드
		qu.setQuestsn(ch.getQuestnum());// 퀘스트 넘버 동일하게 맞춘다.

		String sql4 = "SELECT * FROM siwon12.QUESTS WHERE QUESTSN = ?";

		try {
			pstmt = con.prepareStatement(sql4);
			pstmt.setInt(1, ch.getQuestnum());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				qu.setQuestsn(rs.getInt(1));
				qu.setContens(rs.getString(2));
				qu.setGoal(rs.getInt(3));
				qu.setCOMPENSATION(rs.getInt(4));
				qu.setQMONNAME(rs.getString(5));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 스킬 로드
		String sql5 = "SELECT * FROM siwon12.SKILL WHERE S_JOB = ?";

		try {
			pstmt = con.prepareStatement(sql5);
			pstmt.setString(1, ch.getJob());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sk.setS_job(rs.getString(1));
				String skname[] = new String[sk.getNum()];
				int Sk_attack[] = new int[sk.getNum()];
				int Sk_critical[] = new int[sk.getNum()];
				int Sk_mp[] = new int[sk.getNum()];

				for (int i = 0; i < sk.getNum(); i++) {
					skname[i] = rs.getString(2 + 4 * i);
					Sk_attack[i] = rs.getInt(3 + 4 * i);
					Sk_critical[i] = rs.getInt(4 + 4 * i);
					Sk_mp[i] = rs.getInt(5 + 4 * i);
				}
				sk.setJob_Skname(skname);
				sk.setSk_attack(Sk_attack);
				sk.setSk_critical(Sk_critical);
				sk.setSk_mp(Sk_mp);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// 렙업 로드
		String sql6 = "SELECT * FROM siwon12.LEVELUP WHERE LV = ?";

		try {
			pstmt = con.prepareStatement(sql6);
			pstmt.setInt(1, ch.getLevel());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				le.setLV(rs.getInt(1));
				le.setLVSTUPhp(rs.getInt(2));
				le.setLVSTUPmp(rs.getInt(3));
				le.setLVSTUPattack(rs.getInt(4));
				le.setLVSTUPshield(rs.getInt(5));
				le.setLVSTUPevasion(rs.getInt(6));
				le.setLVSTUPcritical(rs.getInt(7));
				le.setNEEDLVUP(rs.getInt(8));
			} // rs.next()

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}// 메소드 종료

	// 캐릭터 진행
	public void procced(CHARCTERDTO ch, DUNGEONDTO du, EnforceDTO en, eqDTO eq, FIGHTDTO fi, INVENTORYDTO in,
			LEVELUPDTO le, MEDICIANDTO me, MonsterDTO mo, QuestsDTO qu, SkillDTO sk) {
		boolean run = true;
		int menu;
		System.out.println("...전생에 은둔형 외톨이였던 내가 이세계에선 최강자?!...");
		
		
		while (run) {
			System.out.println();
			System.out.println("캐릭터 : "+ch.getNICNAME()+" \t직업 : "+ch.getJob());
			System.out.println("hp : "+ch.getMy_hp()+"/"+ch.getMaxhp()+" \tmp : "+ch.getMy_mp()+"/"+ch.getMaxmp());
			System.out.println("lv : "+ch.getLevel() + " \t경험치 : "+ch.getExperience()+"/"+le.getNEEDLVUP());
			System.out.println("골드 : "+ch.getGold());
			System.out.println("1.던전 입장!\t 2.상점으로 가자!\t 3.강화하러 가자! ");
			System.out.println("4.휴식하러 가자!\t 5.퀘스트하러 가자!\t 6.도박하러 가자!");
			System.out.println("7.저장 후, 캐릭터 선택창으로!");
			System.out.print("어디로 가시겠습니까 ? : ");

			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("던전에 입장하셨습니다.");
				dungeon(du, in, ch, me, mo, sk, le,qu);
				break;
			case 2:
				System.out.println("상점에 들어갑니다.");
				shop(ch, in, me);
				break;
			case 3:
				System.out.println("강화로 들어갑니다.");
				System.out.println("무기 : "+ch.getEq1());
				System.out.println("갑옷 : "+ch.getEq2());
				System.out.println("투구 : "+ch.getEq3());
				System.out.println("신발 : "+ch.getEq4());
				enforce(ch);
				break;
			case 4:
				System.out.println("휴식으로 들어갑니다.");
				rest(ch);
				break;
			case 5:
				System.out.println("퀘스트로 들어갑니다.");
				quest(ch, qu);
				break;
			case 6:
				System.out.println("도박장으로 들어갑니다.");
				gamble(ch);
				break;
			case 7:
				System.out.println("--------------------------------");
				System.out.println("\"어딜 쉬려고?, 빚은 갚아야지!\"");
				System.out.println("100골드를 뺏겼습니다");
				int gold=ch.getGold()-100;
				if(gold <0) {
					gold = 0;
				}
				ch.setGold(gold);
				//ch.setGold(ch.getGold()-100);
				System.out.println("현재 골드 : "+ch.getGold());
				System.out.println("게임을 종료합니다.");
				run = false;
				System.out.println("캐릭터 선택창으로 이동합니다.");
				save(ch, du, en, eq, fi, in, le, me, mo, qu, sk);
				System.out.println("--------------------------------");
				break;
			default:
				System.out.println("제대로 입력해주십시오.");
				break;
			}// switch문 종료
		} // while문 종료
	} // 메소드 종료

	// 캐릭터 저장 메소드(캐릭터,인벤토리)
	public void save(CHARCTERDTO ch, DUNGEONDTO du, EnforceDTO en, eqDTO eq, FIGHTDTO fi, INVENTORYDTO in,
			LEVELUPDTO le, MEDICIANDTO me, MonsterDTO mo, QuestsDTO qu, SkillDTO sk) {

		// 캐릭터 테이블 저장
		String sql = "UPDATE siwon12.CHARACTER2 SET CJOB=? , CLEVEL=? , QUESTNUM =?, EQ1=? , EQ2=? , EQ3=? , EQ4=? ,"
				+ " GENDER =?, EXPERIENCE=? , GOLD=? , MAXHP=? , MAXMP=? ,"
				+ " MY_HP=? , MY_MP=? , MY_ATTACK=? , MY_SHIELD=? ,"
				+ " MY_EVASION=? , MY_CRITICAL=?,GOAL=? WHERE NICNAME =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ch.getJob());
			pstmt.setInt(2, ch.getLevel());
			pstmt.setInt(3, ch.getQuestnum());
			pstmt.setInt(4, ch.getEq1());
			pstmt.setInt(5, ch.getEq2());
			pstmt.setInt(6, ch.getEq3());
			pstmt.setInt(7, ch.getEq4());
			pstmt.setString(8, ch.getGender());
			pstmt.setInt(9, ch.getExperience());
			pstmt.setInt(10, ch.getGold());
			pstmt.setInt(11, ch.getMaxhp());
			pstmt.setInt(12, ch.getMaxmp());
			pstmt.setInt(13, ch.getMy_hp());
			pstmt.setInt(14, ch.getMy_mp());
			pstmt.setInt(15, ch.getMy_attack());
			pstmt.setInt(16, ch.getMy_shield());
			pstmt.setInt(17, ch.getMy_evasion());
			pstmt.setInt(18, ch.getMy_critical());
			pstmt.setInt(19, ch.getGoal());
			pstmt.setString(20, ch.getNICNAME());

			int result = pstmt.executeUpdate();
			// int result는 결과 확인을 위한 변수일뿐 실행과 전혀 관계x
			// if문과 result변수를 사용하지 않아도 상관없다.
			if (result > 0) {
				System.out.println("캐릭터 저장 완료!");
			} else {
				System.out.println("캐릭터 저장 실패!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 인벤토리 테이블 저장
		String sql2 = "UPDATE siwon12.INVENTORY SET IV_1=?,IV_2=?,IV_3=?,IV_4=?,IV_5=? WHERE I_NICNAME=?";
		try {
			pstmt = con.prepareStatement(sql2);
			//pstmt.setInt(1, in.getNum());
			for (int i = 0; i < 5; i++) {
				pstmt.setInt(i + 1, in.getMednum()[i]);
			}
			pstmt.setString(6, in.getNICNAME());

			int result = pstmt.executeUpdate();
			// int result는 결과 확인을 위한 변수일뿐 실행과 전혀 관계x
			// if문과 result변수를 사용하지 않아도 상관없다.
			if (result > 0) {
				System.out.println("인벤토리 저장 완료!");
			} else {
				System.out.println("인벤토리 저장 실패!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ==================================던전,몬스터 조우,전투진행=============================================
	// 던전 메소드
	public void dungeon(DUNGEONDTO du, INVENTORYDTO in, CHARCTERDTO ch, MEDICIANDTO me, MonsterDTO mo, SkillDTO sk,
			LEVELUPDTO lv,QuestsDTO qu) {
		boolean run = true;
		boolean run2 = true;
		int number = 0;
		String[] D_NAME = new String[10];
		int[] D_LVLIM = new int[10];
		int[] D_MONEY = new int[10];
		int menu = 0;

		// 던전 개수를 찾습니다.
		String sql = "SELECT COUNT(*) FROM siwon12.DUNGEON";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				number = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 던전을 출력합니다.
		while (run) {
			System.out.println(" ** 던전 카테코리 선택 ** ");
			String sql2 = "SELECT * FROM siwon12.DUNGEON";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql2);

				int i = 0;
				while (rs.next()) {
					D_NAME[i] = rs.getString(1);
					D_LVLIM[i] = rs.getInt(2);
					D_MONEY[i] = rs.getInt(3);
					i++;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < number; i++) {
				System.out.println((i + 1) + ". " + D_NAME[i] + " 던전 (입장료 : " + D_MONEY[i] + " GOLD / 레벨제한 : "
						+ D_LVLIM[i] + "LV ↑)");
			}
			System.out.println((number+1) + ". 돌아가기");
			System.out.println();
			System.out.println("던전을 선택하세요 : ");

			menu = sc.nextInt();

			if (menu == number+1) {
				System.out.println("마을로 돌아갑니다.");
				run = false;
				run2 = false;
			} else if (menu < 1 || menu > number+1) {
				System.out.println("존재하지 않는 던전입니다.");
			} else if (ch.getLevel() < D_LVLIM[menu - 1]) {
				System.out.println("레벨이 부족합니다.");
			} else if (ch.getGold() < D_MONEY[menu - 1]) {
				System.out.println("입장료가 부족합니다.");
			} else {
				System.out.println(D_NAME[menu - 1] + " 던전에 오신걸 환영합니다.");
				du.setD_NAME(D_NAME[menu - 1]);
				du.setD_MONEY(D_MONEY[menu - 1]);
				du.setD_LVLIM(D_LVLIM[menu - 1]);
				run = false;
			}
		} // while문 종료
		if (run2) {
			System.out.println("던전에 입장합니다.");
			// 입장료 제출
			int gold = ch.getGold() - du.getD_MONEY();
			ch.setGold(gold);
			// 던전 입장
			sf(ch, du, in, me, mo, sk, lv,qu);
		}
	} // 메소드 종료

	// 몬스터 조우 메소드
	public void sf(CHARCTERDTO ch, DUNGEONDTO du, INVENTORYDTO in, MEDICIANDTO me, MonsterDTO mo, SkillDTO sk,
			LEVELUPDTO lv,QuestsDTO qu) {

		boolean run = true;

		while (run) {
			String sql = "SELECT COUNT(*) FROM siwon12.MONSTER WHERE DNAME = ?";
			int ENP = 0;// 랜덤을 돌렸을 때 걸린 몬스터
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, du.getD_NAME());
				rs = pstmt.executeQuery();

				if(rs.next()) {
					ENP = (int) (Math.random() * rs.getInt(1));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String sql2 = "SELECT * FROM siwon12.MONSTER WHERE DNAME = ?";
			try {
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, du.getD_NAME());
				rs = pstmt.executeQuery();

				int i = 0;

				while (rs.next()) {
					if (i == ENP) {
						mo.setMname(rs.getString(1));
						mo.setDname(rs.getString(2));
						mo.setMaxhp(rs.getInt(3));
						mo.setMaxmp(rs.getInt(4));
						mo.setMy_hp(rs.getInt(5));
						mo.setMy_mp(rs.getInt(6));
						mo.setMy_attack(rs.getInt(7));
						mo.setMy_shield(rs.getInt(8));
						mo.setMy_evasion(rs.getInt(9));
						mo.setMy_critical(rs.getInt(10));
						mo.setSkil(rs.getString(11));
						mo.setSk_attack(rs.getInt(12));
						mo.setSk_critical(rs.getInt(13));
						mo.setSkilPersent(rs.getInt(14));
						mo.setCompensation1(rs.getInt(15));
						mo.setCompensation2(rs.getInt(16));
						mo.setDropp(rs.getInt(17));
					}
					i++;
				} // while문

				System.out.println(mo.getMname() + "(이)가 나타났다!");
				run = battlemenu(du, mo, ch, in, me, sk, lv,qu);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}// 메소드 종료

	// 전투 진행
	public boolean battlemenu(DUNGEONDTO du, MonsterDTO mo, CHARCTERDTO ch, INVENTORYDTO in, MEDICIANDTO me,
			SkillDTO sk, LEVELUPDTO lv,QuestsDTO qu) {
		boolean runing = true;// 도주하기를 선택하면 false
		boolean run = true;// 전투가 종료되면 false
		int menu = 0;// 선택할 행동
		while (run) {
			boolean run2=true;//평타,스킬,아이템을 사용하면 true, 사용하지 않으면 false   ,false면 몬스터는 공격하지 않는다.
			System.out.println("---------------------------------------------------");
			System.out.println("캐릭터 : " + ch.getNICNAME()); // 케릭터 이름
			System.out.println("체력 : " + ch.getMy_hp() + "/" + ch.getMaxhp()); // 케릭터 체력
			System.out.println("마나 : " + ch.getMy_mp() + "/" + ch.getMaxmp()); // 케릭터 마나
			System.out.println();
			System.out.println("몬스터 이름 : " + mo.getMname()); // 몬스터 이름
			System.out.println("체력 : " + mo.getMy_hp() + "/" + mo.getMaxhp()); // 몬스터 체력
			System.out.println("마나 : " + mo.getMy_mp() + "/" + mo.getMaxmp()); // 몬스터 마나
			System.out.println("---------------------------------------------------");
			System.out.println();

			System.out.println("1. 평타 2. 스킬선택  3. 아이템 사용  4. 도주하기");
			System.out.print("행동을 선택하세요>>");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("'평타'을(를) 사용합니다.");
				Demage(1, 0, ch, mo, sk);
				break;
			case 2:
				System.out.println("'스킬'을(를) 사용합니다.");
				for (int i = 0; i < sk.getNum(); i++) {
					System.out.print((i + 1) + ". " + sk.getJob_Skname()[i] + " ");
				}
				System.out.println();
				System.out.println("스킬을 선택하세요");
				int menu2 = 0;
				menu2 = sc.nextInt();
				if (menu2 < 1 || menu2 > sk.getNum()) {
					menu2 = 1;
				}
				run2=Demage(1, menu2 - 1, ch, mo, sk);
				break;
			case 3:
				run2=Use_Inventory(ch, in, me);
				break;
			case 4:
				System.out.println("던전을 탈출합니다.");
				run=false;
				runing = false;
				break;
			default:
				break;
			}// switch문 종료

			if (mo.getMy_hp() <= 0) {// 몬스터가 죽었습니다.
				System.out.println("몬스터가 사망했습니다.");
				if(mo.getMname().equals(qu.getQMONNAME())) {
					int goal = ch.getGoal() - 1; // 몬스터 사망시 퀘스트 필요 조건-1
					ch.setGoal(goal);
					System.out.println("퀘스트 달성률 : "+ch.getGoal()+"/"+qu.getGoal());
				}
				System.out.println("획득한 골드 : "+mo.getCompensation1());
				// 골드 보상
				int gold = ch.getGold() + mo.getCompensation1();
				// 렙업 보상
				int ex = ch.getExperience() + mo.getCompensation2(); // 경험치 추가
				ch.setExperience(ex);//경험치 저장
				
				while (ch.getExperience() > lv.getNEEDLVUP()) { // 렙업조건이 완료된다면
					ch.setExperience(ch.getExperience()-lv.getNEEDLVUP()); // 경험치는 뺀다.
					levelup(ch, lv); // 렙업시킨다.
				}
				
				System.out.println("현재 골드 : "+ch.getGold());
				System.out.println("현재 레벨 : "+ch.getLevel());
				System.out.println("현재 경험치 : "+ch.getExperience());
				run = false;
			} else if(runing){//도망가면 runing은 false
				if(run2) {//평타,스킬,아이템을 사용했을 경우에만
					Demage(2, 1, ch, mo, sk);// 몬스터가 공격합니다.
				}
				
				if(ch.getMy_hp()<0){//캐릭터 사망 여부
					System.out.println("캐릭터가 사망했습니다.");
					System.out.println("돈을 약10% 잃습니다.");
					int money=(int)((float)ch.getGold()*0.9);
					ch.setGold(money);
					System.out.println("던전을 탈출합니다.");
					ch.setMy_hp(0);
					run=false;
					runing = false;
				}
			} // if_else문 - 몬스터 사망 여부/캐릭터 사망 여부

		} // while문 종료 == 전투 종료

		return runing;// 도망가면 runing은 false
	}// 메소드 종료

	// 데미지 메소드
	public boolean Demage(int num1, int num2, CHARCTERDTO ch, MonsterDTO mo, SkillDTO sk) {
		boolean result=true;
		int performance;
		int a = 0;
		int b = 0;
		boolean run = true;
		if (num1 == 1)// 캐릭터가 공격할때
		{
			System.out.println("캐릭터가 공격합니다.");
			a = ch.getMy_attack() - mo.getMy_shield() + sk.getSk_attack()[num2];// 공격력-방어력+스킬공격력
			if (a < 0) {
				a = 0;
			}
			b = ch.getMy_critical() * 2 - mo.getMy_evasion() + sk.getSk_critical()[num2];// 치명*2-회피+스킬치명타
			if (b < 1) {
				b = 1;
			}
			//System.out.println("캐릭터의 평타 데미지 : "+a);
			a *= (int) (Math.random() * b)+1;// 데미지
			
			int c = mo.getMy_hp() - a;
			int d = ch.getMy_mp() - sk.getSk_mp()[num2];
			if(d<0) {//마나가 부족하면
				c=mo.getMy_hp();//몬스터 체력 그대로
				d=ch.getMy_mp();//캐릭터 마나 그대로
				System.out.println("마나가 부족합니다.");
				result=false;
			}else {
				System.out.println("   캐릭터가 "+sk.getSk_mp()[num2]+"의 마나를 사용했습니다.");
				System.out.println("   몬스터가 "+a+"의 데미지를 입었습니다.");
			}
			mo.setMy_hp(c);// 몬스터 체력 줄어듬
			ch.setMy_mp(d);// 캐릭터 마나 줄어듬
		} 
		
		else if (num1 == 2)// 몬스터가 공격할때
		{
			System.out.println("몬스터가 공격합니다.");
			a = mo.getMy_attack()*5 - ch.getMy_shield();// 공격력-방어력
			b = mo.getMy_critical() * 2 - ch.getMy_evasion();// 치명*2-회피+스킬치명타
			if ((int)(Math.random()*100) < mo.getSkilPersent()) {
				System.out.println("   몬스터가 스킬을 사용했습니다.");
				a += mo.getSk_attack();
				b += mo.getSk_critical();
			}
			if (a < 0) {
				a = 0;
			}
			if (b < 1) {
				b = 1;
			}
			//System.out.println("몬스터의 평타 데미지 : "+a);
			a *= (int) (Math.random() * b/5)+1;// 데미지
			int c = ch.getMy_hp() - a;
			System.out.println("   캐릭터가 "+a+"의 데미지를 입었습니다.");
			// int d=mo.getMy_mp()-15;
			ch.setMy_hp(c);// 캐릭터 체력 줄어듬
			// ch.setMy_mp(c);//몬스터 마나 줄어듬
		} // if_elseif

		return result;
	}// 메소드 종료

	// 아이템 사용 메소드
	public boolean Use_Inventory(CHARCTERDTO ch, INVENTORYDTO in, MEDICIANDTO me) {
		boolean result=true;
		int[] colnum = new int[in.getNum()];
		System.out.println("-----------------------------------");
		for (int i = 0; i < in.getNum(); i++) {
			for (int j = 0; j < me.getCount(); j++) {
				if (me.getMEDNUM()[j] == in.getMednum()[i]) {
					System.out.println((i + 1) + "번 : " + me.getMEDTYPE()[j]);
					System.out.println("hp회복량 : " + me.getMEDHP()[j]);
					System.out.println("mp회복량 : " + me.getMEDMP()[j]);
					System.out.println();
					colnum[i] = j;
				} // if문
			} // j_for문
		} // i_for문
		System.out.println((in.getNum()+1)+"번 : 사용종료");
		System.out.println("-----------------------------------");
		System.out.print("사용할 번호 선택");
		int menu = sc.nextInt();
		if (menu < 1 || menu > in.getNum()+1) {
			// 번호 잘못 선택
			System.out.println("잘못 선택하셨습니다.");
			result=false;
		} else if (menu == in.getNum()+1) {
			// 사용 중지
			System.out.println("아이템을 사용하지 않습니다.");
			result=false;
			
		} else {
			// 아이템 사용
			// hp을 추가합니다.
			int hp = ch.getMy_hp() + me.getMEDHP()[colnum[menu - 1]];
			
			if (hp > ch.getMaxhp()) {
				hp = ch.getMaxhp();
			}
			System.out.println("   hp를 "+(hp-ch.getMy_hp())+"회복합니다.");
			ch.setMy_hp(hp);
			// mp를 추가합니다.
			int mp = ch.getMy_mp() + me.getMEDMP()[colnum[menu - 1]];
			if (mp > ch.getMaxmp()) {
				mp = ch.getMaxmp();
			}
			System.out.println("   mp를 "+(mp-ch.getMy_mp())+"회복합니다.");
			ch.setMy_mp(mp);

			// 아이템을 삭제합니다.
			int inventory[] = new int[in.getNum()];
			for (int i = 0; i < in.getNum(); i++) {
				if (i != menu - 1)// 삭제하지 않을 아이템
				{
					inventory[i] = in.getMednum()[i];
				} else {
					inventory[i] = me.getMEDNUM()[0]; // 물약 테이블 가장 끝은 항상 빈칸을 의미한다.
				} // else문 종료 (인벤토리에 물약 제거)
			} // for문 종료
			in.setMednum(inventory);
		} // else문 종료(hp와 mp 회복, 물약 제거)
		return result;
	} // 메소드 종료

	// 렙업 메소드
	public void levelup(CHARCTERDTO ch, LEVELUPDTO lv) {
		if (lv.getNEEDLVUP() > 800000) {
			System.out.println("   만렙입니다.");
			ch.setExperience(0);//경험치가 0으로 초기화 됩니다.
		} else {
			// 레벨 상승
			int level = ch.getLevel() + 1;
			ch.setLevel(level);

			// 렙업시 스텟 상승
			int hp = ch.getMaxhp() + lv.getLVSTUPhp();
			int mp = ch.getMaxmp() + lv.getLVSTUPmp();
			int attack = ch.getMy_attack() + lv.getLVSTUPattack();
			int shield = ch.getMy_shield() + lv.getLVSTUPshield();
			int evasion = ch.getMy_evasion() + lv.getLVSTUPevasion();
			int critical = ch.getMy_critical() + lv.getLVSTUPcritical();
			ch.setMaxhp(hp);
			ch.setMaxmp(mp);
			ch.setMy_attack(attack);
			ch.setMy_shield(shield);
			ch.setMy_evasion(evasion);
			ch.setMy_critical(critical);

			// 다음 레벨업 정보를 미리 렙업DTO에 저장하기
			String sql = "SELECT * FROM siwon12.LEVELUP WHERE LV=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, level);
				rs = pstmt.executeQuery();

				if (rs.next()) {// 렙업 DTO에 저장
					System.out.println("   레벨업!");
					lv.setLV(rs.getInt(1));
					lv.setLVSTUPhp(rs.getInt(2));
					lv.setLVSTUPmp(rs.getInt(3));
					lv.setLVSTUPattack(rs.getInt(4));
					lv.setLVSTUPshield(rs.getInt(5));
					lv.setLVSTUPevasion(rs.getInt(6));
					lv.setLVSTUPcritical(rs.getInt(7));
					lv.setNEEDLVUP(rs.getInt(8));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} // try_catch
		} // if_else 만렙유무
	}// 메소드 종료

}// 클래스 종료
