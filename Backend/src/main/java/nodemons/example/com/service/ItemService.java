package nodemons.example.com.service;

import nodemons.example.com.Entity.Item;

import java.util.List;

public interface ItemService {

    Item lostItem(Item item);

    Item foundItem(Item item);

    List<Item> getAllItem();

    Item claimItem(int id);
}