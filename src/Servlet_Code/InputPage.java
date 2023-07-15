package Servlet_Code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputPage")
public class InputPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		String first_name = request.getParameter("first_name");
		String second_name = request.getParameter("second_name");
		String firstname_dup = "";
		for(int i=0;i<first_name.length();i++) {
			if(first_name.charAt(i)!=' ') {
				firstname_dup += String.valueOf(first_name.charAt(i));
			}
		}
		first_name = firstname_dup;
		
		String secondname_dup = "";
		for(int i=0;i<second_name.length();i++) {
			if(second_name.charAt(i)!=' ') {
				secondname_dup += String.valueOf(second_name.charAt(i));
			}
		}
		second_name = secondname_dup;
		int number= getNumber(first_name,second_name); 
		String relation = getRelation(number);
		int percentage = getPercent(first_name, second_name, relation);
		request.setAttribute("relation", relation);
		request.setAttribute("percentage", percentage);
		
		request.getRequestDispatcher("OutputPage.jsp").forward(request, response);
	}
	
	int getNumber(String first_name, String second_name) {
		int[] first_arr = new int[26];
		int[] second_arr = new int[26];
		
		first_name = first_name.toLowerCase();
		second_name = second_name.toLowerCase();
		
		for(int i=0;i<first_name.length();i++) {
			first_arr[first_name.charAt(i)-97]++;
		}
		
		for(int i=0;i<second_name.length();i++) {
			second_arr[second_name.charAt(i)-97]++;
		}
		
		int count = 0;
		for(int i=0;i<26;i++) {
			count+= Math.abs(first_arr[i] - second_arr[i]);
		}
		return count;
	}
	
	String getRelation(int number) {
		String relations[] = {"Friends","Love","Affection","Marraige","Enemies","Sisters"};
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<6;i++) {
			al.add(i);
		}
		int size = 6;
		int index = 0;
		while(size != 1) {
			int remove_index = (index+((number-1)%size))%size;
			al.remove(remove_index);
			size--;
			index = (remove_index)%size;	
		}
		return relations[al.get(0)];
	}
	
	int getPercent(String first_name, String second_name, String relation) {
		
		first_name = first_name.toLowerCase();
		second_name = second_name.toLowerCase();
		relation = relation.toLowerCase();
		
		int[] count = new int[26];
		for(int i=0;i<first_name.length();i++) {
			count[first_name.charAt(i)-97]++;
		}
	
		for(int i=0;i<second_name.length();i++) {
			count[second_name.charAt(i)-97]++;
		}
		
		for(int i=0; i<relation.length();i++) {
			char c = relation.charAt(i);
			count[c-97]++;
		}
		
		int[] flag = new int[26];
		
		StringBuilder num = new StringBuilder("");
		for(int i=0;i<first_name.length();i++) {
			char c = first_name.charAt(i);
			if(flag[c-97] == 0) {
				num.append(count[c-97]);
				flag[c-97] = 1;
			}
		}
		
		for(int i=0;i<relation.length();i++) {
			char c = relation.charAt(i);
			if(flag[c-97] == 0) {
				num.append(count[c-97]);
				flag[c-97] = 1;
			}
		}
		
		for(int i=0;i<second_name.length();i++) {
			char c = second_name.charAt(i);
			if(flag[c-97] == 0) {
			    num.append(count[c-97]);
				flag[c-97] = 1;
			}
		}
		
    
		 while(num.length() > 2){
	            StringBuilder new_num = new StringBuilder("");
	            int low = 0, high = num.length()-1;
	            
	            while(low < high) {
	                new_num.append(Integer.valueOf(String.valueOf(num.charAt(low))) + Integer.valueOf(String.valueOf(num.charAt(high))));
	                low++;
	                high--;
	            }
	            if(low == high) {
	                new_num.append(num.charAt(low));
	            }
	            num = new_num;
	        }
		
		int percentage = Integer.valueOf(String.valueOf(num)); 
		return percentage;
		
	}
	
	int getNumberOfDigits(int num) {
		int count = 0;
		if(num == 0) {
			return 1;
		}
		while(num > 0) {
			count++;
			num = num / 10;
		}
		
		return count;
	}
	

}
