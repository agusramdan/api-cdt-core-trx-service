package agus.ramdan.cdt.core.trx.mapper;

import agus.ramdan.cdt.core.trx.domain.TrxDeposit;
import agus.ramdan.cdt.core.trx.dto.deposit.TrxDepositResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QueryMapper {
    TrxDepositResponseDTO toDto(TrxDeposit entity);
    List<TrxDepositResponseDTO> toDtoList(List<TrxDeposit> entities);
}
