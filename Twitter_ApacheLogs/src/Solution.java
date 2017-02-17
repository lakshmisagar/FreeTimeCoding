import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) throws IOException, ParseException {
		FileInputStream fstream;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, List<String>> minuteMap = new HashMap<String, List<String>>();
		String formatted_Date_Time = null;
		String min = null;
		try {
			fstream = new FileInputStream("apache.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String line = null;
			while ((line = br.readLine()) != null) {
//				System.out.println(line);

				Pattern p = Pattern.compile("\\[([^]]*)\\]");
				Matcher m = p.matcher(line);
				while (m.find()) {
					//System.out.println(m.group(1));

					p = Pattern.compile(Pattern.quote(" "));
					String[] dateNtime = p.split(m.group(1));
					//System.out.println(dateNtime[0]);

					p = Pattern.compile(Pattern.quote(":"));
					String[] parseDateNtime = p.split(m.group(1));
					String date = parseDateNtime[0];
					String hr = parseDateNtime[1];
					min = parseDateNtime[2];

					DateFormat originalFormat = new SimpleDateFormat(
							"dd/MMM/yyyy", Locale.ENGLISH);
					DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date parseed_date = originalFormat.parse(date);
					String formattedDate = targetFormat.format(parseed_date);
					//System.out.println(formattedDate);

					formatted_Date_Time = formattedDate + "T" + hr + ":" + min;
					//System.out.println(formatted_Date_Time);

				}

				// //////////////////////////////////////////////////////
				// data inside quotes
				String[] quotesSplit = line.split("\"");
				//System.out.println("quotesSplit :" + quotesSplit[1]);

				String[] validarr = quotesSplit[2].split(" ");
				String validValue = validarr[1];
				//System.out.println("validValue :" + validValue);

				p = Pattern.compile(Pattern.quote(" "));
				String[] pathFull = p.split(quotesSplit[1]);
				//System.out.println("PATH :" + pathFull[1]);

				p = Pattern.compile(Pattern.quote("?"));
				String[] path = p.split(pathFull[1]);
				//System.out.println(path[0]);

				String key = formatted_Date_Time + " " + path[0];
				//System.out.println(key);
				if (map.containsKey(key)) {
					int count = map.get(key);
					count++;
					map.put(key, count);
				} else {
					map.put(key, 1);
				}

				//System.out.println(map.get(key));
				List<String> list = new ArrayList<String>();
				if (validValue.equals("200")) {
					if (minuteMap.containsKey(formatted_Date_Time)) {
						list = minuteMap.get(formatted_Date_Time);
						list.add(key);
						minuteMap.put(formatted_Date_Time, list);
					} else {
						list.add(key);
						minuteMap.put(formatted_Date_Time, list);
					}
				}

				//System.out.println("minMap: "	+ minuteMap.get(formatted_Date_Time));
			}

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> readList = new ArrayList<String>();
		for (Entry<String, List<String>> entry : minuteMap.entrySet()) {
			readList = entry.getValue();
			Collections.sort(readList);
			HashMap<String, Integer> lastCal = new HashMap<String, Integer>();
			for (String mapKey : readList) {
				if (lastCal.containsKey(mapKey)) {
					int count = lastCal.get(mapKey);
					count++;
					lastCal.put(mapKey, count);
				} else {
					lastCal.put(mapKey, 1);
				}
			}
			for (Entry<String, Integer> entries : lastCal.entrySet()) {
				
				double rawPercent = ( (double)(entries.getValue()) / (double)( map.get(entries.getKey())) ) * 100.00;
				String percentage = String.format("%.2f", rawPercent);
				System.out.println(entries.getKey()+" "+ percentage );
			}
		}

	}
}
