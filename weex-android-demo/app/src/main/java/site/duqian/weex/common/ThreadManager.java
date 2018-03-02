package site.duqian.weex.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * ThreadManager:简易的线程池管理类
 *
 * @author Dusan-杜乾 Created on 2017/6/13 - 13:46.
 *         E-mail:duqian2010@gmail.com
 */
public class ThreadManager {
    public static final String DEFAULT_SINGLE_POOL_NAME = "DEFAULT_SINGLE_POOL_NAME";

    private static ThreadPoolProxy mBackgroundPool = null;
    private static final Object mBackgroundLock = new Object();

    private static ThreadPoolProxy mDownloadPool = null;
    private static final Object mDownloadLock = new Object();

    private static Map<String, ThreadPoolProxy> mMap = new HashMap<String, ThreadPoolProxy>();
    private static final Object mSingleLock = new Object();


    /**
     * 获取后台线程
     */
    public static ThreadPoolProxy getBackgroundPool() {
        synchronized (mBackgroundLock) {
            if (mBackgroundPool == null) {
                mBackgroundPool = new ThreadPoolProxy(2, 5, 5L);
            }
            return mBackgroundPool;
        }
    }

    /**
     * 获取一个用于执行长耗时任务的线程池，
     * 避免和短耗时任务处在同一个队列而阻塞了重要的短耗时任务
     */
    public static ThreadPoolProxy getDownloadPool() {
        synchronized (mDownloadLock) {
            if (mDownloadPool == null) {
                mDownloadPool = new ThreadPoolProxy(2, 5, 0L);
            }
            return mDownloadPool;
        }
    }

    /**
     * 获取一个单线程池
     */
    public static ThreadPoolProxy getSinglePool() {
        return getSinglePool(DEFAULT_SINGLE_POOL_NAME);
    }

    /**
     * 获取一个单线程池，所有任务将会被按照加入的顺序执行，免除了同步开销的问题
     */
    public static ThreadPoolProxy getSinglePool(String name) {
        synchronized (mSingleLock) {
            ThreadPoolProxy singlePool = mMap.get(name);
            if (singlePool == null) {
                singlePool = new ThreadPoolProxy(1, 1, 5L);
                mMap.put(name, singlePool);
            }
            return singlePool;
        }
    }

    public static class ThreadPoolProxy {
        private ThreadPoolExecutor mPool;
        private int mCorePoolSize;
        private int mMaximumPoolSize;
        private long mKeepAliveTime;

        private ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
            mCorePoolSize = corePoolSize;
            mMaximumPoolSize = maximumPoolSize;
            mKeepAliveTime = keepAliveTime;
        }

        /**
         * 执行任务，当线程池处于关闭，将会重新创建新的线程池
         */
        public synchronized void execute(Runnable run) {
            if (run == null) {
                return;
            }
            if (mPool == null || mPool.isShutdown()) {
                //ThreadFactory是每次创建新的线程工厂
                mPool = new ThreadPoolExecutor(mCorePoolSize, mMaximumPoolSize, mKeepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new AbortPolicy());
            }
            mPool.execute(run);
        }

        /**
         * 取消线程池中某个还未执行的任务
         */
        public synchronized void remove(Runnable run) {
            if (mPool != null && (!mPool.isShutdown() || mPool.isTerminating())) {
                mPool.getQueue().remove(run);
            }
        }

        /**
         * 是否包含某个任务
         */
        public synchronized boolean contains(Runnable run) {
            if (mPool != null && (!mPool.isShutdown() || mPool.isTerminating())) {
                return mPool.getQueue().contains(run);
            } else {
                return false;
            }
        }

        /**
         * 关闭线程池，
         *
         * @param isNow if true 立即终止线程池，并尝试打断正在执行的任务，清空任务缓存队列，返回尚未执行的任务。
         *              if false ,确保所有已经加入的任务都将会被执行完毕才关闭,后面不接受任务
         **/
        public synchronized void shutdown(boolean isNow) {
            if (mPool != null && (!mPool.isShutdown() || mPool.isTerminating())) {
                if (isNow) {
                    mPool.shutdownNow();
                } else {
                    mPool.shutdown();
                }
            }
        }
    }
}
