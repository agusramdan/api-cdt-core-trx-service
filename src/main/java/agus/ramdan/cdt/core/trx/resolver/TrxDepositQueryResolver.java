package agus.ramdan.cdt.core.trx.resolver;

import agus.ramdan.cdt.core.trx.dto.query.TrxDepositQueryDTO;
import agus.ramdan.cdt.core.trx.service.TrxDepositQueryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
@RequiredArgsConstructor
public class TrxDepositQueryResolver implements GraphQLQueryResolver {
    private final TrxDepositQueryService service;

    public TrxDepositQueryDTO getTrxDepositById(UUID id) {
        System.out.println("GraphQL Query getTrxDepositById dipanggil dengan ID: " + id);
        return service.getTrxDepositById(id);
    }

    public List<TrxDepositQueryDTO> getAllTrxDeposits() {
        System.out.println("GraphQL Query getAllTrxDeposits dipanggil");
        return service.getAllTrxDeposits();
    }
}
