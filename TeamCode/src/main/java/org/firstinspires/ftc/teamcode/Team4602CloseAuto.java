package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Team4602CloseAuto", group = "4602")
public class Team4602CloseAuto extends LinearOpMode {
    Team4602HM2025 robot = new Team4602HM2025();
    double targetTicksPerSec = (3000.0 / 60.0) * 28.0;

    @Override
    public void runOpMode() {

        // ✅ INIT HARDWARE
        robot.Map(hardwareMap);

        telemetry.addLine("Initialized");
        telemetry.update();

        // ✅ WAIT FOR PLAY
        waitForStart();

        if (!opModeIsActive()) return;

        // ---- AUTONOMOUS SEQUENCE ----
        moveForward(800);
        robot.Shooter.setPower(0.4);
        sleep(3000);
        robot.Transfer.setPower(-0.8);
        robot.Intake.setPower(0.7);
        sleep(3000);
        robot.Transfer.setPower(0);
        robot.Intake.setPower(0);
        robot.Shooter.setPower(0);
    }

    public void moveForward(long timeMs) {
        robot.DriveRightFront.setPower(0.8);
        robot.DriveLeftFront.setPower(0.8);
        robot.DriveRightBack.setPower(0.8);
        robot.DriveLeftBack.setPower(0.8);

        sleep(timeMs);

        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
}