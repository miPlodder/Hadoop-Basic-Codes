import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class MapperTemperature extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	public static final int MISSING = 9999;

	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {

		String line = value.toString();
		String year = line.substring(0, 4);
		int temperature = Integer.parseInt(line.substring(4, 6));
		String quality = line.substring(6, 8);

		output.collect(new Text(year), new IntWritable(temperature));

	}

}
