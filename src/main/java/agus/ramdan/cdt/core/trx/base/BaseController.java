package agus.ramdan.cdt.core.trx.base;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface BaseController<T, ID> {
    JpaRepositoryImplementation<T, ID> getRepository();
}
