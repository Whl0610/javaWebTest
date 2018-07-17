package cn.hnust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import cn.hnust.DBConnection;

public class Search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/plain;charset=utf-8");
		String temper = request.getParameter("temperature");
		String key1 = request.getParameter("key");
		String city = request.getParameter("cityname");
		System.out.println("temperature:" + temper);
		
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			//ResultSet rs = db.executeQuery("select * from weather where temperature = '"+ temper+"' and `key`='"+key1+"'");
			//ResultSet rs = db.executeQuery("select * from weather where cityname = '"+city+"'");
			ResultSet rs = db.executeQuery("select * from weather where temperature = '"+ temper+"'");
			
			String cityname = "";
			String temperature = "";
			String humidity = "";
			String key = "";
			
			while(rs.next()){
				cityname=rs.getString(1);
				temperature=rs.getString(2);
				humidity=rs.getString(3);
				key=rs.getString(4);
			}
			db.close();
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			obj.put("cityname", cityname);
			obj.put("temperature", temperature);
			obj.put("humidity", humidity);
			obj.put("key", key);

			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void doSearch(String temper/*String key1,String city*/) {
		try {
			
			DBConnection db = new DBConnection();
			//ResultSet rs = db.executeQuery("select * from weather where temperature = '"+ temper+"' AND `key`='"+key1+"'");
			//ResultSet rs = db.executeQuery("select * from weather where cityname = '"+city+"'");
			ResultSet rs = db.executeQuery("select * from weather where temperature = '"+ temper+"'");
			String cityname = "";
			String temperature = "";
			String humidity = "";
			String key = "";
			
			while(rs.next()){
				cityname=rs.getString(1);
				temperature=rs.getString(2);
				humidity=rs.getString(3);
				key=rs.getString(4);
			}
			db.close();
			
			JSONObject obj = new JSONObject();
			
			obj.put("cityname", cityname);
			obj.put("temperature", temperature);
			obj.put("humidity", humidity);
			obj.put("key", key);
			
			System.out.println(obj.toString(3));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//doSearch("±±¾©");
		//doSearch("31", "5");
		doSearch("25");
	}

}
