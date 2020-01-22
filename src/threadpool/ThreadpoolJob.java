package threadpool;

public class ThreadpoolJob implements Runnable {

    private final Object lock;

    private JobFunc job;
    private Object data_out = null;
    private Object data_in;
    boolean completed = false;

    public ThreadpoolJob(JobFunc job) {
        lock = new Object();
        this.job = job;
    }

    @Override
    public void run() {
        while (true) {
            if (!completed) {
                Object data = job.func(data_in);
                complete_job(data);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Object get_data() {
        synchronized(lock) {
            if (!completed) {
                return null;
            }
            return data_out;
        }
        
    }

    public boolean set_job(JobFunc job, Object data, boolean override) {
        synchronized(lock) {
            if (!override && !completed) {
                return false;
            }
            completed = false;
            data_in = data;
            this.job = job;
            return true;
        }
    }

    private void complete_job(Object data) {
        synchronized(lock) {
            this.data_out = data;
            completed = true;
        }
    }
}

interface JobFunc {
    Object func(Object data);
}