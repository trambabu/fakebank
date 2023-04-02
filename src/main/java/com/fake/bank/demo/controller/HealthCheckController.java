package com.fake.bank.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fake.bank.demo.utils.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API Health Check", description = "Fake Banking management Index API's")
@RestController
@RequestMapping("/home")
public class HealthCheckController {

	 @Operation(
		      summary = "Application Health Check",
		      description = "Core Banking Management for a customer include Transaction management, Other bank Debit order, Notification, Reports generation for Other bank Transactions .",
		      tags = { "HealthCheck", "get" })
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = HealthCheckController.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping(Constants.URI_API_HEALTHCHECK)											
	public ResponseEntity<?> getApplicationHealth(){
		return ResponseEntity.ok("Application Available");
	}
	@GetMapping("/index")
	public String home() {
		return "Welcome";
		
	}
}
