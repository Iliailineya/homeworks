package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.AppConfigTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spring.controller.PaymentController;
import spring.exception.EntityExceptionHandler;
import spring.exception.PaymentNotFoundException;
import spring.model.Account;
import spring.model.Payment;
import spring.service.PaymentService;

import java.math.BigDecimal;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {AppConfigTest.class})
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class PaymentControllerTest {

    MockMvc mockMvc;

    @Autowired
    PaymentService paymentService;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PaymentController(paymentService))
                .setControllerAdvice(new EntityExceptionHandler()).build();
    }

    @Test
    void findNotExistingPayment() throws Exception {
        mockMvc.perform(get("/api/payment/999"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof PaymentNotFoundException))
                .andExpect(result -> assertEquals("Payment not found", Objects.requireNonNull(result.getResolvedException()).getMessage()))
                .andReturn();
    }

    @Test
    void findExistingPayment() throws Exception {
        Account account = new Account();
        Payment payment = Payment.builder()
                .amount(BigDecimal.valueOf(100))
                .account(account)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(payment);

        mockMvc.perform(post("/api/payment")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        mockMvc.perform(get("/api/payment/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void savePayment() throws Exception {
        Account account = new Account();
        Payment payment = Payment.builder()
                .amount(BigDecimal.valueOf(200))
                .account(account)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(payment);

        mockMvc.perform(post("/api/payment")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }
}
