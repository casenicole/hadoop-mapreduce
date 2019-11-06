import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Create a Reducer class and implement the reduce function.
//Input Key,Value: Text, IntWritable
//Output Key,Value: Text, Text
public class CategoryStatsReducer extends Reducer<Text, IntWritable , Text, Text> {
	private static List<String> cat = new ArrayList<String>();
	private static List<String> bodySizeDocCount = new ArrayList<String>();
	
//This Reducer should compute the count and average body size for each category. 
//Write to the context object the category as the key and "AverageBodySize,DocCount" as the value (this is one string with the two values separated by a comma). 
	public void reduce(Text category, Iterable<IntWritable> bodySize, Context context)
	throws IOException, InterruptedException{
		int document_count = 0;
		int body_size = 0;
		while(bodySize.iterator().hasNext()){
			document_count++;
			body_size += bodySize.iterator().next().get();
		}
		if(!cat.contains(category.toString())){
			cat.add(category.toString());
		}
	
		int average_body_size = body_size / document_count;
		
		if(!bodySizeDocCount.contains(average_body_size))
		{
			bodySizeDocCount.add(average_body_size + "," + document_count);
		}	
		
		}
	
	public void cleanup(Context context) throws IOException, InterruptedException{
		for(int i = 0; i < cat.size(); i++){
		context.write(new Text(cat.get(i)), new Text(bodySizeDocCount.get(i)));
		}
	}
	}
