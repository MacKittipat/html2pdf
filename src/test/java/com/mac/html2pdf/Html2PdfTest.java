package com.mac.html2pdf;

import org.junit.Test;

public class Html2PdfTest {

    @Test
    public void testGeneratePdf() throws Exception {
        Html2Pdf html2Pdf = new Html2Pdf();
        String pdfPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "test.pdf";
        html2Pdf.generatePdf("<html><head><title>test</title></head><body>test</body></html>", pdfPath);
    }
}
