package co.edu.unbosque.springdemo.controller;

import co.edu.unbosque.springdemo.model.BaseResponse;
import co.edu.unbosque.springdemo.model.EmployeeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/employment/api")
public interface EmploymentAPI {

    @Operation(
            summary = "Retrieves Employee by Employee ID",
            description = "Search for an Employee using a provided ID"
    )
    @ApiResponses(
            value={
                    @ApiResponse(
                            responseCode = "200",
                            description = "Employee found successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id);

    @Operation(
            summary = "Retrieves all Employees",
            description = "Search for all Employees"
    )
    @ApiResponses(
            value={
                    @ApiResponse(
                            responseCode = "200",
                            description = "Employees found successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/employee")
    ResponseEntity<Set<EmployeeDTO>> getAllEmployees();

    @Operation(
            summary = "Creates an Employee",
            description = "Creates a new Employee"
    )
    @ApiResponses(
            value={
                    @ApiResponse(
                            responseCode = "201",
                            description = "Employee created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EmployeeDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    mediaType = "application/json"//,
                                    //schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )
                    )
            }
    )
    @PostMapping("/employee")
    ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employee);
}
