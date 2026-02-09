package com.multithreading.printshop;
class PrintJob implements Runnable {
    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName=jobName;
        this.pages=pages;
        this.priority=priority;
    }
    public void run() {
        long startTime=System.currentTimeMillis();

        String level;
        if (priority>=7) {
            level="[High Priority]";
        }
        else if (priority>=5) {
            level="[Medium Priority]";
        }
        else {
            level="[Low Priority]";
        }
        for (int i=1;i<=pages; i++) {
            System.out.println(level + " Printing " + jobName +" - Page " + i + " of " + pages);
            try {
                Thread.sleep(100); 
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
           }
        }
        long endTime=System.currentTimeMillis();
        System.out.println(jobName + " completed in "+(endTime-startTime));
    }
}