package sudokugame;
import java.sql.*;

/* For this class to work do the following.
 * 1. In the "jarfiles" folder there will be "sqlite-jdbc-3.16.1.jar" folder.
 * 2. Configure JRE System Library and add the "sqlite-jdbc-3.16.1.jar" file to the JRE System library.
*/

//For more details on connecting data base to java application, you can visit this link
//https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

// This class is used to create a .sqlite file that will save the game.

public class SQLiteConnection 
{
	static Connection conn=null;
	private static boolean hasData=false;
	private static Statement state;
	private static ResultSet rs;
	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("org.sqlite.JDBC");
		conn=DriverManager.getConnection("jdbc:sqlite:Sudoku.sqlite");
		initialize();
		System.out.println("Connection Sucessful");
		return conn;
	}

	public static void initialize() throws SQLException
	{
		if(hasData==false)
		{
			hasData=true;
			
			// Check if a table named SaveSudoku is there.
			// This table is used to save the state of the game.
			state=conn.createStatement();
			rs=state.executeQuery(" select name from sqlite_master where type=\"table\" and name=\"SaveSudoku\"; ");
			
			// If the table is not there, then create the table
			if(rs.next()==false)
			{
				Statement st=conn.createStatement();
				st.execute(" create table SaveSudoku (value varchar,filled varchar); ");
			}
			
			// Check if a table named SolveSudoku is there.
			// This table is used to save the solution of the game
			state=conn.createStatement();
			rs=state.executeQuery(" select name from sqlite_master where type=\"table\" and name=\"SolveSudoku\"; ");
			
			// If the table is not there, then create the table 
			if(rs.next()==false)
			{
				Statement st=conn.createStatement();
				st.execute(" create table SolveSudoku (value integer); ");
			}
			
			// Check if a table names SystemConfig is there
			// This table is used to save which scanning method is to be used to navigate the UI.
			state=conn.createStatement();
			rs=state.executeQuery(" select name from sqlite_master where type=\"table\" and name=\"SystemConfig\"; ");
			
			// If the table is not there, then create the table.
			if(rs.next()==false)
			{
				Statement st=conn.createStatement();
				st.execute(" create table SystemConfig (Scanning varchar,time integer); ");
			}
		}
	}
}