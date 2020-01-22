package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Logger {

    public static final String LOG_FILE_DIR = "~/logs/";
    private ArrayList<Buffer> logStreams = new ArrayList<>();

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd_yyyy");
    public static LocalDate now = LocalDate.now();


    class Buffer{
        public static final int BUFFER_SIZE = 1024;
        Object[] buf = new Object[BUFFER_SIZE];
        String name;
        String filename;
        int size = 0;

        public Buffer(String name){
            this.name = name;
            filename = "log"+"_"+name+"_"+dtf.format(now);
        }

        public boolean add(Object obj){
            buf[size] = obj;
            size++;
            if(size>=BUFFER_SIZE){
                return true;
            }else{
                return false;
            }
        }
    }
    
    
    public void createLogStream(String name){
        logStreams.add(new Buffer(name));
    }

    private Buffer findBuffer(String name){
        for(Buffer i:logStreams){
            if(i.name.equals(name)){
                return i;
            }
        }
        return null;
    }

    public void logDouble(String name, Object[] obj){
        findBuffer(name).add(obj);
        if(findBuffer(name).add(obj)==true){
            flushBuffer(findBuffer(name));
        }
    }

    public void logEvent(String name, Object[] obj){
        findBuffer(name).add(obj);
        if(findBuffer(name).add(obj)==true){
            flushBuffer(findBuffer(name));
        }
    }

    public void flushBuffer(Buffer buf){
        
        
    }

    public static void main(String... args) {
        System.out.println();
    }
}