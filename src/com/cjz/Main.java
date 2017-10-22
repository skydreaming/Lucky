package com.cjz;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.cjz.data.Ticket;
import com.cjz.data.provider.DataProvider;
import com.cjz.proccessor.LineProccessor;
import com.cjz.proccessor.LineProccessor.ProccessCore;

public class Main {

	public static void main(String[] args) {
		List<Ticket> all = DataProvider.getInstance().getAll();
		
		LineProccessor proccessor = new LineProccessor(all);
		final Map<Integer, Integer> sum = new TreeMap<>();
		proccessor.setProcessCore(new ProccessCore() {
			
			
			@Override
			public void onProcess(Ticket ticket) {
				Iterator<Integer> it = ticket.iterator();
				int num;
				while(it.hasNext()){
					num = it.next();
					Integer count = sum.get(num);
					if(count == null){
						sum.put(num, 1);
					}else {
						sum.put(num, count + 1);
					}
				}
			}
		}).process();
		Set<Entry<Integer,Integer>> entrySet = sum.entrySet();
		for(Entry<Integer, Integer> entry : entrySet){
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
//		System.out.println(all.size());
	}

}
