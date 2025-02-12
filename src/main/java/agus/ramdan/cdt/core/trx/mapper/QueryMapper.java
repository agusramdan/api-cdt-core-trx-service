package agus.ramdan.cdt.core.trx.mapper;

import agus.ramdan.cdt.core.trx.domain.TrxDeposit;
import agus.ramdan.cdt.core.trx.dto.query.TrxDepositQueryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QueryMapper {
    TrxDepositQueryDTO toDto(TrxDeposit entity);
    List<TrxDepositQueryDTO> toDtoList(List<TrxDeposit> entities);
}
