package eu.glutfree.glutfree.web;

import eu.glutfree.glutfree.model.entities.FoodEntity;
import eu.glutfree.glutfree.repository.FoodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/food")
@RestController
public class FoodRestController {

  private final FoodRepository foodRepository;
  private final ModelMapper modelMapper;

  public FoodRestController(FoodRepository foodRepository, ModelMapper modelMapper) {
    this.foodRepository = foodRepository;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/api")
  public ResponseEntity<List<FoodEntity>> findAll() {
    return ResponseEntity
            .ok()
            .body(foodRepository.findAll());
  }

  @GetMapping("/api-tested")
  public ResponseEntity<List<FoodEntity>> findAllTested() {
    return ResponseEntity
            .ok()
            .body(foodRepository.findAllByNimaTestedIsTrue());
  }
}