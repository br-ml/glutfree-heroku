package eu.glutfree.glutfree.web;

import eu.glutfree.glutfree.model.entities.ReceiptEntity;
import eu.glutfree.glutfree.model.entities.StoreEntity;
import eu.glutfree.glutfree.model.entities.UserEntity;
import eu.glutfree.glutfree.model.entities.enums.TypeOfMealsEnums;
import eu.glutfree.glutfree.repository.ReceiptRepository;
import eu.glutfree.glutfree.repository.StoreRepository;
import eu.glutfree.glutfree.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class StoreControllerTest {

    private static final String RECEIPT_CONTROLLER_PREFIX = "/store";


    private long testStoreId;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StoreRepository storeRepository;

    @BeforeEach
    public void setup() {
        this.init();
    }

    public void init() {


        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setLogoUrl("testUrl");
        storeEntity.setStoreWebSiteUrl("websaita");
        storeEntity.setName("lidlaa");


        storeEntity = storeRepository.save(storeEntity);
        testStoreId = storeEntity.getId();



    }

//    @Test
//    void testShouldReturnViewStatusAndModel() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get(
//                RECEIPT_CONTROLLER_PREFIX,   testStoreId
//        )).andExpect(status().isOk()).andExpect(view().name("details")).
//                andExpect(model().attributeExists("receipt"));
//    }




}
