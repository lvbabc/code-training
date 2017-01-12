package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zx.soft.utils.http.HttpClientDaoImpl;
import zx.soft.utils.time.TimeUtils;

public class FromSolr {

	private static final String BASE_URL = "http://192.168.32.13:5920/sentiment/search?q=";
	private static Logger logger = LoggerFactory.getLogger(FromSolr.class);
	private static File file;

	public static void main(String[] args) throws ParseException, IOException {
		FromSolr indexFromSolr = new FromSolr();
		indexFromSolr.run();
	}

	private void run() throws ParseException, IOException {

		for (int num = 98; num < 101; num++) {
			file = new File("src/main/resources/" + num + ".txt");
			creatFile(file);
			int count = 10000;
			long now = TimeUtils.getZeroHourTime(System.currentTimeMillis());
			for (int timeNum = 0; timeNum < 10; timeNum++) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				long endTime = TimeUtils.transCurrentTime(now, 0, 0, 0, -timeNum);
				long startTime = TimeUtils.transCurrentTime(now, 0, 0, 0, -timeNum - 1);
				//
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append(BASE_URL + "*:*&start=" + 0 + "&rows=" + count + "&fq=timestamp:"
						+ URLEncoder.encode("[", "utf-8") + TimeUtils.transToSolrDateStr(startTime)
						+ URLEncoder.encode(" ", "utf-8") + "TO" + URLEncoder.encode(" ", "utf-8")
						+ TimeUtils.transToSolrDateStr(endTime) + URLEncoder.encode("]", "utf-8"));
				String response = new HttpClientDaoImpl().doGet(sBuilder.toString());

				JSONObject obj = JSONObject.fromObject(response);
				JSONArray jsonArray = obj.getJSONArray("results");
				logger.info(Integer.toString(jsonArray.size()));
				for (int j = 0; j < jsonArray.size(); j++) {
					JSONObject info = jsonArray.getJSONObject(j);
					writer.write(info.toString());
					writer.write("\r\n");
				}
				writer.close();
			}
		}
	}

	//创建新文件
	private void creatFile(File file) {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
