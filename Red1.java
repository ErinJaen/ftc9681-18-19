package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by erin on 10/21/18.
 */

@Autonomous (name = "Red 1", group = "Linear OpMode")
public class Red1 extends LinearOpMode{
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor slide;

    Servo hook;

    public void runOpMode () {
        frontRight = hardwareMap.dcMotor.get("Front Right");
        frontLeft = hardwareMap.dcMotor.get("Front Left");
        backRight = hardwareMap.dcMotor.get("Back Right");
        backLeft = hardwareMap.dcMotor.get("Back Left");

        slide = hardwareMap.dcMotor.get("Slide");

        hook = hardwareMap.servo.get("Hook");

        waitForStart();

        while (opModeIsActive()) {
            frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
            frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
            backRight.setDirection(DcMotorSimple.Direction.FORWARD);
            backLeft.setDirection(DcMotorSimple.Direction.FORWARD);

            slide.setDirection(DcMotorSimple.Direction.FORWARD);

            hook.setPosition(1);

            //unhooking
            slide.setPower(0.3);
            sleep(3000);
            hook.setPosition (0);
            sleep(3000);


        }
    }

}
