package br.com.bpaixao.bpmoney.api.exception;

import com.google.common.base.Preconditions;

import java.io.Serializable;

import static com.google.common.base.Preconditions.*;

public class MessageException implements Serializable {


    private static final long serialVersionUID = 1261102228532848250L;

    private String messageUser;
    private String messageDeveloper;

    private MessageException(String messageUser, String messageDeveloper) {
        this.messageUser = messageUser;
        this.messageDeveloper = messageDeveloper;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public String getMessageDeveloper() {
        return messageDeveloper;
    }

    public static MessageException of(String messageUser, String messageDeveloper) {
        checkNotNull(messageUser);
        checkNotNull(messageDeveloper);
        return new MessageException(messageUser, messageDeveloper);
    }


}
