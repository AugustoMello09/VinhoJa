package io.gitHub.AugustoMello09.payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gitHub.AugustoMello09.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
