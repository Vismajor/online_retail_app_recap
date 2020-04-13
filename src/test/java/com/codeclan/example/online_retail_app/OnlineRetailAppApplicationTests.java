package com.codeclan.example.online_retail_app;

import com.codeclan.example.online_retail_app.models.Item;
import com.codeclan.example.online_retail_app.models.User;
import com.codeclan.example.online_retail_app.repositories.ItemRepository;
import com.codeclan.example.online_retail_app.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;


//@RunWith(SpringRunner.class)
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
	public void canFindItemsForUser(){
		User user = userRepository.findByName("John");
		List<Item> boughtItems = itemRepository.findByUsersId(user.getId());
		assertEquals(3, boughtItems.size());
	}

//	@Test
//	public void canFindUsersForItem(){
//		Item item = itemRepository.findByName("John");
//		List<Item> boughtItems = itemRepository.findByUsersId(user.getId());
//		assertEquals(3, boughtItems.size());
//	}

}
