package io.human.networks.service;

import io.human.networks.service.impl.SchoolServiceImpl;
import io.human.networks.service.vo.SchoolVo;
import io.human.networks.util.RestUtils;
import io.human.networks.util.mapper.RestMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
public class SchoolServiceMockTest {

    @Test
    public void getSchool() {
        SchoolService schoolService = new SchoolServiceImpl(new MockRestUtils());

        Map<String, String> paramQuery = new HashMap<>();
        paramQuery.put("name", "문정");
        paramQuery.put("pIndex", "1");
        paramQuery.put("pSize", "50");

        SchoolVo schoolVo = schoolService.getSchool(paramQuery);
        log.info(schoolVo.toString());

        assertEquals("9", schoolVo.getListTotalCount());
        assertEquals(9, schoolVo.getSchoolItems().size());

    }

    static class MockRestUtils extends RestUtils {

        public <T> T get(String url, Map<String, String> paramQuery, RestMapper restMapper) {
            String data = null;
            try {
                data = IOUtils.toString(getClass().getResourceAsStream("/sample/schoolData.json"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return (T) new SchoolVo().toSchoolVo(data);
        }
    }
}
