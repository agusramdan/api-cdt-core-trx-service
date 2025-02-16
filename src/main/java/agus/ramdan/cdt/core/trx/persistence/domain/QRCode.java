package agus.ramdan.cdt.core.trx.persistence.domain;

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
    @Enumerated(EnumType.STRING)
    @Column(name = "code_type", nullable = false)
    @JsonProperty("code_type")
    private QRCodeType type;

    // customer/user information
    @Embedded
    private TrxUser user;
    // Beneficiary Account information
    @Embedded
    private BeneficiaryAccount beneficiaryAccount;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "service_trx_id")),
            @AttributeOverride(name = "no", column = @Column(name = "service_trx_no"))
    })
    private ServiceTransaction serviceTransaction;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "service_product_id")),
            @AttributeOverride(name = "code", column = @Column(name = "service_product_code")),
            @AttributeOverride(name = "name", column = @Column(name = "service_product_name"))
    })
    private ServiceProduct serviceProduct;
}