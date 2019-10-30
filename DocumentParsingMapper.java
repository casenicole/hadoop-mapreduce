import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// Create a Mapper class and implement the map function.
// Input Key,Value: Text, Text
// Output Key,Value: Text, Article

// In the map function, you need to utilize the Article class that is given for you. The constructor of the Article class takes the file content and the file path as arguments. 
// Simply create an Article object by using the input key and value as arguments for the Article constructor. 
// The mapper should output through the context the filepath as a key and the article object as a value.  

