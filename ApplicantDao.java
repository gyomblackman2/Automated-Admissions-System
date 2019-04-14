
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ApplicantDao {

	public void upDate(Applicant app, ICS cs2, EEE ee2, ECP cpse2, SBT bioTech2, BFE fe2) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admissions_database", "root", "");
			Statement stm = con.createStatement();

			upDateDb(stm, app, cs2, ee2, cpse2, bioTech2, fe2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void upDateDb(Statement stm, Applicant app, ICS cs, EEE ee, ECP cpse, SBT bioTech, BFE fe)
			throws SQLException {

		String[] values = app.getChoice();
		System.out.println(" ");
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			if (app.getSelectedFor() == null) {
				System.out.println("Going through choice " + i + " with value of " + values[i] + " for applicant: "
						+ app.getFname() + " " + app.getLname() + " ranked: " + app.getF_choiceRating());

				switch (i) {
				case 0:
					switch (value) {
					case "ICS":
						String query = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[0] + "'" + "," + app.getPoints() + ","
								+ app.getF_choiceRating() + ")";
						String query2 = "UPDATE student " + "SET selected_for = 'ICS' " + "WHERE student.student_id = "
								+ app.getId() + " ";
						// String query = sort the class
						if ((app.getF_choiceRating() > cs.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query);
							stm.executeUpdate(query2);
							app.setSelectedFor("Computer Science");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + cs.getCUTOFFVALUE());
						}
						break;
					case "EEE":
						String query3 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[0] + "'" + "," + app.getPoints() + ","
								+ app.getF_choiceRating() + ")";
						String query4 = "UPDATE student " + "SET selected_for = 'EEE' " + "WHERE student.student_id = "
								+ app.getId() + "";
						if ((app.getF_choiceRating() > ee.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query3);
							stm.executeUpdate(query4);
							app.setSelectedFor("Electronic Engineering");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + ee.getCUTOFFVALUE());
						}
						break;
					case "ECP":
						String query5 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[0] + "'" + "," + app.getPoints() + ","
								+ app.getF_choiceRating() + ")";
						String query6 = "UPDATE student " + "SET selected_for = 'ECP' " + "WHERE student.student_id= "
								+ app.getId() + "";
						if ((app.getF_choiceRating() > cpse.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query5);
							stm.executeUpdate(query6);
							app.setSelectedFor("Chemical Engineering");
							System.out.println("Selected fo is " + app.getSelectedFor() + "with rating of "
									+ cpse.getCUTOFFVALUE());
						}
						break;
					case "SBT":
						String query7 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[0] + "'" + "," + app.getPoints() + ","
								+ app.getF_choiceRating() + ")";
						String query8 = "UPDATE student " + "SET selected_for = 'SBT' " + "WHERE student.student_id = "
								+ app.getId() + "";
						if ((app.getF_choiceRating() > bioTech.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query7);
							stm.executeUpdate(query8);
							app.setSelectedFor("BioTech");
							System.out.println("Selected fo is " + app.getSelectedFor() + "with rating of "
									+ bioTech.getCUTOFFVALUE());
						}
						break;
					case "BFE":
						String query9 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[0] + "'" + "," + app.getPoints() + ","
								+ app.getF_choiceRating() + ")";
						String query10 = "UPDATE student " + "SET selected_for = 'BFE' " + "WHERE student.student_id = "
								+ app.getId() + " ";
						// String query = sort the class
						if ((app.getF_choiceRating() > fe.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query9);
							stm.executeUpdate(query10);
							app.setSelectedFor("Finacial Engineering");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + fe.getCUTOFFVALUE());
						}
						break;
					}
					break;
				case 1:
					switch (value) {
					case "ICS":
						String query = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[1] + "'" + "," + app.getPoints() + ","
								+ app.getS_choiceRating() + ")";
						String query2 = "UPDATE student " + "SET selected_for = 'ICS' " + "WHERE student.student_id= "
								+ app.getId().toString() + "";
						if ((app.getS_choiceRating() > cs.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query);
							stm.executeUpdate(query2);
							app.setSelectedFor("Computer Science");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + cs.getCUTOFFVALUE());
						}
						break;
					case "EEE":
						String query3 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[1] + "'" + "," + app.getPoints() + ","
								+ app.getS_choiceRating() + ")";
						String query4 = "UPDATE student " + "SET selected_for = 'EEE' " + "WHERE student.student_id = "
								+ app.getId().toString() + "";
						if ((app.getS_choiceRating() > ee.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query3);
							stm.executeUpdate(query4);
							app.setSelectedFor("Electronic Engineering");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + ee.getCUTOFFVALUE());
						}
						break;
					case "ECP":
						String query5 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[1] + "'" + "," + app.getPoints() + ","
								+ app.getS_choiceRating() + ")";
						String query6 = "UPDATE student " + "SET selected_for = 'ECP' " + "WHERE student.student_id = "
								+ app.getId().toString() + "";
						if ((app.getS_choiceRating() > cpse.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query5);
							stm.executeUpdate(query6);
							app.setSelectedFor("Chemical Engineering");
							System.out.println("Selected fo is " + app.getSelectedFor() + "with rating of "
									+ cpse.getCUTOFFVALUE());
						}
						break;
					case "SBT":
						String query7 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[1] + "'" + "," + app.getPoints() + ","
								+ app.getS_choiceRating() + ")";
						String query8 = "UPDATE student " + "SET selected_for = 'SBT' " + "WHERE student.student_id= "
								+ app.getId().toString() + "";
						if ((app.getS_choiceRating() > bioTech.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query7);
							stm.executeUpdate(query8);
							app.setSelectedFor("BioTech");
							System.out.println("Selected fo is " + app.getSelectedFor() + "with rating of "
									+ bioTech.getCUTOFFVALUE());
						}
						break;
					case "BFE":
						String query9 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[0] + "'" + "," + app.getPoints() + ","
								+ app.getF_choiceRating() + ")";
						String query10 = "UPDATE student " + "SET selected_for = 'BFE' " + "WHERE student.student_id = "
								+ app.getId() + " ";
						// String query = sort the class
						if ((app.getF_choiceRating() > fe.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query9);
							stm.executeUpdate(query10);
							app.setSelectedFor("Finacial Engineering");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + fe.getCUTOFFVALUE());
						}
						break;
					}
					break;
				case 2:
					switch (value) {
					case "ICS":
						String query = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[2] + "'" + "," + app.getPoints() + ","
								+ app.getT_choiceRating() + ")";
						String query2 = "UPDATE student " + "SET selected_for = 'ICS' " + "WHERE student.student_id= "
								+ app.getId().toString() + "";
						if ((app.getT_choiceRating() > cs.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query);
							stm.executeUpdate(query2);
							app.setSelectedFor("Computer Science");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + cs.getCUTOFFVALUE());
						}
						break;
					case "EEE":
						String query3 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[2] + "'" + "," + app.getPoints() + ","
								+ app.getT_choiceRating() + ")";
						String query4 = "UPDATE student " + "SET selected_for = 'EEE' " + "WHERE student.student_id= "
								+ app.getId().toString() + "";
						if ((app.getT_choiceRating() > ee.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query3);
							stm.executeUpdate(query4);
							app.setSelectedFor("Electronic Engineering");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + ee.getCUTOFFVALUE());
						}
						break;
					case "ECP":
						String query5 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[2] + "'" + "," + app.getPoints() + ","
								+ app.getT_choiceRating() + ")";
						String query6 = "UPDATE student " + "SET selected_for = 'ECP' " + "WHERE student.student_id = "
								+ app.getId().toString() + "";
						if ((app.getT_choiceRating() > cpse.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query5);
							stm.executeUpdate(query6);
							app.setSelectedFor("Chemical Engineering");
							System.out.println("Selected fo is " + app.getSelectedFor() + "with rating of "
									+ cpse.getCUTOFFVALUE());
						}
						break;
					case "SBT":
						String query7 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId().toString() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[2] + "'" + "," + app.getPoints() + ","
								+ app.getT_choiceRating() + ")";
						String query8 = "UPDATE student " + "SET selected_for = 'SBT' " + "WHERE student.student_id = "
								+ app.getId().toString() + "";
						if ((app.getT_choiceRating() > bioTech.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query7);
							stm.executeUpdate(query8);
							app.setSelectedFor("BioTech");
							System.out.println("Selected fo is " + app.getSelectedFor() + "with rating of "
									+ bioTech.getCUTOFFVALUE());
						}
						break;
					case "BFE":
						String query9 = "insert into results (student_id, f_name, l_name, f_choice, points, rating) values ("
								+ "'" + app.getId() + "'" + "," + "'" + app.getFname() + "'" + "," + "'"
								+ app.getLname() + "'" + "," + "'" + values[0] + "'" + "," + app.getPoints() + ","
								+ app.getF_choiceRating() + ")";
						String query10 = "UPDATE student " + "SET selected_for = 'BFE' " + "WHERE student.student_id = "
								+ app.getId() + " ";
						// String query = sort the class
						if ((app.getF_choiceRating() > fe.getCUTOFFVALUE()) && (app.getSelectedFor() == null)
								&& (app.getOlevels().length >= 5)) {
							stm.executeUpdate(query9);
							stm.executeUpdate(query10);
							app.setSelectedFor("Financial Engineering");
							System.out.println(
									"Selected fo is " + app.getSelectedFor() + "with rating of " + fe.getCUTOFFVALUE());
						}
						break;
					}
					break;
				}
			}
		}

	}

	public List<Applicant> getApplicant() {
		return DataStore.getApplicant();
	}

	public ICS getICS() {
		return DataStore.getICSValues();
	}

	public EEE getEEE() {

		return DataStore.getEEEValues();
	}

	public ECP getECP() {

		return DataStore.getECPValues();
	}

	public SBT getSBT() {

		return DataStore.getSBTValues();
	}

	public BFE getBFE() {

		return DataStore.getBFEValues();
	}

}
