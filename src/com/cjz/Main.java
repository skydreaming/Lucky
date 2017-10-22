package com.cjz;

import java.util.List;

import com.cjz.data.Ticket;
import com.cjz.data.provider.DataProvider;

public class Main {

	public static void main(String[] args) {
		List<Ticket> all = DataProvider.getInstance().getAll();
		System.out.println(all.size());
	}

}
