package eu.glutfree.glutfree.service.impl;

import eu.glutfree.glutfree.model.entities.ReceiptEntity;
import eu.glutfree.glutfree.model.service.ReceiptAddServiceModel;
import eu.glutfree.glutfree.repository.ReceiptRepository;
import eu.glutfree.glutfree.service.CloudinaryService;
import eu.glutfree.glutfree.service.ReceiptService;
import eu.glutfree.glutfree.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ModelMapper modelMapper;
    private final ReceiptRepository receiptRepository;
    private final UserService userService;
    private final CloudinaryService cloudinaryService;


    public ReceiptServiceImpl(ModelMapper modelMapper, ReceiptRepository receiptRepository, UserService userService, CloudinaryService cloudinaryService) {
        this.modelMapper = modelMapper;
        this.receiptRepository = receiptRepository;

        this.userService = userService;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public void addReceipt(ReceiptAddServiceModel receiptAddServiceModel) throws IOException {

        MultipartFile img = receiptAddServiceModel.getImage();
        String imageUrl = cloudinaryService.uploadImage(img);


        ReceiptEntity receipt = modelMapper.map(receiptAddServiceModel, ReceiptEntity.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        receipt.setUser(userService.findUserByUsername(authentication.getName()));
        receipt.setUrlToPic(imageUrl);
        receiptRepository.save(receipt);





    }


//    @Override
//    public List<RecepitViewModel> findAll() {
//        return receiptRepository.
//                findAll().
//                stream().
//                map(se -> modelMapper.map(se, ReceiptViewModel.class)).
//                collect(Collectors.toList());
//    }




}
