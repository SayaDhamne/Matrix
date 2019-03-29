package com.amura.matrix.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amura.matrix.model.ErrorResponse;
import com.amura.matrix.model.InputMatrix;
import com.amura.matrix.model.Submatrix;
import com.amura.matrix.service.MatrixService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Matrix Controller which provides Rest Endpoint to find longest submatrix
 * 
 * @author Sayali Doshi
 * @since 29-03-2019
 */

@RestController
@RequestMapping("/v1")
@Api("Matrix Main controller")
public class MatrixController {

	@Autowired
	MatrixService matrixService;

	@PostMapping("/submatrix")
	@ApiOperation(value = "Finds longest submatrix", response = Submatrix.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Longest Submatrix found", response = Submatrix.class),
			                @ApiResponse(code = 400, message = "Invalid Input matrix", response = ErrorResponse.class)})
	public ResponseEntity<Submatrix> findSubMatrix(@Valid @RequestBody InputMatrix inputMatrix) {
		return new ResponseEntity(matrixService.findLongestSubMatrix(inputMatrix.getMatrix()), HttpStatus.OK);
	}

}
