package com.qlnsitsol.demo.repository;

import com.qlnsitsol.demo.entity.Luong;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelFileExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Luong> luongs;

    public  ExcelFileExporter(List<Luong> luong) {
        this.luongs = luong;
        workbook = new XSSFWorkbook();

    }
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Bảng lương");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Tên nhân viên", style);
        createCell(row, 2, "Phòng ban", style);
        createCell(row, 3, "Hệ số lương", style);
        createCell(row, 4, "Ngày công", style);
        createCell(row, 5, "Phụ cấp", style);
        createCell(row, 6, "Tạm ứng", style);
        createCell(row, 7, "Khen thưởng", style);
        createCell(row, 8, "Kỷ luật", style);
        createCell(row, 9, "Tổng công", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        int index = 1;

        for (Luong luong : luongs) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, index++, style);
            createCell(row, columnCount++, luong.getId().getNhanVien().getTenNhanVien(), style);
            createCell(row, columnCount++, luong.getId().getNhanVien().getPhongBan().getTenPhongBan(), style);
            createCell(row, columnCount++, luong.getHeSoLuong().getHeSoLuong(), style);
            createCell(row, columnCount++, luong.getNgayCong(), style);
            createCell(row, columnCount++, luong.getPhuCap().getTienPhuCap(), style);
            createCell(row, columnCount++, luong.getTamUng().getTienTamung(), style);
            createCell(row, columnCount++, luong.getKhenThuongKl().getSoTien(), style);
            createCell(row, columnCount++, luong.getKyLuat().getTienPhat(), style);
            String formula = "D" + rowCount + " * E" + rowCount +"+F"+ rowCount + "-G" +rowCount +"+H" +rowCount +"-I"+rowCount;
            row.createCell(9, CellType.FORMULA).setCellFormula(formula);

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
