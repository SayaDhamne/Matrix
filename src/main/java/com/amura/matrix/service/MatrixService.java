package com.amura.matrix.service;

import com.amura.matrix.model.Submatrix;

/**
 * Matrix service interface indicating services
 *  provided to play with matrix
 * 
 * @author Sayali Doshi
 * @since 29-03-2019
 */
public interface MatrixService {
	
	public Submatrix findLongestSubMatrix(Integer[][] matrix );

}
