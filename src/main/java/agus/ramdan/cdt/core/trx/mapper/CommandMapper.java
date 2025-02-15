package agus.ramdan.cdt.core.trx.mapper;

import agus.ramdan.cdt.core.trx.domain.TrxDeposit;
import agus.ramdan.cdt.core.trx.domain.TrxDepositDenomination;
import agus.ramdan.cdt.core.trx.dto.deposit.CreateTrxDepositCommandDTO;
import agus.ramdan.cdt.core.trx.dto.deposit.CreateTrxDepositDenominationDTO;
import agus.ramdan.cdt.core.trx.dto.deposit.TrxDepositDenominationResponseDTO;
import agus.ramdan.cdt.core.trx.dto.deposit.TrxDepositResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandMapper {
    TrxDeposit toEntity(CreateTrxDepositCommandDTO dto);
    TrxDepositDenomination toEntity(CreateTrxDepositDenominationDTO dto);
    TrxDepositResponseDTO toResponseDto(TrxDeposit entity);
    TrxDepositDenominationResponseDTO toResponseDto(TrxDepositDenomination entity);
}

