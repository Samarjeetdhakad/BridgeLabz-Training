package com.multithreading.threadstatemonitoring;
import java.time.LocalTime;
import java.util.*;

public class StateMonitor extends Thread {
    private Thread[] threads;
    private Map<String,Set<Thread.State>> stateHistory=new HashMap<>();
    public StateMonitor(Thread... threads) {
        this.threads=threads;
        setName("Monitor");
    }
    public void run() {
        boolean allTerminated = false;
        while (!allTerminated) {
            allTerminated=true;

            for (Thread t:threads) {
                Thread.State state=t.getState();
                String name=t.getName();
                stateHistory .computeIfAbsent(name, k -> new HashSet<>()).add(state);

                System.out.println("[Monitor] " + name + " is in " + state +" state at " + LocalTime.now());

                if (state!=Thread.State.TERMINATED) {
                    allTerminated=false;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
        }
        stateHistory.forEach((name, states) ->System.out.println("Summary: " + name + states.size() + states));
    }
}