package agus.ramdan.cdt.core.trx.controller.resolver;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositUpdateDTO;
import agus.ramdan.cdt.core.trx.service.TrxDepositCommandService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrxDepositMutationResolver  implements GraphQLQueryResolver {
    private final TrxDepositCommandService service;
    @MutationMapping
    public TrxDepositResponseDTO createTrxDeposit(TrxDepositCreateDTO input) {
        return service.createTrxDeposit(input);
    }

    @MutationMapping
    public TrxDepositResponseDTO updateTrxDeposit(TrxDepositUpdateDTO input) {
        return service.updateTrxDeposit(input);
    }
}
