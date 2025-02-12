package agus.ramdan.cdt.core.trx.resolver;

import agus.ramdan.cdt.core.trx.service.TrxDepositCommandService;
import agus.ramdan.cdt.core.trx.dto.command.CreateTrxDepositCommandDTO;
import agus.ramdan.cdt.core.trx.dto.command.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.dto.command.UpdateTrxDepositCommandDTO;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrxDepositMutationResolver  implements GraphQLQueryResolver {
    private final TrxDepositCommandService service;
    @MutationMapping
    public TrxDepositResponseDTO createTrxDeposit(CreateTrxDepositCommandDTO input) {
        return service.createTrxDeposit(input);
    }

    @MutationMapping
    public TrxDepositResponseDTO updateTrxDeposit(UpdateTrxDepositCommandDTO input) {
        return service.updateTrxDeposit(input);
    }
}
