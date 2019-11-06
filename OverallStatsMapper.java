import java.io.IOException;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//Create a Mapper class and implement the map function.
//Input Key,Value: LongWritable, Text
//Output Key,Value: LongWritable, IntWritable
public class OverallStatsMapper extends Mapper<LongWritable, Text, LongWritable, IntWritable>{
//In the map function, you need to split the content of each line and get the body column.
//Write to the context object the smae input key and the length (character count) of the text of the body column as the value.
	
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		
		String[] line = value.toString().split("\t");	
		IntWritable body_length = new IntWritable(line[4].length());
	
		context.write(key, body_length);
		
	}
}
