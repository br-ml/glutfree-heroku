package eu.glutfree.glutfree.repository;

import eu.glutfree.glutfree.model.entities.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository  extends JpaRepository<FeedbackEntity, Long> {
}
