package com.fundoo.service.notes;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.fundoo.dto.note.NoteResponseDTO;
import com.fundoo.entity.Notes;

@Service
public class NoteExportService {

	public byte[] exportToExcel(List<NoteResponseDTO> notes) throws Exception {

		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("My Notes");

		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("Title");
		header.createCell(1).setCellValue("Content");
		header.createCell(2).setCellValue("State");

		int rowNum = 1;

		for (NoteResponseDTO note : notes) {

			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(note.getTitle());
			row.createCell(1).setCellValue(note.getContent());
			row.createCell(2).setCellValue(note.getState().toString());
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		workbook.write(out);
		workbook.close();

		return out.toByteArray();
	}
}