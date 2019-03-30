package com.amura.matrix.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amura.matrix.exception.ApiException;
import com.amura.matrix.model.Submatrix;
import com.amura.matrix.service.MatrixService;

/**
 * Matrix Service implementation class
 * 
 * @author Sayali Doshi
 * @since 29-03-2019
 */

@Service
public class MatrixServiceImpl implements MatrixService {

	@Override
	public Submatrix findLongestSubMatrix(Integer[][] matrix) {
		int x, y, width, height, longestWidth, longestHeight;
		x = y = width = height = longestHeight = longestWidth = 0;
		boolean isFound = true;

		validateMatrix(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				isFound = true;
				width = height = 0;
				if (matrix[i][j] == 1) {
					width++;
					height++;

					// check width first
					width = findWidth(matrix, width, i, j);

					// Check submatrix for each height width combination
					for (int w = 1; w <= width; w++) {
						int h = findHeight(matrix, w, height, i, j);

						// check if current matrix is longest matrix
						if (isCurrentMatrixLongest(w, h, longestWidth, longestHeight)) {
							x = i;
							y = j;
							longestWidth = w;
							longestHeight = h;
						}
					}

				}
			}
		}
		return Submatrix.builder().x(x).y(y).height(longestHeight).width(longestWidth).build();
	}

	/**
	 * Check if input matrix is valid
	 * 
	 * @param matrix
	 */
	private void validateMatrix(Integer[][] matrix) {
		checkInvalidEleemnt(matrix);
		checkRectangularMatrix(matrix);
	}

	private void checkInvalidEleemnt(Integer[][] matrix) {
		Set<Integer> arrayElements = Arrays.stream(matrix).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toSet());
		List<Integer> possibleValues = Arrays.asList(0, 1);
		arrayElements.removeAll(possibleValues);
		if (arrayElements.size() > 0)
			throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid Input matrix");
	}

	void checkRectangularMatrix(Integer[][] matrix) {
		int randomLength = matrix[0].length;
		if (!Arrays.stream(matrix).allMatch(array -> (randomLength == array.length))) {
			throw new ApiException(HttpStatus.BAD_REQUEST, "Invalid Input matrix");
		}
	}

	private int findWidth(Integer[][] matrix, int width, int i, int j) {
		for (int k = j + 1; k < matrix[i].length; k++) {
			if (matrix[i][k] == 1) {
				width++;
			} else {
				break;
			}
		}
		return width;
	}

	private int findHeight(Integer[][] matrix, int width, int height, int i, int j) {
		boolean isFound;
		isFound = true;
		for (int k = i + 1; k < matrix.length; k++) {
			for (int l = j; l <= j + width - 1; l++) {
				if (matrix[k][l] == 1) {
					if (l == j + width - 1)
						height++;
				} else {
					isFound = false;
					break;
				}
			}
			if (!isFound)
				break;
		}
		return height;
	}

	private boolean isCurrentMatrixLongest(int width, int height, int longestWidth, int longestHeight) {
		return (longestWidth * longestHeight) < (width * height);
	}

}
