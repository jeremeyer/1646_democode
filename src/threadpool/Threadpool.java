package threadpool;

import java.util.ArrayList;

public class Threadpool {
    private ArrayList<Thread> busy_threads;
    private ArrayList<Thread> free_threads;
    private Thread[] threads;
}