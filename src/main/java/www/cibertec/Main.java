package www.cibertec;

public class Main {
    static void main() {

        // Ejercicio: Gestión de compras escolares con beneficios por rendimiento

        // 1. VARIABLES FIJAS CON TIPOS DE DATOS MODIFICADOS
        String alumno = "Miguel Romero";
        double costoPaquete = 640.0;
        char nivelEscolar = 'S'; // 'P' = Primaria, 'S' = Secundaria, 'I' = Inicial

        // CORRECCIÓN 1: Nombre unificado en minúscula para evitar errores de compilación
        boolean esTercioSuperior = true;

        System.out.println("--- SISTEMA MATRÍCULA Y TEXTOS Innova School ---");
        System.out.println("Estudiante evaluado: " + alumno);
        System.out.println("Costo base del paquete: S/ " + costoPaquete);

        // 2. SWITCH CASE EVALUANDO CARACTERES
        double porcentajeDescuento = 0.0;

        switch (nivelEscolar) {
            case 'P':
                porcentajeDescuento = 0.15;
                System.out.println("Nivel Académico: Primaria ( 15% de rebaja)");
                break;
            case 'S':
                porcentajeDescuento = 0.25;
                System.out.println("Nivel Académico: Secundaria ( 25% de rebaja)");
                break;
            case 'I':
                porcentajeDescuento = 0.10;
                System.out.println("Nivel Académico: Inicial ( 10% de rebaja)");
                break;
            default:
                porcentajeDescuento = 0;
                System.out.println("Ingrese un nivel valido para obtener un descuento.");
        }

        // 3. ESTRUCTURA IF / ELSE IF / ELSE
        double rebajaNivel = costoPaquete * porcentajeDescuento;
        double subtotal = costoPaquete - rebajaNivel;

        if (subtotal >= 200.0) {
            System.out.println("Categoría de Pago: Inversión Alta");
        } else if (subtotal >= 100.0) {
            System.out.println("Categoría de Pago: Inversión Estándar");
        } else {
            System.out.println("Categoría de Pago: Inversión Promocional");
        }

        // 4. LLAMADA AL METODO (CORRECCIÓN 2: Ya coincide exactamente con la variable de arriba)
        double totalNeto = calcularLiquidacion(subtotal, esTercioSuperior);

        // 5. CICLO WHILE ACUMULATIVO  ESTOY CONSIDERANDO 3 CUOTAS
        int mes = 1;
        double cuotaMensual = totalNeto / 3;
        System.out.println("\n--- CRONOGRAMA DE PAGOS EN CUOTAS ---");
        while (mes <= 3) {
            System.out.println("Mes " + mes + " -> Monto sugerido de pago: S/ " + cuotaMensual);
            mes++;
        }

        // 6. CICLO FOR ESTOY COLOCANDO 2 COMO ALGO FIJO DEPENDERA CUANTOS AÑOS ESTE EN EL COLEGIO
        System.out.println("\n--- PROYECCION DE PUNTOS DE FIDELIDAD ---");
        int puntosAcumulados = 0;
        for (int i = 1; i <= 2; i++) {
            puntosAcumulados += 20;
            System.out.println("ESTA EN EL GRADO  " + i + ": " + puntosAcumulados + " puntos acumulados.");
        }

        // REPORTE FINAL TOTALIZADO

        System.out.println("\n--- LIQUIDACIÓNN FINAL DE CAJA ---");
        System.out.println("Monto neto final liquidado para " + alumno + ": S/ " + totalNeto);

        if (totalNeto < 200.0) {
            System.out.println("Estado de Cuenta: Cuenta Optimizada (Máximos beneficios aplicados)");
        } else {
            System.out.println("Estado de Cuenta: Facturación Regular");
        }
    }
    // METODO
    static double calcularLiquidacion(double subtotalActual, boolean aplicaExcelencia) {
        double descuentoAdicional = 0.0;

        if (aplicaExcelencia) {
            descuentoAdicional = subtotalActual * 0.10;
        }

        double montoConDescuento = subtotalActual - descuentoAdicional;
        double igv = montoConDescuento * 0.18;
        double totalConImpuesto = montoConDescuento + igv;

        System.out.println("\n[ Auditoría Interna del Método ]");
        System.out.println(" -> Descuento por rendimiento aplicado: S/ " + descuentoAdicional);
        System.out.println(" -> Impuesto IGV (18%) calculado: S/ " + igv);

        return totalConImpuesto;
    }
}