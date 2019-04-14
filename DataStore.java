
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

public class DataStore {

	private static List<Applicant> applicants = new ArrayList<>();
	private static ICS cs = new ICS();
	private static EEE ee = new EEE();
	private static ECP cpse = new ECP();
	private static SBT bioTech = new SBT();
	private static BFE fe = new BFE();

	public static int maths = 0;
	public static int physics = 0;
	public static int chemistry = 0;
	public static int computers = 0;
	public static int biology = 0;
	public static int geography = 0;
	public static int agriculture = 0;

	public static int omaths = 0;
	public static int oenglish = 0;

	public static void loadData() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admissions_database", "root", "");
			Statement stm = con.createStatement();

			loadConstants(stm);
			loadApplicants(stm);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void loadApplicants(Statement stm) throws SQLException {
		// TODO if @PREFERENCES can be increased as time proceeds
		String query = "Select distinct student.first_name,student.lastname,student.student_id, preferences.f_choice, preferences.sec_choice, preferences.third_choice, student.selected_for,"
				+ "(select GROUP_CONCAT(alevelsubs.subject)"
				+ "from alevelsubs where student.student_id = alevelsubs.student_id ) AS alevels,"
				+ "(select GROUP_CONCAT(alevelsubs.grade)"
				+ "from alevelsubs where student.student_id = alevelsubs.student_id)  as alevelgrades,"
				+ "(select GROUP_CONCAT(olevelsubs.subject)"
				+ "from olevelsubs where student.student_id = olevelsubs.student_id) AS olevels,"
				+ "(select GROUP_CONCAT(olevelsubs.grade)"
				+ "from olevelsubs where student.student_id = olevelsubs.student_id) as olevelgrades"
				+ " from student, preferences, alevelsubs, olevelsubs "
				+ "where (student.student_id = preferences.student_id and student.student_id = alevelsubs.student_id and student.student_id = olevelsubs.student_id)";

		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {

			System.out.println(" ");

			String id = rs.getString("student_id");
			String fname = rs.getString("first_name");
			String lname = rs.getString("lastname");
			String selectedFor = rs.getString("selected_for");

			String[] choice = new String[3];
			choice[0] = rs.getString("f_choice");
			choice[1] = rs.getString("sec_choice");
			choice[2] = rs.getString("third_choice");

			String[] alevelgradeString = rs.getString("alevelgrades").split(",");
			int[] alevelgrade = new int[alevelgradeString.length];
			for (int i = 0; i < alevelgradeString.length; i++) {
				alevelgrade[i] = Integer.parseInt(alevelgradeString[i]);
			}

			String[] alevelsubs = rs.getString("alevels").split(",");

			String[] olevelgradeString = rs.getString("olevelgrades").split(",");
			int[] olevelgrade = new int[olevelgradeString.length];
			for (int i = 0; i < olevelgradeString.length; i++) {
				olevelgrade[i] = Integer.parseInt(olevelgradeString[i]);
			}

			String[] olevelsubs = rs.getString("olevels").split(",");

			for (int i = 0; i < olevelsubs.length; i++) {
				String sub1 = olevelsubs[i];
				switch (sub1) {
				case "maths":
					omaths = olevelgrade[i];
					break;
				case "english":
					oenglish = olevelgrade[i];
					break;
				}
			}
			// Assigning student alevel subs and grades to variables.

			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Collected data is Maths " + maths + " Physics " + physics + " Chemistry " + chemistry
					+ " Computers " + computers + " Biology " + biology + " Geography " + geography + " Agriculture "
					+ agriculture + "\n");

			System.out.println("Olevels : " + Arrays.toString(olevelgrade) + "\n");
			System.out.println("Alevels : " + Arrays.toString(alevelgrade) + "\n" + omaths);
			System.out.println(checkConstraints(selectedFor, omaths, oenglish, alevelsubs, olevelgrade));
			if (selectedFor != null) {
				System.out.println(fname + " " + lname + " has already been selected for " + selectedFor);
			}

			if (checkConstraints(selectedFor, omaths, oenglish, alevelsubs, olevelgrade)) {
				System.out.println("Creating object : " + fname + " " + lname + "\n");
				Applicant applicant = ApplicantManager.getInstance().createApplicant(id, fname, lname, choice, maths,
						physics, chemistry, computers, biology, geography, agriculture, olevelsubs, selectedFor);
				applicants.add(applicant);
			}
		}
	}

	public static void collectAlevelSubs(String[] alevelsubs, int[] alevelgrade) {
		for (int x = 0; x < alevelsubs.length; x++) {
			String sub = alevelsubs[x];
			switch (sub) {
			case "Maths":
				maths = alevelgrade[x];
				break;
			case "Physics":
				physics = alevelgrade[x];
				break;
			case "Chemistry":
				chemistry = alevelgrade[x];
				break;
			case "Computers":
				computers = alevelgrade[x];
				break;
			case "Biology":
				biology = alevelgrade[x];
				break;
			case "Geography":
				geography = alevelgrade[x];
				break;
			case "Agriculture":
				agriculture = alevelgrade[x];
				break;
			}
		}
	}

	public static boolean checkConstraints(String selectedFor, int maths, int english, String[] alevels,
			int[] olevels) {
		boolean flag;
		int passes=0;
		for (int i = 0; i < olevels.length; i++) {
			if (olevels[i] >= 3) {
				passes++;
			}
		}
		if (((selectedFor == null) && (maths >= 3) && (english >= 3) && (alevels.length >= 2) && (passes>=5))) {
			flag = true;
		} else
			flag = false;

		return flag;
	}

	private static void loadConstants(Statement stm) throws SQLException {
		// load data "Select query"
		// Loop through all records and assign the values to variables..
		// if prog = cs call the cs constructor and setConstants

		String query = "Select program, maths, physics, chemistry, computers, biology, geography, agriculture, cutoff from subject_values";
		ResultSet rs = stm.executeQuery(query);
		while (rs.next()) {
			String program = rs.getString("program");

			double[] subValue = new double[8];

			subValue[0] = rs.getFloat("maths");
			subValue[1] = rs.getFloat("physics");
			subValue[2] = rs.getFloat("chemistry");
			subValue[3] = rs.getFloat("computers");
			subValue[4] = rs.getFloat("biology");
			subValue[5] = rs.getFloat("geography");
			subValue[6] = rs.getFloat("agriculture");
			subValue[7] = rs.getFloat("cutoff");

			switch (program) {
			case "ICS":
				cs = ApplicantManager.getInstance().setCsValues(program, subValue[0], subValue[1], subValue[2],
						subValue[3], subValue[4], subValue[5], subValue[6], subValue[7]);
				break;
			case "EEE":
				ee = ApplicantManager.getInstance().setEeValues(program, subValue[0], subValue[1], subValue[2],
						subValue[3], subValue[4], subValue[5], subValue[6], subValue[7]);
				break;
			case "ECP":
				cpse = ApplicantManager.getInstance().setCpseValues(program, subValue[0], subValue[1], subValue[2],
						subValue[3], subValue[4], subValue[5], subValue[6], subValue[7]);
				break;
			case "SBT":
				bioTech = ApplicantManager.getInstance().setBiotechValues(program, subValue[0], subValue[1],
						subValue[2], subValue[3], subValue[4], subValue[5], subValue[6], subValue[7]);
				break;
			case "BFE":
				fe = ApplicantManager.getInstance().setBFEValues(program, subValue[0], subValue[1], subValue[2],
						subValue[3], subValue[4], subValue[5], subValue[6], subValue[7]);
				break;
			}
			System.out.println(
					program + " with subvalues " + subValue[0] + "," + subValue[1] + "," + subValue[2] + subValue[3]
							+ "," + subValue[4] + "'" + subValue[5] + "," + subValue[6] + "," + subValue[7] + "\n");

		}
	}

	public static List<Applicant> getApplicant() {
		return applicants;
	}

	public static ICS getICSValues() {
		return cs;
	}

	public static EEE getEEEValues() {
		return ee;
	}

	public static ECP getECPValues() {
		return cpse;
	}

	public static SBT getSBTValues() {
		return bioTech;
	}

	public static BFE getBFEValues() {
		return fe;
	}
}
