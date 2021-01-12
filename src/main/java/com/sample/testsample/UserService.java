package com.sample.testsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class UserService {
    private final DateUtils dateUtils;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository
        , DateUtils dateUtils) {
        this.userRepository = userRepository;
        this.dateUtils = dateUtils;
    }

    public void addUser(String name, LocalDate birthday) {
        // User entity の作成
        UserEntity entity = makeUserEntity(name, birthday);
        // 保存
        userRepository.save(entity);
    }

    private UserEntity makeUserEntity(String name, LocalDate birthday) {
        // User entity の作成
        UserEntity entity = new UserEntity();
        entity.setName(name);
        // 年齢の算出・設定
        entity.setAge(calcAge(birthday));
        return entity;
    }

    public Long calcAge(LocalDate birthday) {
        Long age = ChronoUnit.YEARS.between(birthday, dateUtils.getNowDate());
        return age;
    }
}
