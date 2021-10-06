package dgg;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.client.WireMockBuilder;
import com.github.tomakehurst.wiremock.http.HttpHeader;
import com.github.tomakehurst.wiremock.security.ClientAuthenticator;
import org.junit.jupiter.api.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import java.util.Collections;
import java.util.List;

public class mockbuilder {

    // Create a WireMock client instance to talk to this API
    WireMock wm = new WireMockBuilder()
            .scheme("https")
            .host("qadgg001.mocklab.io")
            .port(443)
            .authenticator(new ClientAuthenticator() {
                @Override
                public List<HttpHeader> generateAuthHeaders() {
                    return Collections.singletonList(new HttpHeader("Authorization", "Token 9b7fa6142d16c77cc442e7fcd2403ec3"));
                }
            })
            .build();

}
