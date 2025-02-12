package agus.ramdan.cdt.core.trx.dto.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTrxDepositCommandDTO {
    private String token;
    private String signature;
    private String service_transaction_id;
    private String service_transaction_no;

    private String service_product_id;
    private String service_product_code;
    private String service_product_name;

    private String machine_deposit_id;
    private String machine_deposit_code;
    private String machine_deposit_sn;

    private BigDecimal amount;
    private List<CreateTrxDepositDenominationDTO> denominations;
}
