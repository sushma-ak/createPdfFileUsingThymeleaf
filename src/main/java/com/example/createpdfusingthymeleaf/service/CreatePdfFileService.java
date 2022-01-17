package com.example.createpdfusingthymeleaf.service;


import com.example.createpdfusingthymeleaf.model.Student;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@Service
public class CreatePdfFileService {



    public void createPdf() {
        String filePdf = "C:/Users/user/Desktop/PdfFile/SamplePdfFile.pdf";
        ArrayList<Student> studentList = new ArrayList();
        Student s1 = new Student(1,"Sachine","Sachine@gmail.com");
        Student s2 = new Student(2, "Rahul","Rahul@gmail.com");
        studentList.add(s1);
        studentList.add(s2);

        try {
            PdfWriter writer = new PdfWriter(filePdf);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            Paragraph p1 = new Paragraph("Hello Welcome To CS Academy");
            float[] columnWidth = {200f, 200f, 200f};
            Table  table = new Table(columnWidth);
            table.addCell(new Cell().add("ID"));
            table.addCell(new Cell().add("Name"));
            table.addCell(new Cell().add("Email"));
            for(Student stduentData: studentList){
                table.addCell(new Cell().add(String.valueOf(stduentData.getId())));
                table.addCell(new Cell().add(stduentData.getName()));
                table.addCell(new Cell().add(stduentData.getEmailId()));

            }


            document.add(p1);
            document.add(table);
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
