/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.entity.monitor;

/**
 * 统计类
 * @author Bryan.Zhang
 */
public class CompStatistics implements Comparable<CompStatistics>{

	private String componentClazzName;

	private long timeSpent;

	private long memorySpent;

	private long recordTime;
	
	public CompStatistics(String componentClazzName, long timeSpent) {
		this.componentClazzName = componentClazzName;
		this.timeSpent = timeSpent;
		this.recordTime = System.currentTimeMillis();
	}
	public String getComponentClazzName() {
		return componentClazzName;
	}

	public void setComponentClazzName(String componentClazzName) {
		this.componentClazzName = componentClazzName;
	}

	public long getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(long timeSpent) {
		this.timeSpent = timeSpent;
	}

	public long getMemorySpent() {
		return memorySpent;
	}

	public void setMemorySpent(long memorySpent) {
		this.memorySpent = memorySpent;
	}
	
	public long getRecordTime() {
		return recordTime;
	}
	
	@Override
	public int compareTo(CompStatistics o) {
		if(o != null) {
			return this.recordTime >= o.getRecordTime()  ? -1 : 1;
		}
		return 1;
	}
}
