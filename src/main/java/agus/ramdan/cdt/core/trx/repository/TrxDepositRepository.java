package agus.ramdan.cdt.core.trx.repository;

import agus.ramdan.cdt.core.trx.domain.TrxDeposit;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;
import java.util.UUID;

public interface TrxDepositRepository extends JpaRepositoryImplementation<TrxDeposit, UUID> {
    Optional<TrxDeposit> findByTokenAndSignature(String token, String signature);
}