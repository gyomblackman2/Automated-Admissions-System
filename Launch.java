
import java.util.List;
import java.util.ArrayList;

public class Launch {
	private static List<Applicant> applicants = new ArrayList<>();
	private static ICS cs = new ICS();
	private static EEE ee = new EEE();
	private static ECP cpse = new ECP();
	private static SBT bioTech = new SBT();
	private static BFE fe = new BFE();

	public static void loadData() {
		System.out.println("1 Loading data ....\n");
		DataStore.loadData();

		applicants = ApplicantManager.getInstance().getApplicants();
		cs = ApplicantManager.getInstance().getICS();
		ee = ApplicantManager.getInstance().getEEE();
		cpse = ApplicantManager.getInstance().getECP();
		bioTech = ApplicantManager.getInstance().getSBT();
		fe = ApplicantManager.getInstance().getBFE();

		System.out.println("Printing data .....\n");
		upDateDb(applicants, cs, ee, cpse, bioTech, fe);
		printApplicantData();
	}

	public static void printApplicantData() {
		System.out.println(" ");
		for (Applicant applicant : applicants) {
			System.out.println(applicant);
		}

	}

	public static void upDateDb(List<Applicant> applications, ICS cs2, EEE ee2, ECP cpse2, SBT bioTech2, BFE fe2) {
		for (Applicant app : applications) {
			System.out.println(" ");
			ApplicantManager.getInstance().upDate(app, cs2, ee2, cpse2, bioTech2, fe2);
		}
	}

	public static void main(String[] args) {
		loadData();
	}

}
