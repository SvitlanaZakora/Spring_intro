package app.util;

import app.model.Report;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("reportView")
public class ReportPdfView extends AbstractView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=myReport.pdf");
        Report report = (Report) model.get("report");

        //IText API
        PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
        PdfDocument pdf = new PdfDocument(pdfWriter);
        Document pdfDocument = new Document(pdf);

        //content
        for (Long eventId : report.getEvents()) {
            Paragraph event = new Paragraph(String.valueOf(eventId));
            pdfDocument.add(event);
        }
        for (Long userId : report.getUsers()) {
            Paragraph user = new Paragraph(String.valueOf(userId));
            pdfDocument.add(user);
        }
        for (String categoryName : report.getCategories()) {
            Paragraph category = new Paragraph(categoryName);
            pdfDocument.add(category);
        }
        for (String placeName : report.getPlaces()) {
            Paragraph place = new Paragraph(placeName);
            pdfDocument.add(place);
        }

        pdfDocument.close();
    }
}
