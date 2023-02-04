package game;

import java.util.Arrays;
//캐릭터
public class CHARCTERDTO {

	private String NICNAME;
	private String job;
	private int level;
	private int questnum;
	private int eq1;
	private int eq2;
	private int eq3;
	private int eq4;
	private String gender;
	private int experience;
	private int gold;
	private int maxhp;
	private int maxmp;
	private int my_hp;
	private int my_mp;
	private int my_attack;//공격력
	private int my_shield;//방어력
	private int my_evasion;//회피
	private int my_critical;//치명
	private int goal; //퀘스트 목표
	public String getNICNAME() {
		return NICNAME;
	}
	public void setNICNAME(String nICNAME) {
		NICNAME = nICNAME;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getQuestnum() {
		return questnum;
	}
	public void setQuestnum(int questnum) {
		this.questnum = questnum;
	}
	public int getEq1() {
		return eq1;
	}
	public void setEq1(int eq1) {
		this.eq1 = eq1;
	}
	public int getEq2() {
		return eq2;
	}
	public void setEq2(int eq2) {
		this.eq2 = eq2;
	}
	public int getEq3() {
		return eq3;
	}
	public void setEq3(int eq3) {
		this.eq3 = eq3;
	}
	public int getEq4() {
		return eq4;
	}
	public void setEq4(int eq4) {
		this.eq4 = eq4;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
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
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	@Override
	public String toString() {
		return "CHARCTERDTO [NICNAME=" + NICNAME + ", job=" + job + ", level=" + level + ", questnum=" + questnum
				+ ", eq1=" + eq1 + ", eq2=" + eq2 + ", eq3=" + eq3 + ", eq4=" + eq4 + ", gender=" + gender
				+ ", experience=" + experience + ", gold=" + gold + ", maxhp=" + maxhp + ", maxmp=" + maxmp + ", my_hp="
				+ my_hp + ", my_mp=" + my_mp + ", my_attack=" + my_attack + ", my_shield=" + my_shield + ", my_evasion="
				+ my_evasion + ", my_critical=" + my_critical + ", goal=" + goal + "]";
	}
	
	
	
	
	
	
	
}
