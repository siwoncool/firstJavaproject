package game;

import java.util.Arrays;

public class SkillDTO {
	private String S_job;
	private int num = 3;
	private String[] Job_Skname = new String[num];		//스킬이름
	private int[] Sk_attack = new int[num];				//공격력 추가량
	private int[] Sk_critical = new int[num];			//치명타 추가량
	private int[] Sk_mp = new int[num];					//마나 소모량
	public String getS_job() {
		return S_job;
	}
	public void setS_job(String s_job) {
		S_job = s_job;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String[] getJob_Skname() {
		return Job_Skname;
	}
	public void setJob_Skname(String[] job_Skname) {
		Job_Skname = job_Skname;
	}
	public int[] getSk_attack() {
		return Sk_attack;
	}
	public void setSk_attack(int[] sk_attack) {
		Sk_attack = sk_attack;
	}
	public int[] getSk_critical() {
		return Sk_critical;
	}
	public void setSk_critical(int[] sk_critical) {
		Sk_critical = sk_critical;
	}
	public int[] getSk_mp() {
		return Sk_mp;
	}
	public void setSk_mp(int[] sk_mp) {
		Sk_mp = sk_mp;
	}
	@Override
	public String toString() {
		return "SkillDTO [S_job=" + S_job + ", num=" + num + ", Job_Skname=" + Arrays.toString(Job_Skname)
				+ ", Sk_attack=" + Arrays.toString(Sk_attack) + ", Sk_critical=" + Arrays.toString(Sk_critical)
				+ ", Sk_mp=" + Arrays.toString(Sk_mp) + "]";
	}
	
	
}
