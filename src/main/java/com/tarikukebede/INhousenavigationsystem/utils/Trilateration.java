package com.tarikukebede.INhousenavigationsystem.utils;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.tarikukebede.INhousenavigationsystem.dtos.TrilaterationResult;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.apache.commons.math3.linear.RealVector;

/**
 * This class provides a method for calculating the position of an object
 * based on the distance it is from three or more points using trilateration.
 * @author Tariku Kebede
 */

public class Trilateration {

    /**
     * Calculates the position of an object based on the distance it is from three or more points
     * using trilateration.
     * @param distances  an array of distances from the object to each point
     * @param positions  a two-dimensional array of the x and y coordinates of each point
     * @return a TrilaterationResult object that contains the x and y coordinates of the object's position
     * as well as an error radius that represents the accuracy of the calculation
     */
    public static TrilaterationResult calculate(double[] distances, double[][] positions) {
        NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
        LeastSquaresOptimizer.Optimum optimum = solver.solve();

        double[] centroid = optimum.getPoint().toArray();
        RealVector standardDeviation = optimum.getSigma(0);
        double errorRadius = Math.sqrt(Math.pow(standardDeviation.getEntry(0), 2) + Math.pow(standardDeviation.getEntry(1), 2));

        return TrilaterationResult.builder()
                .x((float) centroid[0])
                .y((float) centroid[1])
                .errorRadius((float) errorRadius)
                .build();
    }
}