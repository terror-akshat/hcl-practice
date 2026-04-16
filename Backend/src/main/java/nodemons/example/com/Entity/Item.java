package nodemons.example.com.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    private int item_id;
    private String item_name;
    private String item_description;
    private String location;
    private LocalDateTime event_date;
    private String item_status;
    

    
}
