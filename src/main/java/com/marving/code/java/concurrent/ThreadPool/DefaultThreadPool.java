package com.marving.code.java.concurrent.ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mercop on 2017/8/3.
 */

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private static final int MAX_WORKER_NUMS = 10;

    private static final int DEAFAULT_WORKER_NUMS = 5;

    private static final int MIN_WORKER_NUMS = 1;

    private final LinkedBlockingDeque<Worker> wokers = new LinkedBlockingDeque();

    private final LinkedBlockingDeque<Job> jobs = new LinkedBlockingDeque<>();

    private int workerNum = DEAFAULT_WORKER_NUMS;

    private AtomicLong threadNum = new AtomicLong(0);



    public DefaultThreadPool(){
        initializeWorkers(DEAFAULT_WORKER_NUMS);
    }

    private void initializeWorkers(int num){
        for(int i = 0; i < num; i++){
            Worker worker = new Worker();
            wokers.offer(worker);
            new Thread(worker,"Thread-Pool Worker = " + threadNum.incrementAndGet()).start();
        }
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            try {
                jobs.put(job);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker : wokers)
            worker.shutdown();
    }

    @Override
    public synchronized void addWorkers(int n) {
        if(n + this.workerNum > MAX_WORKER_NUMS){
            n = MAX_WORKER_NUMS - this.workerNum;
        }
        initializeWorkers(n);
        this.workerNum += n;
    }

    @Override
    public synchronized void removeWorkers(int num) throws NoSuchMethodException {
       throw new NoSuchMethodException("NOT implement this function");

    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }


    class Worker implements Runnable{
        private volatile boolean running = true;
        @Override
        public void run() {
            while(running){
                Job job = null;
                try {
                    job = jobs.take();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                if(job != null){
                    job.run();
                }
            }
        }

        public void shutdown(){

            running = false;
        }
    }
}


