package org.firstinspires.ftc.teamcode;

/**
 * Created by erin on 10/7/18.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TeleOP", group = "TeleOP")
public class CodeTest1 extends OpMode{
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    //DcMotor slide;

    //Servo hook;

    ElapsedTime runTime;

    public CodeTest1() {
        runTime = new ElapsedTime();
    }

    public void init ()
    {
        //hardware map is for phone
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft= hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft"); //wheels
        //slide = hardwareMap.dcMotor.get("slide"); //draw slides

        //hook = hardwareMap.servo.get("hook"); //hook for lander at top of draw slides

    }

    public void loop(){

        //In place of motor power, gamestick position is used
        float move = -gamepad1.left_stick_y;
        float rotation = gamepad1.right_stick_x;
        float crabWalk = -gamepad1.left_stick_x;

        //Wheels: Holonomic drive formula uses values of gamestick position to move
        double fLeftPower = Range.clip(move + rotation - crabWalk, -1.0, 1.0);
        double bLeftPower = Range.clip(move + rotation + crabWalk, -1.0, 1.0);
        double fRightPower = Range.clip(move - rotation + crabWalk, -1.0, 1.0);
        double bRightPower = Range.clip(move - rotation - crabWalk, -1.0, 1.0);

        //Assignment of motor power in relation to wheels
        frontLeft.setPower(fLeftPower/.5);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setPower(bLeftPower/.5);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setPower(fRightPower/.5);
        backRight.setPower(bRightPower/.5);


            /*want draw slides to move up when game pad 2 right stick y is forward
            want draw slides to move down when game pad 2 right stick y is backward
            */

            //slide.setPower(gamepad2.right_stick_y);


        telemetry.addData("status", "Run Time:", runTime.toString());
    }

}

