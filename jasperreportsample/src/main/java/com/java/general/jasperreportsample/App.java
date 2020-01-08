package com.java.general.jasperreportsample;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JRException, IOException {

		// Compile jrxml file.
		JasperReport jasperReport = JasperCompileManager
				.compileReport("C:\\Users\\samuel.alten\\Desktop\\personal\\06_jasper\\StyledTextReport.jrxml");

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();

		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource dataSource = new JREmptyDataSource();

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		// Make sure the output directory exists.
		File outDir = new File("C:/jasperoutput");
		outDir.mkdirs();

		// Export to PDF.
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/jasperoutput/StyledTextReport.pdf");

		System.out.println("Done!");
	}
}
