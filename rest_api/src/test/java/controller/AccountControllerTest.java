//package controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import config.AppConfigTest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import spring.controller.AccountController;
//import spring.exception.AccountNotFoundException;
//import spring.exception.EntityExceptionHandler;
//import spring.model.Account;
//import spring.model.enums.Gender;
//import spring.service.AccountService;
//
//import java.time.LocalDate;
//import java.util.Objects;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@ContextConfiguration(classes = {AppConfigTest.class})
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//class AccountControllerTest {
//
//    MockMvc mockMvc;
//
//    @Autowired
//    AccountService accountService;
//
//    @BeforeEach
//    void setup() {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(accountService))
//                .setControllerAdvice(new EntityExceptionHandler()).build();
//    }
//
//    @Test
//    void findNotExistingAccount() throws Exception {
//        mockMvc.perform(get("/api/account/999"))
//                .andExpect(result -> assertTrue(result.getResolvedException() instanceof AccountNotFoundException))
//                .andExpect(result -> assertEquals("Account not found", Objects.requireNonNull(result.getResolvedException()).getMessage()))
//                .andReturn();
//    }
//
//    @Test
//    void findExistingAccount() throws Exception {
//        Account account = Account.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .country("USA")
//                .birthday(LocalDate.of(1990, 5, 15))
//                .balance(1000.0)
//                .gender(Gender.MALE)
//                .build();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonBody = mapper.writeValueAsString(account);
//
//        mockMvc.perform(post("/api/account")
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        mockMvc.perform(get("/api/account/1"))
//                .andExpect(status().isOk())
//                .andReturn();
//    }
//
//    @Test
//    void saveAccount() throws Exception {
//        Account account = Account.builder()
//                .firstName("Alice")
//                .lastName("Smith")
//                .country("UK")
//                .birthday(LocalDate.of(1985, 9, 20))
//                .balance(2000.0)
//                .gender(Gender.FEMALE)
//                .build();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonBody = mapper.writeValueAsString(account);
//
//        mockMvc.perform(post("/api/account")
//                        .content(jsonBody)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andReturn();
//    }
//}
