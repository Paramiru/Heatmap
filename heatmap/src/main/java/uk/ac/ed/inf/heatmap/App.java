package uk.ac.ed.inf.heatmap;

import java.io.FileNotFoundException;


public class App 
{
    public static void main( String[] args ) throws FileNotFoundException 
    {
    	//Read predictions.txt into a 2D array
    	var heatMapIO = new HeatMapIO();
    	//Get 2D array from the input file
    	var predictions = heatMapIO.parseFile(args[0]);
    	var map_to_build = new HeatMap();
    	//create 2D array of geometries from the predictions array
    	var array_of_geometries = map_to_build.create_2D_array_of_geometries();
    	//use geometry_map and predictions to get a 2D array
    	//with geometries converted into features with their attributes
    	var array_of_features = map_to_build.get_2D_array_of_features(predictions, array_of_geometries);
    	//get feature collection from the array of features
    	var feature_collection = map_to_build.get_feature_collection_from_feature_array(array_of_features);
    	var formated_FeatureCollection = feature_collection.toJson();
    	// Create file heatmap.geojson and write the formated_FeatureCollection as JSON
    	var filename = "heatmap.geojson";
    	heatMapIO.createFile(filename, formated_FeatureCollection);
    }
 
}