package agus.ramdan.cdt.core.trx.mapper;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositDenCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositDenominationResponseDTO;
import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.persistence.domain.TrxDeposit;
import agus.ramdan.cdt.core.trx.persistence.domain.TrxDepositDenomination;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandMapper {
    TrxDeposit toEntity(TrxDepositCreateDTO dto);
    TrxDepositDenomination toEntity(TrxDepositDenCreateDTO dto);

    TrxDepositResponseDTO toResponseDto(TrxDeposit entity);
    TrxDepositDenominationResponseDTO toResponseDto(TrxDepositDenomination entity);
}

