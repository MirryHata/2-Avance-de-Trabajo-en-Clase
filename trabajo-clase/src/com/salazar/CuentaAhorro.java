package com.salazar;

public class CuentaAhorro extends Cuenta {

    public final double SALDO_MIN_BONO = 50_000;
    public final double INTERES_BONO = 0.01;

    public boolean depositar(double monto){

        if (monto > SALDO_MIN_BONO){
            monto += (monto * INTERES_BONO);
        }
        return super.depositar(monto);
    }
}
