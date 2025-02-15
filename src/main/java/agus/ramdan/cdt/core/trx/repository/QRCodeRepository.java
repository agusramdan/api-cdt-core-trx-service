package agus.ramdan.cdt.core.trx.repository;

import agus.ramdan.cdt.core.trx.domain.QRCode;
import brave.internal.collect.UnsafeArrayMap;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QRCodeRepository extends JpaRepositoryImplementation<QRCode, UUID> {
    Optional<QRCode> findByCode(String code);

}
