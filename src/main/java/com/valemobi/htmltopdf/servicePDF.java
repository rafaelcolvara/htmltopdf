package com.valemobi.htmltopdf;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class servicePDF  {

    public Document parseToDocument(ClassPathResource resource) throws IOException {
        File inputHTML = new File(String.valueOf(resource.getFile()));

        Document document = Jsoup.parse(inputHTML, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

}
