import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Driver extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		
		JobConf conf = new JobConf(getConf(), Driver.class);
		conf.setJobName("Driver");

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);

		conf.setMapperClass(MapperClass.class);
		conf.setReducerClass(ReducerClass.class);

		Path inputData = new Path(args[0]);
		Path outputData = new Path(args[1]);

		FileInputFormat.addInputPath(conf, inputData);
		FileOutputFormat.setOutputPath(conf, outputData);
		
		
		
		// running the task here
		JobClient.runJob(conf);

		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		
		int res = ToolRunner.run(new Configuration(), new Driver(), args);
		System.exit(res);
		
	}

}
