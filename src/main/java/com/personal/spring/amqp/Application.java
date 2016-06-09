package com.personal.spring.amqp;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by minhpham on 6/9/16.
 */
public class Application {

    public static void main(String[] args) {
        // configure log4j
        BasicConfigurator.configure();

        if (args == null || args.length == 0) {
            print("App Name Parameter required. It should be 'publisher' or 'subscriber'.");
            terminate(1);
        }

        final String appName = args[0];
        if (appName == null) {
            print("App Name can not null");
            terminate(1);
        }

        switch (appName) {
            case "publisher":
                runPublisher();
                break;
            case "subscriber":
                runSubscriber();
                break;
            default:
                print("App Name '" + appName + "' is invalid. It should be 'publisher' or 'subscriber'.");
                terminate(1);
                break;
        }
    }

    public static void runPublisher() {
        new ClassPathXmlApplicationContext("classpath:amqp-output.xml");
    }

    public static void runSubscriber() {
        new ClassPathXmlApplicationContext("classpath:amqp-input.xml");
    }

    private static void print(final String message) {
        System.out.println(message);
    }

    private static void terminate(final int status) {
        System.exit(status);
    }
}
