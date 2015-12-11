package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by heel7_000 on 12/4/2015.
 */
public class Autonomus extends Gyro {
   //Servo one;
    //Servo two;
    GyroSensor gyroSensor;


    @Override
    public void init() {
       // one = hardwareMap.servo.get("arm");
        //two = hardwareMap.servo.get("leftS");
        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()){
           sleep(400);
            }

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        sleepMove(3000);

        gyroTurn(90);
        sleepMove(3000);

        leftMotor.setPower(0);
        rightMotor.setPower(0);

    }

    @Override
    public void stop() {
        super.stop();
    }
}
