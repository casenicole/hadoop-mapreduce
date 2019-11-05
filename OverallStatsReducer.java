import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Create a Reducer class and implement the reduce function and the cleanup function.
//Input Key,Value: LongWritable, IntWritable
//Output Key,Value: Text, DoubleWritable

public class OverallStatsReducer extends Reducer<LongWritable, IntWritable, Text, DoubleWritable>{
//This Reducer should follow the example we learned in class to compute the count and average values.
//The output should look as clarified in the instructions document.
int doc_count = 0;
int body_word_count = 0;
int average_body_word_count = 0;

public void reduce(LongWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
	while(values.iterator().hasNext()){
		doc_count++;
		body_word_count += values.iterator().next().get();
	}
	average_body_word_count = body_word_count / doc_count;
	
	context.write(new Text("Count"), new DoubleWritable(doc_count));
	context.write(new Text("Average"), new DoubleWritable(average_body_word_count));
}
}
