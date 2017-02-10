package com.espark.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.espark.adarsh.bean.TaskCreateForm;
import com.mysql.jdbc.Statement;
class JDBCDemo9
{
	//TaskCreateForm tc = new TaskCreateForm();
	public static void main(String[] args)
	{
		Connection conn = null;
		Scanner sc = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		TaskCreateForm tc = new TaskCreateForm();
		try
		{
			sc = new Scanner(System.in);
			System.out.println("Enter issue name");
			//String issue_name = sc.next();
			String issue_name = tc.getIssue_name();
			System.out.println(issue_name);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kida","root","mysql");
			String query1 = "select * from kida.issue_main where issue_name=?"; 
			pst = conn.prepareStatement(query1);
			pst.setString(1,issue_name);
			rs= pst.executeQuery();
			while(rs.next()){
				int s1 = rs.getInt(1);
				String s2 = rs.getString(2);
				String s3 = rs.getString(3);
				String s4 = rs.getString(4);
				String s5 = rs.getString(5);
				String s6 = rs.getString(6);
				String s7 = rs.getString(7);
				String s8 = rs.getString(8);
				String s9 = rs.getString(9);
				String s10 = rs.getString(10);
				String s11 = rs.getString(11);
				String s12 = rs.getString(12);
				System.out.println("ID "+s1+"Issue Name= "+s2+"Issue report date= "+s3+"Issue Update date= "+s4+"issue Heading= "+s5+"Issue Description= "+s6+"Issue Status= "+s7+"Issue Linked with= "+s8+"Issue Comments= "+s9+"Any Other = "+s10+"Issue closed date= "+s11+"Issue Type= "+s12);
				
			}
			String query2 = "UPDATE kida.issue_main SET issue_update_date=? WHERE issue_name=? ";
			pst = conn.prepareStatement(query2);
			System.out.println("Enter update date");
			String updateDate = sc.next();
			pst.setString(1,updateDate);
			pst.setString(2,issue_name);
			boolean b= pst.execute();
			System.out.println("value inserted");
		}
		catch (SQLException se)
		{
			System.out.println(se);
		}
		catch (ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		finally
		{
            try
            {
				if (conn!=null )
				{
					conn.close();
					System.out.println("connection closed");
				}
                if (pst!=null )
				{
					pst.close();
					System.out.println("prepareStatement closed");
				}
                if (sc!=null)
                {
                	sc.close();
                	System.out.println("Scanner closed");
                }
                if (rs!=null)
                {
                	rs.close();
                	System.out.println("ResultSet closed");
                }
            }
            catch (SQLException se1)
            {
				System.out.println(se1.toString());
            }
		}
	}
}
