import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//Create a Mapper class and implement the map function.
//Input Key,Value: LongWritable, Text
//Output Key,Value: Text, IntWritable
public class CategoryStatsMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

//In the map function, you need to split the content of each line and get the category and body column.
//Write to the context object the category as the key and the length (character count) of the text of the body column as the value.

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		String[] columns = line.split("\t");
		String category = columns[1];
		String body = columns[4];
		Text cat = new Text(category);
		IntWritable bodyLength = new IntWritable(body.length());
		context.write(cat, bodyLength);
	}

}
