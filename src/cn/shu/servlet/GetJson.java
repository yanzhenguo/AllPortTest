package cn.shu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;

import cn.shu.DataSaver;
import cn.shu.entity.ArrayMessage;
import cn.shu.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GetJson extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Integer time = Integer.valueOf(req.getParameter("time"));
		String uid = req.getParameter("uid");
		StringBuilder sb = new StringBuilder("");
		ArrayMessage am = DataSaver.DataMap.get(uid);		
		List<Message> messages = am.getSingleList();
		int size_am = messages.size();
		if(size_am==0){
			sb.append("null");			
			out.print(sb.toString());
			return;
		}else if(time==0){
			//获取今天所有时刻的发电量
			for(int i=0;i<size_am;i++){
				Message m = messages.get(i);
				if(i==0){
					sb.append("{'content':[");					
				}
				sb.append("{'id':'"+m.getId()+"','time':'"+DataSaver.sd.format(m.getTime())+
						"','enegy':'"+m.getEnergy()+"','power':'"+m.getPower()+"'},");				
			}
		}else if(time>0 && time<1000){
			//获取过去time分钟的发电数据
			List<Message> newMessages = getLimitMessage(time,messages);
			if(newMessages.size()==0){
				sb.append("null");			
				out.print(sb.toString());
				return;
			}
			for(int i=0;i<newMessages.size();i++){
				Message m = newMessages.get(i);
				if(i==0){
					sb.append("{'content':[");					
				}
				sb.append("{'id':'"+m.getId()+"','time':'"+DataSaver.sd.format(m.getTime())+
						"','enegy':'"+m.getEnergy()+"','power':'"+m.getPower()+"'},");				
			}
		}else{
			sb.append("null");			
			out.print(sb.toString());
			return;
		}
		sb.delete(sb.length()-1, sb.length());		
		sb.append("]}");
		
		String response = sb.toString();
		response = response.replace("'", "\"");
		out.print(response);
	}
	private List<Message> getLimitMessage(int limit, List<Message> messages){
		List<Message> ms = new ArrayList<Message>();
		Date now = new Date();
		long mills = (long)limit*60*1000; 
		Date past=new Date(now.getTime()-mills);
		for(Message m : messages){
			if(m.getTime().after(past)){
				ms.add(m);
			}
		}
		return ms;
	}
}
