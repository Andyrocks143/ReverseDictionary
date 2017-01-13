package com.database;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBManager

{

	private static DataBaseConnection databaseConnection;
	static DataBaseConnection dbConnection_r = DataBaseConnection.getInstance();
	private Connection con;

	public static void main(String[] args) {
		DBManager d = new DBManager();
		List<String> holdWords = new ArrayList<String>();
		holdWords = d.getUserStatusKeyWords("15");
		//now compare to adverts list ...
	
	}

	public boolean register(int last, String fname, String lname,
			String gender, String dob, String City, String mo, String mail,
			String country)

	{

		boolean insertvalue = false;
		String insertquery = "insert into register(userid,fname,lname,gender,dob,city,mobno,mailid,profilePic,country)values(?,?,?,?,?,?,?,?,?,?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(insertquery);
			ps.setInt(1, last);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, gender);
			ps.setString(5, dob);
			ps.setString(6, City);
			ps.setString(7, mo);
			ps.setString(8, mail);
			ps.setString(9, "null");
			ps.setString(10, country);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return insertvalue;
	}

	public boolean AddFriends(int userID, int frdId)

	{

		boolean insertvalue = false;
		String insertquery = "insert into srs.friendslist(userId,friendId,flag)values(?,?,?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(insertquery);
			ps.setInt(1, userID);
			ps.setInt(2, frdId);
			ps.setInt(3, 1);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return insertvalue;
	}

	public boolean StoreStatus(int id, String status)

	{

		boolean insertvalue = false;
		String insertquery = "insert into srs.status(id,status)values(?,?);";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(insertquery);
			ps.setInt(1, id);
			ps.setString(2, status);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return insertvalue;
	}

	public boolean registere(int last)

	{

		boolean insertvalue = false;
		String insertquery = "insert into phr.registerPatient(userid) values(?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(insertquery);
			ps.setInt(1, last);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return insertvalue;
	}

	public boolean registereid(int last)

	{

		boolean insertvalue = false;
		System.out.println(last);
		System.out.println(last);
		System.out.println(last);

		String insertquery = "insert into phr.entrypatient(userid)values(?) ;";

		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(insertquery);
			ps.setInt(1, last);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return insertvalue;

	}

	public boolean loginregi(int id, String username, String password)

	{

		boolean insertvalue = false;
		String insertquery = "insert into srs.login(userid,username,password,emailFlag)values(?,?,?,?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(insertquery);
			ps.setInt(1, id);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setInt(4, 1);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("as");
		return insertvalue;

	}

	public int lastvalue()

	{
		int i = 0;

		String getvalue = "select max(userid) from register;";

		try {

			Connection con = dbConnection_r.makeConnectionDB();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(getvalue);
			if (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;

	}

	public String getd(int id) throws Exception {

		String types = "";

		String Hname = "";
		String Problem = "";
		String Symtoms = "";
		String Status = "";
		String Description = "";
		String Lastcheck = "";

		int cardn = 0;
		String query = "select Hname,Problem,Symtoms,Status,Description,Lastcheck,creditno from phr.entrypatient where userid='"
				+ id + "';";
		String dummyval = "";
		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next())

			{
				Hname = rs.getString("Hname");
				Problem = rs.getString("Problem");
				Symtoms = rs.getString("Symtoms");
				Status = rs.getString("Status");
				Description = rs.getString("Description");
				Lastcheck = rs.getString("Lastcheck");
				cardn = rs.getInt("creditno");
			}

			if (Hname == null || Problem == null || Symtoms == null
					|| Status == null || Description == null
					|| Lastcheck == null) {
				Hname = dummyval;
				Problem = dummyval;
				Symtoms = dummyval;
				Status = dummyval;
				;
				Description = dummyval;
				Lastcheck = dummyval;

			} else if (Status == "select one") {
				Status = dummyval;
				;

			}
			types = Hname + "-" + Problem + "-" + Symtoms + "-" + Status + "-"
					+ Description + "-" + Lastcheck + "-" + cardn;
			System.out.println(types);

		}

		catch (Exception e) {
			System.out.println(e);
		}
		return types;
	}

	public boolean descriptionmodify(int id, String desc)

	{

		boolean update = false;

		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement("update entrypatient set Description='"
					+ desc + "' where userid='" + id + "'");

			ins = ps.executeUpdate();

			if (ins != 0) {
				update = true;

			} else {
				update = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(desc);
		return update;

	}

	/*
	 * 
	 * public int laststudentId() { int i = 0;
	 * 
	 * String query =
	 * "select count(*) as lastRow from projectmanagement.student;"; try {
	 * 
	 * Connection con = dbConnection.makeConnectionDB(); Statement st =
	 * con.createStatement(); ResultSet rs = st.executeQuery(query); if
	 * (rs.next()) { i = rs.getInt(1);
	 * 
	 * // System.out.println(returnval); } } catch (Exception e) {
	 * System.out.println(e); }
	 * 
	 * return i; }
	 */

	public boolean registerdoctor(int i, String fname, String lname,
			String gender, String Address, String City, int mo, String mailid,
			String hname, int hid, String spl)

	{
		System.out.println("haii");
		boolean insertvalue = false;
		String insertquery = " insert into phr.registerDoctor(userid,dFirstname,dLastname,dGender,dAddress,dCity,dMobno,dMailid,hospitalname,hospitalid,spacilist)values(?,?,?,?,?,?,?,?,?,?,?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(insertquery);
			ps.setInt(1, i);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, gender);
			ps.setString(5, Address);
			ps.setString(6, City);
			ps.setLong(7, mo);
			ps.setString(8, mailid);
			ps.setString(9, hname);
			ps.setInt(10, hid);
			ps.setString(11, spl);
			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return insertvalue;
	}

	public int doctorlastvalue()

	{
		int i = 0;

		String getvalue = "select max(userid) from login;";

		try {

			Connection con = dbConnection_r.makeConnectionDB();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(getvalue);
			if (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;

	}

	public String getUserTypeandid(String uname, String upass) throws Exception {
		String type = "";
		int userid = 0;
		String usertype = "";
		String query = "select userid,usertype from phr.login where username='"
				+ uname + "' and password='" + upass + "';";

		try {
			System.out.println("assd");
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				userid = rs.getInt("userid");
				usertype = rs.getString("usertype");

			}// patient-01
			type = Integer.toString(userid) + "-" + usertype;

		} catch (Exception e) {
			System.out.println(e);
		}
		return type;
	}

	public String getUid(String uname, String pword) throws Exception {

		int userid = 0;
		int flag = 0;
		String query = "select userid,emailFlag from login where username='"
				+ uname + "' and  password='" + pword + "' ;";
		String value = "";
		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				userid = rs.getInt("userid");
				flag = rs.getInt("emailFlag");

			}// patient-01

			value = userid + "-" + flag;
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}

	public String getdata1(int id) throws Exception {
		String type = "";
		String name = "";
		String mailids = "";
		String query = " select fname,mailid from register where userid='" + id
				+ "' ";

		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				name = rs.getString("fname");
				mailids = rs.getString("mailid");

			}// patient-01

			type = name + "-" + mailids;
		} catch (Exception e) {
			System.out.println(e);
		}
		return type;
	}

	public String getUname(int id) throws Exception {
		String type = "";

		String query = " select username from login where userid='" + id + "' ";

		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				type = rs.getString("username");

			}// patient-01

		} catch (Exception e) {
			System.out.println(e);
		}
		return type;
	}

	public String getName(int id, String tableName, String colName)
			throws Exception {

		String fname = "";

		String query = "select " + colName + "  from phr." + tableName
				+ " where userid='" + id + "';";
		// System.out.println(query);
		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {

				fname = rs.getString(colName);

			}

		} catch (Exception e) {
			System.out.println(fname);
		}
		return fname;
	}

	public String getdoctorname(int id) throws Exception {

		String fname = "";

		String query = "select dFirstname  from phr.registerDoctor where userid='"
				+ id + "';";

		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {

				fname = rs.getString("dFirstname");

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return fname;
	}

	public boolean patiententry(int pid, String hname, String dname,
			String problem, String Symtom, String str, String date,
			String desc, int no)

	{
		System.out.println(pid + hname + dname + problem + Symtom + str + date
				+ desc);
		boolean insertvalue = false;
		// String insertquery =
		// "update phr.entrypatient set Hname='"+hname+"',Doctorname='"+dname+"',Problem='"+problem+"',Symtoms='"+Symtom+"',Status='"+str+"',Description='"+desc+"',Lastcheck='"+date+"' where userid='"+pid+"');";
		String insertquery = "update phr.entrypatient set Hname='" + hname
				+ "',Doctorname='" + dname + "',Problem='" + problem
				+ "',Symtoms='" + Symtom + "',Status='" + str
				+ "',Description='" + desc + "',Lastcheck='" + date
				+ "',creditno='" + no + "' where userid='" + pid + "';";

		try

		{
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;
			ps = con.prepareStatement(insertquery);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("as");
		return insertvalue;

	}

	public boolean patiententry2(int pid, String dname, String fname)

	{
		// System.out.println(pid+dname+pfname);
		boolean insertvalue = false;
		String insertquery = "insert into phr.doctor(puserid,duserid,patientfname)values(?,?,?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;
			ps = con.prepareStatement(insertquery);
			ps.setInt(1, pid);
			ps.setString(2, dname);
			ps.setString(3, fname);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(dname);
		return insertvalue;

	}

	public boolean putkeyword(int id, String value)

	{
		// System.out.println(pid+dname+pfname);
		boolean insertvalue = false;
		String insertquery = "insert into userkeyword(userid,keywords)values(?,?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;
			ps = con.prepareStatement(insertquery);
			ps.setInt(1, id);
			ps.setString(2, value);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return insertvalue;

	}

	public boolean another(int pid, String rel, String frd, String edoc,
			String mail, String key1, String key2, String key3)

	{
		// System.out.println(pid+dname+pfname);
		boolean insertvalue = false;
		String insertquery = "insert into registerpatient2(userid,relname,friend,emerdoctor,emerdoctormail,key1,key2,key3)values(?,?,?,?,?,?,?,?) ;";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;
			ps = con.prepareStatement(insertquery);
			ps.setInt(1, pid);
			ps.setString(2, rel);
			ps.setString(3, frd);
			ps.setString(4, edoc);
			ps.setString(5, mail);
			ps.setString(6, key1);
			ps.setString(7, key2);
			ps.setString(8, key3);

			ins = ps.executeUpdate();

			if (ins != 0) {
				insertvalue = true;

			} else {
				insertvalue = false;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return insertvalue;

	}

	public String doctorviews(int ddID) throws Exception

	{

		String tablecreation = "<table><tr><td><h3><u>Patientname</u></h3></td</tr>";

		String viewpage = "ViewPage.jsp?puserid=";

		String query = " select patientfname,puserid from phr.doctor where duserid='"
				+ ddID + "';";

		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			for (; rs.next();) {

				tablecreation += "<tr><td><a href=" + viewpage
						+ rs.getString("puserid") + ">" + "Link"
						+ rs.getString("patientfname") + "</a></td</tr>";

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(viewpage);
		return tablecreation;

	}

	public String doctorview(int ddID) throws Exception {

		String fname = "";

		String query = "select patientfname  from phr.doctor where duserid='"
				+ ddID + "';";

		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {

				fname = rs.getString("patientfname");

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(fname);
		System.out.println(fname);

		return fname;
	}

	public int getuname(String name) throws Exception {

		int fname = 0;

		String query = "select userid  from login where username='" + name
				+ "';";

		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {

				fname = rs.getInt("userid");

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return fname;
	}

	public String getPath(int id) throws Exception {

		String fname = null;

		String query = "select profilePic  from register where userid='" + id
				+ "';";

		try {

			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {

				fname = rs.getString("profilePic");

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return fname;
	}

	public boolean verifyEmail(String id) {
		boolean update = false;
		String query = "update srs.login set emailFlag='0' where userid='" + id
				+ "';";

		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(query);

			ins = ps.executeUpdate();

			if (ins != 0) {
				update = true;

			} else {
				update = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return update;
	}

	public String getStatus(int id) {
		String buffer = "<div>";
		String tableCreation = "";
		int i = 0;
		List dataList = new ArrayList();
		String qry = "select status,date,likes from srs.status where id='" + id
				+ "';";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(qry);

			tableCreation = "<table class=\"gridtable\">";

			while (rs.next()) {
				int count = i++;
				// int count = i++;
				tableCreation += "<tr>";
				tableCreation += "<td id=\"statusId" + count + "\">"
						+ rs.getString("status") + " - "
						+ rs.getTimestamp("date") + " - likes:"
						+ rs.getInt("likes") + " </td> ";

				tableCreation += "</tr>";

				System.out.println("Results:" + tableCreation);

			}
			tableCreation += "</table>";
			// buffer = buffer + "</div>";
			buffer = tableCreation + "</div>";

		} catch (Exception e) {
			System.out.println(e);
		}

		return tableCreation;
	}

	public String getStatusView(int id) {
		String buffer = "<div>";
		String tableCreation = "";
		int i = 0;
		List dataList = new ArrayList();
		String qry = "select status,date,autoid from srs.status where id='"
				+ id + "';";
		System.out.println(qry);

		try {
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(qry);

			tableCreation = "<table class=\"gridtable\">";

			while (rs.next()) {
				int count = i++;
				// int count = i++;
				tableCreation += "<tr>";
				tableCreation += "<td id=\"statusId" + count + "\">"
						+ rs.getString("status") + " - "
						+ rs.getTimestamp("date")
						+ " <a href='javascript:void(0)' onclick='likeStatus("
						+ rs.getInt("autoid") + ");''>Like</a></td> ";

				tableCreation += "</tr>";

				System.out.println("Results:" + tableCreation);

			}
			tableCreation += "</table>";
			// buffer = buffer + "</div>";
			buffer = tableCreation + "</div>";

		} catch (Exception e) {
			System.out.println(e);
		}

		return tableCreation;
	}

	public String getFriends() {
		String tableCreation = "";
		String query = "";

		return tableCreation;
	}

	public boolean updateRegisterTable(String path, String id) {
		boolean update = false;
		String query = "update srs.register set profilePic='" + path
				+ "' where userid='" + id + "';";
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(query);

			ins = ps.executeUpdate();

			if (ins != 0) {
				update = true;

			} else {
				update = false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return update;

	}

	public String getFriendsTable(String name, String userID) {
		String tableCreation = "";
		String query = "select userid,profilePic,fname,mailid from srs.register where fname like '"
				+ name + "%';";
		System.out.println(query);
		int i = 0;
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query);

			tableCreation = "<table class=\"gridtable\">";

			while (rs.next()) {
				int count = i++;
				tableCreation += "<tr><td id=\"profileId"
						+ rs.getInt("userid")
						+ "\"><img src='images/profile/"
						+ rs.getString("profilePic")
						+ "'"
						+ "</td><td><a href='javascript:void(0)' onclick='getUserProfile("
						+ rs.getInt("userid") + "," + userID + ")'>"
						+ rs.getString("fname") + "</a></td><td>"
						+ rs.getString("mailid") + "</td></tr>";

			}
			tableCreation += "</table>";

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(tableCreation);
		return tableCreation;
	}

	public int friendsCount(int UserID) {
		int i = 0;
		String query = "SELECT count(distinct friendId) from  srs.friendslist where userId='"
				+ UserID + "' and flag='1'";
		System.out.println(query);
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Count :" + i);
		return i;
	}

	public ArrayList<Integer> getFriedsIds(int userId) {
		ArrayList<Integer> friendId = new ArrayList<>();
		int i = 0;
		String query = "select distinct friendId from srs.friendslist where userId='"
				+ userId + "'";
		System.out.println(query);
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				friendId.add(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return friendId;
	}

	public String showFriends(ArrayList<Integer> ids) {
		System.out.println(ids);

		String tableCreation = "";
		tableCreation = "<table class=\"gridtable\">";

		int i = 0;
		try {
			for (int j = 0; j < ids.size(); j++) {
				String query = "select userid,profilePic,fname,mailid from srs.register where userid = '"
						+ ids.get(j) + "'";
				System.out.println(query);
				Connection con = dbConnection_r.makeConnectionDB();
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					int count = i++;
					tableCreation += "<tr><td id=\"profileId"
							+ rs.getInt("userid")
							+ "\"><img src='images/profile/"
							+ rs.getString("profilePic") + "'"
							+ "</td><td><a href='javascript:void(0)'>"
							+ rs.getString("fname") + "</a></td><td>"
							+ rs.getString("mailid") + "</td></tr>";

				}
			}
			tableCreation += "</table>";

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(tableCreation);
		return tableCreation;
	}

	public int getLikeCount(int StatusId) {
		int value = 0;
		System.out.println("get Staus");
		try {
			String query = "select likes from srs.status where autoid='"
					+ StatusId + "'";
			System.out.println(query);
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				value = rs.getInt("likes");
			}

			System.out.println("getLikes :" + value);
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}

	public boolean updateLikes(int statusId, int presentValue) {
		boolean value = false;
		int govalue = presentValue + 1;
		System.out.println("updateLikes");
		try {
			String query = "update srs.status set likes='" + govalue
					+ "' where autoid='" + statusId + "'";
			System.out.println(query);

			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;

			ps = con.prepareStatement(query);

			ins = ps.executeUpdate();

			if (ins != 0) {
				value = true;

			} else {
				value = false;
			}

		} catch (Exception e) {

		}
		return value;
	}

	// mapping logic

	public List<String> getUserStatusKeyWords(String userId) {
		List<String> getUserStatusKeyWords = new ArrayList<String>();
		String query = "SELECT * from srs.userkeyword where userid='" + userId
				+ "' ORDER BY userid DESC LIMIT 6;";
		System.out.println(query);
		try {
			Connection con = dbConnection_r.makeConnectionDB();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				getUserStatusKeyWords.add(rs.getString("keywords"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(getUserStatusKeyWords);
		return getUserStatusKeyWords;

	}

	public void storeDate(String dateStore, String name) throws Exception {
		String query = "insert into srs.d (date,name)value(?,?);";

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = formatter.parse(dateStore);

		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

		try {
			Connection con = dbConnection_r.makeConnectionDB();
			PreparedStatement ps = null;
			int ins = 0;
			ps = con.prepareStatement(query);
			// 2011-09-05
			ps.setDate(1, sqlDate);
			ps.setString(2, name);

			ins = ps.executeUpdate();

			if (ins != 0) {
				// insertvalue = true;
				System.out.println("Inserted");

			} else {
				// insertvalue = false;
				System.out.println("Failed");

			}

			con.close();

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
