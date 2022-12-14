package com.onpu.web.service.decorator;

import com.onpu.web.api.dto.ProfileReadDto;
import com.onpu.web.api.dto.UserReadDto;
import com.onpu.web.service.interfaces.UserService;
import com.onpu.web.store.entity.UserEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
@Service
public class LoggedUserService implements UserService {

    UserService cachedUserService;

    @Override
    public Optional<UserEntity> findById(String id) {

        log.info("Find User by id: " + id);

        return cachedUserService.findById(id);
    }

    @Override
    public UserEntity getById(String id) {
        log.info("Get user by id: " + id);

        return cachedUserService.getById(id);
    }

    @Override
    public UserReadDto getOauthUser(String id) {
        log.info("Get user by id: " + id);
        return cachedUserService.getOauthUser(id);
    }

    @Override
    public ProfileReadDto getProfile(String userId) {
        return cachedUserService.getProfile(userId);
    }

    @Override
    public List<UserReadDto> getAllUsers() {
        log.info("Search all users");
        return cachedUserService.getAllUsers();
    }

    @Override
    public UserEntity create(UserEntity user) {
        log.info("Save user: " + user.getName() + " id : " + user.getId());
        return cachedUserService.create(user);
    }

    @Override
    public UserEntity uploadAvatar(MultipartFile image, UserEntity user) {
        log.info("Upload image: " + image.getName());
        log.info("User: " + user.getId());
        return cachedUserService.uploadAvatar(image, user);
    }

    @Override
    public Optional<byte[]> findAvatar(String id) {
        log.info("Get image: " + id);
        return cachedUserService.findAvatar(id);
    }

}
