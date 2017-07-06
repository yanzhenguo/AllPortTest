package cn.shu;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import cn.shu.entity.ArrayMessage;
import cn.shu.entity.ClientPool;
import cn.shu.entity.MessagePool;
import cn.shu.gui.MainWindow;

public class DataSaver {
	public static MainWindow mainWindow;
	public static SimpleDateFormat sd =new SimpleDateFormat("HH:mm:ss:SSS");
	public static SimpleDateFormat sd2 =new SimpleDateFormat("yyyyMMdd");
	public static Map<String,ArrayMessage> DataMap = new HashMap<String,ArrayMessage>();
	public static Map<String,ClientPool> clientmap = new HashMap<String,ClientPool>();
	public static MessagePool messagePool=new MessagePool();
	public static Map<String, Socket> sockketPool = new HashMap<String, Socket>(); //保存所有连接，键为哈希值
}
