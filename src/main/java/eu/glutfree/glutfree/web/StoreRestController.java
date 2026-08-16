package eu.glutfree.glutfree.web;

import eu.glutfree.glutfree.model.service.StoreAddServiceModel;
import eu.glutfree.glutfree.model.view.StoreViewModel;
import eu.glutfree.glutfree.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store")
@RestController
public class StoreRestController {

    private final StoreService storeService;

    public StoreRestController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/api")
    public ResponseEntity<List<StoreViewModel>> findAll() {
        return ResponseEntity.ok(storeService.findAllStoreDetails());
    }

    @PutMapping("/api/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> updateStore(@PathVariable Long id, @RequestBody StoreAddServiceModel model) {
        storeService.updateStore(id, model);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> addStore(@RequestBody StoreAddServiceModel model) {
        storeService.addStore(model);
        return ResponseEntity.ok().build();
    }
}
