package game;
public class QuestsDTO {
	private int Questsn;
	private String Contens;  //20마리 잡아라
	private int Goal;		//15마리 남았다
	private int COMPENSATION;
	private String QMONNAME;
	public int getQuestsn() {
		return Questsn;
	}
	public void setQuestsn(int questsn) {
		Questsn = questsn;
	}
	public String getContens() {
		return Contens;
	}
	public void setContens(String contens) {
		Contens = contens;
	}
	public int getGoal() {
		return Goal;
	}
	public void setGoal(int goal) {
		Goal = goal;
	}
	public int getCOMPENSATION() {
		return COMPENSATION;
	}
	public void setCOMPENSATION(int cOMPENSATION) {
		COMPENSATION = cOMPENSATION;
	}
	public String getQMONNAME() {
		return QMONNAME;
	}
	public void setQMONNAME(String qMONNAME) {
		QMONNAME = qMONNAME;
	}
	@Override
	public String toString() {
		return "QuestsDTO [Questsn=" + Questsn + ", Contens=" + Contens + ", Goal=" + Goal + ", COMPENSATION="
				+ COMPENSATION + ", QMONNAME=" + QMONNAME + "]";
	}
	
	
	
	
}