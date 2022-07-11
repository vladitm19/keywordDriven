package com.jalasoft.todoly.credentials;

import framework.CredentialsManager;
import org.testng.annotations.Test;

public class CredentialsTests {
    private static final CredentialsManager credentialsManager = CredentialsManager.getInstance();

    @Test
    public void credentialsTest() {
        System.out.println(credentialsManager.getEnvId());
        /*System.out.println(credentialsManager.getBaseURL());
        System.out.println(credentialsManager.getBasePath());
        System.out.println(credentialsManager.getProjectsEndpoint());
        System.out.println(credentialsManager.getProjectByIdEndpoint().replace("[id]", "3281567"));
        System.out.println(credentialsManager.getUserName("validUser"));
        System.out.println(credentialsManager.getPassword("validUser"));
        System.out.println(credentialsManager.getUserName("invalidUser"));
        System.out.println(credentialsManager.getPassword("invalidUser"));*/
    }
}
