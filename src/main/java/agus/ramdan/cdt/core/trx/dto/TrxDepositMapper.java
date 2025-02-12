package agus.ramdan.cdt.core.trx.dto;

import agus.ramdan.cdt.core.trx.domain.TrxDeposit;
import agus.ramdan.cdt.core.trx.domain.TrxDepositDenomination;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TrxDepositMapper {

    TrxDepositDenomination trxDepositMachineDenominationDtoToTrxDepositMachineDenomination(TrxDepositDenominationDto trxDepositMachineDenominationDto);

    TrxDepositDenominationDto trxDepositMachineDenominationToTrxDepositMachineDenominationDto(TrxDepositDenomination trxDepositMachineDenomination);

    TrxDepositDenomination trxDepositMachineDenominationRequestToTrxDepositMachineDenomination(TrxDepositDenominationRequest trxDepositMachineDenominationRequest);

    TrxDepositDenominationRequest toTrxDeposit(TrxDepositDenomination trxDepositMachineDenomination);

    TrxDeposit toTrxDeposit(TrxDepositRequest trxDepositMachineRequest);

    TrxDepositResponse toTrxDepositResponse(TrxDeposit trxDeposit);
}
