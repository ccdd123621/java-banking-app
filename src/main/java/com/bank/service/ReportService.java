package com.bank.service;

import com.bank.entity.User;
import com.bank.entity.Branch;
import com.bank.entity.BankTransaction;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportService {

    public ByteArrayInputStream generateUserReport(List<User> users) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph title = new Paragraph("User Report");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(3);
            table.addCell("ID");
            table.addCell("Username");
            table.addCell("Roles");

            for (User user : users) {
                table.addCell(String.valueOf(user.getUserId()));
                table.addCell(user.getUsername());
                table.addCell(user.getRoles().toString());
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generateBranchReport(List<Branch> branches) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph title = new Paragraph("Branch Report");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(3);
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Address");

            for (Branch branch : branches) {
                table.addCell(String.valueOf(branch.getBranchId()));
                table.addCell(branch.getBranchName());
                table.addCell(branch.getBranchAddress());
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generateTransactionReport(List<BankTransaction> transactions) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph title = new Paragraph("Transaction Report");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.addCell("ID");
            table.addCell("From Account");
            table.addCell("To Account");
            table.addCell("Amount");

            for (BankTransaction tx : transactions) {
                table.addCell(String.valueOf(tx.getBankTransactionId()));
                table.addCell(String.valueOf(tx.getBankTransactionFromAccount()));
                table.addCell(String.valueOf(tx.getBankTransactionToAccount()));
                table.addCell(String.valueOf(tx.getAmount()));
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
