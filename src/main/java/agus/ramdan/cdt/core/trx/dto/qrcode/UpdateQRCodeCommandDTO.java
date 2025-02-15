package agus.ramdan.cdt.core.trx.dto.qrcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQRCodeCommandDTO {
    private UUID id;
    private boolean active;
}
