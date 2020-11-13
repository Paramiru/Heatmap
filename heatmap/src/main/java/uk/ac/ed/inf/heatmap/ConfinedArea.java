package uk.ac.ed.inf.heatmap;

import java.util.ArrayList;
import java.util.List;

import com.mapbox.geojson.Point;
import com.mapbox.geojson.Polygon;

public class ConfinedArea {
	
		//four corners of the grid							(longitude - latitude)
		final static Point NORTH_WEST_LIMIT = Point.fromLngLat(-3.192473, 55.946233);
		final static Point NORTH_EAST_LIMIT = Point.fromLngLat(-3.184319, 55.946233);
		final static Point SOUTH_WEST_LIMIT = Point.fromLngLat(-3.192473, 55.942617);
		final static Point SOUTH_EAST_LIMIT = Point.fromLngLat(-3.184319, 55.942617);
		//dimensions of the grid (total width and total height)
		final static double EAST_TO_WEST = Math.abs(3.192473 - 3.184319);
		final static double NORTH_TO_SOUTH = Math.abs(55.946233 - 55.942617);

		/**
		 * Use map dimensions to calculate the required width
		 * of each Polygon.
		 * @return width of the rectangle
		 */
		public static double calculate_rectangle_width() {
			int width = (int) (EAST_TO_WEST * 1000000);
			double width_ = (double) (width / 10000000.0) ;
			return width_;
		}

		/**
		 * Use map dimensions to calculate the required height 
		 * of each Polygon
		 * @return height Height of the rectangle
		 */
		public static double calculate_rectangle_height() {
			int height = (int) (NORTH_TO_SOUTH * 1000000);
			double height2 = height / 10000000.0;
			return height2;
		}

		/**
		 * 
		 * @param pt1 Starting point
		 * @param pt2 Second point
		 * @param pt3 Third point
		 * @param pt4 Fourth point
		 * @param pt5 Starting point to close the loop
		 * @return Polygon rectangle from given 5 points
		 */
		public static Polygon create_rectangle (Point pt1, Point pt2, Point pt3, Point pt4, Point pt5) {
			var list_of_points = new ArrayList<Point>();
			list_of_points.add(pt1); list_of_points.add(pt2);
			list_of_points.add(pt3); list_of_points.add(pt4); list_of_points.add(pt5);
			var rectangle = Polygon.fromLngLats(List.of(list_of_points));
			return rectangle;
		}
}
