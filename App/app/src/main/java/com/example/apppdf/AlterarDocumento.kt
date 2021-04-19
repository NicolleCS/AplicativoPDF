package com.example.apppdf

import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.xwpf.usermodel.*
import java.io.FileOutputStream
import java.io.IOException

class AlterarDocumento {
    @Throws(IOException::class, InvalidFormatException::class)
    fun alterar(sourse: String, destination: String) {
        val doc = XWPFDocument(
            OPCPackage.open(
                sourse
                        + "DocumentoBase.docx"
            )
        )
        for (tbl: XWPFTable in doc.tables) {
            for (row: XWPFTableRow in tbl.rows) {
                for (cell: XWPFTableCell in row.tableCells) {
                    for (p: XWPFParagraph in cell.paragraphs) {
                        for (r: XWPFRun in p.runs) {
                            var text = r.getText(0)
                            if ((text != null
                                        && text.contains("\${TITULO}"))
                            ) {
                                text = text.replace(
                                    "\${TITULO}",
                                    Lista.lista.get(0)
                                )
                                r.setText(text, 0)
                            }
                            if (text != null && text.contains("\${data}")) {
                                text = text.replace(
                                    "\${data}",
                                    Lista.lista.get(2)
                                )
                                r.setText(text, 0)
                            }
                            if (text != null && text.contains("\${cliente}")) {
                                text = text.replace("\${cliente}", Lista.lista.get(1))
                                r.setText(text, 0)
                            }
                            if (text != null && text.contains("\${cnpj}")) {
                                text = text
                                    .replace("\${cnpj}", Lista.lista.get(2))
                                r.setText(text, 0)
                            }
                            if ((text != null
                                        && text.contains("\${endereco}"))
                            ) {
                                text = text.replace("\${endereco}", Lista.lista.get(3))
                                r.setText(text, 0)
                            }
                        }
                    }
                }
            }
        }
        doc.write(FileOutputStream(destination + "_Test_Document.doc"))
    }
}