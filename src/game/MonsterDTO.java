package game;

public class MonsterDTO {
	private String Mname;		//몬스터이름
	private String Dname;		//던전이름
	private int maxhp;			//최대체력
	private int maxmp;			//최대마나
	private int my_hp;			//체력
	private int my_mp;			//마나
	private int my_attack;		//공격력
	private int my_shield;		//방어력
	private int my_evasion;		//회피
	private int my_critical;	//치명
	private String Skil;		//스킬이름
	private int sk_attack;		//스킬공격력
	private int sk_critical;	//스킬치명타
	private int SkilPersent;	//스킬확률
	private int Compensation1;	//골드보상
	private int Compensation2;	//경험치보상
	private int Dropp;			//드롭확률
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public int getMaxhp() {
		return maxhp;
	}
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	public int getMaxmp() {
		return maxmp;
	}
	public void setMaxmp(int maxmp) {
		this.maxmp = maxmp;
	}
	public int getMy_hp() {
		return my_hp;
	}
	public void setMy_hp(int my_hp) {
		this.my_hp = my_hp;
	}
	public int getMy_mp() {
		return my_mp;
	}
	public void setMy_mp(int my_mp) {
		this.my_mp = my_mp;
	}
	public int getMy_attack() {
		return my_attack;
	}
	public void setMy_attack(int my_attack) {
		this.my_attack = my_attack;
	}
	public int getMy_shield() {
		return my_shield;
	}
	public void setMy_shield(int my_shield) {
		this.my_shield = my_shield;
	}
	public int getMy_evasion() {
		return my_evasion;
	}
	public void setMy_evasion(int my_evasion) {
		this.my_evasion = my_evasion;
	}
	public int getMy_critical() {
		return my_critical;
	}
	public void setMy_critical(int my_critical) {
		this.my_critical = my_critical;
	}
	public String getSkil() {
		return Skil;
	}
	public void setSkil(String skil) {
		Skil = skil;
	}
	public int getSk_attack() {
		return sk_attack;
	}
	public void setSk_attack(int sk_attack) {
		this.sk_attack = sk_attack;
	}
	public int getSk_critical() {
		return sk_critical;
	}
	public void setSk_critical(int sk_critical) {
		this.sk_critical = sk_critical;
	}
	public int getSkilPersent() {
		return SkilPersent;
	}
	public void setSkilPersent(int skilPersent) {
		SkilPersent = skilPersent;
	}
	public int getCompensation1() {
		return Compensation1;
	}
	public void setCompensation1(int compensation1) {
		Compensation1 = compensation1;
	}
	public int getCompensation2() {
		return Compensation2;
	}
	public void setCompensation2(int compensation2) {
		Compensation2 = compensation2;
	}
	public int getDropp() {
		return Dropp;
	}
	public void setDropp(int dropp) {
		Dropp = dropp;
	}
	@Override
	public String toString() {
		return "MonsterDTO [Mname=" + Mname + ", Dname=" + Dname + ", maxhp=" + maxhp + ", maxmp=" + maxmp + ", my_hp="
				+ my_hp + ", my_mp=" + my_mp + ", my_attack=" + my_attack + ", my_shield=" + my_shield + ", my_evasion="
				+ my_evasion + ", my_critical=" + my_critical + ", Skil=" + Skil + ", sk_attack=" + sk_attack
				+ ", sk_critical=" + sk_critical + ", SkilPersent=" + SkilPersent + ", Compensation1=" + Compensation1
				+ ", Compensation2=" + Compensation2 + ", Dropp=" + Dropp + "]";
	}
	
	
	
}
