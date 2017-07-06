package cn.shu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shu.DataSaver;
import cn.shu.entity.Message;
import cn.shu.entity.MessagePool;

public class GetRecent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		MessagePool messagePool = DataSaver.messagePool;
		int length = messagePool.getSize();
		if (length==0) {
			out.print("null");
		}else{
			StringBuffer sb = new StringBuffer();
			sb.append("{\"content\":[");
			
			while(messagePool.getSize()>20){
				messagePool.getMessage();
			}
			String message;
			
			for(int i=0;i<length;i++){
				message=messagePool.getMessage();
				sb.append("{\"message\":\""+message+"\"}");
				if(i!=length-1) {
					sb.append(",");
				}
			}
			String response = sb.toString();
			response+="]}";
			out.print(response);
		}
	}

}
