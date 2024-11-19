package info.dmerej.stubs;

import info.dmerej.HttpClient;
import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.mailprovider.SendMailResponse;

public class HttpClientStub implements HttpClient {
    private SendMailRequest sendMailRequest;
    private SendMailResponse firstSendMailResponse;

    private boolean retry;
    private boolean nextShouldFail = false;

    @Override
    public SendMailResponse post(String url, Object request) {
        if(this.sendMailRequest != null) {
            retry = true;
        }

        this.sendMailRequest = (SendMailRequest) request;
        if(!retry) {
            this.firstSendMailResponse = new SendMailResponse(200, "success");
        }

        if(this.nextShouldFail) {
            this.nextShouldFail = false;
            this.firstSendMailResponse = new SendMailResponse(503, "error");
        }

        return this.firstSendMailResponse;
    }

    public SendMailRequest getSendMailRequest() {
        return sendMailRequest;
    }

    public SendMailResponse getFirstSendMailResponse() {
        return firstSendMailResponse;
    }

    public boolean getRetry() {
        return this.retry;
    }

    public void makeNextFail() {
        this.nextShouldFail = true;
    }
}
