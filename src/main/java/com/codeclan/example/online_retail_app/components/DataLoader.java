package com.codeclan.example.online_retail_app.components;

import com.codeclan.example.online_retail_app.models.Item;
import com.codeclan.example.online_retail_app.models.User;
import com.codeclan.example.online_retail_app.repositories.ItemRepository;
import com.codeclan.example.online_retail_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        User user1 = new User("John");
        userRepository.save(user1);

        User user2 = new User("Louise");
        userRepository.save(user2);

        Item item1 = new Item("Pedigree Chum" , "pet food");
        itemRepository.save(item1);

        Item item2 = new Item("Pedigree", "pet treats");
        itemRepository.save(item2);

        Item item3 = new Item("Tetley", "tea");
        itemRepository.save(item3);

        Item item4 = new Item("Nivea", "deodorant");
        itemRepository.save(item4);

        user1.addItem(item1);
        item1.addUser(user1);
        user1.addItem(item2);
        item2.addUser(user1);
        user1.addItem(item3);
        item3.addUser(user1);
        userRepository.save(user1);

        user2.addItem(item3);
        item3.addUser(user2);
        user2.addItem(item4);
        item4.addUser(user2);
        user2.addItem(item2);
        item2.addUser(user2);
        userRepository.save(user2);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);



    }

}
