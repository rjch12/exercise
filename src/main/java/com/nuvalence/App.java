package com.nuvalence;

import java.util.ArrayList;
import java.util.List;

import com.nuvalence.util.rectangle;
import com.nuvalence.util.util;
import com.nuvalence.util.validation;

/**
 * Validate Rectangle features!
 */

public final class App {

    static util ut = new util();

    private App() {
    }

    /**
     * Accepts two 2D array representing coordinates of 2 rectangles.
     * and returnes the set of features existing
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        List<String> features = getFeatures(ut.getRectangle(1), ut.getRectangle(2));

        System.out.println("The features of the two triangles are:-");
        System.out.print(features);
    }

    public static List<String> getFeatures(rectangle rect1, rectangle rect2) {
        List<String> featuresList = new ArrayList<>();

        if (!validation.validateRectangles(rect1, rect2)) {
            return new ArrayList<String>();
        }
        validateFeatures vF = new validateFeatures();

        if (vF.validateIntersection(rect1, rect2))
            featuresList.add("intersection");
        else
            featuresList.add("no intersection");

        if (vF.validateContainment(rect1, rect2))
            featuresList.add("containement");
        else
            featuresList.add("no containement");

        featuresList.add(vF.validateAdjacency(rect1, rect2));

        return featuresList;
    }
}
