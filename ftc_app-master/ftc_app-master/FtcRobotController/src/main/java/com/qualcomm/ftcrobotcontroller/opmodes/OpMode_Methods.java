package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by SrinivasaRao on 11/22/2015.
 */
public class OpMode_Methods extends OpMode {
    DcMotor right;
    DcMotor left;
    Servo RightServo;
    Servo LeftServo;
    double ServoPosition;
    double armPosition;
    double servoDelta = 0.1;
    double armDelta = 0.03;

    LightSensor lightSensor;


    @Override
    public void init() {
        right = hardwareMap.dcMotor.get("right");

        left = hardwareMap.dcMotor.get("left");
        left.setDirection(DcMotor.Direction.REVERSE);


        LeftServo = hardwareMap.servo.get("leftS");
        RightServo = hardwareMap.servo.get("arm");

        lightSensor = hardwareMap.lightSensor.get("LightSensor");

        RightServo.setPosition(ServoPosition);
        LeftServo.setPosition(ServoPosition);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

    }

    @Override
    public void stop(){

    }

}
