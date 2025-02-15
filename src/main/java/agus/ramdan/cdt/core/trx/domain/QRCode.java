package agus.ramdan.cdt.core.trx.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "qr_code", uniqueConstraints = {
        @UniqueConstraint(name = "uc_qrcode_code", columnNames = {"code"})
})
@Schema
@EntityListeners(AuditingEntityListener.class)
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_on;
    @UpdateTimestamp
    private LocalDateTime updated_on;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String created_by;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "code")
    @JsonProperty(index = 2)
    @Schema(description = "QR Code")
    private String code;

    private LocalDateTime expired_time ;
    private boolean active=true;
    // multiple_trx_use
    // single_trx_use
    private String type;

    // customer/user information
    private UUID customer_id;
    private UUID customer_crew_id;
    private String username;

    // account information
    private String account_number;
    private String account_name;
    private String bank_code;
    private String bank_name;

    private String service_transaction_id;
    private String service_transaction_no;

    private String service_product_id;
    private String service_product_code;
    private String service_product_name;
}