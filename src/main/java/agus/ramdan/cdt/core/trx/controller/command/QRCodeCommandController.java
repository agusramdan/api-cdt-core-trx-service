package agus.ramdan.cdt.core.trx.controller.command;

import agus.ramdan.base.controller.BaseCommandController;
import agus.ramdan.cdt.core.trx.controller.dto.QRCodeCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeQueryDTO;
import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeUpdateDTO;
import agus.ramdan.cdt.core.trx.persistence.domain.QRCode;
import agus.ramdan.cdt.core.trx.service.QRCodeCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/cdt/core/trx/qr-code/command","/qr-code/command"})
@RequiredArgsConstructor
public class QRCodeCommandController implements BaseCommandController<QRCode, QRCodeQueryDTO, QRCodeCreateDTO, QRCodeUpdateDTO, String> {
    private final QRCodeCommandService service;

    @Override
    public QRCodeCommandService getService() {
        return service;
    }
}

