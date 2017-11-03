import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MapperClass extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {

		int x = 4; //row of a
		int y = 4; //col of a, row of b
		int z = 4; //col of b

		String[] input = value.toString().split(",");

		String matrix = "", row = "", col = "";
		int counter = 0;

		for (String item : input) {

			if (counter == 0)
				matrix = item.trim();

			if (counter == 1)
				row = item.trim();

			if (counter == 2)
				col = item.trim();

			counter++;

		}

		if (matrix.equals("a")) {

			for (int i = 0; i < z; i++) {

				output.collect(new Text(row + "," + i), value);
			}
		}

		if (matrix.equals("b")) {

			for (int i = 0; i < x; i++) {

				output.collect(new Text(i + "," + col), value);
			}
		}
	}

}
