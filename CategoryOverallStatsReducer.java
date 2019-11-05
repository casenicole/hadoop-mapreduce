import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Create a Reducer class and implement the reduce function and the cleanup function.
//Input Key,Value: Text, Text 
//Output Key,Value: Text, Text 
public class CategoryOverallStatsReducer extends Reducer<Text, Text, Text, Text>{
//This Reducer should follow the example we learned in class to compute the stats as described in the instructions document for this part.

	int maxWordCount = Integer.MAX_VALUE;
	int minWordCount = Integer.MIN_VALUE;
	int average_docs_per_category = 0;
	String maxCategory;
	String minCategory;
	
	
	public void reduce(Iterable<Text> categories, Iterable<Text> averageBodySizeAndDocCounts, Context context) throws IOException, InterruptedException{
		
		
		int doc_count = 0;
		while(categories.iterator().hasNext()){
			String[] accountedForCategories = new String[20];
			for(int i = 0; i <= 20; i++){
				if(accountedForCategories[i] != categories.iterator().next().toString()){
					accountedForCategories[i] = categories.iterator().next().toString();
				} else{
					String[] average_body_size_and_doc_count = averageBodySizeAndDocCounts.iterator().next().toString().split(",");
					doc_count += Integer.parseInt(average_body_size_and_doc_count[1]);
					int bodyWordCount = Integer.parseInt(average_body_size_and_doc_count[0]);
					
					if(bodyWordCount > maxWordCount){
						maxWordCount = bodyWordCount;
						maxCategory = accountedForCategories[i];
					} else if (bodyWordCount < minWordCount){
						minWordCount = bodyWordCount;
						minCategory = accountedForCategories[i];
					} else {
						continue;
					}
				}
			}
 		average_docs_per_category = doc_count / 20;
		}
	}
	
	public void cleanup(Context context) throws IOException, InterruptedException{
		context.write(new Text("Average Document Per Category"), new Text(Integer.toString(average_docs_per_category)));
		context.write(new Text("Category with Max Avg Body Word Count"), new Text(maxCategory));
		context.write(new Text("Category with Min Avg Body Word Count"), new Text(minCategory));
	}
}
