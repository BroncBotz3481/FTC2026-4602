package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4602RedFarAuto", group="4602")
public class Team4602BlueFarAuto extends LinearOpMode {

    Team4602HM2025 robot = new Team4602HM2025();
    ElapsedTime Time = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        sleep(1000);
        waitForStart();


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
    public void moveSideways(double power, int time) {
        // put negative value to move left
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftBack.setPower(power);
        //robot.DriveRightBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        //robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void Turn(double power, int time) {
        // put negative value to move left
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftBack.setPower(-power);
        //robot.DriveRightBack.setPower(power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        //robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
}