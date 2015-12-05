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

        A = hardwareMap.dcMotor.get("left");
        B = hardwareMap.dcMotor.get("right");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        A.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        sleepMove(3000,gyroSensor,0,.5,A,B);

        gyroTurn(gyroSensor,75);
        sleepMove(3000,gyroSensor,75,.5,A,B);

        A.setPower(0);
        B.setPower(0);

    }

    @Override
    public void stop() {
        super.stop();
    }
}
