package cn.shu;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TestClass {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Long res;
		int dimension_size = Integer.parseInt(in.nextLine().trim());
		List<Long[]> dimList = new ArrayList<Long[]>();

		for (int _dimension_i = 0; _dimension_i < dimension_size; _dimension_i++) {
			Long[] dimension_item = new Long[5];
			String dimItemStr = in.nextLine().trim();
			String[] dimItemStrs = dimItemStr.split(" ");
			for (int j = 0; j < 5; j++) {
				dimension_item[j] = Long.parseLong(dimItemStrs[j]);
			}
			dimList.add(dimension_item);
		}	
		
		res = guessMyPath(dimList);
		System.out.println(res);

	}
	/**
	 * 计算救所有同伴所需的燃料
	 * @param dimList
	 * @return
	 */
	public static Long guessMyPath(List<Long[]> dimList){
		Long res = 0L;
		Long[] current = {0L,0L,0L,0L,0L};  //保存当前位置坐标
		List<Long[]> notArrive = dimList;   //保存未到达位置坐标		
		for(int i=0;i<dimList.size();i++){  //依次救出每一位同伴
			int miniIndex = getNearFriend(notArrive, current); 
			res+=Math.abs((notArrive.get(miniIndex)[0]-current[0]))+Math.abs((notArrive.get(miniIndex)[1]-current[1]))+Math.abs((notArrive.get(miniIndex)[2]-current[2]))+
					10*Math.abs((notArrive.get(miniIndex)[3]-current[3])) + 100*Math.abs((dimList.get(miniIndex)[4]-current[4]));
			current = notArrive.get(miniIndex);			
			notArrive.remove(miniIndex);
			if(i==dimList.size()-1){ //返回原点
				res+=Math.abs((notArrive.get(miniIndex)[0]))+Math.abs((notArrive.get(miniIndex)[1]))+Math.abs((notArrive.get(miniIndex)[2]))+
						10*Math.abs((notArrive.get(miniIndex)[3])) + 100*Math.abs((dimList.get(miniIndex)[4]));
			}
		}
		
		return res;
	}
	/**
	 * 找到离得最近的同伴,返回id
	 * @param dimList
	 * @return
	 */
	public static int getNearFriend(List<Long[]> dimList, Long[] current){
		Long miniDistance = Long.MAX_VALUE;
		int miniIndex = 0;
		for(int j=0;j<dimList.size();j++){
			Long distance = 0L;
			for(int i=0;i<5;i++){
				distance+=(dimList.get(j)[i]-current[i])^2;
			}
			if(distance<miniDistance){
				miniDistance=distance;
				miniIndex=j;
			}
		}
		return miniIndex;
	}

}
