package cn.shu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shu.DataSaver;

public class GetGatesList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Set<String> keys= DataSaver.DataMap.keySet();
		if(keys.isEmpty()==true){
			out.print("null");
			return;
		}
		StringBuilder sb = new StringBuilder("");
		sb.append("{'content':[");
		for(String key : keys){
			sb.append("'key':'"+key+"',");
		}
		sb.delete(sb.length()-1, sb.length());		
		sb.append("]}");
		
		String response = sb.toString();
		response = response.replace("'", "\"");
		out.print(response);
	}
	
}
