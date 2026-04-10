package jdbc_progams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.awt.Desktop;
import java.awt.Color;
import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;

public class ReportPDFBox {

    private static final String PROJECT_DIR = "D:\\Downloads\\JDBC_Progams";
    private static final String LOGO_PATH = "D:\\Downloads\\tllogo.png";
    private static final String HEADER_IMAGE_PATH = "D:\\Downloads\\tllogo.png";

    private static final Color TAJ_GOLD = new Color(166, 124, 0);

    private static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotel_management",
                "root",
                "zameer17"
        );
    }

    private static String safeString(ResultSet rs, String column) throws SQLException {
        String value = rs.getString(column);
        return value == null ? "N/A" : value;
    }

    private static void writeLine(PDPageContentStream cs, String text, int x, int y, Color color, int fontSize, boolean bold) throws Exception {
        cs.beginText();
        cs.setFont(bold ? PDType1Font.HELVETICA_BOLD : PDType1Font.HELVETICA, fontSize);
        cs.setNonStrokingColor(color);
        cs.newLineAtOffset(x, y);
        cs.showText(text);
        cs.endText();
    }

    private static void writeCentered(PDPageContentStream cs, String text, int y, Color color, int fontSize, boolean bold) throws Exception {
        float pageWidth = PDRectangle.A4.getWidth() - 100;
        float textWidth = (bold ? PDType1Font.HELVETICA_BOLD : PDType1Font.HELVETICA)
                .getStringWidth(text) / 1000 * fontSize;
        float startX = 50 + (pageWidth - textWidth) / 2;
        writeLine(cs, text, (int) startX, y, color, fontSize, bold);
    }

    private static void drawPageBorder(PDPageContentStream cs) throws Exception {
        cs.setStrokingColor(Color.DARK_GRAY);
        cs.setLineWidth(1.2f);
        cs.addRect(30, 30, PDRectangle.A4.getWidth() - 60, PDRectangle.A4.getHeight() - 60);
        cs.stroke();
    }

    private static void drawFooter(PDPageContentStream cs) throws Exception {
        writeCentered(cs, "Contact: HotelEase@org.in", 37, Color.RED, 10, true);
        String timestamp = "Report Generated On: "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));

        writeCentered(cs, timestamp, 15, Color.DARK_GRAY, 9, false);
    }

    private static void addWatermark(PDDocument doc, PDPage page) throws IOException {
        PDImageXObject pdImage = PDImageXObject.createFromFile(LOGO_PATH, doc);
        try (PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
            PDExtendedGraphicsState gs = new PDExtendedGraphicsState();
            gs.setNonStrokingAlphaConstant(0.08f);
            gs.setStrokingAlphaConstant(0.08f);
            cs.setGraphicsStateParameters(gs);

            float imgWidth = 350;
            float imgHeight = 250;
            float centerX = (PDRectangle.A4.getWidth() - imgWidth) / 2;
            float centerY = (PDRectangle.A4.getHeight() - imgHeight) / 2;
            cs.drawImage(pdImage, centerX, centerY, imgWidth, imgHeight);
        }
    }

    private static void drawHeaderImage(PDDocument doc, PDPageContentStream cs, float yTop) throws IOException {
        try {
            PDImageXObject headerImg = PDImageXObject.createFromFile(HEADER_IMAGE_PATH, doc);
            float pageWidth = PDRectangle.A4.getWidth();
            float maxWidth = pageWidth - 100;
            float maxHeight = 65;
            float imgWidth = headerImg.getWidth();
            float imgHeight = headerImg.getHeight();
            float scale = Math.min(maxWidth / imgWidth, maxHeight / imgHeight);
            imgWidth = imgWidth * scale;
            imgHeight = imgHeight * scale;

            float startX = (pageWidth - imgWidth) / 2;
            float startY = yTop - imgHeight + 20;

            cs.drawImage(headerImg, startX, startY, imgWidth, imgHeight);
        } catch (Exception e) {
            System.err.println("Header image not found. Using text fallback.");
            try {
                writeCentered(cs, "Taj Lands Hotel", (int) yTop - 20, TAJ_GOLD, 22, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // ========================== Reservation Payments Report ==========================
    public static void generateReservationPaymentsReport() throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT payment_id, reservation_id, payment_date, amount, payment_method, payment_status FROM payments"
        );

        String filePath = PROJECT_DIR + File.separator + "ReservationReport.pdf";
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        doc.addPage(page);

        PDPageContentStream cs = new PDPageContentStream(doc, page);
        drawPageBorder(cs);
        drawHeaderImage(doc, cs, 780);

        writeCentered(cs, "Reservation Payments Report", 720, TAJ_GOLD, 16, true);

        cs.setStrokingColor(Color.GRAY);
        cs.moveTo(60, 700);
        cs.lineTo(550, 700);
        cs.stroke();

        int y = 680;

        while (rs.next()) {
            int lines = 6;
            int lineSpacing = 16;
            int boxHeight = lines * lineSpacing + 20;

            cs.setNonStrokingColor(new Color(245, 245, 245));
            cs.addRect(55, y - boxHeight + 10, 490, boxHeight);
            cs.fill();

            cs.setStrokingColor(Color.LIGHT_GRAY);
            cs.addRect(55, y - boxHeight + 10, 490, boxHeight);
            cs.stroke();
            cs.setNonStrokingColor(Color.BLACK);

            int textStartY = y - 14;
            Color labelColor = Color.DARK_GRAY;

            writeLine(cs, "Payment ID: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "payment_id"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Reservation ID: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "reservation_id"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Date: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "payment_date"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Amount: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "amount"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Method: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "payment_method"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            String status = safeString(rs, "payment_status");
            Color statusColor = status.equalsIgnoreCase("Paid") ? new Color(0, 128, 0) : Color.RED;
            writeLine(cs, "Status: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, status, 190, textStartY, statusColor, 12, true);

            y -= boxHeight + 15;

            if (y < 100) {
                drawFooter(cs);
                cs.close();
                addWatermark(doc, page);

                page = new PDPage(PDRectangle.A4);
                doc.addPage(page);
                cs = new PDPageContentStream(doc, page);
                drawPageBorder(cs);
                drawHeaderImage(doc, cs, 780);

                writeCentered(cs, "Reservation Payments Report", 720, TAJ_GOLD, 16, true);
                cs.setStrokingColor(Color.GRAY);
                cs.moveTo(60, 700);
                cs.lineTo(550, 700);
                cs.stroke();
                y = 680;
            }
        }

        drawFooter(cs);
        cs.close();
        addWatermark(doc, page);

        doc.save(filePath);
        doc.close();
        con.close();

        Desktop.getDesktop().open(new File(filePath));
    }

    // ========================== Guest Stay Report ==========================
    public static void generateGuestStayReport() throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT r.reservation_id, g.first_name, g.last_name, rm.room_number, r.check_in_date, r.check_out_date, r.total_price "
                + "FROM reservations r LEFT JOIN guests g ON r.guest_id = g.guest_id "
                + "LEFT JOIN rooms rm ON r.room_id = rm.room_id"
        );

        String filePath = PROJECT_DIR + File.separator + "GuestStayReport.pdf";
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        doc.addPage(page);

        PDPageContentStream cs = new PDPageContentStream(doc, page);
        drawPageBorder(cs);
        drawHeaderImage(doc, cs, 780);

        writeCentered(cs, "Guest Stay Report", 720, TAJ_GOLD, 16, true);

        cs.setStrokingColor(Color.GRAY);
        cs.moveTo(60, 700);
        cs.lineTo(550, 700);
        cs.stroke();

        int y = 680;

        while (rs.next()) {
            int lines = 6;
            int lineSpacing = 16;
            int boxHeight = lines * lineSpacing + 20;

            cs.setNonStrokingColor(new Color(245, 245, 245));
            cs.addRect(55, y - boxHeight + 10, 490, boxHeight);
            cs.fill();

            cs.setStrokingColor(Color.LIGHT_GRAY);
            cs.addRect(55, y - boxHeight + 10, 490, boxHeight);
            cs.stroke();
            cs.setNonStrokingColor(Color.BLACK);

            int textStartY = y - 14;
            Color labelColor = Color.DARK_GRAY;

            writeLine(cs, "Reservation ID: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "reservation_id"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Guest: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "first_name") + " " + safeString(rs, "last_name"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Room: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "room_number"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Check-In: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "check_in_date"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Check-Out: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "check_out_date"), 190, textStartY, Color.BLACK, 12, false);
            textStartY -= lineSpacing;

            writeLine(cs, "Total: ", 70, textStartY, labelColor, 12, true);
            writeLine(cs, safeString(rs, "total_price"), 190, textStartY, Color.BLACK, 12, false);

            y -= boxHeight + 15;

            if (y < 100) {
                drawFooter(cs);
                cs.close();
                addWatermark(doc, page);

                page = new PDPage(PDRectangle.A4);
                doc.addPage(page);
                cs = new PDPageContentStream(doc, page);
                drawPageBorder(cs);
                drawHeaderImage(doc, cs, 780);

                writeCentered(cs, "Guest Stay Report", 720, TAJ_GOLD, 16, true);
                cs.setStrokingColor(Color.GRAY);
                cs.moveTo(60, 700);
                cs.lineTo(550, 700);
                cs.stroke();
                y = 680;
            }
        }

        drawFooter(cs);
        cs.close();
        addWatermark(doc, page);

        doc.save(filePath);
        doc.close();
        con.close();

        Desktop.getDesktop().open(new File(filePath));
    }

    // ========================== Main Option Dialog ==========================
    public static void askAndGenerateReport() {
        String[] options = {"Guest Stay Report", "Reservation Report", "Both Reports"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Which report do you want to check?",
                "Generate Reports",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        try {
            if (choice == 0) {
                generateGuestStayReport();
                JOptionPane.showMessageDialog(null, "✅ Guest Stay Report generated successfully!");
            } else if (choice == 1) {
                generateReservationPaymentsReport();
                JOptionPane.showMessageDialog(null, "✅ Reservation Payments Report generated successfully!");
            } else if (choice == 2) {
                generateGuestStayReport();
                generateReservationPaymentsReport();
                JOptionPane.showMessageDialog(null, "✅ Both Reports generated successfully!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
