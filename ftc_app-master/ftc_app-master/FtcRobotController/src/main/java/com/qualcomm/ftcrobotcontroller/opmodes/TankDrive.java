package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by heel7_000 on 9/2/2015.
 */
public class TankDrive extends OpMode {

    DcMotor urmom;
    DcMotor yo;
    Servo mama;
    Servo goma;
    double servopos;

    public TankDrive() {
    }

    @Override
    public void init() {
        urmom = hardwareMap.dcMotor.get("right");//right forward
        yo = hardwareMap.dcMotor.get("left");
        yo.setDirection(DcMotor.Direction.REVERSE);
        mama = hardwareMap.servo.get("right1");
        goma = hardwareMap.servo.get("left1");
        servopos = .5;

    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        mama.setPosition(servopos);
        goma.setPosition(servopos);
        double rightPower = -gamepad1.left_stick_y;
        double leftPower = -gamepad1.right_stick_y
        rightPower = Range.clip(rightPower, -1, 1);
        leftPower = Range.clip(leftPower, -1, 1);
        urmom.setPower(-leftPower);
        yo.setPower(rightPower);
        if(gamepad1.a){
            double servopos = this.servopos-.2;
            mama.setPosition(servopos);
            goma.setPosition(servopos);

        }
        if(gamepad1.y){
           double servopos = this.servopos+.2;
            mama.setPosition(servopos);
            goma.setPosition(servopos);
        }

    }
}

