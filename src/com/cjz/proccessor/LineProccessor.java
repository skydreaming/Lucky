package com.cjz.proccessor;

import java.util.List;

import com.cjz.data.Ticket;

public class LineProccessor {
	private List<Ticket> tickets;
	private ProccessCore processCore;

	public LineProccessor(List<Ticket> tickets) {
		super();
		this.tickets = tickets;
	}
	
	public LineProccessor setProcessCore(ProccessCore core){
		processCore = core;
		return this;
	}
	
	public void process(){
		if(processCore != null && tickets != null && !tickets.isEmpty()){
			for(Ticket t : tickets){
				processCore.onProcess(t);
			}
		}
	}
	
	public interface ProccessCore {
		void onProcess(Ticket ticket);
	}
}
