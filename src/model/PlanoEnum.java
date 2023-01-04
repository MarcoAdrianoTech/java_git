/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mmgti
 */
public enum PlanoEnum {
    PLANO_INICIAL(100),
    PLANO_BASE(150),
    PLANO_TOTAL(200);

    public int valor;

    private PlanoEnum(int valor) {

        this.valor = valor;

    }
}