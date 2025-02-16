package agus.ramdan.cdt.core.trx.service;

import agus.ramdan.base.service.BaseCommandService;
import agus.ramdan.cdt.core.trx.controller.dto.QRCodeCreateDTO;
import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeQueryDTO;
import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeUpdateDTO;
import agus.ramdan.cdt.core.trx.mapper.QRCodeMapper;
import agus.ramdan.cdt.core.trx.persistence.domain.QRCode;
import agus.ramdan.cdt.core.trx.persistence.repository.QRCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QRCodeCommandService implements BaseCommandService<QRCode, QRCodeQueryDTO, QRCodeCreateDTO, QRCodeUpdateDTO, String> {
    private final QRCodeRepository repository;
    private final QRCodeMapper mapper;

    @Override
    public QRCode saveCreate(QRCode entity) {
        return repository.save(entity);
    }

    @Override
    public QRCode saveUpdate(QRCode entity) {
        return repository.save(entity);
    }

    @Override
    public QRCode convertFromCreateDTO(QRCodeCreateDTO dto) {
        return mapper.createDtoToEntity(dto);
    }

    @Override
    public QRCode convertFromUpdateDTO(String id, QRCodeUpdateDTO dto) {
        QRCode qrCode = repository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("QR Code not found"));
        mapper.updateEntityFromUpdateDto(dto, qrCode);
        return qrCode;
    }

    @Override
    public QRCodeQueryDTO convertToResultDTO(QRCode entity) {
        return mapper.entityToQueryDto(entity);
    }

    @Override
    public void commandDelete(String id) {
        repository.deleteById(UUID.fromString(id));
    }
}
