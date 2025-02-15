package agus.ramdan.cdt.core.trx.service;

import agus.ramdan.cdt.core.trx.dto.qrcode.QRCodeResponseDTO;
import agus.ramdan.cdt.core.trx.exception.ResourceNotFoundException;
import agus.ramdan.cdt.core.trx.mapper.QRCodeQueryMapper;
import agus.ramdan.cdt.core.trx.repository.QRCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QRCodeQueryService {
    private final QRCodeRepository repository;
    private final QRCodeQueryMapper queryMapper;

    public List<QRCodeResponseDTO> getAllQRCodes() {
        return repository.findAll().stream()
                .map(queryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public QRCodeResponseDTO getQRCodeById(UUID id) {
        return repository.findById(id)
                .map(queryMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("QR Code not found"));
    }
    public QRCodeResponseDTO getQRCodeByCode(String code) {
        return repository.findByCode(code)
                .map(queryMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("QR Code not found"));
    }
}
