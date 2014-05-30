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
        try {
            System.out.println("funcion: "+funcion);
            operation = engine.eval(funcion);
        } catch (ScriptException ex) {
            operation = "Math.Error";
        }
        return operation.toString();
    }
}
