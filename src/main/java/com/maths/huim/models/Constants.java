package com.maths.huim.models;

public class Constants {

    public static long minUtil = 30;
    public static final int maxG = 10000;
    public static long antCount = 100;
    public static final double alpha = 1.0;
    public static final double beta = 2.0;
    public static final double tau0 = 1.0;
    public static final double tauBefore = 3.0;
    public static final double rho =0.4;
    public static final double q0 =0.5;
    public static double delta = 0.025;

    public static final double beta2 = 4.0;
    public static final double glmau = 10.0;

    public static void setMinUtil(long minUtil) {
        Constants.minUtil = minUtil;
    }

    public static void setDelta(double delta) {
        Constants.delta = delta;
    }

    public static void setAntCount(long antCount) {
        Constants.antCount = antCount;
    }


}
