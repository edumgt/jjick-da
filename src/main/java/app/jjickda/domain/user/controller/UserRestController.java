package app.jjickda.domain.user.controller;

import app.jjickda.domain.common.dto.response.DefaultResultDto;
import app.jjickda.domain.user.dto.request.EmailDuplicationDto;
import app.jjickda.domain.user.dto.request.LoginDto;
import app.jjickda.domain.user.dto.request.SignUpDto;
import app.jjickda.domain.user.dto.response.User;
import app.jjickda.domain.user.service.UserService;
import app.jjickda.global.config.model.ApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation("이메일 중복 체크 API")
    @PostMapping("/email-duplication")
    public ResponseEntity<ApiResponse<DefaultResultDto>> emailDuplicationCheck(@Validated @RequestBody EmailDuplicationDto emailDuplicationDto) {
        return ResponseEntity.ok(new ApiResponse<>(userService.emailDuplicationCheck(emailDuplicationDto)));
    }

    @ApiOperation("회원가입, 계정생성 API")
    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse<DefaultResultDto>> signUp(@Validated @RequestBody SignUpDto signUpDto) {
        return ResponseEntity.ok(new ApiResponse<>(userService.signUp(signUpDto)));
    }

    @ApiOperation("로그인 API")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<DefaultResultDto>> login(@Validated @RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(new ApiResponse<>(userService.login(loginDto)));
    }

    @ApiOperation("로그아웃 API")
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<DefaultResultDto>> login() {
        return ResponseEntity.ok(new ApiResponse<>(userService.logout()));
    }

    @ApiOperation("내 정보 조회 API")
    @PostMapping("/my-info")
    public ResponseEntity<ApiResponse<User>> myInfo() {
        return ResponseEntity.ok(new ApiResponse<>(userService.myInfo()));
    }

}
