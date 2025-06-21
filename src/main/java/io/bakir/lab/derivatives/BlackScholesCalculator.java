package io.bakir.lab.derivatives;

/**
 * Implements the Black-Scholes pricing formula for European call and put options.
 */
public class BlackScholesCalculator {
    private static final double INV_SQRT_2PI = 1.0 / Math.sqrt(2.0 * Math.PI);

    private static double phi(double x) {
        return Math.exp(-0.5 * x * x) * INV_SQRT_2PI;
    }

    private static double cdf(double x) {
            // Abramowitz and Stegun approximation
        double k = 1.0 / (1.0 + 0.2316419 * Math.abs(x));
        double a1 = 0.319381530, a2 = -0.356563782, a3 = 1.781477937;
        double a4 = -1.821255978, a5 = 1.330274429;
        double poly = ((((a5 * k + a4) * k + a3) * k + a2) * k + a1) * k;
        double approx = 1.0 - phi(x) * poly;
        return x >= 0.0 ? approx : 1.0 - approx;
    }

    private static double d1(double S, double K, double T, double r, double sigma) {
        return (Math.log(S / K) + (r + 0.5 * sigma * sigma) * T) / (sigma * Math.sqrt(T));
    }

    private static double d2(double d1, double sigma, double T) {
        return d1 - sigma * Math.sqrt(T);
    }

    /**
     * Calculates the price of a European option using the Black-Scholes formula.
     *
     * @param type option type (CALL or PUT)
     * @param spot current price of the underlying asset
     * @param strike strike price of the option
     * @param timeToMaturity time to maturity in years
     * @param riskFreeRate annual risk-free interest rate (as decimal)
     * @param volatility annual volatility of the underlying (as decimal)
     * @return option price
     */
    public static double calcPrice(OptionType type,
                                   double spot,
                                   double strike,
                                   double timeToMaturity,
                                   double riskFreeRate,
                                   double volatility) {
        if (type == OptionType.CALL) {
            return callPrice(spot, strike, timeToMaturity, riskFreeRate, volatility);
        } else {
            return putPrice(spot, strike, timeToMaturity, riskFreeRate, volatility);
        }
    }

    private static double callPrice(double S,
                                    double K,
                                    double T,
                                    double r,
                                    double sigma) {
        double d1 = d1(S, K, T, r, sigma);
        double d2 = d2(d1, sigma, T);
        return S * cdf(d1) - K * Math.exp(-r * T) * cdf(d2);
    }

    private static double putPrice(double S,
                                   double K,
                                   double T,
                                   double r,
                                   double sigma) {
        double d1 = d1(S, K, T, r, sigma);
        double d2 = d2(d1, sigma, T);
        return K * Math.exp(-r * T) * cdf(-d2) - S * cdf(-d1);
    }

    /**
     * Calculates the delta of a European option.
     * @return delta
     */
    public static double calcDelta(OptionType type,
                                   double S,
                                   double K,
                                   double T,
                                   double r,
                                   double sigma) {
        double d1 = d1(S, K, T, r, sigma);
        return type == OptionType.CALL ? cdf(d1) : cdf(d1) - 1.0;
    }

    /**
     * Calculates the gamma of a European option.
     * @return gamma
     */
    public static double calcGamma(double S,
                                   double K,
                                   double T,
                                   double r,
                                   double sigma) {
        double d1 = d1(S, K, T, r, sigma);
        return phi(d1) / (S * sigma * Math.sqrt(T));
    }

    /**
     * Calculates the vega of a European option.
     * @return vega
     */
    public static double calcVega(double S,
                                  double K,
                                  double T,
                                  double r,
                                  double sigma) {
        double d1 = d1(S, K, T, r, sigma);
        return S * phi(d1) * Math.sqrt(T);
    }

    /**
     * Calculates the theta (time decay) of a European option.
     * @return theta
     */
    public static double calcTheta(OptionType type,
                                   double S,
                                   double K,
                                   double T,
                                   double r,
                                   double sigma) {
        double d1 = d1(S, K, T, r, sigma);
        double d2 = d2(d1, sigma, T);
        double term1 = - (S * phi(d1) * sigma) / (2.0 * Math.sqrt(T));
        if (type == OptionType.CALL) {
            double term2 = r * K * Math.exp(-r * T) * cdf(d2);
            return term1 - term2;
        } else {
            double term2 = r * K * Math.exp(-r * T) * cdf(-d2);
            return term1 + term2;
        }
    }

    /**
     * Calculates the rho (interest rate sensitivity) of a European option.
     * @return rho
     */
    public static double calcRho(OptionType type,
                                 double S,
                                 double K,
                                 double T,
                                 double r,
                                 double sigma) {
        double d1 = d1(S, K, T, r, sigma);
        double d2 = d2(d1, sigma, T);
        if (type == OptionType.CALL) {
            return K * T * Math.exp(-r * T) * cdf(d2);
        } else {
            return -K * T * Math.exp(-r * T) * cdf(-d2);
        }
    }
}