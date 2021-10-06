package dgg;


import com.github.javafaker.Faker;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;


@WireMockTest
public class mocktests extends mockbuilder{
    String BASEURL = "https://reqres.in",
            getuser = "/api/users/2",
            postdata = "/api/users";

    WireMock wm = new WireMock("https", "qadgg001.mocklab.io", 443);

    protected static WireMockTest testClient;
    Faker faker = new Faker();

//   // void test_something_with_wiremock(WireMockRuntimeInfo wmRuntimeInfo) {
//        // The static DSL will be automatically configured for you
//        stubFor(get("/static-dsl").willReturn(WireMock.ok()));
//
//        // Info such as port numbers is also available
//        int port = wmRuntimeInfo.getHttpPort();
//
//        // Do some testing...
//    }

    @Test
    public void headerMatching() {
        stubFor(post(urlEqualTo(BASEURL+postdata))
                .withHeader("name", equalTo(faker.name().firstName()))
                .withHeader("job", equalTo(faker.job().field()))
                .willReturn(aResponse()
                .withStatus(201)
                .withHeader("name", "application/json")
                .withHeader("Etag", "b13894794wb")));}



    // Configure a stub
    @Test
    public void somequerry() {
        stubFor(get(urlEqualTo("https://qadgg001.mocklab.io/api/users/2"))
                .willReturn(aResponse().withStatus(200).
                                withHeader("Matched-Stub-Name", "get contact info").
                        withBody("{\"id\": \"2\"}")));}

    @Test
    public void someNewQuerry() {
            stubFor(get(urlEqualTo("https://qadgg001.mocklab.io/api/users/2"))
            .withHeader("Accept", matching("application/json"))
            .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")
                .withBody("{\"serviceStatus\": \"running\"}")));}

//    @Test
//    public void exactUrlOnly() {
//        stubFor(get(urlEqualTo("/some/thing"))
//                .willReturn(aResponse()
//                        .withHeader("Content-Type", "text/plain")
//                        .withBody("Hello world!")));
//
//        assertThat(testClient.get("/some/thing").statusCode(), is(200));
//        assertThat(testClient.get("/some/thing/else").statusCode(), is(404));
//    }
//
//    public static void getResponseHeaders(){
//        System.out.println("The headers in the response "+
//                get("https://qadgg001.mocklab.io/hello-world").then().extract()
//                        .headers());
//    }

}
//{
//    "data": {
//        "id": 2,
//        "email": "janet.weaver@reqres.in",
//        "first_name": "Janet",
//        "last_name": "Weaver",
//        "avatar": "https://reqres.in/img/faces/2-image.jpg"
//    },
//    "support": {
//        "url": "https://reqres.in/#support-heading",
//        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
//
//    {
//    "name": "morpheus",
//    "job": "leader"
//}
//    }{
//    "name": "morpheus",
//    "job": "leader",
//    "id": "207",
//    "createdAt": "2021-10-06T18:56:57.718Z"
//}
//}
