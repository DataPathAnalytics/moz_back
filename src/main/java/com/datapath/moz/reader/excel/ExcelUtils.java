package com.datapath.moz.reader.excel;

import com.datapath.moz.dto.NomenclatureDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

class ExcelUtils {
    static NomenclatureDTO generateNomenclaturesFromFile(Row row, String mnn) {
        return NomenclatureDTO.builder()
                .mnn(mnn)
                .column2(getIntegerFromCell(row.getCell(0)))
                .column3(getStringFromCell(row.getCell(1)))
                .column4(getStringFromCell(row.getCell(2)))
                .direction(getStringFromCell(row.getCell(3)))
                .subDirection(getStringFromCell(row.getCell(4)))
                .form(getStringFromCell(row.getCell(6)))
                .dosage(getStringFromCell(row.getCell(7)))
                .extraListDosage(getStringFromCell(row.getCell(8)))
                .unit(getStringFromCell(row.getCell(9)))
                .cost(getFloatFromCell(row.getCell(10)))
                .uah(getIntegerFromCell(row.getCell(11)))
                .column12(getIntegerFromCell(row.getCell(12)))
                .vinnytsa(getIntegerFromCell(row.getCell(13)))
                .volyn(getIntegerFromCell(row.getCell(14)))
                .dnipropetrovsk(getIntegerFromCell(row.getCell(15)))
                .donetsk(getIntegerFromCell(row.getCell(16)))
                .zhytomyr(getIntegerFromCell(row.getCell(17)))
                .zakarpattia(getIntegerFromCell(row.getCell(18)))
                .zaporizhia(getIntegerFromCell(row.getCell(19)))
                .ivanoFrankivsk(getIntegerFromCell(row.getCell(20)))
                .kiev(getIntegerFromCell(row.getCell(21)))
                .kirovograd(getIntegerFromCell(row.getCell(22)))
                .lugansk(getIntegerFromCell(row.getCell(23)))
                .lviv(getIntegerFromCell(row.getCell(24)))
                .nikolaev(getIntegerFromCell(row.getCell(25)))
                .odessa(getIntegerFromCell(row.getCell(26)))
                .poltava(getIntegerFromCell(row.getCell(27)))
                .rivne(getIntegerFromCell(row.getCell(28)))
                .sumy(getIntegerFromCell(row.getCell(29)))
                .ternopil(getIntegerFromCell(row.getCell(30)))
                .kharkiv(getIntegerFromCell(row.getCell(31)))
                .kherson(getIntegerFromCell(row.getCell(32)))
                .khmelnytsky(getIntegerFromCell(row.getCell(33)))
                .cherkassy(getIntegerFromCell(row.getCell(34)))
                .chernivtsi(getIntegerFromCell(row.getCell(35)))
                .chernihiv(getIntegerFromCell(row.getCell(36)))
                .sityKyiv(getIntegerFromCell(row.getCell(37)))
                .hip(getIntegerFromCell(row.getCell(38)))
                .ndsl(getIntegerFromCell(row.getCell(39)))
                .dzpcrl(getIntegerFromCell(row.getCell(40)))
                .onmu(getIntegerFromCell(row.getCell(41)))
                .hmapo(getIntegerFromCell(row.getCell(42)))
                .dzumcagr(getIntegerFromCell(row.getCell(43)))
                .dnmu(getIntegerFromCell(row.getCell(44)))
                .npmcdkk(getIntegerFromCell(row.getCell(45)))
                .ismozu(getIntegerFromCell(row.getCell(46)))
                .kct(getIntegerFromCell(row.getCell(47)))
                .duucsocmoz(getIntegerFromCell(row.getCell(48)))
                .build();
    }

    static String getStringFromCell(Cell c) {
        String value = getStringValueFromCell(c);
        if (isEmpty(value)) {
            return null;
        }
        return value.replaceAll(" ", " ");
    }

    private static Float getFloatFromCell(Cell c) {
        String value = getStringValueFromCell(c);
        if (isEmpty(value)) {
            return null;
        }
        return Float.parseFloat(value.replaceAll(" ", "")
                .replaceAll(" ", "")
                .replaceAll(",", "."));
    }

    private static Integer getIntegerFromCell(Cell c) {
        String value = getStringValueFromCell(c);
        if (isEmpty(value)) {
            return null;
        }
        return new Double(value.replaceAll(" ", "")
                .replaceAll(" ", "")).intValue();
    }

    private static String getStringValueFromCell(Cell c) {
        if (isNull(c)) {
            return null;
        }
        String type = c.getCellType().name();
        if ("NUMERIC".equals(type)) {
            if (isNull(c.getNumericCellValue())) {
                return null;
            }
            return String.valueOf(c.getNumericCellValue());
        } else {
            if (isEmpty(c.getStringCellValue())) {
                return null;
            }
            return c.getStringCellValue().trim();
        }
    }
}
