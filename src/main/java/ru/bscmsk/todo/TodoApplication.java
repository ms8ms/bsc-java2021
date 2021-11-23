package ru.bscmsk.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bscmsk.todo.task.ToDo;

@SpringBootApplication
@Slf4j
public class TodoApplication
        implements CommandLineRunner {
    @Autowired
    private ToDo todo;

    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(TodoApplication.class, args);
        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        todo.exec();
    }
}
