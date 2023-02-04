package game;

import java.util.Scanner;

public class A_GameMain {

	public static void main(String[] args) {

		// BankSQL 객체 sql 만들기
		A_gameSQL sql = new A_gameSQL();

		// Scanner 객체 sc 만들기
		Scanner sc = new Scanner(System.in);

		CHARCTERDTO ch = new CHARCTERDTO();
		DUNGEONDTO du = new DUNGEONDTO();
		EnforceDTO en = new EnforceDTO();
		eqDTO eq = new eqDTO();
		FIGHTDTO fi = new FIGHTDTO();
		INVENTORYDTO in = new INVENTORYDTO();
		LEVELUPDTO le = new LEVELUPDTO();
		MEDICIANDTO me = new MEDICIANDTO();
		MonsterDTO mo = new MonsterDTO();
		QuestsDTO qu = new QuestsDTO();
		SkillDTO sk = new SkillDTO();
		
		boolean run=true;  //while문
		int menu=0;
		
		sql.connect();//DB에 접속합니다.
		while(run) {
			System.out.println("1. 캐릭터 생성 2. 캐릭터 로드 3. 게임 종료");
			System.out.print("메뉴를 선택하세요 >>");
			menu=sc.nextInt();
			
			switch(menu) {
			case 1:
				sql.CreateCharacter(ch,du,en,eq,fi,in,le,me,mo,qu,sk);
				sql.procced(ch, du, en, eq, fi, in, le, me, mo, qu, sk);
				break;
			case 2:
				boolean result=true;
				while(result) {
					System.out.print("캐릭터 닉네임을 입력하세요");
					String nicname=null;
					nicname=sc.next();
					result= !sql.load(ch, du, en, eq, fi, in, le, me, mo, qu, sk, nicname);
					if(result) {
						System.out.println("\n캐릭터가 없습니다, 다시 입력하세요");
					}
				}
				sql.procced(ch, du, en, eq, fi, in, le, me, mo, qu, sk);
				
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				run=false;
				break;
			default:
				System.out.println("잘못 입력했습니다.");
				break;
			}//switch문 종료
		}//while문 종료
		sql.conclose();//DB접속을 종료합니다.
		
		
		
		//while문1
		//switch문1
		//1. 캐릭터 생성 2. 캐릭터 로드 3. 게임 종료 (while문)
		
		//1. 캐릭터 생성 메소드
		// 캐릭터 insert문 써서 DB에 넣고, 로드 메소드
		
		//2. 캐릭터 로드 메소드
		// select문 써서 DTO에 모든 정보 넣기
		
		//3. 게임 진행 메소드
		// 1.던전, 2.상점......... while문, switch문
		//case 2:
			//sql.shop();
			//default;
		//case 7: 메뉴화면으로(while문 종료)
		
		//1. 생성
//		System.out.println("이세계 가는 스토리");
//		System.out.println("던전에서 죽을뻔하다 구해지는 스토리");
//		System.out.println("빚갚아야 하는 스토리");
		
		//게임 시작
		
		//게임 시작메소드
		//while문
		// 캐릭터 이름 입력받기(Scanner)
		// select문으로 캐릭터 이름 중복 확인
		// 중복되면 다시 입력받기
		//insert로 캐릭터 생성
		
		

		//insert한 '캐릭터 번호'(기본키)를 가지고 게임 진행 메소드	
		//메소드 안에 while문, switch문
		// DB와 연동
		// 1. 던전  2. 도박  3. 상점  4. 휴식(체력,마나 회복)  5. 퀘스트  6. 강화  7. 메뉴화면으로
		
		// 1. 던전 메소드(던전 DTO, 몬스터 DTO,캐릭터 DTO, 인벤토리 DTO,물약 DTO)
		//while문 -> switch문
		// 던전 선택(던전이름,입장료,레벨제한)
		//던전DTO.set던전이름()
		//던전DTO.set입장료()
		//던전DTO.set레벨제한()
		
		// 1-2. 전투 시작(던전DTO, 몬스터 DTO,캐릭터 DTO, 인벤토리 DTO,물약 DTO)
		//select * from monster where 던전이름=? 
		//? = 던전 DTO.get던전이름()
		// 나오는 몬스터 종류 알려주기 (1,2,3)
		//sysout
		//몬스터 배열 만들기 => 배열에 몬스터 이름넣기
		
		//while문
			//랜덤함수
			//몬스터 선택(0,1,2,3,4,5) // 랜덤으로 몬스터와 마주침 (50% 약한놈, 50%강한놈)
			//전투 진행 메소드(몬스터 배열[3]==몬스터이름)
		
		
		// 전투 메소드
		
		//1-3. 전투 진행 메소드(던전DTO, 몬스터 DTO,캐릭터 DTO, 인벤토리 DTO,물약 DTO, 몬스터이름)
		// while문, switch문
		// 캐릭터 hp가 0이면 전투,몬스터,던전 메소드 종료
		// 몬스터 hp가 0이면 전투 메소드 종료 (ㄱ)
		// switch문
		// 1. 평타 2. 스킬선택  3. 아이템 사용  4. 도주하기(전투 메소드 종료)
		// switch문 끝나면, 캐릭터->몬스터공격 + (ㄱ) + 몬스터->캐릭터 공격
		// (ㄱ)이면 보상 메소드, 특정 조건하에 렙업메소드
		
		//2. 도박 메소드
		// 주사위, 홀짝 등등 + 본 메뉴로 돌아가기
		
		//CHARCTERDTO.get함수로 캐릭터의 골드를 받아온다.
		//걸 돈을 입력 받는다. scanner
		//잔액이 부족합니다.
		//랜덤함수
		//random 0~1
		//0.5보다 큰가 작은가?
		//CHARCTERDTO.set함수로 캐릭터 골드 수정
		
		//3. 상점 메소드
		//while문, switch문
		//1. 물약 종류 선택(hp, mp) or 본 메뉴로 돌아가기
		//2. 물약 성능 선택(소형, 중형, 대형)
		
		//4. 휴식 메소드
		//CHARCTERDTO 캐릭터의 hp, mp 최대치를 가져온다.
		//CHARCTERDTO에 현재 캐릭터의 hp, mp에 대입
		
		//5.퀘스트 메소드(CHARCTERDTO ch)
		//퀘스트 번호1,2,3,4,5,6,7~
		//퀘스트 내용 출력
		//퀘스트 보상 출력
		//switch문
		//1. 보상받고 다음 퀘스트로
		//2. 본 메뉴로 돌아가기
		
//		//6. 강화 메소드(CHARCTERDTO ch)
//		//while문, switch문
//		//장비 선택 메뉴 + 본 메뉴로 돌아가기
//		int a=0;
//		int menu
//		switch(menu)
//		case1:
//			a=ch.getEq1();
//		case2:
//			a=ch.getEq2();
//		.a..a.;
//		
//		case 5:
//			run=false;
//		default:
//			.a..a
//			;
//			
//			
//		//강화 확률 출력
//			select문 사용해서 where 강화레벨=?
//			?=a;
//			System.out.println();//a레벨에 맞는 강화 확률 출력
//			
//			
//			
//			
//		//강화 하시겠습니까? (y/n)
//			scanner string값 받기
//			if (eqal.string(입력값==y)) {
//				random값 적용
//				random값<강화확률이면 성공
//				아니면 실패
//			}else {
//				종료
//			}
//		//y이면 강화성공 메소드(return값 : true,false)
//		//n이면 장비선택메뉴
//		결과 장비레벨+1; set함수
//			switch(menu) {
//			case1:
//				seteq1()
//				case 2:
//					seteq2()
//			}
			
		//7번과 default
		//생략
			
		//222222. 캐릭터 로드
		// 캐릭터 닉네임 나열
		// while문, switch문으로 캐릭터 선택
		// 가져온 '캐릭터 번호'(기본키)를 가지고 게임 진행 메소드 ㄱ
		
		//3. 게임 종료
		// close(접속 종료)
		// 종료
		
		
		
	}// main 종료
}// class끝
