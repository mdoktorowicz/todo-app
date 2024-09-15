package com.todoapp.springboottodoapplication.config;


import com.todoapp.springboottodoapplication.models.TodoItem;
import com.todoapp.springboottodoapplication.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("Get the milk");
            TodoItem todoItem2 = new TodoItem("Rake the leaves");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }

        logger.info("Number of todoitems: " + todoItemRepository.count());
    }

}
