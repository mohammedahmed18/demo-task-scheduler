package com.example.TaskScheduled;


import com.example.TaskScheduled.Automation.ExecuteWorkflowRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class Main {

    @Autowired
    private TaskScheduler taskScheduler;

    @EventListener(ApplicationReadyEvent.class)
    public void onStart(){

        ExecuteWorkflowRunner workflowRunner = new ExecuteWorkflowRunner("123456");
        var job = taskScheduler.schedule(workflowRunner, new CronTrigger("*/2 * * * * *"));

       Mono<String> cancelJobAsync = Mono.fromCallable(() -> {
            Thread.sleep(10000);
            assert job != null;
            job.cancel(false); // false means don't interrupt the task if it's running, and wait for it to finish
            return "execute action task is terminated successfully 10 seconds passed";
        });
       cancelJobAsync.subscribe(System.out::println);
    }
}
