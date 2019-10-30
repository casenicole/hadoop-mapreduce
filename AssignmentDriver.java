import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.jobcontrol.JobControl;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.jobcontrol.ControlledJob;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class AssignmentDriver {
  public static void main(String[] args) throws Exception {
  
	 // ------------------------
	 //  Job 1
	 // ------------------------
	 // Create job1 Object
	 // Set JAR class: AssignmentDriver
	 
	 // Set Mapper class for Job1: DocumentParsingMapper
	 // Set Reducer class for Job1: DocumentParsingReducer
	  
	 // Set Output Key type: Text
	 // Set Output Value type: Article
	  
	 // Set Inputformat class: WholeFileInputFormat
	 // Since the dataset contains multiple folders, make sure to read in recursive mode:  WholeFileInputFormat.setInputDirRecursive(job1, true);
	 
	 // Set Input Path "20-newsgroups" for local testing or args[0] when you export the jar
	 // Set Output path
	  
	  // Don't submit the job!
	  

     
     // ------------------------
	 //  Job 2
	 // ------------------------
	 // Create job2 Object
	 // Set JAR class: AssignmentDriver
	 
	 // Set Mapper class for Job1: OverallStatsMapper
	 // Set Reducer class for Job1: OverallStatsReducer
	  
	 // Set Output Key type: Text
	 // Set Output Value type: DoubleWritable
     
     // Set Mapper Output Key type: LongWritable  (this is needed here because the key and value types of Mapper are different from reducer). Use the Job2.setMapKeyClass(...)
     // Set Mapper Output Key type: IntWritable  (this is needed here because the key and value types of Mapper are different from reducer).  Use the Job2.setMapValueClass(...)
	  
	 // Set Inputformat class: TextInputFormat
	 
	 // Set Input Path: the output path of Job 1
	 // Set Output path
     
     // Don't submit the job!
     
    
     
     // ------------------------
  	 //  Job 3
  	 // ------------------------
  	 // Create job3 Object
  	 // Set JAR class: AssignmentDriver
  	 
  	 // Set Mapper class for Job1: CategoryStatsMapper
  	 // Set Reducer class for Job1: CategoryStatsReducer
  	  
  	 // Set Output Key type: Text
  	 // Set Output Value type: Text
       
     // Set Mapper Output Key type: Text  (this is needed here because the key and value types of Mapper are different from reducer). Use the Job2.setMapKeyClass(...)
     // Set Mapper Output Key type: IntWritable  (this is needed here because the key and value types of Mapper are different from reducer).  Use the Job2.setMapValueClass(...)
  	  
  	 // Set Inputformat class: TextInputFormat
  	 
  	 // Set Input Path: the output path of Job 1
  	 // Set Output path
       
     // Don't submit the job!
     
 
     
     // ------------------------
  	 //  Job 4
  	 // ------------------------
  	 // Create job4 Object
  	 // Set JAR class: AssignmentDriver
  	 
  	 // Set Mapper class for Job1: CategoryOverallStatsMapper
  	 // Set Reducer class for Job1: CategoryOverallStatsReducer
  	  
  	 // Set Output Key type: Text
  	 // Set Output Value type: Text
      
  	 // Set Inputformat class: KeyValueTextInputFormat
  	 
  	 // Set Input Path: the output path of Job 3
  	 // Set Output path
       
     // Don't submit the job!
     

     
     // ------------------------
  	 //  Create Controlled Jobs
  	 // ------------------------
     
     // Create Controlled Job for Job1.
     // Configuration ControlJobConf1 = new Configuration();
     // ControlledJob controlledJob1 = new ControlledJob(ControlJobConf1);
     // controlledJob1.setJob(job1);
     
    
     // Create Controlled Job for Job2.
    
     
     // Create Controlled Job for Job3.
     
     
     // Create Controlled Job for Job4.
     
     
     // ------------------------
  	 //  Create Job Dependencies
  	 // ------------------------
     
     // add job1 as a dependency for job2
     
     // add job1 as a dependency for job3
     
     // add job3 as a dependency for job4
     
     
     // ------------------------
  	 // The Job Controller
  	 // ------------------------
     
     // create a job controller object
     
     // add ControlledJob1 to the controller
	 // add ControlledJob2 to the controller
	 // add ControlledJob3 to the controller
	 // add ControlledJob4 to the controller
     
     // Run the controller
  }
}
