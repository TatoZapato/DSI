/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Utilidades.Inventario.ArbolRaleo;
import Utilidades.Inventario.DetalleParcela;
import Utilidades.Inventario.DetalleTablaRodal;
import Utilidades.Inventario.Inventario;
import Utilidades.Inventario.ParametroGeneral;
import Utilidades.Inventario.ParametroParcela;
import Utilidades.Inventario.TablaRodal;
import Utilidades.Persistencia.DAO.BancoDatos.BancoDatosDAO;
import Utilidades.Persistencia.DAOManager.DAOException;
import java.sql.Date;
import java.util.LinkedList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.fitting.CurveFitter;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer;

/**
 *
 * @author Führer
 */
public class ProcesamientoInventario {

    private final static int CON_PODA = 1;

    public static ParametroGeneral obtenerParametroGeneral(Inventario inv, LinkedList<ArbolRaleo> arboles, String model, String function) throws DAOException {
        ParametroGeneral parametro = new ParametroGeneral();
        parametro.setEmPropietaria(BancoDatosDAO.obtenerEmpresaPropietaria(inv));
        parametro.setFundo(Integer.parseInt(inv.getFundo()));
        parametro.setRodal(Integer.parseInt(inv.getRodal()));
        parametro.setAnoPlantacion("Sin Información"); //?
        parametro.setFuncionVolumen(function);
        parametro.setModeloAltura(model);
        LinkedList<Integer> especies = new LinkedList();
        for (int i = 0; i < arboles.size(); i++) {
            if (!especies.contains(arboles.get(i).getEspecie())) {
                especies.add(arboles.get(i).getEspecie());
            }
        }
        int[][] array = new int[especies.size()][2];
        if (especies.isEmpty()) {
            array = null;
        }
        for (int i = 0; i < especies.size(); i++) {
            array[i][0] = especies.get(i);
            array[i][1] = 0;
            for (int j = 0; j < arboles.size(); j++) {
                if (especies.get(i).intValue() == arboles.get(j).getEspecie()) {
                    array[i][1] = (Integer) (array[i][1]) + 1;
                }
            }
        }
        if (array == null) {
            parametro.setEspeciePrincipal("Sin Información");
            parametro.setEspecieSecundaria("Sin Información");
            parametro.setNumEspecies(0);
        } else {

            //Especie Principal
            //System.out.println("ESPECIE PRINCIAPAL: "+parametro.getEspeciePrincipal());
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.println("arr" + array[i][j]);
                }
            }
//            if(array.length == 1){
//                
//            }
            array = BubbleSort(array);
            //System.out.println("aray" + array.length+"\n cod : "+(Integer) array[array.length - 1][1]);

            System.out.println("array[array.length - 1][1]" + array[array.length - 1][0]);
            System.out.println("array[array.length - 2][1]" + array[array.length - 2][0]);
            parametro.setEspeciePrincipal(BancoDatosDAO.obtenerEspecie(array[array.length - 1][0]));
            //Especie Secundaria
            if (array.length > 1) {
                parametro.setEspecieSecundaria(BancoDatosDAO.obtenerEspecie(array[array.length - 2][0]));
            } else {
                parametro.setEspecieSecundaria(parametro.getEspeciePrincipal());
            }
            //Numero de Especie
            parametro.setNumEspecies(array.length);
        }
        /* private int ordeTrabajo */
        parametro.setOrdenTrabajo(inv.getOrdenTrabajo());

        /* private String fechaMedicion */
        parametro.setFechaMedicion(inv.getFecha());

        /* private String tipoInventario */
        parametro.setTipoInventario(BancoDatosDAO.obtenerTipoInventario(inv.getTipoInventario()));

        /* private int numParcelas */
        parametro.setNumParcelas(BancoDatosDAO.obtenerNumParcelas(inv));

        /* private String superficieParcelas */
        float superficie = BancoDatosDAO.obtenerSuperficieParcelas(inv);

        parametro.setSuperficieParcelas(superficie + "");

        /* private String empresaServicios */
        parametro.setEmpresaServicios(BancoDatosDAO.obtenerEmpresaServicio(inv));
        /* private Date fechaProyeccion */
        parametro.setFechaProyeccion(new Date(new java.util.Date().getTime()));
        int numArboles = arboles.size();
        float factorExpansion = 10000 / superficie;
        parametro.setFactorExpansion(factorExpansion+"");
        //densidad
        //float densidad = numArboles / superficie;
        parametro.setDensidad((numArboles * factorExpansion) + "");

        //densidadP;
        int numArbolesPodados = 0, numArbolesNoPodados = 0;
        for (int i = 0; i < arboles.size(); i++) {
            if (arboles.get(i).getConPoda() == CON_PODA) {
                numArbolesNoPodados++;
            } else {
                numArbolesPodados++;
            }
        }
        parametro.setDensidadP((numArbolesPodados * factorExpansion) + "");// / superficie);
        parametro.setDensidadNP((numArbolesNoPodados * factorExpansion) + "");// / superficie);
        float sumaDap = 0, sumaDapP = 0, sumaDapNP = 0;
        float dapMedio = 0, dapMedioP = 0, dapMedioNP = 0;

        //SUMA DAP
        for (int i = 0; i < arboles.size(); i++) {
            if (arboles.get(i).getConPoda() == CON_PODA) {
                sumaDapNP += arboles.get(i).getDap();
            } else {
                sumaDapP += arboles.get(i).getDap();
            }
            sumaDap += arboles.get(i).getDap();
        }

        // CALCULO DAP
        if (array != null) {
            dapMedio = sumaDap / arboles.size();
            dapMedioP = sumaDapP / numArbolesPodados;
            dapMedioNP = sumaDapNP / numArbolesNoPodados;
            parametro.setDapMedio(dapMedio + "");
            parametro.setDapMedioP(dapMedioP + "");
            parametro.setDapMedioNP(dapMedioNP + "");
        } else {
            String cero = "0";
            parametro.setDapMedio(cero);
            parametro.setDapMedioP(cero);
            parametro.setDapMedioNP(cero);
        }

        float areaBasal = 0, areaBasalP = 0, areaBasalNP = 0;
        if (array != null) {
            areaBasal = (float) (Math.PI * Math.pow(dapMedio / 2, 2));
            areaBasalP = (float) (Math.PI * Math.pow(dapMedioP / 2, 2));
            areaBasalNP = (float) (Math.PI * Math.pow(dapMedioNP / 2, 2));
        }
        parametro.setAreaBasal((areaBasal * factorExpansion) + "");
        parametro.setAreaBasalP((areaBasalP * factorExpansion) + "");
        parametro.setAreaBasalNP((areaBasalNP * factorExpansion) + "");

        /* CALCULO DE REGRESIÓN */
        LinkedList<ArbolRaleo> conAltura = new LinkedList();
        for (int i = 0; i < arboles.size(); i++) {
            if (arboles.get(i).gethTotal() > 0f) {
                conAltura.add(arboles.get(i));
            }
        }
        int coef = buscarCoeficientes(model).size();
        String modelo = new String();
        if (array != null) {
            //CALCULAR REGRESION
            modelo = calculoRegresion(conAltura, coef);
            for (int i = 0; i < arboles.size(); i++) {
                if (arboles.get(i).gethTotal() == 0) {
                    try {
                        //Calculo de altura en Base a la Regresión
                        float nvaAltura = calcularAlturaModelo(modelo, arboles.get(i).getDap());
                        arboles.get(i).sethTotal(nvaAltura);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al evaluar la función ajustada", "Información", 1);
                    }
                }
            }
        }
        parametro.setMisArboles(arboles);
        float sumaAlturas = 0, sumaAlturasP = 0, sumaAlturasNP = 0;
        for (int i = 0; i < arboles.size(); i++) {
            sumaAlturas += arboles.get(i).gethTotal();
            if (arboles.get(i).getConPoda() == CON_PODA) {
                sumaAlturasNP += arboles.get(i).gethTotal();
            } else {
                sumaAlturasP += arboles.get(i).gethTotal();
            }
        }
        parametro.setAlturaTotalMedia((sumaAlturas / numArboles) + "");
        parametro.setAlturaTotalMediaP((sumaAlturasP / numArbolesPodados) + "");
        parametro.setAlturaTotalMediaNP((sumaAlturasNP / numArbolesNoPodados) + "");

        LinkedList<Float> volumenes = new LinkedList();
        for (int i = 0; i < arboles.size(); i++) {
            try {
                float vol = calcularVolumenFuncion(function, arboles.get(i).getDap(), arboles.get(i).gethTotal());
                volumenes.add(vol * factorExpansion);
            } catch (Exception e) {
                System.err.println("Función mal escrita: " + e.getLocalizedMessage());
                volumenes.add(0f);
            }
        }
        float sumaVol = 0, sumaVolP = 0, sumaVolNP = 0;
        for (int i = 0; i < volumenes.size(); i++) {
            sumaVol += volumenes.get(i);
            if (arboles.get(i).getConPoda() == CON_PODA) {
                sumaVolNP += volumenes.get(i);
            } else {
                sumaVolP += volumenes.get(i);
            }
        }
        parametro.setVolumen((sumaVol / numArboles) + "");
        parametro.setVolumenP((sumaVolP / numArbolesPodados) + "");
        parametro.setVolumenNP((sumaVolNP / numArbolesNoPodados) + "");
        parametro.setModeloAltura(modelo);
        double[] b = new double[7];
        double[] cof = calculoCoeficientesRegresion(arboles, coef);
        for (int i = 0; i < b.length; i++) {
            b[i] = (i < cof.length) ? cof[i] : 0;
        }
        parametro.setBO(b);
        parametro.setAjuste("Minimo Cuadrado");

        /* private String superficieRodal */
        //parametro.setSuperficieRodal("0");

        System.out.println(parametro.toString());
        return parametro;
    }

    public static TablaRodal obtenerTablaRodal(ParametroGeneral parametro, Inventario inv, String model, String function) throws DAOException {
        TablaRodal tabla = new TablaRodal(parametro);
        LinkedList<ArbolRaleo> arboles = parametro.getMisArboles();
        float maxDap = 0, minDap = Float.MAX_VALUE;
        for (int i = 0; i < arboles.size(); i++) {
            if (arboles.get(i).getDap() > maxDap) {
                maxDap = arboles.get(i).getDap();
            }
            if (arboles.get(i).getDap() < minDap) {
                minDap = arboles.get(i).getDap();
            }
        }
        System.out.println(parametro.toString());
        int numClases = 0;
        float aux = minDap;
        while (aux < maxDap) {
            aux += 2;
            numClases++;
        }

        System.out.println("MIN DAP: " + minDap);
        System.out.println("MAX DAP: " + maxDap);
        System.out.println("NUM CLASES: " + numClases);
        LinkedList<DetalleTablaRodal> detalles = new LinkedList();
        for (int i = 0; i < numClases; i++) {
            LinkedList<ArbolRaleo> misArboles = new LinkedList();
            for (int j = 0; j < arboles.size(); j++) {
                if (arboles.get(j).getDap() >= minDap) {// && (minDap + 2) > arboles.get(j).getDap()) {
                    misArboles.add(arboles.get(j));
                }
            }
            System.out.println("misArboles.size(): " + misArboles.size());

            DetalleTablaRodal detalle = new DetalleTablaRodal();
            /* private int ordenTrabajo */
            detalle.setOrdenTrabajo(parametro.getOrdenTrabajo());

            /* private int claseDAP */
            detalle.setClaseDAP((int) minDap);

            /* private int densidadTotal */
            float superficie = 1;
            if (misArboles.isEmpty()) {
                detalle.setDensidadTotal("0");
                detalle.setDensidadPodado("0");
                detalle.setAreaBasal("0");
                detalle.setAlturaPoda("0");
                detalle.setVolumenPodado("0");
                detalle.setVolumeNoPodado("0");
                detalle.setVolumenTotal("0");
            } else {
                int numArboles = misArboles.size();
                superficie = BancoDatosDAO.obtenerSuperficieParcelas(inv);
                System.out.println("NUMERO ARBOLES: " + numArboles);
                System.out.println("SUPERFICIE: " + superficie);
                detalle.setDensidadTotal("" + (numArboles / superficie));
                int numArbolesP = 0, numArbolesNP = 0;
                float sumaDap = 0;

                LinkedList<ArbolRaleo> conAltura = new LinkedList();
                for (int j = 0; j < misArboles.size(); j++) {
                    if (misArboles.get(j).getConPoda() == CON_PODA) {
                        numArbolesP++;
                    } else {
                        numArbolesNP++;
                    }
                    sumaDap += misArboles.get(j).getDap();
                    if (misArboles.get(j).gethTotal() != 0f) {
                        conAltura.add(misArboles.get(j));
                    }
                }
                detalle.setDensidadPodado("" + numArbolesP / superficie);
                detalle.setDensidadNoPodado("" + numArbolesNP / superficie);

                float dapMedio = (sumaDap / misArboles.size());
                double areaBasal = Math.PI * Math.pow(dapMedio / 2, 2);
                detalle.setAreaBasal("" + areaBasal);
                int coef = buscarCoeficientes(model).size();
                String modelo = "";
                if (!conAltura.isEmpty()) {
                    modelo = calculoRegresion(conAltura, coef);
                    for (int j = 0; j < misArboles.size(); j++) {
                        if (misArboles.get(j).gethTotal() == 0) {
                            try {
                                float nvaAltura = calcularAlturaModelo(modelo, misArboles.get(j).getDap());
                                System.out.println("ALTURA RODAL: " + nvaAltura);
                                misArboles.get(j).sethTotal(nvaAltura);
                            } catch (Exception e) {
//                            JOptionPane.showMessageDialog(null, "Error al evaluar la función ajustada", "Información", 1);
                            }
                        }
                    }
                }

                /* private String alturaMedia */
                float sumaAlturas = 0, sumaAlturasP = 0;;
                for (int j = 0; j < misArboles.size(); j++) {
                    sumaAlturas += misArboles.get(j).gethTotal();
                    if (misArboles.get(j).getConPoda() != CON_PODA) {
                        sumaAlturasP += misArboles.get(j).gethTotal();
                        numArbolesP++;
                    }
                }
                detalle.setAlturaMedia((sumaAlturas / misArboles.size()) + "");
                detalle.setAlturaPoda((sumaAlturasP / numArbolesP) + "");

                LinkedList<Float> volumenes = new LinkedList();
                for (int j = 0; j < misArboles.size(); j++) {
                    try {
                        float vol = calcularVolumenFuncion(function, misArboles.get(i).getDap(), misArboles.get(i).gethTotal());
                        System.out.println("RESULTADO VOL: " + vol);
                        volumenes.add(vol);
                    } catch (Exception e) {
//                    System.err.println("LA FUNCIÓN ESTÁ MALA");
                        volumenes.add(0f);
                    }
                }

                float sumaVolP = 0;
                for (int j = 0; j < misArboles.size(); j++) {
                    if (misArboles.get(j).getConPoda() == CON_PODA) {
                        sumaVolP += volumenes.get(j);
                    }
                }
                System.out.println("VOLUMEN PODADA: " + (sumaVolP / numArbolesP));
                detalle.setVolumenPodado((sumaVolP / numArbolesP) + "");

                float sumaVolNP = 0;
                for (int j = 0; j < misArboles.size(); j++) {
                    if (misArboles.get(j).getConPoda() != CON_PODA) {
                        sumaVolNP += volumenes.get(j);
                        numArbolesNP++;
                    }
                }
                detalle.setVolumeNoPodado((sumaVolNP / numArbolesNP) + "");

                float sumaVol = 0;
                for (int j = 0; j < volumenes.size(); j++) {
                    sumaVol += volumenes.get(j);
                }
                detalle.setVolumenTotal((sumaVol / misArboles.size()) + "");
                System.out.println("-----" + detalle.toString());
                minDap += 2;

                detalles.add(detalle);
            }
            tabla.setDetalles(detalles);

        }
        return tabla;
    }

    public static ParametroParcela obtenerParametroParcela(ParametroGeneral p, Inventario inv, String function) throws DAOException {
        ParametroParcela parametro = new ParametroParcela(p);
        LinkedList<ArbolRaleo> arboles = p.getMisArboles();
        LinkedList<Integer> parcelas = new LinkedList();
        for (ArbolRaleo arbol : arboles) {
            if (!parcelas.contains(arbol.getNumParcela())) {
                parcelas.add(arbol.getNumParcela());
            }
        }
        LinkedList<DetalleParcela> detalles = new LinkedList();
        for (int i = 0; i < parcelas.size(); i++) {

            LinkedList<ArbolRaleo> misArbolRaleos = new LinkedList();
            for (int j = 0; j < misArbolRaleos.size(); j++) {
                if (parcelas.get(i) == arboles.get(j).getNumParcela()) {
                    misArbolRaleos.add(arboles.get(j));
                }
            }
            DetalleParcela detalle = new DetalleParcela();

            /* private int ordenTrabajo */
            detalle.setOrdenTrabajo(parametro.getOrdenTrabajo());
            /* private int numParcela */
            detalle.setNumParcela(parcelas.get(i));
            /* private String superficie */
            detalle.setSuperficie(BancoDatosDAO.obtenerSuperficiePorParcela(detalle.getNumParcela()) + "");

            double factorExpansion = 10000 / Double.parseDouble(detalle.getSuperficie());
            detalle.setFactorExpansion(factorExpansion + "");
            /* private String densidad */
            detalle.setDensidad((Double.parseDouble(p.getDensidad()) * factorExpansion) + "");
            if (misArbolRaleos.isEmpty()) {
                detalle.setAreaBasalMedia(p.getAreaBasal());
                detalle.setDapMedio(p.getDapMedio());
                detalle.setAlturaDominante("0");
            } else {
                float sumaDap = 0;
                for (int j = 0; j < misArbolRaleos.size(); j++) {
                    sumaDap += misArbolRaleos.get(j).getDap();
                }
                float dapMedio = (sumaDap / misArbolRaleos.size());
                double areaBasal = Math.PI * Math.pow(dapMedio / 2, 2);
                detalle.setAreaBasalMedia(areaBasal + "");
                detalle.setDapMedio(dapMedio + "");
                float hMax = Float.MIN_VALUE;
                for (int j = 0; j < misArbolRaleos.size(); j++) {
                    if (misArbolRaleos.get(j).gethTotal() > hMax) {
                        hMax = misArbolRaleos.get(j).gethTotal();
                    }
                }
                detalle.setAlturaDominante(hMax + "");
            }
            double volumen = 0;

            for (int j = 0; j < misArbolRaleos.size(); j++) {
                try {
                    float vol = calcularVolumenFuncion(function, misArbolRaleos.get(j).getDap(), misArbolRaleos.get(j).gethTotal());
                    volumen += vol;
                } catch (Exception e) {
                    System.err.println("LA FUNCIÓN ESTÁ MALA");
                    volumen += 0;
                }
            }
            detalle.setVolumen(volumen + "");

            detalles.add(detalle);
            parametro.setDetalles(detalles);
            System.out.println(parametro.toString());
        }

        return parametro;
    }

    public static float calcularVolumenFuncion(String expresion, float dap, float h) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String exp = expresion.replace("h", h + "");
        exp = exp.replace("pow", "Math.pow");
        exp = exp.replace("sqrt", "Math.sqrt");
        exp = exp.replace("dap", dap + "");
        Object operation = "Math.Error";
        try {
            operation = engine.eval(exp);
            System.out.println(operation);
        } catch (ScriptException ex) {
            throw new Exception("Math.Error...");
        }
        return Float.parseFloat(operation.toString());
    }

    public static float calcularAlturaModelo(String expresion, float dap) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        String exp = expresion.replace("pow", "Math.pow");
        exp = exp.replace("sqrt", "Math.sqrt");
        exp = exp.replace("dap", dap + "");
        System.out.println("La Modelo a resolver es: " + exp);
        Object operation = "Math.Error";
        try {
            operation = engine.eval(exp);
            System.out.println("::>" + operation);
        } catch (ScriptException ex) {
            throw new Exception("Math.Error...");
        }
        return Float.parseFloat(operation + "");
    }

    private static LinkedList<String> buscarCoeficientes(String modelo) {
        String[] coeficientes = {"B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7"};
        LinkedList<String> co = new LinkedList();
        for (String coeficiente : coeficientes) {
            if (modelo.contains(coeficiente)) {
                co.add(coeficiente);
            }
        }
        return co;
    }

    private static int[][] BubbleSort(int[][] n) {
        System.out.println("buublesort: " + n.length);
        int temp;
        int temp2;
        int t = n.length;
        for (int i = 1; i < t; i++) {
            for (int k = t - 1; k >= i; k--) {
                if (n[k][1] < n[k - 1][1]) {
                    temp = n[k][1];
                    n[k][1] = n[k - 1][1];
                    n[k - 1][1] = temp;

                    temp2 = (n[k][0]);
                    n[k][0] = n[k - 1][0];
                    n[k - 1][0] = temp2;
                }
            }
        }
        return n;
    }

    public static String calculoRegresion(LinkedList<ArbolRaleo> muestra, int coeficientes) {
        System.out.println(coeficientes + " :Coef");
        final CurveFitter fitter = new CurveFitter(new LevenbergMarquardtOptimizer());
        for (int i = 0; i < muestra.size(); i++) {
            fitter.addObservedPoint(muestra.get(i).getDap(), muestra.get(i).gethTotal());
        }
        final double[] init = new double[2];//coeficientes];
        for (int i = 0; i < init.length; i++) {
            init[i] = 1;
        }

        final double[] best = fitter.fit(new PolynomialFunction.Parametric(), init);

        final PolynomialFunction fitted = new PolynomialFunction(best);
        String exp = fitted.toString();
        exp = exp.replace("x", " * dap ");
        exp = exp.replace(" ", "");
        return exp;
    }

    public static double[] calculoCoeficientesRegresion(LinkedList<ArbolRaleo> muestra, int coeficientes) {
        final CurveFitter fitter = new CurveFitter(new LevenbergMarquardtOptimizer());
        for (int i = 0; i < muestra.size(); i++) {
            fitter.addObservedPoint(muestra.get(i).getDap(), muestra.get(i).gethTotal());
        }

        final double[] init = new double[2];//coeficientes];
        for (int i = 0; i < init.length; i++) {
            init[i] = 1;
        }

        final double[] best = fitter.fit(new PolynomialFunction.Parametric(), init);

        final PolynomialFunction fitted = new PolynomialFunction(best);
        return fitted.getCoefficients();
    }

}
