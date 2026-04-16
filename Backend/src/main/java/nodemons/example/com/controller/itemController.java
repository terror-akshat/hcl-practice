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
    public ResponseEntity<Item> addLostItem(@RequestBody Item item) {
        Item items = itemService.lostItem(item);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @PostMapping("/found-item")
    public ResponseEntity<Item> foundItem(@RequestBody Item item) {
        Item items = itemService.foundItem(item);
        return ResponseEntity.status(HttpStatus.FOUND).body(items);
    }

    @GetMapping
    public ResponseEntity<List<Item> getAllItems(@RequestBody Item item) {
        List<Item> items = itemService.getAllItem();
        return ResponseEntity.status(HttpStatus.FOUND).body(Collections.singletonList((Item) items));
    }

    @GetMapping("/claim-item")
    public ResponseEntity<Item> claim(@RequestBody int id) {
        Item item = itemService.claimItem(id);
        return ResponseEntity.status(HttpStatus.FOUND).body((Item) item);
    }
}