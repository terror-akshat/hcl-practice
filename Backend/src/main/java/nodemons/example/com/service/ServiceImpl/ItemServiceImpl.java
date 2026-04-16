package nodemons.example.com.service.ServiceImpl;

import lombok.RequiredArgsConstructor;
import nodemons.example.com.Entity.Item;
import nodemons.example.com.repo.ItemRepo;
import nodemons.example.com.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    @Override
    public Item lostItem(Item item) {
        item.setItem_status("LOST");
        return itemRepo.save(item);
    }

    @Override
    public Item foundItem(Item item) {
        item.setItem_status("FOUND");
        return itemRepo.save(item);
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepo.findAll();
    }

    @Override
    public Item claimItem(int id) {
        Item item = itemRepo.findById(id).orElseThrow();

        item.setItem_status("CLAIMED");

        itemRepo.save(item);
        return item;
    }
}
