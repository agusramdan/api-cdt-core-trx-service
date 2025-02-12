package agus.ramdan.cdt.core.trx.controller;

import agus.ramdan.cdt.core.trx.dto.command.CreateTrxDepositCommandDTO;
import agus.ramdan.cdt.core.trx.dto.command.TrxDepositResponseDTO;
import agus.ramdan.cdt.core.trx.dto.command.UpdateTrxDepositCommandDTO;
import agus.ramdan.cdt.core.trx.service.TrxDepositCommandService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/cdt/core/trx/deposit/command")
@RequiredArgsConstructor
@Log4j2
public class TrxDepositCommandController {
    private final TrxDepositCommandService service;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositResponseDTO.class)),})
    })
    public ResponseEntity<TrxDepositResponseDTO> create(@RequestBody CreateTrxDepositCommandDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTrxDeposit(dto));
    }

    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(description = "successful operation", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TrxDepositResponseDTO.class)),})
    })
    public ResponseEntity<TrxDepositResponseDTO> update(@RequestBody UpdateTrxDepositCommandDTO dto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateTrxDeposit(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.deleteTrxDeposit(id);
        return ResponseEntity.noContent().build();
    }
}
