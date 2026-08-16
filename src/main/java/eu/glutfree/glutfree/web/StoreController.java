package eu.glutfree.glutfree.web;

import eu.glutfree.glutfree.model.bindings.StoreAddBindingModel;
import eu.glutfree.glutfree.model.service.StoreAddServiceModel;
import eu.glutfree.glutfree.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/store")
public class StoreController {

  private final StoreService storeService;
  private final ModelMapper modelMapper;

  public StoreController(StoreService storeService, ModelMapper modelMapper) {
    this.storeService = storeService;
    this.modelMapper = modelMapper;
  }



  @GetMapping("/")
  public String allStores(Model model) {
    model.addAttribute("stores", storeService.findAllStoreDetails());
    return "view-stores";
  }

  @GetMapping("/edit/{id}")
  public String editStore(@PathVariable Long id, Model model) {
    eu.glutfree.glutfree.model.entities.StoreEntity entity = storeService.findStoreById(id);
    if (!model.containsAttribute("storeAddBindingModel")) {
      model.addAttribute("storeAddBindingModel", modelMapper.map(entity, StoreAddBindingModel.class));
    }
    model.addAttribute("storeId", id);
    return "edit-store";
  }

  @PostMapping("/edit/{id}")
  public String editConfirm(@PathVariable Long id,
                            @Valid StoreAddBindingModel storeAddBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("storeAddBindingModel", storeAddBindingModel);
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.storeAddBindingModel", bindingResult);
      return "redirect:/store/edit/" + id;
    }
    storeService.updateStore(id, modelMapper.map(storeAddBindingModel, StoreAddServiceModel.class));
    return "redirect:/store/";
  }

  @GetMapping("/add")
  public String addStore(Model model) {

    if(!model.containsAttribute("storeAddBindingModel")) {
      model.addAttribute("storeAddBindingModel", new StoreAddBindingModel());
    }
    return "add-store";
  }


  @PostMapping("/add")
  public String addConfirm(@Valid StoreAddBindingModel storeAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

    if(bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("storeAddBindingModel", storeAddBindingModel);
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.storeAddBindingModel", bindingResult);

      return "redirect:/store/add";
    }

    storeService.addStore(modelMapper.map(storeAddBindingModel, StoreAddServiceModel.class));

    return "redirect:/";

  }


  @GetMapping("/anystore")
  public String anystore() {
    return "any-store";
  }



}
