package game;


public class DUNGEONDTO {

	private String D_NAME;
	private int D_LVLIM;
	private String D_MONSTER;
	private int D_MONEY;
	
	
	public String getD_NAME() {
		return D_NAME;
	}
	public void setD_NAME(String d_NAME) {
		D_NAME = d_NAME;
	}
	public int getD_LVLIM() {
		return D_LVLIM;
	}
	public void setD_LVLIM(int d_LVLIM) {
		D_LVLIM = d_LVLIM;
	}
	public String getD_MONSTER() {
		return D_MONSTER;
	}
	public void setD_MONSTER(String d_MONSTER) {
		D_MONSTER = d_MONSTER;
	}
	public int getD_MONEY() {
		return D_MONEY;
	}
	public void setD_MONEY(int d_MONEY) {
		D_MONEY = d_MONEY;
	}
	@Override
	public String toString() {
		return "DUNGEONDTO [D_NAME=" + D_NAME + ", D_LVLIM=" + D_LVLIM + ", D_MONSTER=" + D_MONSTER + ", D_MONEY="
				+ D_MONEY + "]";
	}
	
	
	
}
