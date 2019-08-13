package com.trilogyed.commentqueueconsumer.util.messages;

import com.trilogyed.commentqueueconsumer.CommentQueueConsumerApplication;
import com.trilogyed.commentqueueconsumer.util.messages.CommentListEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

@RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
public CommentListEntry createComment(CommentListEntry com) {
        System.out.println(com.toString());
        return com;
        }
        }