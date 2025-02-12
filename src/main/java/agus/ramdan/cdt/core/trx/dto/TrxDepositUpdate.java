package agus.ramdan.cdt.core.trx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositUpdate implements Serializable {
    private String status;

    private String service_transaction_id;
    private String service_transaction_no;

    private String machine_deposit_code;
    private String machine_deposit_sn;

    private String service_product_id;
    private String service_product_code;
    private String service_product_name;

    private String cdm_trx_no;

    private LocalDateTime cdm_trx_date;

    private LocalDateTime trx_date;
    private BigDecimal amount;

}
