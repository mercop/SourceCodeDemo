package com.marving.code.java.concurrent.ThreadPool;

/**
 * Created by mercop on 2017/8/3.
 */

public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();
    void addWorkers(int n);

    void removeWorkers(int num) throws Exception;

    int getJobSize();
}
