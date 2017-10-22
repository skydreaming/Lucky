package com.cjz.data;

import java.util.Iterator;

public class Ticket implements Iterable<Integer>{
	public String no;
	
	public int r0, r1, r2, r3, r4, r5;
	public int b;
	private int[] reds = new int[6];
	
	
	
	
	public Ticket() {
	}

	public Ticket(String no, int r0, int r1, int r2, int r3, int r4, int r5, int b) {
		super();
		this.no = no;
		this.r0 = r0;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.r5 = r5;
		this.b = b;
		reds[0] = r0;
		reds[1] = r1;
		reds[2] = r2;
		reds[3] = r3;
		reds[4] = r4;
		reds[5] = r5;
	}

	public void set(String no, int r0, int r1, int r2, int r3, int r4, int r5, int b){
		this.no = no;
		this.r0 = r0;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.r5 = r5;
		this.b = b;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		if(no == null){
			return false;
		}
		Ticket other = (Ticket) obj;
		if(other != null){
			return no.equals(other.no);
		}
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < 6;
			}

			@Override
			public Integer next() {
				return reds[index++];
			}
		};
//		return null;
	}
	
	
	
}
