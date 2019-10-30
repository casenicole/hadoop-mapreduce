import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Create a Reducer class and implement the reduce function and the cleanup function.
//Input Key,Value: LongWritable, IntWritable
//Output Key,Value: Text, DoubleWritable

//This Reducer should follow the example we learned in class to compute the count and average values.
//The output should look as clarified in the instructions document.

