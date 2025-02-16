package agus.ramdan.cdt.core.trx.mapper;

import agus.ramdan.cdt.core.trx.controller.dto.*;
import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeQueryDTO;
import agus.ramdan.cdt.core.trx.controller.dto.qrcode.QRCodeUpdateDTO;
import agus.ramdan.cdt.core.trx.persistence.domain.*;
import org.hibernate.type.StringNVarcharType;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface QRCodeMapper {
    String map(UUID source);
    UUID map(String source);
    ServiceProduct map(ServiceProductDTO source);
    ServiceProductDTO map(ServiceProduct source);
    BeneficiaryAccount map(BeneficiaryAccountDTO source);
    BeneficiaryAccountDTO map(BeneficiaryAccount source);
    ServiceTransaction map(ServiceTransactionDTO source);
    ServiceTransactionDTO map(ServiceTransaction source);
    TrxUser map(TrxUserDTO source);
    TrxUserDTO map(TrxUser source);
    String map(QRCodeType source);

//    @Mapping(source = "beneficiaryAccount.beneficiary_id", target = "beneficiaryAccount.beneficiary_id", qualifiedByName = "stringToUUID")
//    @Mapping(source = "user.customer_id", target = "user.customer_id", qualifiedByName = "stringToUUID")
//    @Mapping(source = "user.customer_crew_id", target = "user.customer_crew_id", qualifiedByName = "stringToUUID")
//    @Mapping(source = "serviceTransaction.id", target = "serviceTransaction.id", qualifiedByName = "stringToUUID")
//    @Mapping(source = "serviceProduct.id", target = "serviceProduct.id", qualifiedByName = "stringToUUID")
    QRCode createDtoToEntity(QRCodeCreateDTO dto);

//    @Mapping(source = "user.customer_id", target = "user.customer_id", qualifiedByName = "uuidToString")
//    @Mapping(source = "user.customer_crew_id", target = "user.customer_crew_id", qualifiedByName = "uuidToString")
//    @Mapping(source = "serviceTransaction.id", target = "serviceTransaction.id", qualifiedByName = "uuidToString")
//    @Mapping(source = "serviceProduct.id", target = "serviceProduct.id", qualifiedByName = "uuidToString")
    QRCodeQueryDTO entityToQueryDto(QRCode entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromUpdateDto(QRCodeUpdateDTO dto, @MappingTarget QRCode entity);
}
