package cn.shu;

import cn.shu.entity.Message;

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
	public static Message contentChange(byte[] src){
		Message message=new Message("1","2","4","5");
		System.out.println(message.getId());
		System.out.println(message.getTime());
		System.out.println(message.getEnergy());
		System.out.println(message.getPower());
		return message;
	}
	}
	
