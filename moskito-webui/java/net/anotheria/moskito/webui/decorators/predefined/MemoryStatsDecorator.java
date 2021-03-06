package net.anotheria.moskito.webui.decorators.predefined;

import net.anotheria.moskito.core.predefined.MemoryStats;
import net.anotheria.moskito.core.producers.IStats;
import net.anotheria.moskito.core.stats.TimeUnit;
import net.anotheria.moskito.webui.shared.bean.LongValueBean;
import net.anotheria.moskito.webui.shared.bean.StatValueBean;
import net.anotheria.moskito.webui.decorators.AbstractDecorator;

import java.util.ArrayList;
import java.util.List;

public class MemoryStatsDecorator extends AbstractDecorator {
	
	/**
	 * Megabyte.
	 */
	private static final long MB = 1024L*1024;
	
	/**
	 * Captions for the values.
	 */
	private static final String CAPTIONS[] = {
		"Current",
		"Min",
		"Max",
		"Current Mb",
		"Min Mb",
		"Max Mb",
	};
	
	/**
	 * Short explanations.
	 */
	private static final String SHORT_EXPLANATIONS[] = {
		"Current amount of memory",
		"Minimum amount of memory",
		"Maximum amount of memory",
		"Current amount of memory in Mb",
		"Minimum amount of memory in Mb",
		"Maximum amount of memory in Mb",
	};

	/**
	 * Explanations.
	 */
	private static final String EXPLANATIONS[] = {
		"Current amount of memory",
		"Minimum amount of memory",
		"Maximum amount of memory",
		"Current amount of memory in Mb",
		"Minimum amount of memory in Mb",
		"Maximum amount of memory in Mb",
	};

	/**
	 * Creates a new memory stats decorator.
	 */
	public MemoryStatsDecorator(){
		super("Memory", CAPTIONS, SHORT_EXPLANATIONS, EXPLANATIONS);
	}
	

	@Override public List<StatValueBean> getValues(IStats statsObject, String interval, TimeUnit unit) {
		MemoryStats stats = (MemoryStats)statsObject;
		List<StatValueBean> ret = new ArrayList<StatValueBean>(CAPTIONS.length);
		int i = 0;
		ret.add(new LongValueBean(CAPTIONS[i++], stats.getCurrent(interval)));
		ret.add(new LongValueBean(CAPTIONS[i++], stats.getMin(interval)));
		ret.add(new LongValueBean(CAPTIONS[i++], stats.getMax(interval)));
		ret.add(new LongValueBean(CAPTIONS[i++], stats.getCurrent(interval)/MB));
		ret.add(new LongValueBean(CAPTIONS[i++], stats.getMin(interval)/MB));
		ret.add(new LongValueBean(CAPTIONS[i++], stats.getMax(interval)/MB));
		return ret;
	}
}