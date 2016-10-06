/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.jersey;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class Endpoint {

    private final Service service;

    public Endpoint(Service service) {
        this.service = service;
    }

    @GET
    public String message() {
        return "Hello " + this.service.message();
    }

    @PUT
    @Path("/first")
    @Consumes(value = MediaType.APPLICATION_XML)
    public String createFirst(@Valid FirstRequest request) {
        return "Hello " + this.service.message();
    }

    @PUT
    @Path("/second")
    @Consumes(value = MediaType.APPLICATION_XML)
    public String createSecond(SecondRequest request) {
        return "Hello " + this.service.message();
    }

}
