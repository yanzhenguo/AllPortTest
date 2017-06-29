package cn.shu;

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
	
	}
	
