
import java.util.Arrays;

public class Applicant {

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", fname=" + fname + ", lname=" + lname + ", choice=" + Arrays.toString(choice)
				+ ", olevels=" + Arrays.toString(olevels) + ", maths=" + maths + ", physics=" + physics + ", chemistry="
				+ chemistry + ", biology=" + biology + ", computers=" + computers + ", geography=" + geography
				+ ", agric=" + agric + ", selectedFor=" + selectedFor + ", f_choiceRating=" + f_choiceRating
				+ ", s_choiceRating=" + s_choiceRating + ", t_choiceRating=" + t_choiceRating + ", points=" + points
				+ "]";
	}

	ICS cs = ApplicantManager.getInstance().getICS();
	EEE ee = ApplicantManager.getInstance().getEEE();
	ECP cpse = ApplicantManager.getInstance().getECP();
	SBT bioTech = ApplicantManager.getInstance().getSBT();
	BFE fe = ApplicantManager.getInstance().getBFE();

	private String id;
	private String fname;
	private String lname;
	private String[] choice;
	private String[] olevels;
	private int maths;
	private int physics;
	private int chemistry;
	private int biology;
	private int computers;
	private int geography;
	private int agric;
	private String selectedFor;
	private double f_choiceRating;
	private double s_choiceRating;
	private double t_choiceRating;
	private double rating;
	private int points;

	public int getPoints() {
		return points;
	}

	public void setPoints(int maths, int physics, int chemistry, int biology, int computers, int geography, int agric) {
		points = maths + physics + chemistry + biology + computers + geography + agric;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String[] getChoice() {
		return choice;
	}

	public void setChoice(String[] choice) {
		this.choice = choice;
	}

	public String[] getOlevels() {
		return olevels;
	}

	public void setOlevels(String[] olevels) {
		this.olevels = olevels;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getBiology() {
		return biology;
	}

	public void setBiology(int biology) {
		this.biology = biology;
	}

	public int getComputers() {
		return computers;
	}

	public void setComputers(int computers) {
		this.computers = computers;
	}

	public int getGeography() {
		return geography;
	}

	public void setGeography(int geography) {
		this.geography = geography;
	}

	public int getAgric() {
		return agric;
	}

	public void setAgric(int agric) {
		this.agric = agric;
	}

	public String getSelectedFor() {
		return selectedFor;
	}

	public void setSelectedFor(String selectedFor) {
		this.selectedFor = selectedFor;
	}

	public double getRating() {
		return rating;
	}

	public double getF_choiceRating() {
		return f_choiceRating;
	}

	public void setF_choiceRating(double f_choiceRating) {
		this.f_choiceRating = f_choiceRating;
	}

	public double getS_choiceRating() {
		return s_choiceRating;
	}

	public void setS_choiceRating(double s_choiceRating) {
		this.s_choiceRating = s_choiceRating;
	}

	public double getT_choiceRating() {
		return t_choiceRating;
	}

	public void setT_choiceRating(double t_choiceRating) {
		this.t_choiceRating = t_choiceRating;
	}

	public void setRating(int maths, int physics, int chemistry, int biology, int computers, int geography, int agric,
			String[] choice) {
		System.out.println("Checking Constants: " + "CS math = " + cs.getMATH() + ", EE math = " + ee.getMATH()
				+ ", CPSE math = " + cpse.getMATH() + ", BioTech math = " + bioTech.getMATH());

		for (int i = 0; i < choice.length; i++) {
			System.out.println(" ");
			String currentChoice = choice[i];
			System.out.println("Rating choice " + i + " with value of " + choice[i] + " for applicant: " + this.fname
					+ " " + this.lname);
			switch (i) {
			case 0:
				switch (currentChoice) {
				case "ICS":
					this.f_choiceRating = (maths * cs.getMATH()) + (physics * cs.getPHYSICS())
							+ (chemistry * cs.getCHEMISTRY()) + (biology * cs.getBIOLOGY())
							+ (computers * cs.getCOMPUTERS()) + (geography * cs.getGEOGRAPHY());
					break;
				case "EEE":
					this.f_choiceRating = (maths * ee.getMATH()) + (physics * ee.getPHYSICS())
							+ (chemistry * ee.getCHEMISTRY()) + (biology * ee.getBIOLOGY())
							+ (computers * ee.getCOMPUTERS()) + (geography * ee.getGEOGRAPHY());
					break;
				case "SBT":
					this.f_choiceRating = (maths * bioTech.getMATH()) + (physics * bioTech.getPHYSICS())
							+ (chemistry * bioTech.getCHEMISTRY()) + (biology * bioTech.getBIOLOGY())
							+ (computers * bioTech.getCOMPUTERS()) + (geography * bioTech.getGEOGRAPHY());
					break;
				case "ECP":
					this.f_choiceRating = (maths * cpse.getMATH()) + (physics * cpse.getPHYSICS())
							+ (chemistry * cpse.getCHEMISTRY()) + (biology * cpse.getBIOLOGY())
							+ (computers * cpse.getCOMPUTERS()) + (geography * cpse.getGEOGRAPHY());
					break;
				case "BFE":
					this.f_choiceRating = (maths * fe.getMATH()) + (physics * fe.getPHYSICS())
							+ (chemistry * fe.getCHEMISTRY()) + (biology * fe.getBIOLOGY())
							+ (computers * fe.getCOMPUTERS()) + (geography * fe.getGEOGRAPHY());
					break;

				}
				break;
			case 1:
				switch (currentChoice) {
				case "ICS":
					this.s_choiceRating = (maths * cs.getMATH()) + (physics * cs.getPHYSICS())
							+ (chemistry * cs.getCHEMISTRY()) + (biology * cs.getBIOLOGY())
							+ (computers * cs.getCOMPUTERS()) + (geography * cs.getGEOGRAPHY()) - 0.4;
					break;
				case "EEE":
					this.s_choiceRating = (maths * ee.getMATH()) + (physics * ee.getPHYSICS())
							+ (chemistry * ee.getCHEMISTRY()) + (biology * ee.getBIOLOGY())
							+ (computers * ee.getCOMPUTERS()) + (geography * ee.getGEOGRAPHY()) - 0.4;
					break;
				case "SBT":
					this.s_choiceRating = (maths * bioTech.getMATH()) + (physics * bioTech.getPHYSICS())
							+ (chemistry * bioTech.getCHEMISTRY()) + (biology * bioTech.getBIOLOGY())
							+ (computers * bioTech.getCOMPUTERS()) + (geography * bioTech.getGEOGRAPHY()) - 0.4;
					break;
				case "ECP":
					this.s_choiceRating = (maths * cpse.getMATH()) + (physics * cpse.getPHYSICS())
							+ (chemistry * cpse.getCHEMISTRY()) + (biology * cpse.getBIOLOGY())
							+ (computers * cpse.getCOMPUTERS()) + (geography * cpse.getGEOGRAPHY()) - 0.4;
					break;
				case "BFE":
					this.f_choiceRating = (maths * fe.getMATH()) + (physics * fe.getPHYSICS())
							+ (chemistry * fe.getCHEMISTRY()) + (biology * fe.getBIOLOGY())
							+ (computers * fe.getCOMPUTERS()) + (geography * fe.getGEOGRAPHY());
					break;

				}
				break;
			case 2:
				switch (currentChoice) {
				case "ICS":
					this.t_choiceRating = (maths * cs.getMATH()) + (physics * cs.getPHYSICS())
							+ (chemistry * cs.getCHEMISTRY()) + (biology * cs.getBIOLOGY())
							+ (computers * cs.getCOMPUTERS()) + (geography * cs.getGEOGRAPHY()) - 0.8;
					break;
				case "EEE":
					this.t_choiceRating = (maths * ee.getMATH()) + (physics * ee.getPHYSICS())
							+ (chemistry * ee.getCHEMISTRY()) + (biology * ee.getBIOLOGY())
							+ (computers * ee.getCOMPUTERS()) + (geography * ee.getGEOGRAPHY()) - 0.8;
					break;
				case "SBT":
					this.t_choiceRating = (maths * bioTech.getMATH()) + (physics * bioTech.getPHYSICS())
							+ (chemistry * bioTech.getCHEMISTRY()) + (biology * bioTech.getBIOLOGY())
							+ (computers * bioTech.getCOMPUTERS()) + (geography * bioTech.getGEOGRAPHY()) - 0.8;
					break;
				case "ECP":
					this.t_choiceRating = (maths * cpse.getMATH()) + (physics * cpse.getPHYSICS())
							+ (chemistry * cpse.getCHEMISTRY()) + (biology * cpse.getBIOLOGY())
							+ (computers * cpse.getCOMPUTERS()) + (geography * cpse.getGEOGRAPHY()) - 0.8;
					break;
				case "BFE":
					this.f_choiceRating = (maths * fe.getMATH()) + (physics * fe.getPHYSICS())
							+ (chemistry * fe.getCHEMISTRY()) + (biology * fe.getBIOLOGY())
							+ (computers * fe.getCOMPUTERS()) + (geography * fe.getGEOGRAPHY());
					break;

				}
				break;
			}

		}

	}
}
