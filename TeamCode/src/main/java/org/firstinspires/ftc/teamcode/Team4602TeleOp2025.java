package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

//AUSTIN: YOUR DEADLINE FOR THIS IS BEFORE KICKOFF
//WE NEED YOUR CODE FOR KICKOFF DEMONSTRATION! HELP!
@TeleOp(name = "Team4602TeleOp2025", group = "4602")
public class Team4602TeleOp2025 extends LinearOpMode {
    Team4602HM2025 robot = new Team4602HM2025();
    double targetTicksPerSec = (3000/60) *28;

        PDIFtuning pidController = new PDIFtuning(0, 0, 0, 0.0005);

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        telemetry.addData("Say", "TeleOp Starting");
        telemetry.update();
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //robot.Lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_PARTY_PALETTE);
        waitForStart();

        while (opModeIsActive()) {

            boolean speedslow = gamepad1.right_bumper;
            double mag = speedslow ? 0.5 : 1.0;
//
            double y = gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;

            double ShooterTicks = 28;
            double DriveTicks = 537.6;
            double IntakeTicks = 384.5;



            //Optional Deadzones
//            double y = (Math.abs(gamepad1.left_stick_y) > 0.1 ? gamepad1.left_stick_y : 0); // Remember, this is reversed!
//            double x = -(Math.abs(gamepad1.left_stick_x) > 0.1 ? gamepad1.left_stick_x : 0) * 1.1; // Counteract imperfect strafing
//            double rx = -gamepad1.right_stick_x;


            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.5);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            //AUSTIN: EXPLAIN HOW THE POWER WILL BE AFFECTED BY speedslow WITH mag
            robot.DriveLeftFront.setPower(frontLeftPower * mag);
            robot.DriveLeftBack.setPower(backLeftPower * mag);
            robot.DriveRightFront.setPower(frontRightPower * mag);
            robot.DriveRightBack.setPower(backRightPower * mag);

            telemetry.addData("RightFront", robot.DriveRightFront.getCurrentPosition());
            telemetry.addData("RightBack", robot.DriveRightBack.getCurrentPosition());
            telemetry.addData("LeftFront", robot.DriveLeftFront.getCurrentPosition());
            telemetry.addData("LeftBack", robot.DriveLeftBack.getCurrentPosition());
            telemetry.update();

            if (gamepad1.dpad_up){
                moveForward(mag);
            } else if (gamepad1.dpad_down){
                moveBackward(mag);
            } else if (gamepad1.dpad_left){
                moveLeft(mag);
            } else if (gamepad1.dpad_right){
                moveRight(mag);
            }

           if(gamepad2.right_trigger > 0.5){
               /*double currentVelo = robot.Shooter.getVelocity();
               double power = pidController.calculate(targetTicksPerSec, currentVelo);
               robot.Shooter.setPower(Math.max(-1.0, Math.min(1.0, power)));

               telemetry.addData("Target Velo", targetTicksPerSec);
               telemetry.addData("Actual Velo", currentVelo);
               telemetry.update();*/
               robot.Shooter.setPower(0.7);
           }
           else if(gamepad2.right_bumper){
               robot.Shooter.setPower(-0.9);
               pidController.resetIntegral();
            }
           else {
               robot.Shooter.setPower(0);
               pidController.resetIntegral();
            }
           if(gamepad2.left_trigger > 0.5){
               robot.Transfer.setPower(-0.8);
           }
           else if (gamepad2.left_bumper){
               robot.Transfer.setPower(0.8);
           }
           else{
               robot.Transfer.setPower(0);
           }
           if(gamepad1.right_trigger > 0.5){
               robot.Intake.setPower(0.5);

           }
           else if(gamepad1.left_trigger > 0.5){
               robot.Intake.setPower(-0.5);

            }
           else{
               robot.Intake.setPower(0);
           }
        }
    }


    //Methods go here
    public void moveLeft (double power){

        robot.DriveLeftFront.setPower(power); robot.DriveRightFront.setPower(-power);
        robot.DriveLeftBack.setPower(-power);   robot.DriveRightBack.setPower(power);
    }
    public void moveRight (double power){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(-power); robot.DriveRightFront.setPower(power);
        robot.DriveLeftBack.setPower(power); robot.DriveRightBack.setPower(-power);
    }
    public void moveForward (double power){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(power); robot.DriveRightFront.setPower(power);
        robot.DriveLeftBack.setPower(power);  robot.DriveRightBack.setPower(power);
    }
    public void moveBackward (double power){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(-power); robot.DriveRightFront.setPower(-power);
        robot.DriveLeftBack.setPower(-power);  robot.DriveRightBack.setPower(-power);
    }
    public void stopDriveTrainMotors (){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(0);      robot.DriveRightFront.setPower(0);
        robot.DriveRightBack.setPower(0);      robot.DriveLeftBack.setPower(0);
    }
}