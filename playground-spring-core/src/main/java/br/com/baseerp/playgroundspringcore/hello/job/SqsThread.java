package br.com.baseerp.playgroundspringcore.hello.job;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;
import java.util.UUID;

@Component
public class SqsThread {

    private static final Logger log = LoggerFactory.getLogger(SqsThread.class);
    public static final String QUEUE_URL = "https://sqs.us-east-1.amazonaws.com/788758514985/QueueTestBruna.fifo";
    private final SqsClient sqsClient;
    private final String messageUuid = UUID.randomUUID().toString();



    public SqsThread(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @Scheduled(fixedDelay = 1000)
    public void sendMessage() {
        SendMessageResponse sendMessageResponse = sqsClient.sendMessage(SendMessageRequest.builder()
                        .queueUrl(QUEUE_URL)
                        .messageBody("Mensagem " + messageUuid)
                        .messageGroupId(UUID.randomUUID().toString())
                        .messageDeduplicationId(UUID.randomUUID().toString())
                .build());

        log.debug("Message sent with ID: {}", sendMessageResponse.toString());
    }

    @SqsListener(value = QUEUE_URL, maxMessagesPerPoll = "10")
    public void receive(String messageBody) {
        log.debug(messageBody);
    }

    // @Scheduled(fixedDelay = 1000)
    public void run() {
        ReceiveMessageResponse receiveMessageResponse = sqsClient.receiveMessage(ReceiveMessageRequest.builder()
                .maxNumberOfMessages(10)
                .queueUrl(QUEUE_URL)
                .waitTimeSeconds(20)
                .build());

        receiveMessageResponse.messages().forEach(this::processMessage);
    }

    private void processMessage(Message message) {
        log.debug(message.body());

        sqsClient.deleteMessage(b -> b
                .queueUrl(QUEUE_URL)
                .receiptHandle(message.receiptHandle()));
    }
}
