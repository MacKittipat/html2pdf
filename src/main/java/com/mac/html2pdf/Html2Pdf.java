package com.mac.html2pdf;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Html2Pdf {

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Required 2 arguments : htmlContent and pdfPath");
        }
        Html2Pdf html2Pdf = new Html2Pdf();
        try {
            html2Pdf.generatePdf(args[0], args[1]);
        } catch (IOException | DocumentException e) {
            System.out.println("Cannot generate PDF : " + e.getMessage());
        }
    }

    public void generatePdf(String htmlContent, String pdfPath) throws IOException, DocumentException {
        OutputStream outputStream = new FileOutputStream(pdfPath);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }
}
