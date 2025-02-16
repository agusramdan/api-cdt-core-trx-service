package agus.ramdan.cdt.core.trx.service;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.mapper.QueryMapper;
import agus.ramdan.cdt.core.trx.persistence.repository.TrxDepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrxDepositQueryService {
    private final TrxDepositRepository repository;
    private final QueryMapper queryMapper;

    public List<TrxDepositResponseDTO> getAllTrxDeposits() {
        return queryMapper.toDtoList(repository.findAll());
    }

    public TrxDepositResponseDTO getTrxDepositById(UUID id) {
        return repository.findById(id)
                .map(queryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}

