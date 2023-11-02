package com.cycbersoft.demospringboot03.controller;

import com.cycbersoft.demospringboot03.payload.request.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
*   Để định nghĩa đường dẫn, có 2 annatation:
*       @Controller: Khi url có nội dung trả ra là 1 file html
*       @ResponseBody: Giúp @Controller có thể trả ra data kiểu String để viết API
*
*   @Restcontroller: Là sự kết hợp của @Controller và @ResponseBody => Viết API
* */
@RestController
@RequestMapping("/hello")
public class HelloController {


    // Trong SpringBoot, ko phân biệt phương thức, thì sẽ có 4 phương thức truyền tham số:
    // Tham số truyền trên trình duyệt (truyền qua URL): dùng @RequestParam
    // Tham số truyền ngầm (truyền qua form ): dùng @RequestParam
    // Tham số đóng vai trò như là một đường dẫn: dùng @PathVariable (vd: localhost/hello/daocongphu) (ko su dung ?hoten=daocongphu)
    // Tham số ngầm là đồi tượng: dùng @RequestBody

    // Tuân thủ nguyên tắc RESTFUL: Get thì ko dc truyền ngầm, phải truyền qua URL


    // 3 trường hợp liên quan đến bad request 400:
    //  URL có định nghĩa tham số nhưng user ko truyen tham so vào
    //  co truyen nhu sai ten tham so
    //  dung ten tham so nhung sai kieu du lieu

    // POST MAN
    // Truyền tham so tren trinh duyet thi chon tab Param
    // Truyền ngầm tham so thi chon tab Body


    // Method: POST, truyền ngầm có các dạng:
    // Form data: cho phép truyền ngầm, có hỗ trợ truyền file
    // x-www-form-urlencoded: cho phép truyền ngầm ko hỗ trợ truyền file
    // raw: hỗ trợ truyền ngầm 1 đối tượng
    @GetMapping("")
    public String hello(@RequestParam String hoten, @RequestParam int tuoi){
        return "Hello SpringBoot "+hoten +" - tuoi: " + tuoi;
    }

    @PostMapping("/cycbersoft")
    public String helloCycbersoft(@RequestBody LoginRequest loginRequest){
        return "Hello Cycbersoft "+loginRequest.getUsername() +" - " + loginRequest.getPassword();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        return new ResponseEntity<>("Update "+id, HttpStatus.OK);
    }

/*    @PutMapping("/update/{id}")
    public String update(@PathVariable LoginRequest id){
        return "Update "+id.getUsername();
    }*/

}
