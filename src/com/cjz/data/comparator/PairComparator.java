package com.cjz.data.comparator;

import java.util.Comparator;

import com.cjz.data.Pair;

public class PairComparator<F, S> implements Comparator<Pair<F, S>> {
	
	private Comparator<F> compFirst;
	private Comparator<S> compSecond;
	
	

	@Override
	public int compare(Pair<F, S> o1, Pair<F, S> o2) {
		return 0;
	}

	public static class CompareStrategy<F, S> {
		private Comparator<F> compFirst;
		private Comparator<S> compSecond;
		private boolean firstFirst;
		
		public CompareStrategy compareFirst(Comparator<F> firstComparator){
			compFirst = firstComparator;
//			if()
			return this;
		}
	}
}
