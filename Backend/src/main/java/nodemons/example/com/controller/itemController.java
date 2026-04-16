package nodemons.example.com.controller;


import lombok.RequiredArgsConstructor;
import nodemons.example.com.Entity.Item;
import nodemons.example.com.service.ServiceImpl.ItemServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class itemController {

    private final ItemServiceImpl itemService;

    @PostMapping
    public Item lostItem(@RequestBody Item item) {
        return itemService.lostItem(item);
    }

    @PostMapping("/found-item")
    public Item foundItem(@RequestBody Item item) {
        return itemService.foundItem(item);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItem();
    }

    @GetMapping("/claim-item")
    public ResponseEntity<Item> claim(@RequestBody int id) {
        Item item = itemService.claimItem(id);
        return ResponseEntity.status(HttpStatus.FOUND).body((Item) item);
    }
}