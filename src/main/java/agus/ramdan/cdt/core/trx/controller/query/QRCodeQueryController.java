package agus.ramdan.cdt.core.trx.controller.query;

import agus.ramdan.base.controller.BaseQueryController;
import agus.ramdan.base.service.BaseQueryAllService;
import agus.ramdan.base.service.BaseQueryOneService;
import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeQueryDTO;
import agus.ramdan.cdt.core.trx.persistence.domain.QRCode;
import agus.ramdan.cdt.core.trx.service.QRCodeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping({"/api/cdt/core/trx/qr-code/query","/qr-code/query"})
@RequiredArgsConstructor
public class QRCodeQueryController implements BaseQueryController<QRCode, QRCodeQueryDTO, QRCodeQueryDTO, UUID> {

    @Override
    public BaseQueryAllService<QRCode, QRCodeQueryDTO> getAllService() {
        return service;
    }

    @Override
    public BaseQueryOneService<QRCode, QRCodeQueryDTO, UUID> getOneService() {
        return service;
    }

    private final QRCodeQueryService service;

    @GetMapping("/code/{code}")
    public ResponseEntity<QRCodeQueryDTO> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(service.getQRCodeByCode(code));
    }
}
