package game;

import java.util.Arrays;

public class eqDTO {

private int ea_eqipment[];
	
	public int[] getEa_eqipment() {
		return ea_eqipment;
	}
	public void setEa_eqipment(int[] ea_eqipment) {
		this.ea_eqipment = ea_eqipment;
	}
	@Override
	public String toString() {
		return "eqDTO [ea_eqipment=" + Arrays.toString(ea_eqipment) + "]";
	}
	
}
	

