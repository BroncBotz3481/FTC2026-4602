package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4008AutoTimeBased", group="4008")
public class BlueAuto extends LinearOpMode {

    Team4602HM2025 robot = new Team4602HM2025();
    ElapsedTime Time = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        sleep(3000);
        waitForStart();

        moveForward(-0.5,350);
        robot.Shooter.setPower(0.45);
        sleep(2000);
        robot.ServoRight.setPower(-0.7);
        robot.ServoLeft.setPower(0.7);
        sleep(500);
        robot.Shooter.setPower(0);
        robot.ServoRight.setPower(0);
        robot.ServoLeft.setPower(0);

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