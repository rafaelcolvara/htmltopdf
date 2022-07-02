package com.valemobi.htmltopdf;

import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@SpringBootApplication
public class HtmltopdfApplication {


	public static void main(String[] args) throws IOException {

		SpringApplication.run(HtmltopdfApplication.class, args);
		Document doc = new servicePDF().parseToDocument(new ClassPathResource("htmlExemplo.html"));

		try (OutputStream outputStream = new FileOutputStream("/home/rafael.colvara@VALEMOBI.CORP/Documentos/htmltopdf/src/main/resources/outputpdf.pdf")) {
			ITextRenderer renderer = new ITextRenderer();
			SharedContext sharedContext = renderer.getSharedContext();
			sharedContext.setPrint(true);
			sharedContext.setInteractive(false);
			renderer.setDocumentFromString(doc.html());
			renderer.layout();
			renderer.createPDF(outputStream);
		}
	}

}
