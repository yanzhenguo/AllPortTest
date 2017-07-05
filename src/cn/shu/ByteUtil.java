package cn.shu;

import cn.shu.entity.Message;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;

public class ByteUtil {
	public static String bytesToHexString(byte[] src){
		StringBuilder stringBuilder = new StringBuilder("");
		for(int i=0;i<src.length;i++){
			int v=src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if(hv.length()<2){
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);		
			}
		return stringBuilder.toString();
		}
	public static String jisuan(String string,double num){
		double temp = Integer.parseInt(string,16)/num;
		DecimalFormat decimalFormat=new DecimalFormat(".00");
		return decimalFormat.format(temp);
	}
	public static Message contentChange(byte[] src){
		//增加处理程序
		String srcString = bytesToHexString(src);
		String temp = srcString.substring(0,8);
		String baseData="ffffe770";
		if(baseData.equals(temp)){
			String id = srcString.substring(20,28);
			String data = DataSaver.sd.format(new Date());
			String energy = jisuan(srcString.substring(52,60),4.0);//00002a75
			String power = jisuan(srcString.substring(48,52),1024.0);//04ea
			Message message=new Message(id,data,energy,power);
			System.out.println(message.getId());
			System.out.println(message.getTime());
			System.out.println(message.getEnergy());
			System.out.println(message.getPower());
			return message;
		}else{
			return null;
		}

	}
}
	
