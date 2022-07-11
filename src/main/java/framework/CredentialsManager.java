package framework;

import utils.JSONReader;
import utils.LoggerManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CredentialsManager {
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final String envFilePath = System.getProperty("user.dir") + File.separator + "TLEnvironment.json";
    private static final String usersFilePath = System.getProperty("user.dir") + File.separator + "TLUser.json";
    private static final String apiFilePath = System.getProperty("user.dir") + File.separator + "TLRestAPI.json";
    private static CredentialsManager instance;

    private Map<String, HashMap<String, Object>> users;

    private String envId;
    private String baseURL;
    private String basePath;
    private String projectsEndpoint;
    private String projectByIdEndpoint;

    private CredentialsManager() {
        initialize();
    }

    private void initialize() {
        log.info("Reading credentials");
        String tlEnvironmentId = System.getProperty("envId");
        if ((tlEnvironmentId == null)||(tlEnvironmentId.isEmpty())) {
            envId = "QA01";
        } else {
            envId = tlEnvironmentId;
        }
        log.info("Todo.ly Environment Id --> " + envId);

        JSONReader envReader = new JSONReader(envFilePath);
        JSONReader usersReader = new JSONReader(usersFilePath);
        JSONReader apiReader = new JSONReader(apiFilePath);

        baseURL = envReader.getString("Environments.envId.baseURL".replace("envId", envId));
        users = usersReader.getMap("Users");
        basePath = apiReader.getString("API.basePath");
        projectsEndpoint = apiReader.getString("API.projectsEndpoint");
        projectByIdEndpoint = apiReader.getString("API.projectByIdEndpoint");
    }

    public static CredentialsManager getInstance() {
        if (instance == null) {
            instance = new CredentialsManager();
        }
        return  instance;
    }

    public String getEnvId() {
        return envId;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getProjectsEndpoint() {
        return projectsEndpoint;
    }

    public String getProjectByIdEndpoint() {
        return projectByIdEndpoint;
    }

    public String getUserName(String userType) {
        return (String) users.get(userType).get("userName");
    }

    public String getPassword(String userType) {
        return (String) users.get(userType).get("password");
    }
}
