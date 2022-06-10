package com.example.javapractice.geometry;

import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.geotools.referencing.GeodeticCalculator;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXY;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;

class GeometryTest {

    private final GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

    @Test
    void point_1() throws FactoryException, TransformException {
        Coordinate coordinate1 = new CoordinateXY(37.527161, 126.869452);
        Coordinate coordinate2 = new CoordinateXY(37.546084, 126.829698);
        Point pointYang = geometryFactory.createPoint(coordinate1);
        Point pointBal = geometryFactory.createPoint(coordinate2);

        CoordinateReferenceSystem crs = CRS.decode("epsg:4326");
        GeodeticCalculator geodeticCalculator = new GeodeticCalculator(crs);
        geodeticCalculator.setStartingPosition(JTS.toDirectPosition(coordinate1, crs));
        geodeticCalculator.setDestinationPosition(JTS.toDirectPosition(coordinate2, crs));

        double distance1 = pointYang.distance(pointBal);
        double distance2 = geodeticCalculator.getOrthodromicDistance();

        System.out.println("distance1 = " + distance1);
        System.out.println("distance2 = " + distance2);
    }
}
