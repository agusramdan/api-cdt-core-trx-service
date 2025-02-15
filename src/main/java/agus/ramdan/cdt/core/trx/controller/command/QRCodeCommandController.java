package agus.ramdan.cdt.core.trx.controller.command;

import agus.ramdan.cdt.core.trx.dto.qrcode.CreateQRCodeCommandDTO;
import agus.ramdan.cdt.core.trx.dto.qrcode.QRCodeResponseDTO;
import agus.ramdan.cdt.core.trx.dto.qrcode.UpdateQRCodeCommandDTO;
import agus.ramdan.cdt.core.trx.service.QRCodeCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cdt/core/trx/qr-code/command")
@RequiredArgsConstructor
public class QRCodeCommandController {
    private final QRCodeCommandService service;

    @PostMapping
    public ResponseEntity<QRCodeResponseDTO> create(@RequestBody CreateQRCodeCommandDTO dto) {
        return ResponseEntity.ok(service.createQRCode(dto));
    }

    @PutMapping
    public ResponseEntity<QRCodeResponseDTO> update(@RequestBody UpdateQRCodeCommandDTO dto) {
        return ResponseEntity.ok(service.updateQRCode(dto));
    }
}

