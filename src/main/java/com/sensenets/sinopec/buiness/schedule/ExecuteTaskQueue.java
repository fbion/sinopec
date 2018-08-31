package com.sensenets.sinopec.buiness.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import com.sensenets.sinopec.buiness.dto.CollectTaskDto;


/**
  * @ClassName: CollectTaskQueue
  * @Description: 采集任务队列
  * @author think
  * @date 2018年8月30日 下午2:30:00
  *
  */
public class ExecuteTaskQueue {
	
	private static BlockingQueue<CollectTaskDto> DATA_QUEUE = new LinkedBlockingDeque<CollectTaskDto>();
	
	/**
	 * 一次最多取多少条
	 */
	private static final int MAX_NUM = 100;
	
	private static final Object LOCK = new Object();
	
	public static void add(CollectTaskDto data) {
		if (data == null) {
			return;
		}
		
		synchronized (LOCK) {
			DATA_QUEUE.offer(data);
		}
	}
	
	public static CollectTaskDto take() {
		try {
			return DATA_QUEUE.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<CollectTaskDto> takeList() {
		List<CollectTaskDto> datas = new ArrayList<>();
		synchronized (LOCK) {
			while (DATA_QUEUE.size() > 0) {
				try {
					datas.add(DATA_QUEUE.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (datas.size() == MAX_NUM) {
					break;
				}
			}
		}
		
		return datas;
	}
}
