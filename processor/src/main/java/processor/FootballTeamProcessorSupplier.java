package processor;

import org.apache.kafka.common.record.Record;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.TransformerSupplier;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueIterator;

import java.time.Duration;

public class FootballTeamProcessorSupplier implements ProcessorSupplier<String, String> {
    @Override
    public Processor<String, String> get() {
        return new Processor<String, String>() {
            private ProcessorContext context;
            @Override
            public void init(ProcessorContext context) {
                this.context = context;
            }

            @Override
            public void process(String key, String value) {
                System.out.println(key + "-------" + value);
                context.forward(key, value);
            }

            @Override
            public void close() {

            }
        };
    }
}
