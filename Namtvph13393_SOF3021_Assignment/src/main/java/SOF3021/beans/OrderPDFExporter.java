package SOF3021.beans;

import java.util.List;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import SOF3021.entities.OrderDetail;

public class OrderPDFExporter {
	private List<OrderDetail> orderDetails;

	public OrderPDFExporter(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Address", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Create Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Product", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Price", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Quantity", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Total price", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (OrderDetail orderDetai : orderDetails) {
			table.addCell(orderDetai.getOrder().getUser().getFullname());
			table.addCell(String.valueOf(orderDetai.getOrder().getAddress()));
			table.addCell(String.valueOf(orderDetai.getOrder().getCreatedDate()));
			table.addCell(String.valueOf(orderDetai.getProduct().getName()));
			table.addCell(String.valueOf(orderDetai.getPrice()));
			table.addCell(String.valueOf(orderDetai.getQuantity()));
			table.addCell(String.valueOf(orderDetai.getQuantity() * orderDetai.getPrice()));
			
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Order", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 3.0f, 4.5f, 3.0f, 3.0f, 3.0f, 3.0f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
