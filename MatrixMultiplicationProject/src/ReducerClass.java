import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class ReducerClass extends MapReduceBase implements Reducer<Text, Text, Text, Text> {

	@Override
	public void reduce(Text key, Iterator<Text> value, OutputCollector<Text, Text> output, Reporter reporter)
			throws IOException {
		// TODO Auto-generated method stub

		int sum = 0;

		int row = 0, col = 0, val = 0;
		
		String whichMatrix = "";

		int[] a = new int[3];
		int[] b = new int[3];

		while (value.hasNext()) {

			String[] input = value.next().toString().split(",");

			int counter = 0;

			for (String item : input) {

				if (counter == 0) {

					whichMatrix = item.toString().trim();

				}

				if (counter == 1) {

					row = Integer.parseInt(item.toString().trim());

				}

				if (counter == 2) {

					col = Integer.parseInt(item.toString().trim());
				}

				if (counter == 3)
					val = Integer.parseInt(item.trim());

				counter++;

			}

			if (whichMatrix.equals("a")) {

				a[col] = val;
				
			}

			if (whichMatrix.equals("b")) {

				b[row] = val;

			}

		}

		for (int i = 0; i < a.length; i++) {

			sum += (a[i] * b[i]);

			//output.collect(key, new Text(a[i] + "," + b[i] + "," + sum));
		}
		// output.collect(key, new Text(a.size()+","+b.size()));
		 //output.collect(key, new Text(whichMatrix + "," + row + "," + col + " = " + sum));
	
		output.collect(key, new Text(String.valueOf(sum)));
		
	}
}