package agus.ramdan.base.controller;

import agus.ramdan.base.exception.Errors;
import agus.ramdan.base.service.BaseQueryAllService;
import agus.ramdan.base.service.BaseQueryOneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BaseQueryController<T, ALL_DTO,ONE_DTO,ID>{

    BaseQueryAllService<T,ALL_DTO> getAllService();
    BaseQueryOneService<T,ONE_DTO,ID> getOneService();

    @GetMapping("")
    @Operation(summary = "Get All")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema()))),
            @ApiResponse(responseCode = "204", description = "No Content",
                    content = @Content(schema = @Schema(implementation = Errors.class))),
            @ApiResponse(responseCode = "400", description = "Invalid tag value",
                    content = @Content(schema = @Schema(implementation = Errors.class)))})
    default ResponseEntity<List<ALL_DTO>> getAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(value = "limit", required = false, defaultValue = "25") int limit,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "ids", required = false) String ids
    ) {
        return ResponseEntity.ok(getAllService().getAll(offset,limit,search,ids));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = Errors.class)))

    })
    default ResponseEntity<ONE_DTO> getById(@PathVariable("id") ID id){
        return ResponseEntity.ok().body(getOneService().getById(id));
    }
}
