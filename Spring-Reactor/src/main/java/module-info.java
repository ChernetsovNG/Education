module ru.nchernetsov.spring.reactor {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;
    requires reactor.core;

    opens ru.nchernetsov.springreactor to spring.core;

    exports ru.nchernetsov.springreactor;
    exports ru.nchernetsov.springreactor.controller;
}
