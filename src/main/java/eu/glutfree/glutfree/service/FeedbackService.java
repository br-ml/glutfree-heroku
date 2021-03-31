package eu.glutfree.glutfree.service;

import eu.glutfree.glutfree.model.service.FeedbackAddServiceModel;
import eu.glutfree.glutfree.model.service.FoodAddServiceModel;
import eu.glutfree.glutfree.model.view.FeedbackViewModel;

import java.util.List;

public interface FeedbackService {

    void addFeedback (FeedbackAddServiceModel feedbackAddServiceModel);

    List<FeedbackViewModel> findAllFeedbacks();

    void delete(Long id);

}
