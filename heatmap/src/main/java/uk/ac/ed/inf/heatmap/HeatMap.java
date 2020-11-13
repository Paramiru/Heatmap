package uk.ac.ed.inf.heatmap;

import java.util.ArrayList;
import java.util.List;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Geometry;
import com.mapbox.geojson.Point;

public class HeatMap {				    

	/**
	 * Creates array of rectangles as geometries by starting
	 * from the UPPER_LEFT_LIMIT and calculating the coordinates of
	 * each rectangle frorm there.
	 * 
	 * @return List<List<Geometry>> map_of_geometries
	 */
	public List<List<Geometry>> create_2D_array_of_geometries() {
		// create 10 x 10 polygons
		double rectangle_width = ConfinedArea.calculate_rectangle_width();
		double rectangle_height = ConfinedArea.calculate_rectangle_height();
		// construct map from left to right and north to south
		List<List<Geometry>> map_of_geometries = new ArrayList<List<Geometry>>();
		double longitude = ConfinedArea.NORTH_WEST_LIMIT.coordinates().get(0);
		double latitude = ConfinedArea.NORTH_WEST_LIMIT.coordinates().get(1);
		for (int row = 0; row < 10; row++) {
			var row_of_rectangles = new ArrayList<Geometry>();
			for (int column = 0; column < 10; column++) {
				var up_left = Point.fromLngLat(longitude + rectangle_width*column, latitude - rectangle_height*row);
				var up_right = Point.fromLngLat(longitude + (column+1) * rectangle_width, latitude - rectangle_height*row);
				var down_left = Point.fromLngLat(longitude + rectangle_width*column, latitude - rectangle_height*(row+1));
				var down_right = Point.fromLngLat(longitude + rectangle_width*(column+1), latitude - rectangle_height*(row+1));
				Geometry rectangle = (Geometry) ConfinedArea.create_rectangle(up_left, up_right, down_right, down_left, up_left);
				row_of_rectangles.add(rectangle);
			}
			map_of_geometries.add(row_of_rectangles);
		}
		return map_of_geometries;	
	}
	/**
	 * Converts geometries to features with the required attributes
	 * and using the predictions array to get the corresponding colour.
	 * 
	 * @param predictions Double 2D array
	 * @param geometry_map ArrayList of Geometry ArrayList
	 * @return ArrayList of Feature ArrayList
	 */
	public List<List<Feature>> get_2D_array_of_features(Double[][] predictions, List<List<Geometry>> geometry_map) {
		var list_of_list_of_features = new ArrayList<List<Feature>>();
		for (int row = 0; row < predictions.length; row++) {
			var list_of_features = new ArrayList<Feature>();
			for (int column = 0; column < predictions[0].length; column++) {
				Geometry geometry = geometry_map.get(row).get(column);
				var feature = Feature.fromGeometry(geometry);
				Double corresponding_prediction = predictions[row][column];
				String corresponding_colour = Colour.get_colour(corresponding_prediction);
				feature.addStringProperty("rgb-string", corresponding_colour);
				feature.addStringProperty("fill", corresponding_colour);
				feature.addNumberProperty("fill-opacity", 0.75);
				list_of_features.add(feature);
			}
			list_of_list_of_features.add(list_of_features);
		}
		return list_of_list_of_features;
	}
	
	/**
	 * Append each Feature to an ArrayList<Feature> and
	 * convert it to a FeatureCollection
	 * 
	 * @param array_of_features
	 * @return FeatureCollection fc
	 */
	public FeatureCollection get_feature_collection_from_feature_array(List<List<Feature>> array_of_features) {
		var feature_list = new ArrayList<Feature>();
    	for (List<Feature> list_of_features : array_of_features) {
    		for (Feature feature : list_of_features) {
    			feature_list.add(feature);
    		}
    	}
    	var fc = FeatureCollection.fromFeatures(feature_list);
		return fc;
	}
}



