import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Create a Reducer class and implement the reduce function.
//Input Key,Value: Text, IntWritable
//Output Key,Value: Text, Text

//This Reducer should compute the count and average body size for each category. 
//Write to the context object the category as the key and "AverageBodySize,DocCount" as the value (this is one string with the two values separated by a comma). 

