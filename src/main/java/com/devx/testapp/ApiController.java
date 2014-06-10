package com.devx.testapp;

import spark.Request;
import spark.Response;
import spark.Route;
import java.sql.SQLException;
import javax.inject.Inject;

import static spark.Spark.*;

public class ApiController {

    @Inject DbMysql dbMysql;

    public void createRoutes() {
        get(new Route("/api/echo/:name") {
            @Override
            public Object handle(Request request, Response response) {
                return request.params(":name");
            }
        });

        //Return the user's IP
        //TODO: Figure out how to handle ../my_IP in the same call
        get(new Route("/api/my_ip/:format") {
            @Override
            public Object handle(Request request, Response response) {
                if (request.params(":format").equals("json")) {
                    return "{\"ip\":\"" + request.ip() + "\"}";
                } else {
                    halt(415, "Content type not valid");
                    return null;
                }
            }
        });

        //Add a service to check
        put(new Route("/service/add") {
            @Override
            public Object handle(Request request, Response response) {
                if (request.contentType().equals("application/json")) {
                    response.type("application/json");
                    return request.body();
                } else {
                    halt(415, "Content type not valid");
                    return null;
                }

            }
        });

        delete(new Route("/service/delete") {
            @Override
            public Object handle(Request request, Response response) {
                if (request.contentType().equals("application/json")) {
                    response.type("application/json");
                    return request.body();
                } else {
                    halt(415, "Content type not valid");
                    return null;
                }

            }
        });

        //The service to check
        get(new Route("/service/test/:name") {
            @Override
            public Object handle(Request request, Response response) {
                return request.params(":name");
            }
        });

        //check the mysql version
        get(new Route("/mysql/version") {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    return dbMysql.getMySqlVersion();
                } catch (SQLException e) {
                    return "Something Went Wrong!!";
                }
            }
        });


    }
}
