package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.services.data.TicketUser;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PDFGenerationService {
    public byte[] generatePDFForTickets(Iterable<TicketUser> tickets) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        for (TicketUser ticket : tickets) {
            document.add(new Paragraph("Place ID: " + ticket.getPlace()));
            document.add(new Paragraph("Ticket ID: " + ticket.getId()));
            document.add(new Paragraph("------------------------------"));
        }

        document.close();

        return outputStream.toByteArray();
    }
}
