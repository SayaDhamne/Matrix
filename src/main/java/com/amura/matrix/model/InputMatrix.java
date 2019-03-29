package com.amura.matrix.model;

import lombok.Builder;
import lombok.Data;

/**
 * Java Model to represent matrix in json
 * 
 * @author Sayali Doshi
 * @since 29-03-2019
 */

@Data
@Builder
public class InputMatrix {

	Integer[][] matrix;
}
