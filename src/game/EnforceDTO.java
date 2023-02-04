package game;
//강화
public class EnforceDTO{
	private int ef_lv;
	private int ef_persent;
	private int ef_gold;
	public int getEf_lv() {
		return ef_lv;
	}
	public void setEf_lv(int ef_lv) {
		this.ef_lv = ef_lv;
	}
	public int getEf_persent() {
		return ef_persent;
	}
	public void setEf_persent(int ef_persent) {
		this.ef_persent = ef_persent;
	}
	public int getEf_gold() {
		return ef_gold;
	}
	public void setEf_gold(int ef_gold) {
		this.ef_gold = ef_gold;
	}
	@Override
	public String toString() {
		return "EqDTO [ef_lv=" + ef_lv + ", ef_persent=" + ef_persent + ", ef_gold=" + ef_gold + "]";
	}
	
}
