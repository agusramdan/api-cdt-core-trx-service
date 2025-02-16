package agus.ramdan.base.controller;

import agus.ramdan.base.service.BaseCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
public interface BaseCommandController<T,ResultDTO,CreateDTO,UpdateDTO,ID>{

    BaseCommandService<T,ResultDTO,CreateDTO,UpdateDTO,ID> getService();

    @PostMapping
    @Operation(summary = "Create new data")
    @ApiResponse(responseCode = "201", description = "Data created successfully")
    default ResponseEntity<ResultDTO> createCustomer(@Valid @RequestBody CreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(getService().commandCreate(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update data details (partial update supported)")
    @ApiResponse(responseCode = "200", description = "Customer updated successfully")
    default ResponseEntity<ResultDTO> updateCustomer(@PathVariable ID id,@Valid @RequestBody UpdateDTO dto) {
        return ResponseEntity.ok(getService().commandUpdate(id,dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer")
    @ApiResponse(responseCode = "204", description = "Customer deleted successfully")
    default ResponseEntity<Void> deleteCustomer(@PathVariable ID id) {
        getService().commandDelete(id);
        return ResponseEntity.noContent().build();
    }
}