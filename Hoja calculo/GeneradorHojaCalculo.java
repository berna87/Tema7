import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
 
public class GeneradorHojaCalculo {
 
    // documento con las hojas de calculo
    private final Workbook libro;
 
    // la hoja de calculo
    private final Sheet hojaTiemposPilotos;
 
    // estilo de las celdas del encabezado (con el nombre de las columnas)
    private final CellStyle estiloTitulo;
 
    // estilo de las celdas con fórmula
    private final CellStyle estiloCeldaConFormula;
 
    public GeneradorHojaCalculo() {
        this.libro = new HSSFWorkbook();
        this.hojaTiemposPilotos = this.libro.createSheet("Tiempos entrenamientos");
        this.estiloTitulo = getEstiloTitulo();
        this.estiloCeldaConFormula = getEstiloCeldaConFormula();
        anadeFilaEncabezado();
    }
 
    // crea una fila con los datos del piloto: nombre, tiempos, total, media y mejor tiempo
    public void anadeTiemposPiloto(Piloto piloto) {
        final Row filaPiloto = getNuevaFila();
        filaPiloto.createCell(0).setCellValue(piloto.getNombre());
        for (int i = 1; i <= Piloto.NUMERO_VUELTAS_ENTRENAMIENTO; i++) {
            final Cell celda = filaPiloto.createCell(i);
            celda.setCellValue(piloto.getTiemposVueltas().get(i - 1));
            celda.setCellType(Cell.CELL_TYPE_NUMERIC);
        }
        generaFormulaSumaTiempos(filaPiloto);
        generaFormulaMediaTiempos(filaPiloto);
        generaFormulaMejorTiempo(filaPiloto);
    }
 
    // crea la celda con la fórmula de suma de tiempos correspondiente a una fila
    private void generaFormulaSumaTiempos(Row filaPiloto) {
        final int numeroFila = filaPiloto.getRowNum() + 1;
        final String formula = "SUM" + generaRangoFormulaEnFila(numeroFila);
        anadeFormulaYEstiloACelda(filaPiloto.createCell(Piloto.NUMERO_VUELTAS_ENTRENAMIENTO + 1), formula);
    }
 
    // crea la celda con la fórmula de media de tiempos correspondiente a una fila
    private void generaFormulaMediaTiempos(Row filaPiloto) {
        final int numeroFila = filaPiloto.getRowNum() + 1;
        final String formula = "AVERAGE" + generaRangoFormulaEnFila(numeroFila);
        anadeFormulaYEstiloACelda(filaPiloto.createCell(Piloto.NUMERO_VUELTAS_ENTRENAMIENTO + 2), formula);
    }
 
    // crea la celda con la fórmula de que calcula el mejor tiempo a una fila
    private void generaFormulaMejorTiempo(Row filaPiloto) {
        final int numeroFila = filaPiloto.getRowNum() + 1;
        final String formula = "MIN" + generaRangoFormulaEnFila(numeroFila);
        anadeFormulaYEstiloACelda(filaPiloto.createCell(Piloto.NUMERO_VUELTAS_ENTRENAMIENTO + 3), formula);
    }
 
    // devuelve el rango de columnas sobre las que actuará la formula. Ej: (B2:F2)
    private static String generaRangoFormulaEnFila(int numeroFila) {
        // la columna donde se situa el primer tiempo será la B (codigo ASCII 66) ya que en la A está el nombre del piloto)
        final byte columnaB = 66;
        final char primeraColumna = (char)columnaB;
        final char ultimaColumna = (char)columnaB + Piloto.NUMERO_VUELTAS_ENTRENAMIENTO - 1;
        return "(" + primeraColumna + numeroFila + ":" + ultimaColumna + numeroFila + ")";
    }
 
    // añade la fórmula a una celda y añade el estilo de las celdas con fórmula
    private void anadeFormulaYEstiloACelda(Cell celda, String formula) {
        celda.setCellFormula(formula);
        celda.setCellStyle(estiloCeldaConFormula);
    }
 
    // genera el documento
    public OutputStream generaDocumento() throws IOException {
        ajustaColumnas();
        final OutputStream outputStream = new FileOutputStream("HojaCalculo.xls");
        libro.write(outputStream);
        outputStream.close();
        return outputStream;
    }
 
    // crea la fila y celdas del encabezado con el nombre de las columnas
    private void anadeFilaEncabezado() {
        final Row filaEncabezado = getNuevaFila();
        int numeroCelda = 0;
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Piloto");
        for (int i = 1; i <= Piloto.NUMERO_VUELTAS_ENTRENAMIENTO; i++) {
            creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Vuelta " + i);
        }
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Tiempo total");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Promedio");
        creaCeldaEncabezado(filaEncabezado, numeroCelda++, "Mejor tiempo");
    }
 
    // crea una celda de encabezado (las del título) y añade el estilo
    private void creaCeldaEncabezado(Row filaEncabezado, int numeroCelda, String valor) {
        final Cell celdaEncabezado = filaEncabezado.createCell(numeroCelda);
        celdaEncabezado.setCellValue(valor);
        celdaEncabezado.setCellStyle(estiloTitulo);
    }
 
    // ajusta el ancho de las columnas en función de su contenido
    private void ajustaColumnas() {
        final short numeroColumnas = hojaTiemposPilotos.getRow(0).getLastCellNum();
        for (int i = 0; i < numeroColumnas; i++) {
            hojaTiemposPilotos.autoSizeColumn(i);
        }
    }
 
    // devuelve el estilo que tendrán las celdas del título (negrita y color de fondo azul)
    private CellStyle getEstiloTitulo() {
        final CellStyle cellStyle = libro.createCellStyle();
        final Font cellFont = libro.createFont();
        cellFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyle.setFont(cellFont);
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        return cellStyle;
    }
 
    // devuelve el estilo que tendrán las celdas con fórmula (color de fondo gris claro)
    private CellStyle getEstiloCeldaConFormula() {
        final CellStyle cellStyle = libro.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        return cellStyle;
    }
 
    // crea una nueva fila a continuación de la anterior
    private Row getNuevaFila() {
        return hojaTiemposPilotos.createRow(hojaTiemposPilotos.getPhysicalNumberOfRows());
    }
    public static void main (String args[]) {
        final GeneradorHojaCalculo generadorHojaCalculo = new GeneradorHojaCalculo();
         
        final Piloto piloto1 = new Piloto("Fernando Alonso");
        piloto1.getTiemposVueltas().add(131.78);
        piloto1.getTiemposVueltas().add(129.95);
        piloto1.getTiemposVueltas().add(128.16);
        piloto1.getTiemposVueltas().add(125.91);
        piloto1.getTiemposVueltas().add(130.44);
         
        final Piloto piloto2 = new Piloto("Jaime Alguersuari");
        piloto2.getTiemposVueltas().add(133.16);
        piloto2.getTiemposVueltas().add(132.32);
        piloto2.getTiemposVueltas().add(129.86);
        piloto2.getTiemposVueltas().add(128.02);
        piloto2.getTiemposVueltas().add(132.45);
         
        generadorHojaCalculo.anadeTiemposPiloto(piloto1);
        generadorHojaCalculo.anadeTiemposPiloto(piloto2);
         
        try {
            generadorHojaCalculo.generaDocumento();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
 
}
