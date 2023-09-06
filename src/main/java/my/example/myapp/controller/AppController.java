package my.example.myapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import my.example.myapp.model.DrinkDto;
import my.example.myapp.model.OperationDto;
import my.example.myapp.util.SuccessResponse;
import my.example.myapp.util.Status;
import my.example.myapp.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dmitrii Vorobev on 05.09.2023.
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "CoffeeMachine Controller",
        description = "Coffee machine control")
public class AppController {
    private final AppService appService;

    @Operation(method = "POST", summary = "Start coffee machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: coffee machine is ON",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SuccessResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request: coffee machine is already ON",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Server has broken",
                    content = @Content)})
    @PostMapping("/start")
    public ResponseEntity<SuccessResponse> start() {
        return ResponseEntity.ok(appService.start(Status.ACTIVE));
    }

    @Operation(method = "POST", summary = "Stop coffee machine")
    @PostMapping("/stop")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: coffee machine is OFF",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SuccessResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: coffee machine is already OFF",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Server has broken",
                    content = @Content)})
    public ResponseEntity<SuccessResponse> stop() {
        return ResponseEntity.ok(appService.stop(Status.INACTIVE));
    }

    @Operation(method = "GET", summary = "Get menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: coffee menu is ready",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DrinkDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: coffee machine is OFF",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: server has broken",
                    content = @Content)})
    @GetMapping("/menu")
    public ResponseEntity<List<DrinkDto>> menu() {
        return ResponseEntity.ok(appService.menu(Status.INFO));
    }

    @Operation(method = "GET", summary = "Coffee is ready")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: coffee is ready",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SuccessResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: coffee machine is OFF",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Bad Request: wrong item number entered",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Server has broken",
                    content = @Content)})
    @GetMapping("/make-coffee/{id}")
    public ResponseEntity<SuccessResponse> makeCoffee(@Parameter(description = "Unique Product ID")
                                                      @PathVariable("id") Long id) {
        return ResponseEntity.ok(appService.makeCoffee(id, Status.MAKING));
    }

    @Operation(method = "GET", summary = "Get all latest commands ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: List of registered commands was successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OperationDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request: list commands is empty",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: coffee machine is OFF",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Server has broken",
                    content = @Content)})
    @GetMapping("/list")
    public ResponseEntity<List<OperationDto>> getAllOperations() {
        return ResponseEntity.ok(appService.getAllOperations(Status.INFO));
    }


    @Operation(method = "DELETE", summary = "Delete position")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: Position successful delete",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SuccessResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found: wrong item number entered",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: coffee machine is OFF",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Server has broken",
                    content = @Content)})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessResponse> delete(@Parameter(description = "Unique Product ID")
                                                  @PathVariable Long id) {
        return ResponseEntity.ok(appService.deletePosition(id, Status.DELETE));
    }

    @Operation(method = "POST", summary = "Add new position")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: new products successfully added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SuccessResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request: A product already exists",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: coffee machine is OFF",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Server has broken",
                    content = @Content)})
    @PostMapping("/add")
    public ResponseEntity<SuccessResponse> add(@RequestBody DrinkDto drinkDto) {
        return ResponseEntity.ok(appService.addPosition(drinkDto, Status.ADD));
    }

    @Operation(method = "PATCH", summary = "Correct costs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: price changed successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SuccessResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found: there is no product with this name",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: coffee machine is OFF",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Server has broken",
                    content = @Content)})
    @PatchMapping("/update")
    public ResponseEntity<SuccessResponse> update(@RequestParam("name") String name,
                                                  @RequestParam("newCost") Long cost) {
        return ResponseEntity.ok(appService.updateCost(name, cost, Status.UPDATE));
    }


}
