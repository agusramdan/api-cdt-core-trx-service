package agus.ramdan.cdt.core.trx.service;

import agus.ramdan.cdt.core.trx.dto.query.TrxDepositQueryDTO;
import agus.ramdan.cdt.core.trx.mapper.QueryMapper;
import agus.ramdan.cdt.core.trx.repository.TrxDepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrxDepositQueryService {
    private final TrxDepositRepository repository;
    private final QueryMapper queryMapper;

    public List<TrxDepositQueryDTO> getAllTrxDeposits() {
        return queryMapper.toDtoList(repository.findAll());
    }

    public TrxDepositQueryDTO getTrxDepositById(UUID id) {
        return repository.findById(id)
                .map(queryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}

