package agus.ramdan.cdt.core.trx.service;

import agus.ramdan.cdt.core.trx.domain.QRCode;
import agus.ramdan.cdt.core.trx.dto.qrcode.CreateQRCodeCommandDTO;
import agus.ramdan.cdt.core.trx.dto.qrcode.QRCodeResponseDTO;
import agus.ramdan.cdt.core.trx.dto.qrcode.UpdateQRCodeCommandDTO;
import agus.ramdan.cdt.core.trx.mapper.QRCodeCommandMapper;
import agus.ramdan.cdt.core.trx.repository.QRCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QRCodeCommandService {
    private final QRCodeRepository repository;
    private final QRCodeCommandMapper commandMapper;

    public QRCodeResponseDTO createQRCode(CreateQRCodeCommandDTO dto) {
        QRCode qrCode = commandMapper.toEntity(dto);
        repository.save(qrCode);
        return commandMapper.toResponseDto(qrCode);
    }

    public QRCodeResponseDTO updateQRCode(UpdateQRCodeCommandDTO dto) {
        QRCode qrCode = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("QR Code not found"));
        qrCode.setActive(dto.isActive());
        repository.save(qrCode);
        return commandMapper.toResponseDto(qrCode);
    }
}
