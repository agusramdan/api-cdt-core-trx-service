package agus.ramdan.cdt.core.trx.controller.query;

import agus.ramdan.cdt.core.trx.dto.deposit.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.dto.qrcode.QRCodeResponseDTO;
import agus.ramdan.cdt.core.trx.service.QRCodeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cdt/core/trx/qr-code/query")
@RequiredArgsConstructor
public class QRCodeQueryController {
    private final QRCodeQueryService service;

    @GetMapping
    public ResponseEntity<List<QRCodeResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllQRCodes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QRCodeResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getQRCodeById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<QRCodeResponseDTO> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(service.getQRCodeByCode(code));
    }
}
