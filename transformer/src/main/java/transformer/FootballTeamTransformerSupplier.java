package transformer;

import org.apache.kafka.common.record.Record;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.kstream.TransformerSupplier;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueIterator;

import java.time.Duration;

public class FootballTeamTransformerSupplier implements TransformerSupplier<String, String, KeyValue<String, String>> {
    @Override
    public Transformer<String, String, KeyValue<String, String>> get() {
        return new Transformer<String, String, KeyValue<String, String>>(){

            @Override
            public void init(ProcessorContext context) {
            }

            @Override
            public KeyValue<String, String> transform(String key, String value) {
                System.out.println("Transform --------------------> key:" + key + ", value:" + value);
                return KeyValue.pair(key, value);
            }

            @Override
            public void close() {

            }
        };

    }
}
