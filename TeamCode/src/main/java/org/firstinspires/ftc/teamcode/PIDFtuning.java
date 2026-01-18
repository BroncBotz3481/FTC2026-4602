package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;
public class PIDFtuning {
        boolean firstRun = true;
        private double Kp, Ki, Kd, Kf;
        private double lastError = 0;
        private double integralSum = 0;
        private ElapsedTime timer = new ElapsedTime();

        public PIDFtuning(double p, double i, double d, double f) {
            Kp = p; Ki = i; Kd = d; Kf = f;
        }

        public double calculate(double targetVelocity, double currentVelocity) {
            double error = targetVelocity - currentVelocity;
            double deltaTime = timer.seconds();

            if (firstRun || deltaTime <= 0) {
                lastError = error;
                timer.reset();
                firstRun = false;
                return (Kf * targetVelocity);
            }

            // Integral with basic anti-windup (stops accumulating if error is too large)
            if (Math.abs(error) < 100) {
                integralSum += error * deltaTime;
            }

            double derivative = (error - lastError) / deltaTime;
            lastError = error;
            timer.reset();

            // PIDF formula: Output = (P * error) + (I * sum) + (D * deriv) + (F * target)
            return (Kp * error) + (Ki * integralSum) + (Kd * derivative) + (Kf * targetVelocity);
        }
    public void resetIntegral() {
        this.integralSum = 0;
        this.lastError = 0;
        this.firstRun = true; // Ensures the next calculate call resets the timer
    }
}
