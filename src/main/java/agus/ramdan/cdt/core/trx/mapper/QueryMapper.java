package agus.ramdan.cdt.core.trx.mapper;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.persistence.domain.TrxDeposit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QueryMapper {
    TrxDepositResponseDTO toDto(TrxDeposit entity);
    List<TrxDepositResponseDTO> toDtoList(List<TrxDeposit> entities);
}
