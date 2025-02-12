package agus.ramdan.cdt.core.trx.controller;

import agus.ramdan.cdt.core.trx.service.TrxDepositQueryService;
import agus.ramdan.cdt.core.trx.dto.query.TrxDepositQueryDTO;
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
@RequestMapping("/api/cdm/core/deposit/query")
@RequiredArgsConstructor
@Log4j2
public class TrxDepositQueryController {
    private final TrxDepositQueryService service;

    @GetMapping
    public ResponseEntity<List<TrxDepositQueryDTO>> getAll() {
        return ResponseEntity.ok(service.getAllTrxDeposits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrxDepositQueryDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getTrxDepositById(id));
    }
}
