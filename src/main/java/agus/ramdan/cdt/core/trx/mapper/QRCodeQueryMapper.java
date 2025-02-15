package agus.ramdan.cdt.core.trx.mapper;

import agus.ramdan.cdt.core.trx.domain.QRCode;
import agus.ramdan.cdt.core.trx.dto.qrcode.QRCodeResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QRCodeQueryMapper {
    QRCodeResponseDTO toResponseDto(QRCode entity);
}
