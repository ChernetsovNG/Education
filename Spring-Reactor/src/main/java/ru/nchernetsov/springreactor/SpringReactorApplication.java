package ru.nchernetsov.springreactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@SpringBootApplication
public class SpringReactorApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringReactorApplication.class, args);
        SpringReactorApplication application = context.getBean(SpringReactorApplication.class);
        application.reactorTest();
    }

    private void reactorTest() throws InterruptedException {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 2)
                .map(i -> 10 + i)
                .publishOn(s)
                .map(i -> "value " + i);

        new Thread(() -> flux.subscribe(System.out::println));
    }
}
