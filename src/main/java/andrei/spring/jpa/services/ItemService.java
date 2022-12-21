package andrei.spring.jpa.services;

import andrei.spring.jpa.models.Item;
import andrei.spring.jpa.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional (readOnly = true)
public class ItemService {
    private ItemRepository itemRepository;
@Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public List<Item> index(){
    return itemRepository.findAll();
    }
    public Item show(int id){
    return itemRepository.findById(id).orElse(null);
    }
    @Transactional
    public void save(Item item){
    itemRepository.save(item);
    }

}
