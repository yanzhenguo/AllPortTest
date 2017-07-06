package cn.shu.entity;

import cn.shu.ByteUtil;
import cn.shu.DataSaver;

public class ServerResponse {
	public static byte responseA7 [] = {(byte)0xFF,(byte)0xFF,(byte)0xA7,(byte)0x70,
			(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
			(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
			(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
			(byte)0x00,(byte)0x00,(byte)0x00,(byte)0xFF,
			(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xC8,
			(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
			(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,
			};
	
	public byte[] response(byte[] message){
		if(message.length==32 && message[0]==(byte)0xFF && message[1]==(byte)0xFF
				&& message[2]==(byte)0xE7 && message[3]==(byte)0x70){
			//定时问候指令
			return responseA7(message);
		}
		return null;
	}
	
	private byte[] responseA7(byte[] rec){
		Message message = ByteUtil.contentChange(rec);
		String hexString=ByteUtil.bytesToHexString(rec);
		//写入该客户端缓冲区中,等待被写入文件中
		if(DataSaver.clientmap.get(message.getId())==null){
			ClientPool clientPool = new ClientPool();
			clientPool.setId(message.getId());
			clientPool.add(hexString, message.getId());
			DataSaver.clientmap.put(message.getId(),new ClientPool());
		}else{
			ClientPool clientPool = DataSaver.clientmap.get(message.getId());
			clientPool.add(hexString, message.getId());
		}
		
		//保存到内存中，以供查询
		if(DataSaver.DataMap.get(message.getId())==null){
			ArrayMessage arrayMessage = new ArrayMessage();
			arrayMessage.addMessage(message);
			DataSaver.DataMap.put(message.getId(), arrayMessage);
		}else{
			ArrayMessage arrayMessage = DataSaver.DataMap.get(message.getId());
			arrayMessage.addMessage(message);		
		}
		//保存到缓冲区中
//		DataSaver.messagePool.pushMessage(str.replace("\n", ""));
		return responseA7;
	}
}
