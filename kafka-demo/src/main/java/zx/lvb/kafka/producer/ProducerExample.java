package zx.lvb.kafka.producer;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.lvb.kafka.utils.CheckSumUtils;
import zx.lvb.kafka.utils.KafkaConfig;

public class ProducerExample {
	private static Logger logger = LoggerFactory.getLogger(ProducerExample.class);

	public static void main(String args[]) throws InterruptedException, ExecutionException {

		KafkaProducer<String, String> producer = KafkaConfig.getProducer();
		long start = System.currentTimeMillis();
		boolean sync = false;
		String topic = "test2";
		int i = 100000;
		for (; i < 200000; i++) {
			if (i % 100 == 0) {
				logger.info("i = " + i);
			}
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic,
					CheckSumUtils.getMD5(i + ""));
			if (sync) {
				producer.send(producerRecord).get();
			} else {
				producer.send(producerRecord);
			}
		}
		producer.close();
		logger.info("Push " + i + " 　条数据,耗时为" + (System.currentTimeMillis() - start));
	}
}