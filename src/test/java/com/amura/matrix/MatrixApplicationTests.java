package com.amura.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.amura.matrix.exception.ApiException;
import com.amura.matrix.impl.MatrixServiceImpl;
import com.amura.matrix.model.Submatrix;

@RunWith(MockitoJUnitRunner.class)
public class MatrixApplicationTests {

	@InjectMocks
	MatrixServiceImpl matrixServiceMock;

	@Test
	public void testFindLongestSubMatrix() {
		Integer[][] testMatrix = { { 1, 1, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		Submatrix expected = Submatrix.builder().x(0).y(0).height(3).width(2).build();
		Submatrix actual = matrixServiceMock.findLongestSubMatrix(testMatrix);
		assertEquals(expected.getX(), actual.getX());
		assertEquals(expected.getY(), actual.getY());
		assertEquals(expected.getWidth(), actual.getWidth());
		assertEquals(expected.getHeight(), actual.getHeight());

	}
	
	@Test
	public void testFindLongestSubMatrixWithAllOnes() {
		Integer[][] testMatrix = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		Submatrix expected = Submatrix.builder().x(0).y(0).height(3).width(3).build();
		Submatrix actual = matrixServiceMock.findLongestSubMatrix(testMatrix);
		assertEquals(expected.getX(), actual.getX());
		assertEquals(expected.getY(), actual.getY());
		assertEquals(expected.getWidth(), actual.getWidth());
		assertEquals(expected.getHeight(), actual.getHeight());

	}
	
	@Test(expected = ApiException.class)
	public void testFindLongestSubMatrixForInvalidMAtrix() {
		Integer[][] testMatrix = { { 1, 1, 2 }, { 1, 1, 0 }, { 1, 1, 0 } };
		Submatrix actual = matrixServiceMock.findLongestSubMatrix(testMatrix);
		
	}



}
