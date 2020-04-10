package com.codeclan.example.online_retail_app;

import com.codeclan.example.online_retail_app.models.Item;
import com.codeclan.example.online_retail_app.models.User;
import com.codeclan.example.online_retail_app.repositories.ItemRepository;
import com.codeclan.example.online_retail_app.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineRetailAppApplicationTests {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void canFindUsersWhoBoughtItem(){
//		List<User> users = userRepository.findByItemsId(3L);
//		assertEquals(2, users.size());
//	}

	@Test
	public void canFindItemsBoughtByUser(){
		User user = userRepository.findByName("John");
		List<Item> boughtItems = itemRepository.findByUsersId(user.getId());
		assertEquals(3, boughtItems.size());
	}

}
