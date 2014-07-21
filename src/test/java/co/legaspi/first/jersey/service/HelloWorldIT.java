/*
The MIT License (MIT)

Copyright (c) 2014 legaspi.co

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package co.legaspi.first.jersey.service;

import com.sun.jersey.api.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloWorldIT {
    private final Logger LOG = LogManager.getLogger(getClass());

    private static final int HTTP_PORT = 58080;
    private static final String LOCALHOST = "localhost";
    private static final String PATH = "/hello";
    private static final String FULL_PATH = "http://" + LOCALHOST + ":" + HTTP_PORT + PATH;

    private Client client;
    private String result = "";

    @Before
    public void setup() {
        client = Client.create();
    }

    @Test
    public void plainGet() {
        result = client
                .resource(FULL_PATH)
                .get(String.class);

        LOG.info("result: " + result);

        assertThat(result).contains("Hello, World!");
    }
}
