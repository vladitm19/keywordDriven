package com.jalasoft.todoly.credentials;

import api.APIManager;
import entities.Project;
import framework.Environment;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;

public class Actions {
    private static final Environment environment = Environment.getInstance();
    private static Response response;

    public static void baseUri() {
        RestAssured.baseURI = environment.getBaseURL();
    }

    public static void basePath() {
        RestAssured.basePath = environment.getBasePath();
    }

    public static void endpoint() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(environment.getUserName());
        authScheme.setPassword(environment.getPassword());
        RestAssured.authentication = authScheme;
    }

    public static void request() {
        String projectByIdEndpoint = environment.getProjectByIdEndpoint().replace("%d", "3998272");
        response = RestAssured.given().get(projectByIdEndpoint);
    }

    public static Project obtainProject() {
        Project responseProject = response.as(Project.class);
        return responseProject;
    }
}
