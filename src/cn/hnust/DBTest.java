package cn.hnust;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DBTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			//String sql = "INSERT INTO weather (cityname,temperature, humidity) VALUE ('ÖÐÉ½',33,88)";
			String sql="select * from Que where A='Àî°×'";
			
			b.executeQuery(sql);
			ResultSet rs = b.executeQuery("select * from Que");
			
			ArrayList<Questions> list = new ArrayList();
			while(rs.next()){
				int id=rs.getInt(1);
				String question=rs.getString(2);
				String A=rs.getString(3);
				String B=rs.getString(4);
				String C=rs.getString(5);
				String D=rs.getString(6);
				String answer=rs.getString(7);
				Questions Q = new Questions(id,question,A,B,C,D,answer);
				list.add(Q);
			}
			b.close();
			Random r = new Random();
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				System.out.println(randnumber);
				//if not exist 
				ques[j] = randnumber;
				j++;
			}
			
			for(int k=0;k<4;k++) {
				Questions s = list.get(k);
				System.out.println(s.question);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
