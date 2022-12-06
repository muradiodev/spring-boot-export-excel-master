package com.techgeeknext.controller;

import com.techgeeknext.model.Users;
import com.techgeeknext.repository.UserRepository;
import com.techgeeknext.util.ExcelGeneratorUtility3;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController2 {


    public final UserRepository userRepository;

    @GetMapping("/excel1/")
    public void exportIntoExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=records_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Users> listOfRecords = userRepository.findAll();

        ExcelGeneratorUtility3 generator = new ExcelGeneratorUtility3(listOfRecords);

        generator.generate(response);
    }

}