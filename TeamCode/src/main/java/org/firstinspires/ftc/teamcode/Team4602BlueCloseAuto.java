package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4602BlueCloseAuto", group="4602")
public class Team4602BlueCloseAuto extends LinearOpMode {


    Team4602HM2025 robot = new Team4602HM2025();
    ElapsedTime Time = new ElapsedTime();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        double min = 55;
        double max = 60;
        waitForStart();

        moveForward(-0.5, 2000);
        robot.Shooter.setPower(0.75);
        robot.Intake.setPower(-1);
        while (getRuntime() <= 6 && getRuntime() >= 5) {
                double rps = robot.Shooter.getVelocity() / 28.0;
                telemetry.addData("Shooter Speed (rotor rotations per second)", rps);
                telemetry.update();
                if (rps < min || rps > max) {
                    if (rps > max) {
                        robot.Shooter.setPower(0.65);
                    } else if (rps < min) {
                        robot.Shooter.setPower(0.85);
                }
            }
        }
        sleep(3000);
        robot.ServoRight.setPower(-0.9);
        robot.ServoLeft.setPower(0.9);
        //test to change the time for each cycle
        sleep(3000);
        robot.ServoRight.setPower(0);
        robot.ServoLeft.setPower(0);
        sleep(1000);
        robot.ServoRight.setPower(-0.9);
        robot.ServoLeft.setPower(0.9);
        sleep(3000);
        robot.ServoRight.setPower(0);
        robot.ServoLeft.setPower(0);
        sleep(1000);
        robot.ServoRight.setPower(-0.9);
        robot.ServoLeft.setPower(0.9);
        sleep(3000);
        robot.Shooter.setPower(0);
        robot.ServoRight.setPower(0);
        robot.ServoLeft.setPower(0);
        robot.Intake.setPower(0);
    }




    public void moveForward(double power, int time) {
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(power);
        //robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        //robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }

}