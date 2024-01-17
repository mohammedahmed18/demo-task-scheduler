package com.example.TaskScheduled.Automation;

import org.springframework.stereotype.Component;


public class ExecuteWorkflowRunner implements Runnable {
    private String actionId;
    public ExecuteWorkflowRunner(String actionId) {
        this.actionId = actionId;
    }
    @Override
    public void run() {
        System.out.println("==================");
        System.out.println("executing action " + this.actionId);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("execution is interrupted.");
        }
        System.out.println("done executing action ");
        System.out.println("==================");
    }
}
