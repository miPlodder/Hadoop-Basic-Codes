import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class ReducerTemperature extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
			Reporter reporter) throws IOException {
		
		int temp = 0;
		int count = 0;

		while (values.hasNext()) {
			int current = values.next().get();
			temp += current;
			count += 1;

		}
		
		output.collect(key, new IntWritable(temp / count));

	}

}
