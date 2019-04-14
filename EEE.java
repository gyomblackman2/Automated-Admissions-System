
public class EEE {

	private double MATH;
	private double PHYSICS;
	private double COMPUTERS;
	private double CHEMISTRY;
	private double BIOLOGY;
	private double GEOGRAPHY;
	private double AGRICULTURE;
	private double CUTOFF;
	private double CUTOFFVALUE;

	public double getCUTOFFVALUE() {
		return CUTOFFVALUE;
	}

	public void setCUTOFFVALUE(double cutoff) {
		CUTOFFVALUE = ((cutoff / 15) * 6);
	}

	public void setMATH(double mATH) {
		MATH = mATH;
	}

	public void setPHYSICS(double pHYSICS) {
		PHYSICS = pHYSICS;
	}

	public void setCOMPUTERS(double cOMPUTERS) {
		COMPUTERS = cOMPUTERS;
	}

	public void setCHEMISTRY(double cHEMISTRY) {
		CHEMISTRY = cHEMISTRY;
	}

	public void setBIOLOGY(double bIOLOGY) {
		BIOLOGY = bIOLOGY;
	}

	public void setGEOGRAPHY(double gEOGRAPHY) {
		GEOGRAPHY = gEOGRAPHY;
	}

	public void setAGRICULTURE(double aGRICULTURE) {
		AGRICULTURE = aGRICULTURE;
	}

	public void setCUTOFF(double cUTOFF) {
		CUTOFF = cUTOFF;
	}

	public double getMATH() {
		return MATH;
	}

	public double getPHYSICS() {
		return PHYSICS;
	}

	public double getCOMPUTERS() {
		return COMPUTERS;
	}

	public double getCHEMISTRY() {
		return CHEMISTRY;
	}

	public double getBIOLOGY() {
		return BIOLOGY;
	}

	public double getGEOGRAPHY() {
		return GEOGRAPHY;
	}

	public double getAGRICULTURE() {
		return AGRICULTURE;
	}

	public double getCUTOFF() {
		return CUTOFF;
	}
}
