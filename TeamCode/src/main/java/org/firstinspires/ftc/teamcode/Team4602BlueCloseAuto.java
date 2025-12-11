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
        telemetry.addData("GTelemetry","something");
        telemetry.update();
        System.out.println("DATA BE JERE");
        robot.Map(hardwareMap);
        sleep(1000);
        waitForStart();

        moveForward(-0.5,2000);
        robot.Shooter.setPower(0.75);
        robot.Intake.setPower(-1);
        double secs = getRuntime();
        while(getRuntime()-secs <= 3)
        {
            double rps = robot.Shooter.getVelocity() / 28.0;
                telemetry.addData("Shooter Speed (rotor rotations per second)", rps);
                telemetry.update();
//                if(rps > x)
//                    robot.Shooter.setPower(0.5);
//                if(rps < y)
//                    robot.Shooter.setPower(0.75);
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

    public void moveForward (double power, int time){
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
}