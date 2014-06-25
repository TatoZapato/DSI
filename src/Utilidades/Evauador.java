/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author Desarrollo
 */
public class Evauador {
    
    public static String pruebaFuncion(String funcion){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object operation;
        funcion = funcion.replaceAll("pow", "Math.pow");
        funcion = funcion.replaceAll("sqrt", "Math.sqrt");
        funcion = funcion.replaceAll("dap", "1");
        funcion = funcion.replaceAll("h", "1");
        funcion = funcion.replaceAll("B0", "1");
        funcion = funcion.replaceAll("B1", "1");
        funcion = funcion.replaceAll("B2", "1");
        funcion = funcion.replaceAll("B3", "1");
        funcion = funcion.replaceAll("B4", "1");
        funcion = funcion.replaceAll("B5", "1");
        funcion = funcion.replaceAll("B6", "1");
        funcion = funcion.replaceAll("EA", "1");
        funcion = funcion.replaceAll("H", "1");
        
        try {
            System.out.println("funcion: "+funcion);
            operation = engine.eval(funcion);
        } catch (ScriptException ex) {
            operation = "Math.Error";
        }
        return operation.toString();
    }
}
