package agus.ramdan.cdt.core.trx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxDepositRequest implements Serializable {
    @NotNull(message = "Token/CQ Code cannot be null")
    @Size(min = 20, max = 20, message = "QR Code must 20 characters.")
    private String token;
    private String signature;

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
    @NotNull(message = "amount cannot be null.")
    @Positive(message = "amount must be positive value.")
    private BigDecimal amount;

    @Valid
    @NotNull(message = "denominations cannot be null.")
    @NotEmpty(message = "denominations cannot be empty.")
    private List<TrxDepositDenominationRequest> denominations = new ArrayList<>();
}
