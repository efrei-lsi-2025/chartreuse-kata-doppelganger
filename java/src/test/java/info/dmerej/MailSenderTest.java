package info.dmerej;

import info.dmerej.mailprovider.SendMailRequest;
import info.dmerej.stubs.HttpClientStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MailSenderTest {
    @Test
    void should_make_a_valid_http_request() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV1()
        // Given
        HttpClientStub httpClientStub = new HttpClientStub();
        MailSender mailSender = new MailSender(httpClientStub);
        User user = new User("test", "test@test.com");
        String message = "plop";

        // When
        mailSender.sendV1(user, message);

        // Then
        SendMailRequest request = new SendMailRequest("test@test.com", "New notification", "plop");
        Assertions.assertEquals(request, httpClientStub.getSendMailRequest());
        Assertions.assertEquals(200, httpClientStub.getFirstSendMailResponse().code()); // Optional but we're talking about a "valid" http request
    }

    @Test
    void should_retry_when_getting_a_503_error() {
        // TODO: write a test to demonstrate the bug in MailSender.sendV2()
    }
}
