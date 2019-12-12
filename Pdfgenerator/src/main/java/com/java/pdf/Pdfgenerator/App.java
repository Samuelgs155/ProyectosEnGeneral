package com.java.pdf.Pdfgenerator;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * author
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Generador de Documentos");
		System.out.println("***********************\n");
		crearDocumentoPDF();
		// agregarUnaPaginaPDF();
		// agregarPaginasPDF();
		agregarTextoDocumentoPDF();
		agregarMultilineasDocumentoPDF();
		System.out.println("\n");
		leerDocumentoPDF();
	}

	public static void crearDocumentoPDF() {
		// Creating PDF document object
		PDDocument document = new PDDocument();
		try {
			// Saving the document
			document.save("C:/PdfBox_Examples/my_doc.pdf");
			// add a page
			document.addPage(new PDPage());
			// add a page
			document.addPage(new PDPage());
			// save the document
			document.save("C:/PdfBox_Examples/my_doc.pdf");
			// Closing the document
			document.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("PDF creado. \n");
	}

	public static void agregarPaginasPDF() {
		// Creating PDF document object
		PDDocument document = new PDDocument();

		for (int i = 0; i < 10; i++) {
			// Creating a blank page
			PDPage blankPage = new PDPage();

			// Adding the blank page to the document
			document.addPage(blankPage);
		}

		// Saving the document
		try {
			document.save("C:/PdfBox_Examples/my_doc.pdf");
			System.out.println("PDF creado");

			// Closing the document
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void agregarUnaPaginaPDF() {
		// Loading an existing document
		File file = new File("C:/PdfBox_Examples/sample.pdf");
		PDDocument document;
		try {
			document = PDDocument.load(file);
			System.out.println("PDF cargado");
			// Adding a blank page to the document
			document.addPage(new PDPage());
			// Saving the document
			document.save("C:/PdfBox_Examples/sample.pdf");
			// Closing the document
			document.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void borrarPaginasDocumentoExistentePDF() {
		// Loading an existing document
		File file = new File("C:/PdfBox_Examples/sample.pdf");
		PDDocument document;
		try {
			document = PDDocument.load(file);
			// Listing the number of existing pages
			int noOfPages = document.getNumberOfPages();
			System.out.print(noOfPages);
			// Removing the pages
			document.removePage(2);
			System.out.println("pagina borrada");
			// Saving the document
			document.save("C:/PdfBox_Examples/sample.pdf");
			// Closing the document
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void agregarInformacionPropiedadesDocumentoPDF() {
		// Creating PDF document object
		PDDocument document = new PDDocument();

		// Creating a blank page
		PDPage blankPage = new PDPage();

		// Adding the blank page to the document
		document.addPage(blankPage);

		// Creating the PDDocumentInformation object
		PDDocumentInformation pdd = document.getDocumentInformation();

		// Setting the author of the document
		pdd.setAuthor("Samuel Garcia");

		// Setting the title of the document
		pdd.setTitle("Documento de ejemplo");

		// Setting the creator of the document
		pdd.setCreator("Ejemplos de generación de PDF");

		// Setting the subject of the document
		pdd.setSubject("Documento de ejemplo");

		// Setting the created date of the document
		Calendar date = new GregorianCalendar();
		date.set(2019, 12, 12);
		pdd.setCreationDate(date);
		// Setting the modified date of the document
		date.set(2019, 12, 14);
		pdd.setModificationDate(date);

		// Setting keywords for the document
		pdd.setKeywords("Ejemplo, mi primer ejemplo, mi primer pdf");

		// Saving the document
		try {
			document.save("C:/PdfBox_Examples/doc_attributes.pdf");
			System.out.println("Propiedades agregadas de manera exitosa. ");

			// Closing the document
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void agregarTextoDocumentoPDF() {
		// Loading an existing document
		File file = new File("C:/PdfBox_Examples/my_doc.pdf");
		PDDocument document;

		try {
			document = PDDocument.load(file);
			// Retrieving the pages of the document
			PDPage page = document.getPage(1);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Begin the Content stream
			contentStream.beginText();

			// Setting the font to the Content stream
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

			// Setting the position for the line
			contentStream.newLineAtOffset(25, 500);

			String text = "Esto es un documento de ejemplo y le hemos agregado este texto.";

			// Adding text in the form of string
			contentStream.showText(text);

			// Ending the content stream
			contentStream.endText();

			System.out.println("Contenido agregado");

			// Closing the content stream
			contentStream.close();

			// Saving the document
			document.save(new File("C:/PdfBox_Examples/new.pdf"));

			// Closing the document
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void agregarMultilineasDocumentoPDF() {
		// Loading an existing document
		File file = new File("C:/PdfBox_Examples/my_doc.pdf");
		PDDocument doc;
		try {
			doc = PDDocument.load(file);
			// Creating a PDF Document
			PDPage page = doc.getPage(1);

			PDPageContentStream contentStream = new PDPageContentStream(doc, page);

			// Begin the Content stream
			contentStream.beginText();

			// Setting the font to the Content stream
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 16);

			// Setting the leading
			contentStream.setLeading(14.5f);

			// Setting the position for the line
			contentStream.newLineAtOffset(25, 725);

			String text1 = "Esto es un ejemplo para agregar texto a una página en un documento PDF."
					+ " Podemos agregar varias líneas.";
			String text2 = "como queremos emplear el método de ShowText() "
					+ " de la calse java llamada ContentStream class";

			// Adding text in the form of string
			contentStream.showText(text1);
			contentStream.newLine();
			contentStream.showText(text2);
			// Ending the content stream
			contentStream.endText();

			System.out.println("Content added");

			// Closing the content stream
			contentStream.close();

			// Saving the document
			doc.save(new File("C:/PdfBox_Examples/new2.pdf"));

			// Closing the document
			doc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void leerDocumentoPDF() {
		// Loading an existing document
		File file = new File("C:/PdfBox_Examples/new.pdf");
		PDDocument document;
		try {
			document = PDDocument.load(file);
			// Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();

			// Retrieving text from PDF document
			String text = pdfStripper.getText(document);
			System.out.println(text);

			// Closing the document
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertarImagenDocumentoPDF() {
		// Loading an existing document
		File file = new File("C:/PdfBox_Examples/sample.pdf");
		PDDocument doc;
		try {
			doc = PDDocument.load(file);
			// Retrieving the page
			PDPage page = doc.getPage(0);

			// Creating PDImageXObject object
			PDImageXObject pdImage = PDImageXObject.createFromFile("C:/PdfBox_Examples/logo.png", doc);

			// creating the PDPageContentStream object
			PDPageContentStream contents = new PDPageContentStream(doc, page);

			// Drawing the image in the PDF document
			contents.drawImage(pdImage, 70, 250);

			System.out.println("Image inserted");

			// Closing the PDPageContentStream object
			contents.close();

			// Saving the document
			doc.save("C:/PdfBox_Examples/sample.pdf");

			// Closing the document
			doc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
