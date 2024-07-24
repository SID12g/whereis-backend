package com.sid12g.whereis.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthRepository authRepository;

    @PostMapping("/register")
    @ResponseBody
    public String Register(@RequestBody FormData formData) {
        if(formData.getUsername() == null || formData.getPassword() == null || formData.getGrade() == null || formData.getClassroom() == null || formData.getNumber() == null) {
            return "need more data";
        } else {
            try {
                Auth auth = new Auth();
                auth.setUsername(formData.getUsername());
                auth.setPassword(formData.getPassword());
                auth.setGrade(formData.getGrade());
                auth.setClassroom(formData.getClassroom());
                auth.setNumber(formData.getNumber());
                authRepository.save(auth);
                return auth.toString();
            } catch (Exception error){
                return error.getMessage();
            }
        }
    }

    // FormData 클래스 정의
    public static class FormData {
        private String username;
        private String password;
        private Integer grade;
        private Integer classroom;
        private Integer number;

        // getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Integer getGrade() {
            return grade;
        }

        public void setGrade(Integer grade) {
            this.grade = grade;
        }

        public Integer getClassroom() {
            return classroom;
        }

        public void setClassroom(Integer classroom) {
            this.classroom = classroom;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }
}
