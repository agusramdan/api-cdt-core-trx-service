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
public class TrxUser {

    private UUID customer_id;
    private UUID customer_crew_id;
    private String username;
}