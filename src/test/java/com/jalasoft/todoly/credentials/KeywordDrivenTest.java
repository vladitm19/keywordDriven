package com.jalasoft.todoly.credentials;

import entities.Project;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordDrivenTest {

    @Test
    public void getProjectById() throws Exception {
        String path = "src/test/resources/excel/projects/TestCase.xlsx";
        ExcelReader.setExcelFile(path, "Hoja1");
        Project project = null;
        List<String> jsonAsMap = new ArrayList<>();
        jsonAsMap.add(ExcelReader.getCellData(1,1));
        jsonAsMap.add(ExcelReader.getCellData(2,1));
        jsonAsMap.add(ExcelReader.getCellData(3,1));
        jsonAsMap.add(ExcelReader.getCellData(4,1));
        jsonAsMap.add(ExcelReader.getCellData(5,1));
        for (String data : jsonAsMap) {

        }

        for (int i = 1; i <= 5; i++) {
            String sActions = ExcelReader.getCellData(i, 1);
            System.out.println(sActions);
            if (sActions.equals("baseUri")) {
                Actions.baseUri();
            } else if (sActions.equals("basePath")) {
                Actions.basePath();
            } else if (sActions.equals("endpoint")) {
                Actions.endpoint();
            } else if (sActions.equals("request")) {
                Actions.request();
            } else if (sActions.equals("obtainProject")) {
                project = Actions.obtainProject();
            }
        }
        Assert.assertEquals(project.getId().toString(), "3998272", "Id value is incorrect");
        Assert.assertEquals(project.getContent(), "Work", "Id value is incorrect");
    }
}
