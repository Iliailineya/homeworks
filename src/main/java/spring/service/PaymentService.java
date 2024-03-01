package spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.exception.PaymentNotFoundException;
import spring.model.Payment;
import spring.repository.PaymentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    public Payment createPayment(Payment payment) {
        return repository.save(payment);
    }

    public Payment getPaymentById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with id " + id + " not found"));
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public Payment updatePayment(long id, Payment payment) {
        getPaymentById(id);
        payment.setId(id);
        return repository.save(payment);
    }

    public void deletePaymentById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new PaymentNotFoundException("Payment with id " + id + " not found");
        }
    }
}

