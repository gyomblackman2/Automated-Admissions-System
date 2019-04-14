
import java.util.List;

public class ApplicantManager {
	private static ApplicantManager instance = new ApplicantManager();
	private static ApplicantDao dao = new ApplicantDao();

	private ApplicantManager() {
	}

	public static ApplicantManager getInstance() {
		return instance;
	}

	public Applicant createApplicant(String id, String fname, String lname, String[] choice, int maths, int physics,
			int chemistry, int biology, int computers, int geography, int agric, String[] olevels, String selectedFor) {
		System.out.println("Setting values for object: " + fname + " " + lname);
		Applicant applicant = new Applicant();
		applicant.setId(id);
		applicant.setFname(fname);
		applicant.setLname(lname);
		applicant.setChoice(choice);
		applicant.setMaths(maths);
		applicant.setPhysics(physics);
		applicant.setChemistry(chemistry);
		applicant.setBiology(biology);
		applicant.setComputers(computers);
		applicant.setGeography(geography);
		applicant.setAgric(agric);
		applicant.setOlevels(olevels);
		applicant.setSelectedFor(selectedFor);
		applicant.setPoints(maths, physics, chemistry, biology, computers, geography, agric);
		applicant.setRating(maths, physics, chemistry, biology, computers, geography, agric, choice);

		return applicant;
	}

	public ICS setCsValues(String program, double math, double physics, double chemistry, double computers,
			double biology, double geo, double agri, double cutoff) {
		System.out.println("Setting values for Program : " + program);
		ICS cs = new ICS();
		cs.setMATH(math);
		cs.setPHYSICS(physics);
		cs.setCHEMISTRY(chemistry);
		cs.setCOMPUTERS(computers);
		cs.setBIOLOGY(biology);
		cs.setGEOGRAPHY(geo);
		cs.setAGRICULTURE(agri);
		cs.setCUTOFF(cutoff);
		cs.setCUTOFFVALUE(cutoff);
		return cs;
	}

	public EEE setEeValues(String program, double math, double physics, double chemistry, double computers,
			double biology, double geo, double agri, double cutoff) {
		System.out.println("Setting values for Program : " + program);
		EEE ee = new EEE();
		ee.setMATH(math);
		ee.setPHYSICS(physics);
		ee.setCHEMISTRY(chemistry);
		ee.setCOMPUTERS(computers);
		ee.setBIOLOGY(biology);
		ee.setGEOGRAPHY(geo);
		ee.setAGRICULTURE(agri);
		ee.setCUTOFF(cutoff);
		ee.setCUTOFFVALUE(cutoff);
		return ee;
	}

	public ECP setCpseValues(String program, double math, double physics, double chemistry, double computers,
			double biology, double geo, double agri, double cutoff) {
		System.out.println("Setting values for Program : " + program);
		ECP cpse = new ECP();
		cpse.setMATH(math);
		cpse.setPHYSICS(physics);
		cpse.setCHEMISTRY(chemistry);
		cpse.setCOMPUTERS(computers);
		cpse.setBIOLOGY(biology);
		cpse.setGEOGRAPHY(geo);
		cpse.setAGRICULTURE(agri);
		cpse.setCUTOFF(cutoff);
		cpse.setCUTOFFVALUE(cutoff);
		return cpse;
	}

	public SBT setBiotechValues(String program, double math, double physics, double chemistry, double computers,
			double biology, double geo, double agri, double cutoff) {
		System.out.println("Setting values for Program : " + program);
		SBT biotech = new SBT();
		biotech.setMATH(math);
		biotech.setPHYSICS(physics);
		biotech.setCHEMISTRY(chemistry);
		biotech.setCOMPUTERS(computers);
		biotech.setBIOLOGY(biology);
		biotech.setGEOGRAPHY(geo);
		biotech.setAGRICULTURE(agri);
		biotech.setCUTOFF(cutoff);
		biotech.setCUTOFFVALUE(cutoff);
		return biotech;
	}

	public BFE setBFEValues(String program, double math, double physics, double chemistry, double computers,
			double biology, double geo, double agri, double cutoff) {
		System.out.println("Setting values for Program : " + program);
		BFE fe = new BFE();
		fe.setMATH(math);
		fe.setPHYSICS(physics);
		fe.setCHEMISTRY(chemistry);
		fe.setCOMPUTERS(computers);
		fe.setBIOLOGY(biology);
		fe.setGEOGRAPHY(geo);
		fe.setAGRICULTURE(agri);
		fe.setCUTOFF(cutoff);
		fe.setCUTOFFVALUE(cutoff);
		return fe;
	}

	public List<Applicant> getApplicants() {
		return dao.getApplicant();
	}

	public ICS getICS() {
		return dao.getICS();
	}

	public EEE getEEE() {
		return dao.getEEE();
	}

	public ECP getECP() {
		return dao.getECP();
	}

	public SBT getSBT() {
		return dao.getSBT();
	}

	public BFE getBFE() {
		return dao.getBFE();
	}

	public void upDate(Applicant app, ICS cs2, EEE ee2, ECP cpse2, SBT bioTech2, BFE fe2) {
		// TODO Auto-generated method stub
		dao.upDate(app, cs2, ee2, cpse2, bioTech2, fe2);
	}
}
