package com.minglemingle.chat2mingle.report.controller;

import com.minglemingle.chat2mingle.report.service.ReportService;
import com.minglemingle.chat2mingle.report.vo.ReportVO;
import com.minglemingle.chat2mingle.wishlist.vo.WishlistVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/createReport")
    @ResponseBody
    public ResponseEntity<Boolean> postNewReportFromUser(@RequestBody ReportVO reportVO){
        System.out.println(reportVO);
        boolean result = reportService.createNewReport(reportVO);
        return ResponseEntity.ok(result);
    }
}
