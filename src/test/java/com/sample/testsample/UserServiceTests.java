package com.sample.testsample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class UserServiceTests {
    @Test
    public void 年齢算出のテスト() {
        // Mockの作成
        DateUtils dateUtils = Mockito.mock(DateUtils.class);
        Mockito.when(dateUtils.getNowDate()).thenReturn(LocalDate.of(2021, 1, 11));

        UserService service = new UserService(null, dateUtils);
        LocalDate date = LocalDate.of(2000, 01, 01);
        Long age = service.calcAge(date);
        Assertions.assertEquals(21l, age);
    }

    @Test
    public void ユーザエンティティ作成のテスト() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Mockの作成
        DateUtils dateUtils = Mockito.mock(DateUtils.class);
        Mockito.when(dateUtils.getNowDate()).thenReturn(LocalDate.of(2021, 1, 11));
        // reflection で private メソッドを取得
        UserService service = new UserService(null, dateUtils);
        Method method = service.getClass().getDeclaredMethod("makeUserEntity", String.class, LocalDate.class);
        method.setAccessible(true);
        UserEntity entity = (UserEntity) method.invoke(service, "Richter", LocalDate.of(2000, 1, 1));
        // 結果の比較
        Assertions.assertEquals(null, entity.getId());
        Assertions.assertEquals("Richter", entity.getName());
        Assertions.assertEquals(21l, entity.getAge());
    }
}
