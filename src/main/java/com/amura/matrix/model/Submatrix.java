package com.amura.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Java model to represent output submatrix
 * 
 * @author Sayali Doshi
 * @since 29-03-2019
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Submatrix {

	private int x;
	private int y;
	private int width;
	private int height;
	
	
}
