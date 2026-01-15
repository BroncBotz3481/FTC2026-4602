package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4602CloseAuto", group="4602")
public class Team4602CloseAuto extends LinearOpMode {


    Team4602HM2025 robot = new Team4602HM2025();
    ElapsedTime Time = new ElapsedTime();


    @Override
    public void runOpMode() {
       moveForward(-0.8, 3000);

       robot.Shooter.setPower(0.9);
       robot.Intake.setPower(0.5);
       robot.Transfer.setPower(0.5);

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