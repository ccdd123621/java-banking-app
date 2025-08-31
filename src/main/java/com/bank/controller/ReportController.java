package com.bank.controller;

import com.bank.entity.User;
import com.bank.entity.Branch;
import com.bank.entity.BankTransaction;
import com.bank.repository.UserRepository;
import com.bank.repository.BranchRepository;
import com.bank.repository.BankTransactionRepository;
import com.bank.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BranchRepository branchRepo;

    @Autowired
    private BankTransactionRepository transactionRepo;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/report/users")
    public ResponseEntity<byte[]> userReport() {
        List<User> users = userRepo.findAll();
        ByteArrayInputStream bis = reportService.generateUserReport(users);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=users.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bis.readAllBytes());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/report/branches")
    public ResponseEntity<byte[]> branchReport() {
        List<Branch> branches = branchRepo.findAll();
        ByteArrayInputStream bis = reportService.generateBranchReport(branches);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=branches.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bis.readAllBytes());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/report/transactions")
    public ResponseEntity<byte[]> transactionReport() {
        List<BankTransaction> txs = transactionRepo.findAll();
        ByteArrayInputStream bis = reportService.generateTransactionReport(txs);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=transactions.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bis.readAllBytes());
    }
}
