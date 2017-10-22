package com.cjz.data.provider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cjz.data.Ticket;

public class DataProvider {
	private static final String DATA_PATH = "/Users/cjz/data/2012.txt";
	private static DataProvider instance;
	private static List<Ticket> datas;

	public static DataProvider getInstance() {
		if (instance == null) {
			synchronized (DataProvider.class) {
				if(instance == null){
					instance = new DataProvider();
				}
			}
		}
		return instance;
	}
	
	public List<Ticket> getAll(){
		List<Ticket> ret = null;
		if(datas == null){
			datas = loadFromFile();
		}
		ret = datas;
		return ret;
	}
	
	private List<Ticket> loadFromFile(){
		List<Ticket> tickets = new ArrayList<>();
		FileReader fr = null;
		BufferedReader br = null;
		
//		FileInputStream fis = null;
//		BufferedInputStream bis = null;
//		ByteArrayOutputStream baos = null;
		try{
			fr = new FileReader(new File(DATA_PATH));
			br = new BufferedReader(fr);
			String line;
			String[] raw;
			Ticket t;
			while((line = br.readLine()) != null){
				raw = line.split("\\s+");
				if(raw != null && raw.length >= 8){
					t = new Ticket(raw[0], Integer.parseInt(raw[1]), Integer.parseInt(raw[2]),
							Integer.parseInt(raw[3]), Integer.parseInt(raw[4]), Integer.parseInt(raw[5]),
							Integer.parseInt(raw[6]), Integer.parseInt(raw[7]));
					tickets.add(t);
				}
			}
//			fis = new FileInputStream(new File(DATA_PATH));
//			bis = new BufferedInputStream(fis);
			
//			baos = new ByteArrayOutputStream();
//			byte[] buffer = new byte[1024 * 1024];
//			int read;
//			while((read = bis.read(buffer, 0, buffer.length)) != -1){
//				baos.write(buffer, 0, read);
//			}
//			baos.flush();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally {
//			if(bis != null){
//				try {
//					bis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if(baos != null){
//				try {
//					baos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return tickets;
	}
}
