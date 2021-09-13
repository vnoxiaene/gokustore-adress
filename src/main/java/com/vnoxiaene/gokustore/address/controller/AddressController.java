package com.vnoxiaene.gokustore.address.controller;

import com.vnoxiaene.gokustore.address.dto.AddressDTO;
import com.vnoxiaene.gokustore.address.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Operation(summary = "save address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "address saved",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddressDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server Error",
                    content = @Content) })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestParam("dto") AddressDTO dto){
        log.debug("saving address...");
        try {
            return new ResponseEntity(addressService.save(dto), HttpStatus.CREATED);

        } catch (Exception e) {
            log.error(e);
            return ResponseEntity.internalServerError().body("Not possible to save");
        }
    }

    @Operation(summary = "update address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "address updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddressDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server Error",
                    content = @Content) })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable(value="id") UUID id, @Valid @RequestBody AddressDTO dto){
        log.debug("updating address...");
        try {
            addressService.update(id, dto);
            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            log.error(e);
            return ResponseEntity.internalServerError().body("Not possible to update");
        }
    }

    @Operation(summary = "list all address by CEP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "addresses listed by CEP",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddressDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server Error",
                    content = @Content) })
    @GetMapping(value = "/cep/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllByCEP(@PathVariable(value="cep") String cep){
        log.debug("listing addresses by cep...");
        try {

            return ResponseEntity.ok().body(addressService.findAllAddressesByCEP(cep));

        } catch (Exception e) {
            log.error(e);
            return ResponseEntity.internalServerError().body("Not possible to list");
        }
    }

}
