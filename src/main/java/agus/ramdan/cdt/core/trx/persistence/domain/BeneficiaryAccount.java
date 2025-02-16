package agus.ramdan.cdt.core.trx.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class BeneficiaryAccount {

    private UUID beneficiary_id;

    // account information
    private String account_number;
    private String account_name;
    private String bank_code;
    private String bank_name;
}