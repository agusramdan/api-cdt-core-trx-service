package agus.ramdan.cdt.core.trx.controller.query;

import agus.ramdan.cdt.core.trx.controller.dto.deposit.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.service.TrxDepositQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cdt/core/trx/deposit/query")
@RequiredArgsConstructor
@Log4j2
public class TrxDepositQueryController {
    private final TrxDepositQueryService service;

    @GetMapping
    public ResponseEntity<List<TrxDepositResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllTrxDeposits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrxDepositResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getTrxDepositById(id));
    }
}
