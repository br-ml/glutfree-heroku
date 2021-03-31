package eu.glutfree.glutfree.service.impl;

import eu.glutfree.glutfree.model.entities.FeedbackEntity;
import eu.glutfree.glutfree.model.entities.ReceiptEntity;
import eu.glutfree.glutfree.model.service.FeedbackAddServiceModel;
import eu.glutfree.glutfree.model.view.FeedbackViewModel;
import eu.glutfree.glutfree.repository.FeedbackRepository;
import eu.glutfree.glutfree.service.FeedbackService;
import eu.glutfree.glutfree.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final ModelMapper modelMapper;
    private final FeedbackRepository feedbackRepository;
    private final UserService userService;

    public FeedbackServiceImpl(ModelMapper modelMapper, FeedbackRepository feedbackRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.feedbackRepository = feedbackRepository;
        this.userService = userService;
    }


    @Override
    public void addFeedback(FeedbackAddServiceModel feedbackAddServiceModel) {
        FeedbackEntity feedback = modelMapper.map(feedbackAddServiceModel, FeedbackEntity.class);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        feedback.setUser(userService.findUserByUsername(authentication.getName()));
        feedbackRepository.save(feedback);
    }


    @Override
    public List<FeedbackViewModel> findAllFeedbacks() {
        return this.feedbackRepository.findAll().stream().map( feedbackEntity -> {
            FeedbackViewModel feedbackViewModel = this.modelMapper.map( feedbackEntity , FeedbackViewModel.class);
            feedbackViewModel.setLogoPicture(String.format("/img/feedbacks/logo/%s.jpg", feedbackEntity.getName() ));
            return feedbackViewModel;
        }).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        feedbackRepository.deleteById(id);

    }
}
