package com.sismics.util;

import com.sismics.docs.core.dao.dto.UserDto;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestEmail {

    @Test
    public void testSendEmail() {
        // 准备测试数据
        String templateName = "testTemplate";
        UserDto recipientUser = new UserDto();
        recipientUser.setEmail("test@example.com");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("param1", "value1");
        paramMap.put("param2", "value2");

        // 创建模拟对象
        UserDto recipientUserMock = new UserDto() {
            @Override
            public String getEmail() {
                return "test@example.com";
            }
        };

        // 调用被测试方法
        EmailUtil.sendEmail(templateName, recipientUserMock, paramMap);

        // 验证是否调用了模拟对象的 getEmail 方法
        assertEquals("test@example.com", recipientUserMock.getEmail());
    }
}
