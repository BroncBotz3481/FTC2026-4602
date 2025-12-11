package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4008AutoTimeBased", group="4008")
public class Team4602BlueFarAuto extends LinearOpMode {

    Team4602HM2025 robot = new Team4602HM2025();
    ElapsedTime Time = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        sleep(1000);
        waitForStart();

        moveSideways(0.5, 450);// This powers all the motors to move the robot forward for 1000 milseconds
        robot.Shooter.setPower(0.65);
        sleep(2000);
        robot.ServoRight.setPower(-0.9);
        robot.ServoLeft.setPower(0.9);
        //test to change the time for each cycle
        sleep(1000);
        robot.ServoRight.setPower(0);
        robot.ServoLeft.setPower(0);
        sleep(1000);
        robot.ServoRight.setPower(-0.9);
        robot.ServoLeft.setPower(0.9);
        sleep(1000);
        robot.ServoRight.setPower(0);
        robot.ServoLeft.setPower(0);
        sleep(1000);
        robot.ServoRight.setPower(-0.9);
        robot.ServoLeft.setPower(0.9);
        sleep(1000);
        robot.Shooter.setPower(0);
        robot.ServoRight.setPower(0);
        robot.ServoLeft.setPower(0);
    }

    public void moveSideways(double power, int time) {
        // put negative value to move left
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftBack.setPower(power);
        robot.DriveRightBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
}