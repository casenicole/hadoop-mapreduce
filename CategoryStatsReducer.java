import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Create a Reducer class and implement the reduce function.
//Input Key,Value: Text, IntWritable
//Output Key,Value: Text, Text
public class CategoryStatsReducer extends Reducer<Text, IntWritable , Text, Text> {

//This Reducer should compute the count and average body size for each category. 
//Write to the context object the category as the key and "AverageBodySize,DocCount" as the value (this is one string with the two values separated by a comma). 
	public void reduce(Iterable<Text> categories, Iterable<IntWritable> bodySize, Context context)
	throws IOException, InterruptedException{
		int document_count = 0;
		int body_size = 0;
		Text[] accountedForCategories = new Text[20];
		for(int i = 0; i < 20; i++){
			accountedForCategories[i] = categories.iterator().next();
			while(categories.iterator().next() == accountedForCategories[i]){
				document_count++;
				body_size += bodySize.iterator().next().get();
			}
			Text key = accountedForCategories[i];
			int average_body_size = body_size / document_count;
			Text value = new Text(average_body_size + "," + document_count);
			context.write(key, value);
		}
	}
}
