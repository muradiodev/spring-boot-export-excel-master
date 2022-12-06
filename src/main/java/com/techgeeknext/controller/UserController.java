package com.techgeeknext.controller;

import com.techgeeknext.repository.UserRepository;
import com.techgeeknext.util.ExcelGeneratorUtility2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class UserController {


    public final UserRepository userRepository;


    @GetMapping("/excel")
    public void employeeDetailsReport(HttpServletResponse response) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String headerVal = "attachment; filename=employee_details_" + dateFormat.format(new Date()) + ".xls";
        response.setHeader("Content-Disposition", headerVal);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.getType());

        ExcelGeneratorUtility2.employeeDetailReport(response, userRepository.findAll());
    }
}
