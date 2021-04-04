package eu.glutfree.glutfree.service;

import eu.glutfree.glutfree.model.service.ReceiptAddServiceModel;
import eu.glutfree.glutfree.model.view.FeedbackViewModel;
import eu.glutfree.glutfree.model.view.ReceiptViewModel;

import java.io.IOException;
import java.util.List;

public interface ReceiptService {

    void addReceipt (ReceiptAddServiceModel receiptAddServiceModel) throws IOException;

    List<ReceiptViewModel> findAllReceipts();

    void delete(Long id);

}

//    List<StudentViewModel> findAll();
